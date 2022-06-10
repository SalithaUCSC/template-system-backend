package com.ncinga.backend.dtos;

import com.ncinga.backend.models.Card;
import com.ncinga.backend.models.CardNode;

public class CardLinkedList {
    private CardNode headCard;
    private int size;

    public void addCardToFront(Card card) {
        CardNode node = createCardNode(card);
        if (!isEmpty()) {
            node.setParentCard(headCard);
        }
        headCard = node;
        size++;
    }

    public void addCardToEnd(Card card) {
        CardNode node = createCardNode(card);
        if (isEmpty()) {
            headCard = node;
        } else {
            CardNode current = headCard;
            while (current.getParentCard() != null) {
                current = current.getParentCard();
            }
            current.setParentCard(node);
        }
        size++;
    }

    public void addCardAtPosition(Card card, int position) {
        CardNode node = createCardNode(card);
        CardNode current = headCard;
        if (position == 0) {
            addCardToFront(card);
        } else if (position > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index!");
        } else {
            for (int i = 0; i < position - 1; i++) {
                if (current != null) {
                    current = current.getParentCard();
                }
            }
            if (current != null) {
                node.setParentCard(current.getParentCard());
                current.setParentCard(node);
            }
        }
        size++;
    }
    private boolean isEmpty() {
        return headCard == null;
    }

    public int getSize() {
        return size;
    }

    private CardNode createCardNode(Card card) {
        return CardNode.builder()
            .id(card.getId())
            .name(card.getName())
            .description(card.getDescription())
            .role(card.getRole())
            .timeDuration(card.getTimeDuration())
            .attributes(card.getAttributes())
        .build();
    }
}
