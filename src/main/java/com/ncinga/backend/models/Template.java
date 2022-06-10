package com.ncinga.backend.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "templates")
@Data
@Builder
@Jacksonized
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Template {
    @Id String id;
    @NonNull String name;
    @NonNull String description;
    @Builder.Default
    List<Card> cards = new ArrayList<>();
}
