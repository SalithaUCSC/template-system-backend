package com.ncinga.backend.services;

import com.ncinga.backend.dtos.CardRequestDTO;
import com.ncinga.backend.models.Card;

public interface CardService {
    Card saveCardToTemplate(CardRequestDTO cardRequest);
}
