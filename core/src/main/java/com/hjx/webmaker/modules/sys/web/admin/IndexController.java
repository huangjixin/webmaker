package com.hjx.webmaker.modules.sys.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("admin")
public class IndexController {

    @GetMapping
    public String index(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "admin/index";
    }
}
