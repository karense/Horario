package com.example.Horarios.interceptor;


import com.example.Horarios.dto.TeacherDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class ValidationInterception implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        /*boolean IS_METHOD_EQUALS_TO_POST = "POST".equals(request.getRequestURI().split("/")[1]);

        if(IS_METHOD_EQUALS_TO_POST){
            String path = request.getRequestURI().split("/")[1];

            switch (path){
                case "/teacher":
                    System.out.println(request.getContextPath());
                    break;

            }
            return true;
        }*/

        return true;
    }
}
