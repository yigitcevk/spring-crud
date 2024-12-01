package com.example.demo.athlete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AthleteConfig {

    @Bean
    CommandLineRunner commandLineRunner(AthleteRepository athleteRepository) {
        return args -> {
            Athlete yigit = new Athlete(
                    "Yigit Cevik",
                    LocalDate.of(2000, Month.JULY, 23),
                    182,
                    81,
                    "male"
            );

            Athlete dale = new Athlete(
                    "Daledum dale",
                    LocalDate.of(2000, Month.JULY, 23),
                    182,
                    81,
                    "male"
            );

            athleteRepository.saveAll(
                    List.of(yigit, dale)
            );
        };
    }

}
