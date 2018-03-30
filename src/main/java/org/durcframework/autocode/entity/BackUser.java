package org.durcframework.autocode.entity;

import lombok.Data;
import org.durcframework.core.IUser;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author taylor
 */
@Data
public class BackUser implements IUser {
    @Pattern(regexp = "\\w+", message = "用户名只能由数字,字母,下划线组成")
    @Size(min = 4, max = 20, message = "用户名长度范围在4-20之间")
    private String username;
    @Size(min = 6, max = 20, message = "密码长度范围在6-20之间")
    private String password;
    private Date addTime = new Date();
}
