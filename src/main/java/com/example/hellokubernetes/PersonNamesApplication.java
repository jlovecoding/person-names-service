package com.example.hellokubernetes;

import com.example.hellokubernetes.model.PersonName;
import com.example.hellokubernetes.repository.PersonNamesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class PersonNamesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonNamesApplication.class, args);
    }

    @Component
    public class PersonNamesInitializer implements CommandLineRunner {

        @Autowired
        private PersonNamesRepository personNamesRepository;

        @Override
        public void run(String... strings) throws Exception {
            personNamesRepository.deleteAll();
            Stream.of("John", "Paul")
                    .map(name -> PersonName.builder().personName(name).build())
                    .peek(personNamesRepository::save)
                    .forEach(name -> log.info("Saved name " + name));
        }
    }
}

