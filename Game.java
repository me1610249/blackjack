package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public Player[] users = new Player[4];
    public Card[] papers = new Card[52];
    public int[] HighScore = new int[4];
    int value, n;

    public void deckCreation() {
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                if (rank < 10) {
                    value = 10;
                } else {
                    value = rank + 1;
                }
                papers[n] = new Card(suit, rank, value);
                n++;
            }
        }
    }

    public Card DrawPapers() {
        Random random = new Random();
        Card card =null;
        Card the_paper = DrawPapers();
        do {
            int choice=random.nextInt(51);
            card = papers[choice];
            papers[choice]=null;}
            while (card==null);
return card;
            }


    public void setInfoUsers() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < users.length - 1; i++) {
            System.out.print("enter your name please");
            users[i] = new Player();
            users[i].name = scan.next();
            users[i].cardAddGame(this.DrawPapers());
            users[i].cardAddGame(this.DrawPapers());

        }
        users[3] = new Player();
        users[3].name = "dealer";
        users[3].cardAddGame(this.DrawPapers());
        users[3].cardAddGame(this.DrawPapers());
    }

    public void updateScore() {
        for (int i = 0; i < HighScore.length; i++) {
            HighScore[i] = users[i].score<=21?users[i].score:0;
        }
    }
}
