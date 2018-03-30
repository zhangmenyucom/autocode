package org.durcframework.autocode.entity;

import lombok.Data;
import org.durcframework.core.SearchEntity;
import org.durcframework.core.expression.annotation.LikeDoubleField;
import org.durcframework.core.expression.annotation.ValueField;

/**
 * @author taylor
 */
@Data
public class TemplateConfigSch extends SearchEntity {

    private Integer tcIdSch;
    private String nameSch;
    private String savePathSch;
    private String contentSch;
    private String backUserSch;


    @ValueField(column = "tc_id")
    public Integer getTcIdSch() {
        return this.tcIdSch;
    }

    @LikeDoubleField(column = "name")
    public String getNameSch() {
        return nameSch;
    }

    @ValueField(column = "save_path")
    public String getSavePathSch() {
        return this.savePathSch;
    }

    @ValueField(column = "content")
    public String getContentSch() {
        return this.contentSch;
    }

    @ValueField(column = "back_user")
    public String getBackUserSch() {
        return this.backUserSch;
    }


}