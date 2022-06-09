package com.ncinga.backend.services;

import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateRepository templateRepository;

    @Override
    public List<Template> getAllTemplates() {
        return this.templateRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Template saveTemplate(Template template) {
        return templateRepository.save(template);
    }
}
