package dk.anno1980.springongcp.cloudfunctions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static java.lang.String.format;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Supplier<String> function() {
        return () -> {
            log.info("Request to /time");
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            return format("{\"utc\": \"%s\"}", ISO_LOCAL_DATE_TIME.format(now));
        };
    }
}
