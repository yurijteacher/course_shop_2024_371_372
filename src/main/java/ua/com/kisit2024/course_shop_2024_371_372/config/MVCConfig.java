package ua.com.kisit2024.course_shop_2024_371_372.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry reg) {
       reg.
               addResourceHandler("/static/**")
               .addResourceLocations("classpath:/static/");
    }
}
