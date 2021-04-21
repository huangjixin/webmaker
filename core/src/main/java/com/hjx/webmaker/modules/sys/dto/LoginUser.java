package com.hjx.webmaker.modules.sys.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 5, max = 11, message = "账号长度必须是5-11个字符")
    private String username;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
