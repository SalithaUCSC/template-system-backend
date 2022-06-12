package com.ncinga.backend.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder
public class Card {
    Integer id;
    String name;
    String description;
    String timeDuration;
    Integer parentId;
    List<Attribute> attributes;
    String role;
}
