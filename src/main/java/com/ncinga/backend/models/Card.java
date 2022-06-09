package com.ncinga.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cards")
@Data
public class Card {
    @Id String id;
    String name;
    String description;
    String timeDuration;
    String parentCard;
    List<Attribute> attributes;
    String role;
}
