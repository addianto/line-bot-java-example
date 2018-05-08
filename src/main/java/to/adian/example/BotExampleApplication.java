package to.adian.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotExampleApplication {

    private static final Logger LOGGER = Logger.getLogger(BotExampleApplication.class.getName());
    public static Path downloadedContentDir;

    public static void main(String[] args) {
        LOGGER.info("Application starting ...");

        try {
            downloadedContentDir = Files.createTempDirectory("line-bot");
            SpringApplication.run(BotExampleApplication.class, args);
        } catch (IOException e) {
            LOGGER.severe("Cannot create temporary directory");
            LOGGER.severe(String.format("Exception message: %s", e.getMessage()));
        }
    }
}
