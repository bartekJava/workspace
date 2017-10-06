package pl.altkom.hibernatejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"pl.altkom.hibernatejpa"})
public class EduHibernateJpa2Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EduHibernateJpa2Application.class, args);
	}
}
