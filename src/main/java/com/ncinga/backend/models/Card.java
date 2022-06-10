package com.ncinga.backend.models;

import lombok.Data;

import java.util.List;

@Data
public class Card {
    Integer id;
    String name;
    String description;
    String timeDuration;
    Integer parentId;
    List<Attribute> attributes;
    String role;
}
