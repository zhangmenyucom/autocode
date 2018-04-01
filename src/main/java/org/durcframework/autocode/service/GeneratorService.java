package org.durcframework.autocode.service;

import org.apache.velocity.VelocityContext;
import org.durcframework.autocode.common.AutoCodeContext;
import org.durcframework.autocode.entity.CodeFile;
import org.durcframework.autocode.entity.DataSourceConfig;
import org.durcframework.autocode.entity.GeneratorParam;
import org.durcframework.autocode.entity.TemplateConfig;
import org.durcframework.autocode.generator.SQLContext;
import org.durcframework.autocode.generator.SQLService;
import org.durcframework.autocode.generator.SQLServiceFactory;
import org.durcframework.autocode.util.FileUtil;
import org.durcframework.autocode.util.VelocityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class GeneratorService {
    @Autowired
    private TemplateConfigService templateConfigService;

    private static final String DOWNLOAD_FOLDER_NAME = "download";

    /**
     * 生成代码内容,map的
     *
     * @param tableNames
     * @param tcIds
     * @param dataSourceConfig
     * @return 一张表对应多个模板
     */
    public List<CodeFile> generate(GeneratorParam generatorParam, DataSourceConfig dataSourceConfig) {

        SQLService service = SQLServiceFactory.build(dataSourceConfig);

        List<SQLContext> contextList = service.getColumnSelector(dataSourceConfig).buildSQLContextList(generatorParam.getTableNames());

        List<CodeFile> codeFileList = new ArrayList<>();

        for (SQLContext sqlContext : contextList) {
            setPackageName(sqlContext, generatorParam.getPackageName());
            String packageName = sqlContext.getJavaBeanNameLF();
            for (int tcId : generatorParam.getTcIds()) {
                TemplateConfig template = templateConfigService.get(tcId);
                String fileName = doGenerator(sqlContext, template.getFileName());
                String content = doGenerator(sqlContext, template.getContent());
                CodeFile codeFile = new CodeFile(packageName, fileName, content);
                codeFileList.add(codeFile);
            }
        }
        return codeFileList;
    }

    /**
     * 生成zip
     *
     * @param generatorParam
     * @param dataSourceConfig
     * @param webRootPath
     * @return
     */
    public String generateZip(GeneratorParam generatorParam, DataSourceConfig dataSourceConfig, String webRootPath) {
        SQLService service = SQLServiceFactory.build(dataSourceConfig);
        List<SQLContext> contextList = service.getColumnSelector(dataSourceConfig).buildSQLContextList(generatorParam.getTableNames());
        String projectFolder = this.buildProjectFolder(webRootPath);

        for (SQLContext sqlContext : contextList) {
            setPackageName(sqlContext, generatorParam.getPackageName());
            for (int tcId : generatorParam.getTcIds()) {
                TemplateConfig template = templateConfigService.get(tcId);
                String content = doGenerator(sqlContext, template.getContent());
                String fileName = doGenerator(sqlContext, template.getFileName());
                String savePath = doGenerator(sqlContext, template.getSavePath());

                if (StringUtils.isEmpty(fileName)) {
                    fileName = template.getName();
                }

                FileUtil.createFolder(projectFolder + File.separator + savePath);

                FileUtil.write(content, projectFolder + File.separator + savePath + File.separator + fileName);
            }
        }

        try {
            FileUtil.zip(projectFolder, projectFolder + ".zip");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtil.deleteDir(new File(projectFolder));
        }

        return projectFolder + ".zip";
    }

    private String buildProjectFolder(String webRootPath) {
        return webRootPath + File.separator + DOWNLOAD_FOLDER_NAME + File.separator + AutoCodeContext.getInstance().getUser().getUsername() + System.currentTimeMillis();
    }

    private void setPackageName(SQLContext sqlContext, String packageName) {
        if (StringUtils.hasText(packageName)) {
            sqlContext.setPackageName(packageName);
        }
    }

    private String doGenerator(SQLContext sqlContext, String template) {
        if (template == null) {
            return "";
        }
        VelocityContext context = new VelocityContext();

        context.put("context", sqlContext);
        context.put("table", sqlContext.getTableDefinition());
        context.put("pkColumn", sqlContext.getTableDefinition().getPkColumn());
        context.put("columns", sqlContext.getTableDefinition().getColumnDefinitions());

        return VelocityUtil.generate(context, template);
    }

}
