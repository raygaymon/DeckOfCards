package com.example.deckofcardsapi.Utility;

import java.io.StringReader;

import com.example.deckofcardsapi.Model.Deck;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {
    
    public static JsonObject readJsonString (String json){
        JsonReader jr = Json.createReader(new StringReader(json));
        return jr.readObject();
    }

    public Deck fromJson (JsonObject jo) {
        Deck d = new Deck();
        d.setDeckId(jo.getString("deck_id"));
        d.setRemaining(jo.getInt("remaining"));
        return d;
    }
}
