package com.exercise.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
@Component
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass().getName()+"初始化。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("处理请求： "+servletRequest);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("处理响应："+servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("servlet关闭");
    }
}
