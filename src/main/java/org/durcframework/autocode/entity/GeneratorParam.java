package org.durcframework.autocode.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author taylor
 */
@Data
public class GeneratorParam implements Serializable {
    private static final long serialVersionUID = -3730608805294327160L;
    /**数据源id**/
    private int dcId;
    /**表列表**/
    private List<String> tableNames;
    /**生成类型列表**/
    private List<Integer> tcIds;
    private String packageName;
}
