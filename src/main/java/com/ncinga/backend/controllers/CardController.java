package com.ncinga.backend.controllers;

import com.ncinga.backend.dtos.CardRequestDTO;
import com.ncinga.backend.models.Card;
import com.ncinga.backend.models.Template;
import com.ncinga.backend.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/add")
    public ResponseEntity<Card> saveTemplate(@RequestBody CardRequestDTO cardRequest) {
        return ResponseEntity.ok().body(cardService.saveCardToTemplate(cardRequest));
    }

}