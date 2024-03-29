package com.example.monitor.interceptor;

import com.example.monitor.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* 地址过滤 */
        String uri = request.getRequestURI() ;
        if (uri.contains("/user/login") || uri.contains("/validate") || uri.contains("/user/register") || uri.contains("/wx")){
            return true ;
        }
        //http的header中获得token
        String token = request.getHeader(JWTUtils.USER_LOGIN_TOKEN);
        //token不存在
        if (token == null || token.equals("")) {
            throw new Exception("请先登录");
        }
        //验证token
        String sub = JWTUtils.validateToken(token);
        if (sub == null || sub.equals("")){
            throw new Exception("token验证失败");
        }
        //更新token有效时间 (如果需要更新其实就是产生一个新的token)
        if (JWTUtils.isNeedUpdate(token)) {
            String newToken = JWTUtils.createToken(sub);
            response.setHeader(JWTUtils.USER_LOGIN_TOKEN, newToken);
        }
        return true;
    }
}