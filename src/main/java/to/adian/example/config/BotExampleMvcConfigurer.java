package to.adian.example.config;

import java.util.logging.Logger;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import to.adian.example.BotExampleApplication;

@Configuration
public class BotExampleMvcConfigurer implements WebMvcConfigurer {

    private static final Logger LOGGER = Logger.getLogger(BotExampleMvcConfigurer.class.getName());

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String downloadedContentUri = BotExampleApplication.downloadedContentDir
                .toUri().toASCIIString();

        LOGGER.info("Download directory: " + downloadedContentUri);

        registry.addResourceHandler("/downloaded/**")
                .addResourceLocations(downloadedContentUri);
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
