package com.exercise.reward_management.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.i18n.LocaleContextResolver;

import java.util.Locale;

@Configuration
public class LocaleConfiguration {


    @Value("${local.lang.path}")
    private String LOCAL_LANGUAGE_PATH;

    @Value("${local.lang.default.value}")
    private String DEFAULT_LANGUAGE;

    @Bean(name = "localeContextResolver")
    public LocaleContextResolver localeContextResolver(){
        AcceptHeaderLocaleContextResolver resolver = new AcceptHeaderLocaleContextResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag(DEFAULT_LANGUAGE));
        return resolver;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource rs = new ReloadableResourceBundleMessageSource();
        rs.setBasenames(LOCAL_LANGUAGE_PATH);
        rs.setDefaultEncoding("UTF-8");
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }
}
