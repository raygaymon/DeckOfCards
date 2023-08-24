import { Component, OnInit, inject } from '@angular/core';
import { Card, Deck } from './models';
import { DeckApiService } from './services/deck-api.service';
import { ReadKeyExpr } from '@angular/compiler';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'deckofcards';

  deckId: string = '';
  remaining = 0
  service = inject(DeckApiService)
  deck: Deck[] = [];
  
  cards: Card[] = [];

  ngOnInit():void {
    this.getNewDeck()
    console.log(this.deck[0])
  }

  getNewDeck(){
    this.service.getNewDeck()
    .subscribe(response => {
      let d : Deck
      d = response;
      this.deckId = d['deck_id']
      this.deck.push(d)
      console.log(this.deck)
      this.remaining = d.remaining
      
    })
  }

  drawCards(count: number){
    this.service.drawCards(count, this.deckId).subscribe((response: any) => {
      this.remaining = response.remaining
    // this.cards = response['cards']
    // console.log(this.deckId)
    let c : Card[];
    c = response['cards']
    for (let k of c){
      let card : Card
      card = k
      this.cards.push(card)
    }
    } )
  }

  shuffle() {
    this.service.shuffle(this.deckId).subscribe(() => {
      console.log("shuffle success")
    })


  }
}
