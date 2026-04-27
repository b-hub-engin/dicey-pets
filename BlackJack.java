public class BlackJack{
    ArrayList <String> cards;
    ArrayList<String> playerCards;
    ArrayList<String> diceCards;
    public BlackJack(){
        cards = new ArrayList<String>;
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
        playerCards = new ArrayList<String>;
        diceCards = new ArrayList<String>;
        for(int i = 0; i<2; i++){
            playerCards.add(drawCard());
            diceCards.add(drawCard());
        }
    }

    public boolean hit(ArrayList<String> guysCards){
        guysCards.add(drawCard());
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
            if(total+11*i)>21{
                smallAce +=1;
                aceCount-=1;
            }
        }
        total+=aceCount*11+smallAce;
        return(total);

    }

    public String drawCard(){
        return(cards.remove(Math.random()*cards.size()));
    }


}