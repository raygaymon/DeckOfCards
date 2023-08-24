export interface Card {
    image: string,
    value: string,
    suit: string,
    remaining: string
};

export interface Deck {
    deck_id: string,
    shuffled: string,
    remaining: number,
};