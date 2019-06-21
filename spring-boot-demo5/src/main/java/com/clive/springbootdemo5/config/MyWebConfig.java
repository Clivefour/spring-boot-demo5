package com.clive.springbootdemo5.config;

import com.clive.springbootdemo5.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//只要有这个注解的 他就是一个配置类
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    //重写父类的方法吧我们的自己写的拦截器加入到容器中

//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //这里我们加入了一个拦截器 是我们的拦截器 ， 拦截规则是所有页面,放行我们的登录页面 login,以及登录验证的controller
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/index", "/userLogin");
//    }
//
//    //spring boot1.5以前不会拦截我们的静态资源文件
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //配置静态资源处理  所有路径下 的 static/下的所有资源全部放行
//        registry.addResourceHandler("/**").addResourceLocations("classpath:static/");
//    }

}