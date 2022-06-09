package com.ncinga.backend.models;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "templates")
@Data
@Jacksonized
public class Template {
    @Id String id;
    String name;
    String description;
    List<Card> cards;
}
