package com.ncinga.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "cards")
@Data
public class Card {
    @Id String id;
    String name;
    String description;
    String timeDuration;
    String parentCard;
    List<Map<String, String>> attributes;
    String role;
}
