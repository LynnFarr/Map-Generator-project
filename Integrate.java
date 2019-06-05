//Ben Clay
//CS 240
//Creation Date: 6/3/2019
//Question Tree.
//Last Edited: 6/5/2019 
//Associates Maze with Tiles

import java.util.*; //imports for random num

public class Integrate {

   private String objects[];
   private Maze path;
   
   //*Constructs Integration data strcuture*//
    public Integrate() { 
         objects = new String[800]; //creates string tile label array     
         path = new Maze(0,799);         //creates path to follow when filling objects
                                       
    }//end of Maze Constructor
    
    //*Fills the objects array with String representaitons of the tiles based on the disjoint maze
    public String[] fill(){
      int[] index = path.create(); //gets a random maze array
      
      for(int i=0; i<800; i++){ //establishs empty tiles
         if(index[i] != 0){
            index[i] = -1; 
         }
      }
      
      //Labeling of objects
      int endpath = 0; //intializes end of path location
      for (int row=0; row<20; row++){ //iterates vertically
          for (int i=0+(row*40); i<40+(row*40); i++){ //iterates across row
          if (i !=  -1){
            if (i==0){ //labels start
               objects[i] = "SN0011";
            }
            else{
               if(index[i+1] !=  -1 && index[i-1] !=  -1){ //if left and right of index are not empty  (middle of path)
                  objects[i] = "SN1010";
               }
                if(index[i+1] ==  -1 && index[i-1] ==  -1){ //if left and right of index are  empty  (single path)
                  objects[i] = "SN0101";
               }
               
               if(index[i+1] !=  -1 && index[i-1] ==  -1){ //if left is empty and right of index is not (end left directed path)
                  objects[i] = "SN1001";
                  
                    if(i == endpath +40){ //if end of path above it
                      objects[i] = "SN0110"; //right-bot corner
                     }//end if above end too
               }

               if(index[i+1] ==  -1 && index[i-1] !=  -1){ //if left is filled and right of index is empty (end right directed path)
                  objects[i] = "SN1100";
                  
                   if(i == endpath +40){ //if end of path above it
                      objects[i] = "SN0011"; //left-bot corner
                   }//end if above end too
               }

            } //end else
            endpath = i; //sets last known path end for access
           }//end if i not empty
         }//end of across row
      }//end of row by row
      return objects;
    }//end of method fill
    
}//end of class