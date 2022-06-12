package com.ncinga.backend.repositories;

import com.ncinga.backend.models.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TemplateRepository extends MongoRepository<Template, String> {
    @Query(value = "{name: {$regex:?0}}", sort = "{name:1}")
    Optional<List<Template>> findTemplatesByName(String name);
}
