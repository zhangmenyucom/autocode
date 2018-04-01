package org.durcframework.autocode.entity;


import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class TemplateConfig {
    private int tcId;
    private String name;
    private String savePath;
    private String fileName;
    private String content;
    private String backUser;
    private String suffix;
}
