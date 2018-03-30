package org.durcframework.autocode.entity;

import lombok.Data;
import org.durcframework.core.SearchEntity;
import org.durcframework.core.expression.annotation.ValueField;

import java.util.Date;

/**
 * @author taylor
 */
@Data
public class BackUserSch extends SearchEntity {

    private String usernameSch;
    private String passwordSch;
    private Date addTimeSch;

    @ValueField(column = "username")
    public String getUsernameSch() {
        return this.usernameSch;
    }

    @ValueField(column = "password")
    public String getPasswordSch() {
        return this.passwordSch;
    }

    @ValueField(column = "add_time")
    public Date getAddTimeSch() {
        return this.addTimeSch;
    }
}