package com.film.controller;

import com.film.entity.User;
import com.film.service.UserService;
import com.film.util.ResponseData;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    ResponseData responseData;
    @Autowired
    UserService userService;

    /**
     * 首页地址,登录页面
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @GetMapping("/toRegister")
    public String register(){
        return "register";
    }

    /**
     * 去用户页面
     * @return
     */
    @GetMapping("/toUser")
    public String toUser(){
        return "user/main";
    }

    /**
     * 去管理员页面
     * @return
     */
    @GetMapping("/toAdmin")
    public String toAdmin(){
        return "admin/main";
    }

    /**
     * 注册方法
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/register")
    public Map<String,Object> register(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        if (StringUtils.isNullOrEmpty(account)|| StringUtils.isNullOrEmpty(pwd)
                ||StringUtils.isNullOrEmpty(age)||StringUtils.isNullOrEmpty(gender)
                ||StringUtils.isNullOrEmpty(address)){
            map.put("status",responseData.STATUS_NULL);
        }else{
            User user = new User();
            user.setAccount(account);
           List<User> userList = userService.queryAll(user);
            if (userList.size()>0){
                map.put("status",responseData.STATUS_EXISTS);
            }else {
                user.setPassword(pwd);
                user.setAge(Integer.parseInt(age));
                user.setGender(gender);
                user.setAddress(address);
                user.setRole("1");
                userService.insert(user);
                map.put("status",responseData.STATUS_SUCCESS);
            }
        }
        return map;
    }

    /**
     * 登陆方法
     * @param request
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public Map<String,Object> login(HttpServletRequest request, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        if (StringUtils.isNullOrEmpty(account)|| StringUtils.isNullOrEmpty(pwd)){
            map.put("status",responseData.STATUS_NULL);
        } else {
            User user = new User(account,pwd);
            List<User> userList = userService.queryAll(user);
            if (userList.size()>0){
                session.setAttribute("user",userList.get(0));
                if (userList.get(0).getRole().equals("0")){
                    map.put("status",responseData.STATUS_ADMIN);
                }else if (userList.get(0).getRole().equals("1")){
                    map.put("status",responseData.STATUS_USER);
                }
            }else {
                map.put("status",responseData.STATUS_FAIL);
            }
        }
        return map;
    }

}
