package com.ncinga.backend.services;

import com.ncinga.backend.models.ResponseMessage;
import com.ncinga.backend.models.Template;

import java.util.List;

public interface TemplateService {
    List<Template> getAllTemplates();
    ResponseMessage saveTemplate(Template template);
}
