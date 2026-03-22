//package org.example.lab1springboot.filter;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class LoggingInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Object handler) {
//
//        System.out.println("Request: " + request.getRequestURI());
//
//        return true;
//    }
//
//}