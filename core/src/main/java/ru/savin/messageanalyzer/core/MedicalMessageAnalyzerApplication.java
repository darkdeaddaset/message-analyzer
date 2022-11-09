package ru.savin.messageanalyzer.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan(value = "ru.savin.messageanalyzer")
@EntityScan("liga.medical.core.model")
@EnableJpaRepositories("liga.medical.core.repository")
public class MedicalMessageAnalyzerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalMessageAnalyzerApplication.class, args);
    }
}
