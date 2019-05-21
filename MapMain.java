// Map Generator project 
// Lynn 
//MapMain

import java.io.*;
import java.util.*;

//                                                             <<<need class desc commenting
public class MapMain {
//  constants to improve readability of code
   public static final boolean CLOSED = false;
   public static final boolean OPEN = true;

      //  call Hunter's UI to get dungeon specifics from user will use constants for now, 
      //  but they will populate private fields when code is linked.
      public static final int NUM_TRIES = 100;
      //    private int numTries;
      public static final int MAX_ROOMS = 20;
      public static final int EXTRA_CONNECTOR = 20;
      public static final int EXTRA_SIZE_ROOMS = 5;
      public static final int WINDING_PERCENT = 0;
      public static final boolean PORTRAIT_ORIENTATION = true;
   
   public static void main(String[] args) {
      int mapWidth;
      int mapHeight;
   
      if (PORTRAIT_ORIENTATION) {
         mapHeight = 101;
         mapWidth = 81;
      } else {
         mapHeight = 81;
         mapWidth = 101;
      }
      MapTile[] mapGrid;
      int[] mapUnion;
      // construct each tile, assigning a unique tile number, 
      //                 x, y coordinates and close all walls
      int cellNum = 0;
      for (int cellY = 0; cellY < mapHeight; cellY++) {
         for (int cellX = 0; cellX < mapWidth; cellX++) {
            mapGrid(cellNum) = new MapTile("S", "N", cellNum, cellX, cellY);
            //    assign all outside walls to the same set to avoid rooms placement
            if ((cellY < mapWidth) || (cellY > ((mapHeight - 1) * mapWidth)) ||
               ((cellX % mapWidth) = 0) || ((cellX % mapWidth) = (mapWidth - 1))) {
               mapUnion(cellNum) = 0;
            } else {
               mapUnion(cellNum) = cellNum;
            }
            cellNum++;
         }
      }
       
//   borrowed from Critters to see if applicable
//    private Critter[][] grid;
//    private Map<Critter, PrivateData> info;
//    private SortedMap<String, Integer>critterCount;
   
//        this.width = width;
//        this.height = height;
//        grid = new Critter[width][height];
//        info = new HashMap<Critter, PrivateData>();
//        critterCount = new TreeMap<String, Integer>();
   


   } 
}