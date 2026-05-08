package games;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack{
    ArrayList <String> cards = new ArrayList<>();
    ArrayList<String> playerCards = new ArrayList<>();
    ArrayList<String> diceCards = new ArrayList<>();
    public static Scanner scanBot = new Scanner(System.in);
    public static int runs =0;


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
        //sets up the deck for blackjack with 4 of each type of card


    }

   

    public boolean hit(ArrayList<String> guysCards){
        String newCard = drawCard();
        guysCards.add(newCard);
        //Draws a new card into the deck of parameter
        if(newCard.equals("8")||newCard.equals("Ace")){
            System.out.println("You drew an "+newCard);
        }
        else{
            System.out.println("You drew a "+ newCard);
        }
        //checks whether it should print a or an for the word
        if(getScore(guysCards)>21){
            return false;
        }
        else{
            return true;
        }
        //checks if person busts and looses the game
    }

    public int getScore(ArrayList<String> dudesCards){
        int aceCount = 0;
        int total = 0;
        for (int i = 0; i<dudesCards.size();i++){
            //adds up the scores of all of the cards except for aces
            //counts howmany aces
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
        for ( int i = aceCount; i>=0; i--){
            //checks if aces can be counted as 11 without going over 21; otherwise adds 1
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
        //gets a random card from the deck, returns the card and removes it from the deck
    }

    public ArrayList<String> getPlayerCards(){
        return playerCards;
    }

    public ArrayList<String> getDiceCards(){
        return diceCards;
    }
    //geters


    public static void playBlackJack(String charName){
        //actual game
        boolean keepPlaying = true;
        BlackJack currentGame = new BlackJack();
        while(keepPlaying){
        runs++;
        boolean inputWorks = false;
            System.out.print("You drew ");
            //draws and reaveals the players first 2 cards. if the player drew 2 of the same card says you got 2 __s
        for(int i = 0; i<2; i++){
            currentGame.getPlayerCards().add(currentGame.drawCard());
            currentGame.getDiceCards().add(currentGame.drawCard());
        }
        if( currentGame.getPlayerCards().get(0).equals(currentGame.getPlayerCards().get(1))){
            System.out.println("two "+currentGame.getPlayerCards().get(0)+"s");
        }
        else{
            //checks if an or a should be used for first and second card individually
            if(currentGame.getPlayerCards().get(0).equals("8")||currentGame.getPlayerCards().get(0).equals("Ace")){
                System.out.print("an "+ currentGame.getPlayerCards().get(0));
            }
            else{
                System.out.print("a "+currentGame.getPlayerCards().get(0));
            }

            if(currentGame.getPlayerCards().get(1).equals("8")||currentGame.getPlayerCards().get(1).equals("Ace")){
                System.out.println(" and an "+ currentGame.getPlayerCards().get(1));
            }
            else{
                System.out.println(" and a "+currentGame.getPlayerCards().get(1));
            }
        }

        //reveals pets first card checking if a or an should be used
        System.out.print("Your pet has ");
        if(currentGame.getDiceCards().get(0).equals("8")||currentGame.getDiceCards().get(0).equals("Ace")){
                System.out.println("an "+ currentGame.getDiceCards().get(0));
            }
            else{
                System.out.println("a "+currentGame.getDiceCards().get(0));
            }


           while(!inputWorks){
            //goes until A. Stand is chosen or B. player goes over 21
            System.out.println("[H] hit or [S] stand");
            String newInput = scanBot.nextLine();
                if(newInput.toUpperCase().equals("H")){
                    //checks if over 21
                    if(!currentGame.hit(currentGame.getPlayerCards())){
                        System.out.println("Bust\nYou lose :(");
                        inputWorks=true;
                    }
                    else{
                        //reveals card if not over 21
                        System.out.print("You drew a");
                        if(currentGame.getPlayerCards().get(currentGame.getPlayerCards().size()-1).equals("8")||currentGame.getPlayerCards().get(currentGame.getPlayerCards().size()-1).equals("Ace")){
                            System.out.println("n "+currentGame.getPlayerCards().get(currentGame.getPlayerCards().size()-1));
                        }
                        else{
                            System.out.println(" "+ currentGame.getPlayerCards().get(currentGame.getPlayerCards().size()-1));
                        }
                    }
                }
                else if (newInput.toUpperCase().equals("S")){
                    //plays the pet turn 
                    inputWorks = true;
                    int stopPoint;
                    switch(charName){
                        //sets different stop points for drawing depending on the pet
                        case("Onion Emberwind"):
                            System.out.println("Onion reveals their "+currentGame.getDiceCards().get(1));
                            stopPoint = 17;
                            break;
                        case("Yareal"):
                            System.out.println("Yareal reveals their "+currentGame.getDiceCards().get(1));
                            stopPoint = 16;
                            break;
                        case("The Crawler"):
                            System.out.println("The Crawler reveals their "+currentGame.getDiceCards().get(1));
                            stopPoint = 20;
                            break;
                        case("Speedy & Simon"):
                            if((int)(Math.random()*2)==0){
                                System.out.println("Speedy reveals he and Simon's "+currentGame.getDiceCards().get(1));
                                stopPoint = 19;
                                //decides if simon or speedy is drawing. both having seperate stop points.
                            }
                            else{
                                System.out.println("Simon reveals he and Speedy's "+currentGame.getDiceCards().get(1));
                                stopPoint = 13;
                            }
                            break;
                        default:
                            System.out.println("Your pet reveals their "+currentGame.getDiceCards().get(1));
                            stopPoint = 16;
                            break;
                    }
                    while(currentGame.getScore(currentGame.getDiceCards())<stopPoint){
                      if(!currentGame.hit(currentGame.getDiceCards())){
                        System.out.println(charName +" went over 21. You Win!");
                      }
                      //checks if pet won or lost
                      else if(currentGame.getScore(currentGame.getDiceCards())>currentGame.getScore(currentGame.getPlayerCards())){
                        stopPoint = 0; 
                        System.out.println(charName+" won with a "+currentGame.getDiceCards().get(currentGame.getDiceCards().size()-1));
                      }
                      //Says which pet won and the last card they drew to do it
                      else if(currentGame.getScore(currentGame.getDiceCards()) >=stopPoint){
                        System.out.print(charName + " stopped drawing cards ");
                        // stoping point reached
                        if(currentGame.getScore(currentGame.getDiceCards())==currentGame.getScore(currentGame.getPlayerCards())){
                            System.out.println("You tied!");
                        }
                        //checks if player tied or did better
                        else{
                            System.out.println("YOU WIN!!");
                        }
                      }
                    }
                }
           }
           System.out.println("\nPlay again?\n[Y]: yes    [N]: no");

          
           boolean valid = false;
           while(!valid){
            //waits for a valid input, then continues or stops the loop
             String input = scanBot.nextLine();
           if(input.toUpperCase().equals("N")){
                keepPlaying = false;
                valid = true;
           }
           else if (input.toUpperCase().equals("Y")){
                currentGame = new BlackJack();
                valid = true;

           }
           else{
            System.out.println("Invalid input. Try again.");
           }
           }
        }
    }

        public static int getRuns(){
            int x = runs;
            runs = 0;
            return x;
        //gets amount of times the game was playn so that the pets happiness could be adjusted 
        }

    }