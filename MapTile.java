// Map Generator project 
// Ben & Lynn 
// tile object 
 
// Each MapTile represents a 2.5 ft x 2.5 ft segment of the created map
   public class MapTile {
   public String environment;    // S = subterrenean, adding other codes as needed
   public String buildType;      // N = natural, C = constructed, adding others as needed
   public int cellNum;           // cell location on grid
   public boolean northFace;     // 0(true) = open, 1(false) = closed, 
   public boolean eastFace;      // 0(true) = open, 1(false) = closed, 
   public boolean southFace;     // 0(true) = open, 1(false) = closed, 
   public boolean westFace;      // 0(true) = open, 1(false) = closed, 
    

//  Constructs a Individual MapTile and populates initial state */
    public MapTile(String environment, String buildType, int cellNum) {       
      this.environment = environment;
      this.buildType = buildType;
      this.cellNum = cellNum;
      this.northFace = true;
      this.eastFace = true;
      this.southFace = true;
      this.westFace = true;
    }

//  Sets north edge of block to open or closed
    public void setNorth(boolean northFace) {       
      this.northFace = northFace;
    }

//  Sets east edge of block to open or closed
    public void setEast(boolean eastFace) {       
      this.eastFace = eastFace;
    }

//  Sets south edge of block to open or closed
    public void setSouth(boolean southFace) {       
      this.southFace = southFace;
    }

//  Sets east edge of block to open or closed
    public void setWest(boolean westFace) {       
      this.westFace = westFace;
    }

}