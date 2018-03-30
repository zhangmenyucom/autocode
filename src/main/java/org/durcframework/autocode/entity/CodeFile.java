package org.durcframework.autocode.entity;

import lombok.Data;

/**
 * @author taylor
 */
@Data
public class CodeFile {
    private String tableName;
    private String templateName;
    private String content;

    public CodeFile(String tableName, String templateName, String content) {
        this.tableName = tableName;
        this.templateName = templateName;
        this.content = content;
    }
}
