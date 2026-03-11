package org.example.lab1springboot.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class LoggingFilter implements Filter {


    @Override

    public void doFilter(

            ServletRequest request,
            ServletResponse response,
            FilterChain chain

    ) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Request received for: " + httpRequest.getRequestURI());

        chain.doFilter(request, response);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("Response status: " + httpResponse.getStatus());

    }



}