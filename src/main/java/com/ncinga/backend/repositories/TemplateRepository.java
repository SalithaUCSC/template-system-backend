package com.ncinga.backend.repositories;

import com.ncinga.backend.models.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemplateRepository extends MongoRepository<Template, String> {
}
