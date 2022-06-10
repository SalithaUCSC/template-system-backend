package com.ncinga.backend.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder
@Data
public class CardNode {
    String id;
    String name;
    String description;
    String timeDuration;
    CardNode parentCard;
    List<Attribute> attributes;
    String role;
}
