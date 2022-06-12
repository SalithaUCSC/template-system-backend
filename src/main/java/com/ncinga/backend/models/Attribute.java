package com.ncinga.backend.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class Attribute {
    String key;
    String value;
}
