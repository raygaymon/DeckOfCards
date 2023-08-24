package com.example.deckofcardsapi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private Integer value;
    private String suit;
    private String image;

}
