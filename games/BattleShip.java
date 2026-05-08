package games;
import java.util.Scanner;
public class BattleShip{
    public String[][] playerBoard;
    public String[][] enemyBoard;
    public Scanner scanBot = new Scanner(System.in);
    




    public BattleShip(String name){
        
       
        int[] coords;
        enemyBoard =new String[10][10];
        playerBoard =new String[10][10];


       
            //initializes the enemy and player boards as 10 blank squares lines 20-29 each spot [ ]
            for(int i = 0; i<10; i++){
                for(int j = 0; j<10; j++){
                    enemyBoard[i][j]="[ ]";
                }
            }
            for(int i = 0; i<10; i++){
                for(int j = 0; j<10; j++){
                    playerBoard[i][j]="[ ]";
                }
            }

            //has the player place 4 battleships. cant overlap or go off the board
            int numBattleShips = 0;
            while(numBattleShips<4){
                printBoard(playerBoard);
                System.out.println("Enter coordinates to place in format [A1]");
                coords = getCoordinates(scanBot.nextLine());
                System.out.println("Place ship facing right: [R] or down: [D]");
                boolean vert =true;
                if(scanBot.nextLine().toUpperCase().equals("R")){
                    vert = false;
                }
                if (placeShip(coords[0],coords[1],vert, playerBoard)){
                    numBattleShips++;
                }

            }
            while(numBattleShips<8){
                if(name.equals("Onion Emberwind")){
                    switch((int)(Math.random()*8)){
                        case 0:
                            //onion Emberwind places all his ships in a cluster in one of the corners
                            //2 cases for each of the 4 corners vertical or horizantal ships

                            placeShip(0,0,true,enemyBoard);
                            placeShip(0,1,true,enemyBoard);
                            placeShip(0,2,true,enemyBoard);
                            placeShip(0,3,true,enemyBoard);
                            numBattleShips = 8;
                            break;
                        case 1:
                            placeShip(0,9,true,enemyBoard);
                            placeShip(0,8,true,enemyBoard);
                            placeShip(0,7,true,enemyBoard);
                            placeShip(0,6,true,enemyBoard);
                            numBattleShips = 8;
                            break;
                        case 2:
                            placeShip(6,0,true,enemyBoard);
                            placeShip(6,1,true,enemyBoard);
                            placeShip(6,2,true,enemyBoard);
                            placeShip(6,3,true,enemyBoard);
                            numBattleShips = 8;
                            break;
                        case 3:
                            placeShip(6,9,true,enemyBoard);
                            placeShip(6,8,true,enemyBoard);
                            placeShip(6,7,true,enemyBoard);
                            placeShip(6,6,true,enemyBoard);
                            numBattleShips = 8;
                            break;
                        case 4:
                            placeShip(0,0,false,enemyBoard);
                            placeShip(1,0,false,enemyBoard);
                            placeShip(2,0,false,enemyBoard);
                            placeShip(3,0,false,enemyBoard);
                            numBattleShips = 8;
                            break;
                        case 5:
                            placeShip(9,0,false,enemyBoard);
                            placeShip(8,0,false,enemyBoard);
                            placeShip(7,0,false,enemyBoard);
                            placeShip(6,0,false,enemyBoard);
                            numBattleShips = 8;
                            break;
                        case 6:
                            placeShip(0,6,false,enemyBoard);
                            placeShip(1,6,false,enemyBoard);
                            placeShip(2,6,false,enemyBoard);
                            placeShip(3,6,false,enemyBoard);
                            numBattleShips = 8;
                            break;
                        case 7:
                            placeShip(9,6,false,enemyBoard);
                            placeShip(8,6,false,enemyBoard);
                            placeShip(7,6,false,enemyBoard);
                            placeShip(6,6,false,enemyBoard);
                            numBattleShips = 8;
                            break;
                        default:
                            placeShip(9,6,false,enemyBoard);
                            placeShip(8,6,false,enemyBoard);
                            placeShip(7,6,false,enemyBoard);
                            placeShip(6,6,false,enemyBoard);
                            numBattleShips = 8;
                            break;
                    }

                }
                else{
                    boolean verticle = false;
                    if((int)(Math.random()*2)==1){
                        verticle = true;
                    }
                        if(placeShip((int)(Math.random()*10),(int)(Math.random()*10),verticle,enemyBoard))
                            numBattleShips++;
                
                }
            }
            //places battleships randomly for the pets other than onion



        
    }


public static void playBattleShip(String petName){

}   



public void printBoard(String[][] board){
    for(int i = 0 ; i<10; i++){
        for(int j = 0; j<10; j++){
            System.out.print(board[i][j]);
        }
    System.out.println();
    }
}

public boolean placeShip(int row, int col, boolean vert, String[][] board){
    boolean works = true;
    if(vert){
        
        for (int i = row; i<row+4; i++){
            if(!board[i][col].equals("[ ]")){
                works = false;
            }
        }
        if(works)
         for (int i = row; i<row+4; i++){
            board[i][col]="[U]";
        }
    }
    else{
        
        for (int i = col; i<col+4; i++){
            if(!board[row][i].equals("[ ]")){
                works = false;
            }
        }
        if(works)
         for (int i = col; i<col+4; i++){
            board[row][i]="[D]";
        }
    }
    return(works);
}





public void shoot(int x, int y){
    
}



//returns the integer values of a shot input for the array coordinates
//ex (A1) returns int[0,0]
//(C5) returns int [2,4]
public int[] getCoordinates(String coords){
    int[] coordinateList = new int[2];
    coordinateList[1]= coords.substring(0,1).toUpperCase().compareTo("A");
    coordinateList[0]= Integer.parseInt(coords.substring(1))-1;
    return coordinateList;
}


}
