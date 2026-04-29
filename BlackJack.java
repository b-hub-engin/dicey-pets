import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack{
    ArrayList <String> cards = new ArrayList<>();
    ArrayList<String> playerCards = new ArrayList<>();
    ArrayList<String> diceCards = new ArrayList<>();
    public static Scanner scanBot = new Scanner(System.in);
    public BlackJack(){
        for(int i= 0; i<4; i++){
            cards.add("Ace");
            cards.add("2");
            cards.add("3");
            cards.add("4");
            cards.add("5");
            cards.add("6");
            cards.add("7");
            cards.add("8");
            cards.add("9");
            cards.add("10");
            cards.add("Jack");
            cards.add("Queen");
            cards.add("King");
        }
        System.out.print("You drew ");
        for(int i = 0; i<2; i++){
            playerCards.add(drawCard());
            diceCards.add(drawCard());
        }
        if( playerCards.get(0).equals(playerCards.get(1))){
            System.out.println("two "+playerCards.get(0)+"s");
        }
        else{
            if(playerCards.get(0).equals("8")||playerCards.get(0).equals("Ace")){
                System.out.print("an "+ playerCards.get(0));
            }
            else{
                System.out.print("a "+playerCards.get(0));
            }

            if(playerCards.get(1).equals("8")||playerCards.get(1).equals("Ace")){
                System.out.println("an "+ playerCards.get(1));
            }
            else{
                System.out.println("a "+playerCards.get(1));
            }
        }

    }

   

    public boolean hit(ArrayList<String> guysCards){
        String newCard = drawCard();
        guysCards.add(newCard);
        if(newCard.equals("8")||newCard.equals("Ace")){
            System.out.println("You drew an "+newCard);
        }
        else{
            System.out.println("You drew a "+ newCard);
        }
        if(getScore(guysCards)>21){
            return false;
        }
        else{
            return true;
        }
    }

    public int getScore(ArrayList<String> dudesCards){
        int aceCount = 0;
        int total = 0;
        for (int i = 0; i<dudesCards.size();i++){
            if(dudesCards.get(i).equals("Ace")) aceCount+=1;
        
            if(dudesCards.get(i).equals("2")) total+=2;
        
            if(dudesCards.get(i).equals("3")) total+=3;
        
            if(dudesCards.get(i).equals("4")) total+=4;
            
            if(dudesCards.get(i).equals("5")) total+=5;
        
            if(dudesCards.get(i).equals("6")) total+=6;
        
            if(dudesCards.get(i).equals("7")) total+=7;

            if(dudesCards.get(i).equals("8")) total+=8;
        
            if(dudesCards.get(i).equals("9")) total+=9;

            if(dudesCards.get(i).equals("10")) total+=10;

            if(dudesCards.get(i).equals("Jack")) total+=10;
        
            if(dudesCards.get(i).equals("Queen")) total+=10;
        
            if(dudesCards.get(i).equals("King")) total+=10;
        
        }
        int smallAce =0;
        for ( int i = aceCount; i>0; i++){
            if(total+11*i>21){
                smallAce +=1;
                aceCount-=1;
            }
        }
        total+=aceCount*11+smallAce;
        return(total);

    }

    public String drawCard(){
        int cardNum = (int)(Math.random()*cards.size());
        String card = cards.get(cardNum);
        cards.remove(cardNum);
        return(card);
    }

    public void playBlackJack(int charNum){
        boolean keepPlaying = true;
        while(keepPlaying){
           BlackJack currentGame = new BlackJack(); 
           boolean inputWorks = false;
           while(!inputWorks){
            System.out.println("[H] hit or [S] stand");
                if(scanBot.nextLine().toUpperCase().equals("H")){
                    
                }
           }
           System.out.println("\nPlay again?\n[Y]: yes    [N]: no");
        }

    }
}