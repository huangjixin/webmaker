package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.base.utils.UUIDUtil;
import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.sys.domain.Permission;
import com.hjx.webmaker.modules.sys.dto.PermissionDto;
import com.hjx.webmaker.modules.sys.service.IPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("admin/sys/permission")
public class PermissionController extends BaseController<Permission> {
    private static Logger logger = LoggerFactory.getLogger(PermissionController.class);
    private final static String prefix = "admin/sys/permission";

    @Qualifier(value = "permissionService")
    @Autowired
    private IPermissionService permissionService;


    @GetMapping
    public String index() {
        return prefix + "/permissions";
    }

    @GetMapping("create")
    public String create(Model uiModel, PermissionDto permissionDto, HttpServletRequest request, HttpServletResponse response) {
//        List permissions = this.permissionService.getTree(null);
//        permissionDto.setChildren(permissions);
        uiModel.addAttribute("permission", permissionDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        Permission permission = this.permissionService.selectByPrimaryKey(id);

        uiModel.addAttribute("permission", permission);
        return prefix + "/edit";
    }

    @PostMapping
    public String create(Model uiModel, @ModelAttribute @Validated PermissionDto permissionDto, BindingResult bindingResult, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {
        //-------------- 前端错误显示
        /*<span th:if="${#fields.hasErrors('user.username')}" th:errors="${user.username}"></span>*/

        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        uiModel.addAttribute("permission", permissionDto);

        if (bindingResult.hasErrors()) {
            return prefix + "/create";
        }
        if (null == permissionDto.getParentId() || "".equals(permissionDto.getParentId())) {
            permissionDto.setParentId("0");
        }
        permissionDto.setCreateTime(new Date());
        permissionDto.setId(UUIDUtil.generateUUID());
        this.permissionService.insert(permissionDto);
        attributes.addAttribute("msg", "执行成功");
        return "redirect:/" + prefix + "/create";
    }

    @PostMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, @ModelAttribute Permission permission, HttpServletRequest request, HttpServletResponse response) {
        Permission chan = this.permissionService.selectByPrimaryKey(id);
        if (null == permission.getParentId() || "".equals(permission.getParentId())) {
            permission.setParentId("0");
        }
        permission.setUpdateTime(new Date());
        this.permissionService.updateByPrimaryKeySelective(permission);
        uiModel.addAttribute("permission", permission);
        return "redirect:/" + prefix + "/edit/"+id;
    }
}
