package com.example.deckofcardsapi.Service;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.deckofcardsapi.Utility.Utils;

import jakarta.json.JsonObject;

@Service
public class DeckOfCardsService {
    
    public static final String deckApi = "https://www.deckofcardsapi.com/api/deck/";

    public String getNewDeckID (){
        RequestEntity<Void> re = RequestEntity
                                    .get(deckApi + "new")
                                    .build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(re, String.class);
        JsonObject jo = (Utils.readJsonString(response.getBody()));
        String deckId = jo.getString("deck_id");
        return deckId;
    }

    public ResponseEntity<String> shuffleDeck (String id) {
        RequestEntity<Void> re = RequestEntity
                                    .get(deckApi + id + "/shuffle/?remaining=true")
                                    .build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(re, String.class);
        return response;
    }

    public ResponseEntity<String> drawCards (Integer number, String deckId){
        RequestEntity<Void> re = RequestEntity
                                    .get(deckApi + deckId + "/draw/?count=" + number)
                                    .build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(re, String.class);
        return response;
    }

    
}
