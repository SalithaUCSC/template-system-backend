package com.ncinga.backend.services;

import com.ncinga.backend.dtos.CardRequestDTO;
import com.ncinga.backend.models.Card;
import com.ncinga.backend.models.Template;
import com.ncinga.backend.repositories.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public Card saveCardToTemplate(CardRequestDTO cardRequest) {
        String templateId = cardRequest.getTemplateId();
        Optional<Template> template = templateRepository.findById(templateId);
        if (template.isPresent()) {
            // TODO: create Linked list logic
            List<Card> cardsInTemplate = template.get().getCards();

        }
        return null;
    }
}
