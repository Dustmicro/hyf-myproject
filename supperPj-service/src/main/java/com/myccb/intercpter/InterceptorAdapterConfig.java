//package com.myccb.intercpter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * 注册拦截器方式（一）
// * @author 黄弋峰
// */
//public class InterceptorAdapterConfig extends WebMvcConfigurerAdapter  {
//    @Autowired
//    private AuthorityInterceptor authorityInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry)
//    {
//        //注册自己的拦截器并设置拦截的请求路径
//        registry.addInterceptor(authorityInterceptor).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//}
