package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository)
    {
        return args -> {
            Book b1=new Book("When Nietzche wept",
                    LocalDate.of(2022, Month.APRIL,4),
                    1L, "Ab");
            Book b2=new Book("Atomic habits",
                    LocalDate.of(2022, Month.APRIL,4),"Bb");
            repository.saveAll(List.of(b1,b2));
        };
    }
}
