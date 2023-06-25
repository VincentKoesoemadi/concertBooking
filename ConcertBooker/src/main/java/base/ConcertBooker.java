package base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"base"})
public class ConcertBooker {

    public static void main(String[] args) {
        SpringApplication.run(ConcertBooker.class, args);
    }
}

