package com.hjx.webmaker.modules.sys.dto;

import com.hjx.webmaker.modules.sys.domain.Permission;
import com.hjx.webmaker.modules.sys.domain.Role;
import com.hjx.webmaker.modules.sys.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDto extends User
        implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    private List<Role> roles = new ArrayList<Role>();

    private List<String> roleIds = new ArrayList<String>();

    private List<Permission> permissions = new ArrayList<Permission>();

    private List treePermissions = new ArrayList();


    public void setRoleIdsByRoles() {
        for (Role role : roles) {
            this.roleIds.add(new String (role.getId()));
        }
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
//        this.setRoleIdsByRoles();
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List getTreePermissions() {
        return treePermissions;
    }

    public void setTreePermissions(List treePermissions) {
        this.treePermissions = treePermissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        for (int i = 0; i < this.getPermissions().size(); i++) {
            Permission authority = this.getPermissions().get(i);

            if (!StringUtils.isEmpty(authority.getCode())) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getCode());
                auths.add(grantedAuthority);
            }
        }

        /*
        if (CollectionUtils.isNotEmpty(this.permissions)) {
            GrantedAuthority grantedAuthority;
            for (SysPermission authority : this.permissions) {
                if (null != authority.getCode() && !"".equals(authority.getCode())){
                    grantedAuthority = new SimpleGrantedAuthority(authority.getCode());
                    auths.add(grantedAuthority);
                }
            }
        }*/

        /*if (CollectionUtils.isNotEmpty(this.roles)) {
            GrantedAuthority roleAuth;
            for (String roleValue : this.roles) {
                roleAuth = new SimpleGrantedAuthority(roleValue);
                auths.add(roleAuth);
            }
        }*/


        return auths;
    }

    @Override
    public String getUsername() {
        return super.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
