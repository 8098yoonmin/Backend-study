package com.nhnacademy.board.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.board.controller.BaseController;
import com.nhnacademy.board.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {BaseController.class})
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware, MessageSourceAware {

    public WebConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private final ObjectMapper objectMapper;
    private ApplicationContext applicationContext;
    private MessageSource messageSource;

    public void extendMessageConverter(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(o-> o instanceof MappingJackson2HttpMessageConverter);
        HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);

        converters.add(converter);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //todo#10  thymeleafViewResolver bean 등록
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        thymeleafViewResolver.setOrder(1);
        thymeleafViewResolver.setViewNames(new String[]{"*"});
        return thymeleafViewResolver;
    }
    //todo#11  thymeleafViewResolver 필요한 SpringTemplateEngine 생성
    //messageSource가 필요함. implement MessageSourceAware <--즉 의존성 주입을 위한 setter 구현
    public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(springResourceTemplateResolver());
        templateEngine.setTemplateEngineMessageSource(messageSource);
        //todo#16 custom Dialet 추가 .. SpringTemplateEngine 에다가 직접 추가해줘도 되고 직접 CustomTagDialet @component 붙여 놓으면 .. dialet으로 등록해줌.
        return templateEngine;
    }
    //todo#12  SpringTemplateEngine 생성때 필요한 SpringResourceTemplateResolver 생성
    //applicationContext가 필요함. implement ApplicationContextAware
    // xxxxAware 붙은 녀석들은 setter 구현하게 됨. <--즉 의존성 주입을 위한 setter 구현
    public SpringResourceTemplateResolver springResourceTemplateResolver(){
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setApplicationContext(applicationContext);
        springResourceTemplateResolver.setCharacterEncoding("UTF-8");
        springResourceTemplateResolver.setPrefix("/WEB-INF/views/");
        springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setCacheable(false);
        springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
        return springResourceTemplateResolver;
    }

    //todo#13 thymeleafViewResolver 등록
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/login/");
        registry.addRedirectViewController("/favicon.ico","/resources/favicon.ico");
    }

    @Bean
    public User user(){
        return new User("admin","관리자","/Users/yoonmin/Desktop/java_backend/backend-study/Spring MVC/4.20/board/src/main/webapp/resources/프로필.jpeg","1234");
    }


    //todo#2 cookie 기반의 localReolver bean 등록
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
        return  cookieLocaleResolver;
    }

    //todo#3 LocaleChangeInterceptor 등록 ?locale=ko or ?locale=en
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("locale");
        return localeChangeInterceptor;
    }

    //todo#4 LocaleChangeInterceptor interceptor등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
