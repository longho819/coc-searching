//package com.longho.cocsearch.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.resource.ContentVersionStrategy;
//import org.springframework.web.servlet.resource.VersionResourceResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
///**
// * Created by leho on 2/24/17.
// */
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.longho.cocsearch")
//public class WebConfig  extends WebMvcConfigurerAdapter{
//    @Bean
//    public InternalResourceViewResolver resolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
//                .addVersionStrategy(new ContentVersionStrategy(),"/**");
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/")
//                .setCachePeriod(1)
//        .resourceChain(true)
//        .addResolver(versionResourceResolver);
//    }
//}
