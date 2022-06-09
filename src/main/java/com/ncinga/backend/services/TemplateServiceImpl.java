package com.ncinga.backend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncinga.backend.models.ResponseMessage;
import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import io.swagger.v3.core.util.Json;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateRepository templateRepository;

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<Template> getAllTemplates() {
        return this.templateRepository.findAll();
    }

    @SneakyThrows
    @Override
    public ResponseMessage saveTemplate(Template template) {
        Template templateInserted = templateRepository.save(template);
        return ResponseMessage.builder().message("Template Inserted Successfully")
            .data(
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(templateInserted)
            )
        .build();
    }
}
