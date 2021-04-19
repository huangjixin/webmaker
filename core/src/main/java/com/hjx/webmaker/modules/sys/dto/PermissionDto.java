package com.hjx.webmaker.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hjx.webmaker.modules.sys.domain.Permission;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class PermissionDto extends Permission implements GrantedAuthority {
    private List<String> permissionIds = new ArrayList<>();

    public List<String> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<String> permissionIds) {
        this.permissionIds = permissionIds;
    }


    @JsonIgnore
    @Override
    public String getAuthority() {
        return super.getCode();
    }

}
