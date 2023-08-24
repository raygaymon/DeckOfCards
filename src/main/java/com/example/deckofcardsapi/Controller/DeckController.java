package com.example.deckofcardsapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.deckofcardsapi.Service.DeckOfCardsService;


@RestController
@RequestMapping("/api")
public class DeckController {
    @Autowired
    private DeckOfCardsService service;

    @GetMapping("/new")
    public ResponseEntity<String> getNewDeck () {
        String deckId = service.getNewDeckID();
        return service.shuffleDeck(deckId);
    }

    // do1sx5ko97pi

    @GetMapping("/draw/{deckId}/{count}")
    public ResponseEntity<String> drawCards (@PathVariable Integer count, @PathVariable String deckId) {
        ResponseEntity<String> drawnCards = service.drawCards(count, deckId);
        return drawnCards;
    }

    @GetMapping("/shuffle/{deckId}")
    public ResponseEntity<String> shuffleDeck (@PathVariable String deckId){
        return service.shuffleDeck(deckId);
    }
}
