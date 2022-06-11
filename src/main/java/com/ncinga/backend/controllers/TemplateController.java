package com.ncinga.backend.controllers;

import com.ncinga.backend.models.Template;
import com.ncinga.backend.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    private final TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping("")
    public ResponseEntity<List<Template>> getAllTemplates() {
        return ResponseEntity.ok().body(templateService.getAllTemplates());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Template>> getTemplateByName(@PathVariable String name) {
        return ResponseEntity.ok().body(templateService.getTemplatesByName(name));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Template> getTemplateById(@PathVariable String id) {
        return ResponseEntity.ok().body(templateService.getTemplateById(id));
    }

    @PostMapping("")
    public ResponseEntity<Template> saveTemplate(@RequestBody Template template) {
        return ResponseEntity.ok().body(templateService.saveTemplate(template));
    }

    @PutMapping("/update")
    public void updateTemplate(@RequestBody Template template) {
        templateService.updateTemplate(template);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTemplate(@PathVariable String id) {
        templateService.deleteTemplate(id);
    }

}
