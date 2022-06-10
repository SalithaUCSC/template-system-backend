package com.ncinga.backend.services;

import com.ncinga.backend.exceptions.TemplateNotFoundException;
import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateRepository templateRepository;

    @Override
    public List<Template> getAllTemplates() {
        return this.templateRepository.findAll();
    }

    @Override
    public Template saveTemplate(Template template) {
        return templateRepository.save(template);
    }

    @Override
    public Template getTemplateById(String id) {
        Optional<Template> template = templateRepository.findById(id);
        if (template.isPresent()) {
            return template.get();
        } else {
            throw new TemplateNotFoundException("Template is Not Found with ID: " + id);
        }
    }

    @Override
    public List<Template> getTemplatesByName(String name) {
        Optional<List<Template>> template = templateRepository.findTemplatesByName(name);
        if (template.isPresent()) {
            return template.get();
        } else {
            throw new TemplateNotFoundException("Templates are Not Found with Name: " + name);
        }
    }
}
