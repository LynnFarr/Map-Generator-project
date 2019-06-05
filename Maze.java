//Ben Clay
//CS 240
//Creation Date: 5/13/2019
//Question Tree.
//Last Edited: 3/15/2019 
//Creates Maze

import java.util.*; //imports for random num


public class Maze {
    private int[] index;
    private int randomNum;


    //*Constructs Maze data strcuture*//
    public Maze() {
        for(int i=0; i<800; i++){
            index[i] = i; //establishs sepperate sets
        }
        index  = new int[40];
        randomNum  = 0;
    }//end of Maze Constructor

    //*creates the maze data strcuture itself(builds top-down maze)*
    public int[] create(){
        int i = 0; //starts indexing variable
        for(int row=0; row<20; row++){


            boolean nextRow = false; //false if don't need to switch rows
            while (nextRow==false){ //keeps it on the row

                //**CHECKS**

                //Checks if on last row, creates chances
                int current = i; //grabs current index
                if(row==19){ //last row case
                    Random rand = new Random();
                    randomNum = rand.nextInt(2); //creates random number to compare with (excludes bottom case)
                }
                else{
                    Random rand = new Random();
                    randomNum = rand.nextInt(3); //creates random number to compare with
                }
                //

                //checks if left, right, bot already in disjoint
                boolean left = false; //not in disjoint
                boolean right = false;
                boolean bot = false;
                //
                if(index[current -1] == index[current]){ //checks left tile
                    left = true;
                }
                if(index[current +1] == index[current]){ //checks right tile
                    right = true;
                }
                if(index[current +100] == index[current]){ //checks bot tile (oppisite if bot-up Maze)
                    bot = true;
                }
                //

                //**UNIONS/PATHING**
                //grabs right tile & unions it to rep element
                if(randomNum == 0 && right == false){
                    i++; //moves right
                    index[i] = index[current]; //grabs right tile, places gives it the same rep value as the last tile
                    //assigns right element rep element value

                    if(800% i == 1){ // checks if at end of row, moves down row if moves right
                        nextRow = true;
                    }

                }//
                //grabs bottom tile & unions it to rep element
                if(randomNum == 1 && left == false){//moves left
                    i--;
                    index[i] = index[current];
                    //assigns left element rep element value

                    if(800% i == 0){ // checks if at end of row, moves down row if moves left & down vertically
                        i+=100; //in order to move it down vertically on left side
                        nextRow = true;
                    }

                }//
                if(randomNum == 2 && bot == false){ //moves down
                    i +=40; //grabs tile to below of chosen tile
                    index[i] = index[current];
                    //assigns bottom element rep element value

                    nextRow = true; //switches row down one
                }//


            }//end while loop
        }//end of row iterator
        return index;
    }//end of create method

}//end of class