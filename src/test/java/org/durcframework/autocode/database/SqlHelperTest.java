package org.durcframework.autocode.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.durcframework.autocode.TestBase;
import org.durcframework.autocode.entity.DataSourceConfig;
import org.durcframework.autocode.util.SqlHelper;
import org.junit.Test;
import org.springframework.util.Assert;

public class SqlHelperTest extends TestBase {

    @Test
    public void testSql() {
        String sql = "SHOW TABLES";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverClass("com.mysql.jdbc.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:mysql://139.196.79.91:3306/auto_code");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("ilovemysql^^^");

        List<Map<String, Object>> map = SqlHelper.runSql(dataSourceConfig, sql);

        Assert.notEmpty(map);

    }

    @Test
    public void testSqlParam() {
        String sql = "SELECT * FROM datasource_config WHERE dc_id=${id}";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverClass("com.mysql.jdbc.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:mysql://139.196.79.91:3306/auto_code");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("ilovemysql^^^");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", 2);
        List<Map<String, Object>> map = SqlHelper.runSql(dataSourceConfig, sql, params);
        Assert.notEmpty(map);

    }

}
