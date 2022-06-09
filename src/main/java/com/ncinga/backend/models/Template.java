package com.ncinga.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "templates")
public class Template {
    @Id
    Long id;
    private String name;
    private String description;
}
