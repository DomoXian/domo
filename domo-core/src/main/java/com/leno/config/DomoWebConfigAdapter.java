package com.leno.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XianGuo
 * Date: 2017-10-12 16:51
 */
@Configuration
public class DomoWebConfigAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DomoIntercept()).excludePathPatterns(getExcludePathPatterns());
        super.addInterceptors(registry);
    }

    /**
     * 设置不拦截的页面
     */
    private String[] getExcludePathPatterns(){
        List<String> pattern = new ArrayList<>();
        pattern.add("/");
        pattern.add("/login");
        pattern.add("/500");
        pattern.add("/404");
        pattern.add("/401");
        pattern.add("/error");
        return pattern.toArray(new String[pattern.size()]);
    }
}
