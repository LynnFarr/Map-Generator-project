//Ben Clay
//CS 240
//Creation Date: 5/13/2019
//Question Tree.
//Last Edited: 3/15/2019 
//Creates Maze

import java.util.*; //imports for random num


public class Maze {
   private int numTile; 
   private int tiles[] = new int[numTile];

   //*Constructs Maze data strcuture*//
    public Maze(int numTile) {    
         this.numTile = numTile;
         
                               
    }//end of Maze Constructor
    
    //8creates the maze data strcuture itself*
    public void create(){
      Random rand = new Random();
      int randomNum = rand.nextInt(2) +1; //creates random number to compare with
      int tileRight = 0; 
      int tileBelow = 0;
      for (int i=0; i<=tiles.length-1; i++){
         
         //grabs right tile & unions it to rep element
         if(randomNum == 1){
            tileRight = i +1; //grabs tile to right of chosen tile
            tiles[tileRight] = i;
         }//
         //grabs bottom tile & unions it to rep element
         if(randomNum == 2){
            tileBelow = i +5; //grabs tile to below of chosen tile
            tiles[tileBelow] = i;
         }//

      }//
      System.out.println(Arrays.toString(tiles));
    }//end of create method
     
}