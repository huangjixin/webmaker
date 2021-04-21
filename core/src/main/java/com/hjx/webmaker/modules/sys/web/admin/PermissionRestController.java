package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.base.web.BaseRestController;
import com.hjx.webmaker.modules.sys.domain.Permission;
import com.hjx.webmaker.modules.sys.mapper.RoleMapper;
import com.hjx.webmaker.modules.sys.service.IPermissionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("admin/sys/permission")
public class PermissionRestController extends BaseRestController<Permission> {
    private static Logger logger = LoggerFactory.getLogger(PermissionRestController.class);

    @Qualifier(value = "permissionService")
    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 生成数据结构的权限树
     *
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "获取权限数据结构数据", notes = "获取权限数据结构数据", httpMethod = "GET", tags = "权限管理相关api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父亲ID，默认为空字符串，如果不为空还要查询该字段所在条目，再在列表当中设置为选中状态", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roleId", value = "角色ID，默认为空字符串，如果不为空还要查询该字段所在条目数，再在列表当中设置为选中状态", dataType = "String", paramType = "query"),
    })
    @GetMapping("tree")
    public List<Permission> tree(@RequestParam(name = "parentId", required = false, defaultValue = "") String parentId,
                                 @RequestParam(name = "roleId", required = false, defaultValue = "") String roleId,
                                 HttpServletRequest request, HttpServletResponse response) {
        List<Permission> list = this.permissionService.getTree(parentId, roleId);
        return list;
    }
}
