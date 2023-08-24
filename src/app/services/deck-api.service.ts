import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const springUrl = "http://localhost:8080/api/"

@Injectable({
  providedIn: 'root'
})
export class DeckApiService {

  constructor(private http: HttpClient) { }


  getNewDeck(): Observable<any> {
    console.log("deck service running")
    return this.http.get<any>(springUrl + 'new')
  }

  drawCards(count: number, deckId: string){
    return this.http.get<any>(`${springUrl}draw/${deckId}/${count}`
    )
  }

  shuffle(deckId: string){
    return this.http.get<any>(`${springUrl}shuffle/${deckId}`)
  }
}
