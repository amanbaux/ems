package in.ems.cs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsApplication {
        private static final Logger LOG = LoggerFactory.getLogger(EmsApplication.class);
	public static void main(String[] args) {
                LOG.info("------------------------App Started --------------------");
		SpringApplication.run(EmsApplication.class, args);
	}

}
