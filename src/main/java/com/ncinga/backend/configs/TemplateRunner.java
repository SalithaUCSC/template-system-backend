package com.ncinga.backend.configs;

import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TemplateRunner implements CommandLineRunner {

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public void run(String... args) {
        if (templateRepository.findAll().size() > 0) templateRepository.deleteAll();
        Template t1 = Template.builder().title("Template 1").name("template1").description("Template 1")
                .build();
        Template t2 = Template.builder().title("Template 2").name("template2").description("Template 2")
                .build();
        Template t3 = Template.builder().title("Template 3").name("template3").description("Template 3")
                .build();
        Template t4 = Template.builder().title("Template 4").name("template4").description("Template 4")
                .build();
        templateRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
