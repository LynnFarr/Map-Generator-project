//Ben Clay
//CS 240
//Creation Date: 5/13/2019
//Question Tree.
//Last Edited: 6/5/2019
//Creates Maze

import java.util.*; //imports for random num


public class Maze {
    private int index[];
    private int randomNum; //intializes randomNum
    //Start+End points (must start on first row & end on last row)
    private int start;
    private int end;


    //*Constructs Maze data strcuture*//
    public Maze(int start, int end) {
        this.start = start;
        this.end = end;
        index = new int[end + 50]; //intializes the disjoint set array
        int randomNum = 0; //intializes randomNum

        for(int i = 0; i < index.length; i++){
            index[i] = i; //establishs sepperate sets
        }

    }//end of Maze Constructor

    //*creates the maze data strcuture itself(builds top-down maze)*
    public int[] create(){
        int i = start; //starts indexing variable (Starts at 0)
        for(int row = 0; row < 20; row++){ //does code 20 times(number of rows we have)


            boolean nextRow = false; //false if don't need to switch rows
            while (nextRow==false){ //keeps it on the row

                //**CHECKS**

                //Checks if on last row, creates chances
                int previous = i; //grabs previous index (this is a useful variable but need to be renamed)
                if(row == 19){ //last row case

                    //which direction it goes to end on bottom row
                    if(i < end){
                        randomNum = 0;
                    }
                    if(i > end){
                        randomNum = 1;
                    }
                    if(i == end){ //if reached the end, ends while loop for last time
                        index[i] = index[previous];// redundent
                        nextRow = true;
                    }

                }
                else{
                    Random rand = new Random();
                    randomNum = rand.nextInt(3); //creates random number to compare with (range is 0-2)
                    //0 == right
                    //1 == left
                    //2 == down
                }
                //

                //checks if left, right, bot already in disjoint
                boolean left = false; //not in disjoint
                boolean right = false;
                boolean bot = false;
                //
                if(i != 0) {
                    if (index[i - 1] == index[previous]) { //checks left tile
                        left = true;
                    }
                }
                if(i < 800 - 1) {
                    if (index[i + 1] == index[previous]) { //checks right tile
                        right = true;
                    }
                }
                if(i < 800 - 40) {
                    if (index[i + 40] == index[previous]) { //checks bot tile (oppisite if bot-up Maze)
                        bot = true;
                    }
                }
                //

                //**UNIONS/PATHING**
                //grabs right tile & unions it to rep element
                if(randomNum == 0 && right == false){
                    i++; //moves right
                    index[i] = index[previous]; //grabs right tile, places gives it the same rep value as the last tile
                    //assigns right element rep element value

                    if(800% i == 1){ // checks if at end of row, moves down row if moves right
                        nextRow = true;
                    }

                }//
                //grabs bottom tile & unions it to rep element
                if(randomNum == 1 && left == false && i != 0){//moves left
                        i--;
                        index[i] = index[previous];

                    //assigns left element rep element value

                    if(800% i == 0){ // checks if at end of row, moves down row if moves left & down vertically
                        i+=40; //in order to move it down vertically on left side
                        nextRow = true;
                    }

                }//
                if(randomNum == 2 && bot == false){ //moves down
                    i += 40; //grabs tile to below of chosen tile
                    index[i] = index[previous];
                    //assigns bottom element rep element value

                    nextRow = true; //switches row down one
                }//


            }//end while loop
        }//end of row iterator
        return index;
    }//end of create method

}//end of class