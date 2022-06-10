package com.ncinga.backend.controllers;

import com.ncinga.backend.models.Template;
import com.ncinga.backend.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/templates")
    public ResponseEntity<List<Template>> getAllTemplates() {
        return ResponseEntity.ok().body(templateService.getAllTemplates());
    }

    @GetMapping("/templates/name/{name}")
    public ResponseEntity<List<Template>> getTemplateByName(@PathVariable String name) {
        return ResponseEntity.ok().body(templateService.getTemplatesByName(name));
    }

    @GetMapping("/templates/id/{id}")
    public ResponseEntity<Template> getTemplateById(@PathVariable String id) {
        return ResponseEntity.ok().body(templateService.getTemplateById(id));
    }

    @PostMapping("/templates")
    public ResponseEntity<Template> saveTemplate(@RequestBody Template template) {
        return ResponseEntity.ok().body(templateService.saveTemplate(template));
    }

}
