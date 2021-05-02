package dk.anno1980.springongcp.cloudrun;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@SpringBootApplication
@RestController
@Slf4j
public class SpringOnGcpCloudRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOnGcpCloudRunApplication.class, args);
    }

    @GetMapping("/time")
    public String time() {
        log.info("Request to /time");
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        return format("{\"utc\": \"%s\"}", ISO_LOCAL_DATE_TIME.format(now));
    }

}
