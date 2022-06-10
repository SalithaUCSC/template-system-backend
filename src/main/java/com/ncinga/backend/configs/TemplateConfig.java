package com.ncinga.backend.configs;

import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TemplateConfig {
    @Bean
    CommandLineRunner commandLineRunner(TemplateRepository templateRepository) {
        return args -> {
            if (templateRepository.findAll().size() > 0) templateRepository.deleteAll();
            Template t1 = Template.builder().name("Template 1").description("Template 1")
                    .build();
            Template t2 = Template.builder().name("Template 2").description("Template 2")
                    .build();
            Template t3 = Template.builder().name("Template 3").description("Template 3")
                    .build();
            templateRepository.saveAll(Arrays.asList(t1, t2, t3));
        };
    }
}
