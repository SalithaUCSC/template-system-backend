package com.ncinga.backend.controllers;

import com.ncinga.backend.models.Template;
import com.ncinga.backend.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @GetMapping("/templates")
    public ResponseEntity<List<Template>> getAllTemplates() {
        return ResponseEntity.ok().body(templateService.getAllTemplates());
    }

}
