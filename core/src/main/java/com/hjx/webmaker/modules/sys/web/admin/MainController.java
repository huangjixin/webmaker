package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.sys.dto.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class MainController {
 
    @GetMapping("/")
    public String root() {
        return "redirect:/admin/index";
    }
 
    @GetMapping("/index")
    public String index() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "/admin/index";
    }
 
    /**
     * 获取登录界面
     *
     * @return
     */
    @GetMapping("/login")
    public String login(LoginUser loginUser, Model uiModel) {
        uiModel.addAttribute("loginUser", loginUser);
        return "/admin/login";
    }

    @GetMapping("/login-error")
    public String loginError(LoginUser loginUser,Model model) {
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登录失败，用户名或者密码错误");
        return "/admin/login";
    }
 
    @GetMapping("/register")
    public String register() {
        return "register";
    }
 
 
    @GetMapping("/search")
    public String search() {
        return "search";
    }
}