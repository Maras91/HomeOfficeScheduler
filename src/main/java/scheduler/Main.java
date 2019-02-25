package scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import scheduler.csv.DataBaseSender;

@SpringBootApplication
@EnableJpaAuditing
public class Main {
   public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
