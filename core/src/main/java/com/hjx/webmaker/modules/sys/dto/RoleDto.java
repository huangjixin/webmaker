package com.hjx.webmaker.modules.sys.dto;

import com.hjx.webmaker.modules.sys.domain.Permission;
import com.hjx.webmaker.modules.sys.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDto extends Role {
    private List<String> permissionIds = new ArrayList<String>();
    private List<Permission> permissions = new ArrayList<Permission>();
    ;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }


    public List<String> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<String> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
