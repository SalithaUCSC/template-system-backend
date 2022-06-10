package com.ncinga.backend.services;

import com.ncinga.backend.models.Template;

import java.util.List;

public interface TemplateService {
    List<Template> getAllTemplates();
    Template saveTemplate(Template template);
    Template getTemplateById(String id);
    List<Template> getTemplatesByName(String name);
    void deleteTemplate(String id);
    void updateTemplate(Template template);

}
