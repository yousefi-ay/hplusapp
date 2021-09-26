package com.test.hplus.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class Logginginterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //get all cooke
        //log session id
        //log request path

        String sessionid=null;


        if (null!=request.getCookies())
        {
            for(Cookie cookie : request.getCookies())
            {
                if ("JSESSIONID".equals(cookie.getName()))
                {
                    sessionid=cookie.getValue();

                }

            }
        }

        System.out.println(
                "incomming request data log: session : " + sessionid
                + " at " + new Date() + " for  " + request.getRequestURI()
        );

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("in post handler");
    }
}
