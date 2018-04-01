package org.durcframework.autocode.entity;

import lombok.Data;
import org.durcframework.autocode.generator.DataBaseConfig;

/**
 * @author taylor
 */
@Data
public class DataSourceConfig extends DataBaseConfig {
    private int dcId;
    private String name;
    private String backUser;
}
