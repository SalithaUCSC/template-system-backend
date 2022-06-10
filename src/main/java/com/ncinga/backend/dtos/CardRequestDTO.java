package com.ncinga.backend.dtos;

import com.ncinga.backend.models.Card;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
public class CardRequestDTO {
    String templateId;
    Card card;
}
