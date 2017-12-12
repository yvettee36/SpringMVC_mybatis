package com.eurasia.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yvettee on 2017/12/11.
 * 登录认证拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户请求的URL
        String url = request.getRequestURI();
        //判断URL是否是公开地址（实际使用时将公开地址配置到配置文件中）
        //这里公开地址是登录提交的地址
        if (url.indexOf("login.action") >= 0) {
            //如果进行登录提交，放行
            return true;
        }

        //判断session
        HttpSession session = request.getSession();
        //从session中取出用户身份信息
        String username = (String) session.getAttribute("username");

        if (username != null) {
            //身份存在，放行
            return true;
        }

        //执行这里表示用户身份需要认证，跳转登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        //return false表示拦截，不向下执行
        //return true表示放行
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
