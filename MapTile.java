// Map Generator project 
// Ben & Lynn 
// tile object 
 
// Each MapTile represents a 2.5 ft x 2.5 ft segment of the created map
   public class MapTile {
   public String name;           // name of png file MapTile
// ****                                                                                 somehow need png image fxnode to link to maptile object
   public String environment;    // S = subterrenean, adding other codes as needed
   public String buildtype;      // N = natural, C = constructed, adding others as needed
   public boolean northFace;     // 0(true) = open, 1(false) = closed, 
   public boolean eastFace;      // 0(true) = open, 1(false) = closed, 
   public boolean southFace;     // 0(true) = open, 1(false) = closed, 
   public boolean westFace;      // 0(true) = open, 1(false) = closed, 
// ****                                                                      if partials need to be added these will becomea string not a boolean
    

//  Constructs a Individual MapTile and populates initial state */
    public MapTile(String name/*, fxnode for png image*/) {       //                    uncomment and modify when fxnodes for graphic available
      this.name = name;
//       this.tileGraphic = tileGraphic;                          //                    uncomment and modify when fxnodes for graphic available
      northFace = (name.substring(2,3) = "0");
      eastFace = (name.substring(3,4) = "0");
      southFace = (name.substring(4,5) = "0");
      westFace = (name.substring(5,6) = "0");
    }
