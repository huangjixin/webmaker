package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.sys.dto.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class LoginController {

    private final static String login_prefix = "admin/login";
    private final static String index_prefix = "admin/index";

    @GetMapping("login")
    public String index(LoginUser loginUser, Model uiModel, HttpServletRequest request, HttpServletResponse response) {
        uiModel.addAttribute("loginUser", loginUser);
        return "admin/login";
    }

    /**
     * 登录方法
     *
     * @param user
     * @param bindingResult
     * @param request
     * @param response
     * @param session
     * @return
     */
    @PostMapping("login")
    public String login(Model uiModel, @ModelAttribute @Validated LoginUser user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response,
                        HttpSession session) {

       // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        uiModel.addAttribute("loginUser", user);

        if (bindingResult.hasErrors()) {
            return login_prefix;
        }

        return "redirect:/admin/";
    }
}
