package com.ncinga.backend;

import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import com.ncinga.backend.services.TemplateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TemplateSystemBackendApplicationTests {

    @MockBean
    private TemplateRepository templateRepository;

    @Autowired
    private TemplateService templateService;

    private List<Template> allTemplates;
    private Template singleTemplate;
    private Template updateTemplate;

    @BeforeEach
    void setUp() {
        allTemplates = Arrays.asList(
                Template.builder().title("Template 1").name("template1").description("Description 1").build(),
                Template.builder().title("Template 2").name("template2").description("Description 2").build()
        );
        singleTemplate = Template.builder().id("123").title("Template 2").name("template2").description("Description 2").build();
        updateTemplate = Template.builder().id("456").title("Template 3").name("template3").description("Description 3").build();
    }

    @Test
    void findTemplatesByNameSizeTest() {
        when(templateRepository.findAll()).thenReturn(allTemplates);
        assertEquals(2, templateService.getAllTemplates().size());
    }

    @Test
    void findTemplatesByNameTest() {
        when(templateRepository.findTemplatesByName("template2"))
                .thenReturn(Optional.of(Collections.singletonList(singleTemplate)));
        assertEquals("template2", templateService.getTemplatesByName("template2").get(0).getName());
    }

    @Test
    void findTemplatesByIdTest() {
        when(templateRepository.findById("123"))
                .thenReturn(Optional.of(singleTemplate));
        assertEquals("123", templateService.getTemplateById("123").getId());
        assertNotNull(templateService.getTemplateById("123").getId());
    }

    @Test
    void saveTemplatesTest() {
        when(templateRepository.save(singleTemplate))
                .thenReturn(singleTemplate);
        assertEquals(singleTemplate, templateService.saveTemplate(singleTemplate));
    }

    @Test
    void updateTemplatesTest() {
        Template updatedTemplate = Template.builder().id("456").title("Updated Template 3").name("template3").description("Description 3").build();
        when(templateRepository.findById("456"))
                .thenReturn(Optional.of(updatedTemplate));
        when(templateRepository.save(updatedTemplate))
                .thenReturn(updatedTemplate);
        assertEquals(updatedTemplate.getTitle(), templateService.getTemplateById("456").getTitle());
    }

    @Test
    void deleteTemplatesTest() {
        templateService.deleteTemplate("123");
        verify(templateRepository, times(1)).deleteById("123");
    }

}
