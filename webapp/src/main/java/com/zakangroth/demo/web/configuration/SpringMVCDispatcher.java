package com.zakangroth.demo.web.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Replaces the dispatcher-servlet.xml
 *
 * @Configuration : Let spring know this contains bean definitions.
 * @EnableWebMVC : This is the same as <mvc:annotation-driven/>
 * @ComponentScan(basePackages = {�com.zakangroth.demo�}), this is the same as <context:component-scan base-package=�com.zakangroth.demo�/>
 * WebMvcConfigurerAdapter : This adds stub implementations from the WebMvcConfigurer interface which is used by @EnableWebMVC.
 * It also gives us a chance to override resources and the default handler.
 * <p/>
 * Project : password-keeper-demo
 * Created by Zakangroth on 28/10/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.zakangroth.demo"})
public class SpringMVCDispatcher extends WebMvcConfigurerAdapter {

    /**
     * View resolver for JSP files
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * Declare our static resources.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("./resources/").setCachePeriod(31556926);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean(name = "localeChangeInterceptor")
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    /**
     * Resolve the Locale from the session. If not defined : AcceptHeaderLocaleResolver is used by default.
     * AcceptHeaderLocaleResolver takes the "accept-language" HTTP header as the Locale.
     *
     * @return
     */
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        return new SessionLocaleResolver();
    }

    /**
     * Language files mapping (messages_xx.properties)
     *
     * @return
     */
    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:messages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return reloadableResourceBundleMessageSource;
    }
}
