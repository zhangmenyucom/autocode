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
    private int dcId;
    private List<String> tableNames;
    private List<Integer> tcIds;
    private String packageName;
}
