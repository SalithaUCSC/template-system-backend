package com.ncinga.backend.services;

import com.ncinga.backend.dtos.CardRequestDTO;
import com.ncinga.backend.exceptions.TemplateNotFoundException;
import com.ncinga.backend.models.Card;
import com.ncinga.backend.models.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private TemplateService templateService;

    @Override
    public Card saveCardToTemplate(CardRequestDTO cardRequest) {

        String templateId = Optional.ofNullable(cardRequest.getTemplateId())
                .orElseThrow(() -> new TemplateNotFoundException("Template is Not Found with ID"));
        String cardPositionStr = cardRequest.getCardPosition();

        Optional<Template> templateOp = Optional.ofNullable(templateService.getTemplateById(templateId));
        Template template;

        Card newCard = cardRequest.getCard();
        LinkedList<Card> cardsInTemplate;

        if (templateOp.isPresent()) {
            template = templateOp.get();
            cardsInTemplate = template.getCards();
            newCard.setId(cardsInTemplate.size() + 1);
            if (cardsInTemplate.size() == 0) {
                newCard.setParentId(null);
            } else {
                setParentToCard(cardsInTemplate, newCard);
            }
            addCardToPosition(cardsInTemplate, newCard, cardPositionStr);
            template.setCards(cardsInTemplate);
            templateService.updateTemplate(template);
        } else {
            throw new RuntimeException();
        }
        return null;
    }

    private void setParentToCard(LinkedList<Card> cardsInTemplate, Card newCard) {
        Card lastCard = cardsInTemplate.get(cardsInTemplate.size() - 1);
        Optional<Integer> lastParentIdOp = Optional.ofNullable(lastCard.getParentId());
        if (lastParentIdOp.isPresent()) {
            newCard.setParentId(lastCard.getId());
        } else {
            newCard.setParentId(1);
        }
    }

    private void addCardToPosition(LinkedList<Card> cardsInTemplate, Card newCard, String cardPositionStr) {
        if (cardPositionStr == null) {
            cardsInTemplate.addLast(newCard);
        } else {
            int cardPosition = Integer.parseInt(cardPositionStr);
            if (cardPosition == 0) {
                cardsInTemplate.addFirst(newCard);
            } else if (cardPosition < 0 || cardPosition >= cardsInTemplate.size()) {
                throw new RuntimeException("Invalid Index For Template Card: " + cardPositionStr);
            } else if (cardPosition == cardsInTemplate.size() - 1) {
                cardsInTemplate.addLast(newCard);
            } else {
                Card lastCard = cardsInTemplate.get(cardPosition);
                newCard.setId(lastCard.getId());
                newCard.setParentId(cardsInTemplate.get(cardPosition - 1).getId());
                cardsInTemplate.add(cardPosition, newCard);
                for (int i = cardPosition + 1; i < cardsInTemplate.size(); i++) {
                    Card nextCard = cardsInTemplate.get(i);
                    nextCard.setId(i + 1);
                    nextCard.setParentId(i);
                }
            }
        }
    }

}
