package com.example.monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.monitor.entity.User;
import com.example.monitor.service.UserService;
import com.example.monitor.utils.JWTUtils;
import com.example.monitor.utils.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@RestController
public class LoinApi {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public Object login(@RequestParam String telephone,@RequestParam String password){
        if(telephone == null || password == null){
            return new ResultBody<>(false,500,"missing telephone or password");
        }
        User user = new User();
        user.setTelephone(telephone);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
        if(userService.login(user) == null){
            return new ResultBody<>(false,500,"账号或密码错误");
        }else {
            String token = JWTUtils.createToken(user.getTelephone());
            JSONObject res = new JSONObject();
            res.put("token",token);
            return new ResultBody<>(true,200,token);
        }
    }
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public Object register(@RequestParam String telephone,@RequestParam String password){
        if(telephone == null || password == null){
            return new ResultBody<>(false,500,"missing telephone or password");
        }
        if(userService.getByTelephone(telephone) != null){
            return new ResultBody<>(false,500,"exist");
        }else {
            User user = new User();
            user.setTelephone(telephone);
            user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
            userService.register(user);
            return new ResultBody<>(true,200,null);
        }
    }
}
