package com.ncinga.backend.services;

import com.ncinga.backend.dtos.CardLinkedList;
import com.ncinga.backend.dtos.CardRequestDTO;
import com.ncinga.backend.exceptions.TemplateNotFoundException;
import com.ncinga.backend.models.Card;
import com.ncinga.backend.models.CardPosition;
import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ncinga.backend.models.CardPosition.END;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private TemplateService templateService;

    @Override
    public Card saveCardToTemplate(CardRequestDTO cardRequest) {
        String templateId = Optional.ofNullable(cardRequest.getTemplateId())
                .orElseThrow(() -> new TemplateNotFoundException("Template is Not Found with ID"));
        int cardPosition = Integer.parseInt(cardRequest.getCardPosition());
        Optional<Template> templateOp = Optional.ofNullable(templateService.getTemplateById(templateId));
        Card newCard = cardRequest.getCard();

        // if index is zero, add to front
        // if card position is null - add to last
        // if index is given, add to the relevant place

        Template template = null;

        if (templateOp.isPresent()) {
            template = templateOp.get();
            CardLinkedList cardsInTemplate = template.getCards();
            if (cardPosition == 0) {
                cardsInTemplate.addCardToFront(newCard);
            } else if (cardPosition == cardsInTemplate.getSize() - 1) {
                cardsInTemplate.addCardToEnd(newCard);
            } else {
                cardsInTemplate.addCardAtPosition(newCard, cardPosition);
            }
            template.setCards(cardsInTemplate);
        }


        templateService.updateTemplate(template);


        return null;
    }
}
