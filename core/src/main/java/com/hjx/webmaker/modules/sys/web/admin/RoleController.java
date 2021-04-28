package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.base.utils.UUIDUtil;
import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.sys.domain.Role;
import com.hjx.webmaker.modules.sys.dto.RoleDto;
import com.hjx.webmaker.modules.sys.service.IRoleService;
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
@RequestMapping("admin/sys/role")
public class RoleController extends BaseController<Role> {
    private static Logger logger = LoggerFactory.getLogger(RoleController.class);
    private final static String prefix = "admin/sys/role";

    @Qualifier(value = "roleService")
    @Autowired
    private IRoleService roleService;


    @GetMapping
    public String index() {
        return prefix + "/roles";
    }

    @GetMapping("create")
    public String create(Model uiModel, RoleDto roleDto, HttpServletRequest request, HttpServletResponse response) {
//        List roles = this.roleService.getTree(null);
//        roleDto.setChildren(roles);
        uiModel.addAttribute("role", roleDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        Role role = this.roleService.selectByPrimaryKey(id);

        uiModel.addAttribute("role", role);
        return prefix + "/edit";
    }

    @PostMapping
    public String create(Model uiModel, @ModelAttribute @Validated RoleDto roleDto, BindingResult bindingResult, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {
        //-------------- 前端错误显示
        /*<span th:if="${#fields.hasErrors('user.username')}" th:errors="${user.username}"></span>*/

        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        uiModel.addAttribute("role", roleDto);

        if (bindingResult.hasErrors()) {
            return prefix + "/create";
        }
        roleDto.setCreateTime(new Date());
        roleDto.setId(UUIDUtil.generateUUID());
        this.roleService.insert(roleDto);
        attributes.addAttribute("msg", "执行成功");
        return "redirect:/" + prefix + "/create";
    }

    @PostMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, @ModelAttribute Role role, HttpServletRequest request, HttpServletResponse response) {
        Role chan = this.roleService.selectByPrimaryKey(id);

        role.setUpdateTime(new Date());
        this.roleService.updateByPrimaryKeySelective(role);
        uiModel.addAttribute("role", role);
        return "redirect:/" + prefix + "/edit/"+id;
    }
}
