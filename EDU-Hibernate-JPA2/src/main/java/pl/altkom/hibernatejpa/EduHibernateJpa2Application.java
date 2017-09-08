package pl.altkom.hibernatejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import pl.altkom.hibernatejpa.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"pl.altkom.hibernatejpa"})
public class EduHibernateJpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(EduHibernateJpa2Application.class, args);
	}
}
