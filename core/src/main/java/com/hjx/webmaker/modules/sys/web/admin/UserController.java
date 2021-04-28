package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.base.utils.UUIDUtil;
import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.sys.domain.User;
import com.hjx.webmaker.modules.sys.dto.UserDto;
import com.hjx.webmaker.modules.sys.service.IUserService;
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
@RequestMapping("admin/sys/user")
public class UserController extends BaseController<User> {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final static String prefix = "admin/sys/user";

    @Qualifier(value = "userService")
    @Autowired
    private IUserService userService;


    @GetMapping
    public String index() {
        return prefix + "/users";
    }

    @GetMapping("create")
    public String create(Model uiModel, UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
//        List users = this.userService.getTree(null);
//        userDto.setChildren(users);
        uiModel.addAttribute("user", userDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        UserDto user = this.userService.selectByUserName(id);

        uiModel.addAttribute("user", user);
        return prefix + "/edit";
    }

    @PostMapping
    public String create(Model uiModel, @ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {
        //-------------- 前端错误显示
        /*<span th:if="${#fields.hasErrors('user.username')}" th:errors="${user.username}"></span>*/

        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        uiModel.addAttribute("user", userDto);

        if (bindingResult.hasErrors()) {
            return prefix + "/create";
        }
        userDto.setCreateTime(new Date());
        userDto.setId(UUIDUtil.generateUUID());
        this.userService.insert(userDto);
        attributes.addAttribute("msg", "执行成功");
        return "redirect:/" + prefix + "/create";
    }

    @PostMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, @ModelAttribute UserDto user, HttpServletRequest request, HttpServletResponse response) {
        User chan = this.userService.selectByPrimaryKey(id);

        user.setUpdateTime(new Date());
        this.userService.update(user);
        uiModel.addAttribute("user", user);
        return "redirect:/" + prefix + "/edit/"+id;
    }
}
