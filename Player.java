package blackjack;

public class Player {
    String name;
    int score =0;
    public Card []  Hands = new Card [11];
    public int counterGame=0;
    public Player (String name, int score){
        this.name=name;
        this.score=score;
    }
    public Player(){

    }
    public void cardAddGame(Card card){
        if (counterGame<11) {
            Hands[counterGame]=card;
            counterGame++;
            score+=card.getValue();
        }
    }

}
