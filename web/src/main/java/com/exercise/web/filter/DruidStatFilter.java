package com.exercise.web.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @Author : cg.Zhou
 * @date : 2020/5/8 0008 11:46
 * @Description : druid监控拦截器
 */
@WebFilter(filterName = "druidWebStatFilter",
        urlPatterns = "/*",
        initParams =
                // 忽略资源
                { @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")}
)
public class DruidStatFilter extends WebStatFilter {
}
