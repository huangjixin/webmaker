package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.sys.dto.LoginUser;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
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
import java.io.IOException;

//@Controller
//@RequestMapping("admin")
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
//    @PostMapping("login")
    public String login(Model uiModel, @ModelAttribute @Validated LoginUser user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response,
                        HttpSession session) {

       // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        uiModel.addAttribute("loginUser", user);

        if (bindingResult.hasErrors()) {
            return login_prefix;
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        /*

        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:12345/doPostControllerTwo");
        httpPost.
        User user = new User();
        user.setName("潘晓婷");
        user.setAge(18);
        user.setGender("女");
        user.setMotto("姿势要优雅~");
        // 我这里利用阿里的fastjson，将Object转换为json字符串;
        // (需要导入com.alibaba.fastjson.JSON包)
        String jsonString = JSON.toJSONString(user);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        return "redirect:/admin/";
    }
}
