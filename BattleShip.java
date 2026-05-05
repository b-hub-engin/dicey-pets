/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BattleShip{
    





    public BattleShip(String name){
        Scanner scanBot = new Scanner(System.in);
        boolean playingGame = true;
        boolean gettingInput = true;
        int[] coords;
        String[][] enemyBoard =new String[10][];
        String[][] playerBoard =new String[10][];


        while(playingGame){
            //initializes the enemy and player boards as 10 blank squares lines 20-29 each spot [ ]
            for(int i = 0; i<10; i++){
                for(int j = 0; j<10; j++){
                    enemyBoard[i][j]="[ ]"
                }
            }
            for(int i = 0; i<10; i++){
                for(int j = 0; j<10; j++){
                    playerBoard[i][j]="[ ]"
                }
            }

            //has the player place 4 battleships. cant overlap or go off the board

            //places battleships randomly for the pet

            //lets player shoot once

            //pet shoots. amount of shots + accuracy det by pet





            gettingInput = true; 
            while(gettingInput){
                // checks for if input is a y or n, thencontinues or stops loop depending on answer
                String input = scanBot.nextLine();
                if(input.toUpperCase().equals("Y")){
                    gettingInput=false;
                }
                else if (input.toUpperCase().equals("N")){
                    gettingInput = false;
                    playingGame = false;
                }
            }
        }
    }






public void placeShip(int x, int y, boolean vert){

}





public void shoot(int x, int y){

}



//returns the integer values of a shot input for the array coordinates
//ex (A1) returns int[0,0]
//(C5) returns int [2,4]
public int[2] getCoordinates(String coords){
    int[] coordinateList = new int[2];
    coordinateList[0]= coords.substring(0,1).toUpperCase().compareTo("A");
    coordinateList[1]= Integer.parseInt(coords.substring(1))-1;
    return(coordinateList);
}


}
*/