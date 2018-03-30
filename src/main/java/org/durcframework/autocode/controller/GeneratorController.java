package org.durcframework.autocode.controller;

import org.durcframework.autocode.entity.DataSourceConfig;
import org.durcframework.autocode.entity.GeneratorParam;
import org.durcframework.autocode.service.DataSourceConfigService;
import org.durcframework.autocode.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 代码生成
 *
 * @author hc.tang
 */
@Controller
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;
    @Autowired
    private DataSourceConfigService dataSourceConfigService;

    @ResponseBody
    @RequestMapping("/generatFile.do")
    public
    Object generatFile(GeneratorParam generatorParam, HttpServletRequest request) {

        request.getSession().setAttribute("generatorParam", generatorParam);

        DataSourceConfig dataSourceConfig = dataSourceConfigService.get(generatorParam.getDcId());

        return generatorService.generate(generatorParam, dataSourceConfig);
    }

    @RequestMapping("/downloadZip.do")
    public void downloadZip(HttpServletRequest request, HttpServletResponse response) {
        GeneratorParam generatorParam = (GeneratorParam) request.getSession().getAttribute("generatorParam");
        String webRootPath = request.getSession().getServletContext().getRealPath("/");

        DataSourceConfig dataSourceConfig = dataSourceConfigService.get(generatorParam.getDcId());

        String zipPath = generatorService.generateZip(generatorParam, dataSourceConfig, webRootPath);

        try {
            String downloadUrl = request.getContextPath() + zipPath.substring(webRootPath.length()).replace("\\", "/");
            response.sendRedirect(downloadUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
