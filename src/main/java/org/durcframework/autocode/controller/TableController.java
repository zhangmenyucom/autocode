package org.durcframework.autocode.controller;

import org.durcframework.autocode.entity.DataSourceConfig;
import org.durcframework.autocode.generator.SQLService;
import org.durcframework.autocode.generator.SQLServiceFactory;
import org.durcframework.autocode.generator.TableBean;
import org.durcframework.autocode.service.DataSourceConfigService;
import org.durcframework.autocode.util.DBConnect;
import org.durcframework.core.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TableController extends BaseController {

    @Autowired
    private DataSourceConfigService dataSourceConfigService;
    @ResponseBody
    @RequestMapping("listTable.do")
    public
    Object listTable(int dcId) {
        DataSourceConfig dataSourceConfig = dataSourceConfigService.get(dcId);
        String resultMsg = DBConnect.testConnection(dataSourceConfig);

        if (StringUtils.hasText(resultMsg)) {
            return error(resultMsg);
        }

        SQLService service = SQLServiceFactory.build(dataSourceConfig);

        List<TableBean> list = service.getTableSelector(dataSourceConfig).getTableList();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);
        return map;
    }

}
