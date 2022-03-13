package blackjack;

import java.util.Scanner;

public class BlackJack {

      static Game game = new Game();
    public static void main(String[] args) {
    GUI gui = new GUI();
        game.deckCreation();
        game.setInfoUsers();
        gui.runGUI(game.papers,game.users[0].Hands,game.users[1].Hands
                ,game.users[2].Hands,game.users[3].Hands);
        usersTurn();
        game.updateScore();
        dealerTurn(gui);
        checkgame();
    }
    public static void usersTurn(){
        Scanner input = new Scanner(System.in);
        String output="";
        for (int i=0;i<game.users.length-1;i++){
            while (!output.toLowerCase().equals("stand")){
                output=input.next();
                System.out.print("Player Number"+(i+1)+"Hit or Stand");
                if ( !output.toLowerCase().equals("hit")){

                }
            }
        }

    }
    public static void addCardtoUsers (int index, GUI gui){
        Card card = game.DrawPapers();
        game.users[index].cardAddGame(card);
        gui.updatePlayerHand (card,index);
    }
    public static void dealerTurn (GUI gui){
        boolean dealerWinner=true;
        int maximScore =0;
        for (int i=0; i<game.users.length-1;i++){
         if (game.HighScore[i]>=game.users[3].score){
             dealerWinner=false;
         }
         if (game.HighScore[i]>maximScore){
             maximScore=game.HighScore[i];
         }
        }
        if (!dealerWinner){
            addCardtodealer(gui,maximScore);
        }else {
            return;
        }
    }
    public static void  addCardtodealer(GUI gui ,int maxScore){
     while (game.users[3].score<maxScore){
         Card card = game.DrawPapers();
         game.users[3].cardAddGame(card);
         gui.updateDealerHand(card,game.papers);
     }
    }
    public static void checkgame(){
int higHscore=0;
int winner=-1;
for (int i=0;i<game.papers.length;i++){
    if (game.HighScore [i]< higHscore){
        higHscore = game.HighScore[i];
        winner=i;
    }
}
 if (winner <0){
     System.out.print("the winner is"+game.users[winner].name+"with score "+higHscore);

 }
    }
}
