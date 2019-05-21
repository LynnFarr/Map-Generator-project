// Map Generator project 
// Lynn 
// tile object 
 
// Each MapTile represents a 2.5 ft x 2.5 ft segment of the created map
   public class MapTile {
   public String environment;    // S = subterrenean, adding other codes as needed
   public String buildType;      // N = natural, C = constructed, adding others as needed
   public int cellX;             // cell location on X axis
   public int cellY;             // cell location on Y axis
   public int cellNum;           // cell location on grid
   public boolean northFace;     // 0(true) = open, 1(false) = closed, 
   public boolean eastFace;      // 0(true) = open, 1(false) = closed, 
   public boolean southFace;     // 0(true) = open, 1(false) = closed, 
   public boolean westFace;      // 0(true) = open, 1(false) = closed, 
    

//  Constructs a Individual MapTile and populates initial state */
    public MapTile(String environment, String buildType, int cellNum, int cellX, int cellY) {       
      this.environment = environment;
      this.buildType = buildType;
      this.cellX = cellX;
      this.cellY = cellY;
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

//  returns true is location is rock wall
    public boolean isWall() {       
      return (northFace && eastFace && southFace && westFace);
    }

//  returns name of png image best matching map position
    public String imageName() {       
      String image = "SN";

      if (northFace) { image += "0"; } else { image += "1"; }
      if (eastFace) { image += "0"; } else { image += "1"; }
      if (southFace) { image += "0"; } else { image += "1"; }
      if (westFace) { image += "0"; } else { image += "1"; }
      
      image += "a.png";
      return (image);
    }

}