package org.durcframework.autocode.generator;


import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class DataBaseConfig {

    private String driverClass;

    private String jdbcUrl;

    private String username;

    private String password;
}
