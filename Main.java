//Hunter Cambridge
//CS 240
//Creation Date: 5/13/2019
//Last Edited: 6/5/2019
//Creates a randomly generated map
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent>{
    public static final int SCALE = 30;
    public static final int WIDTH = SCALE * 40;
    public static final int HEIGHT = SCALE * 20;


    private static Stage secondStage;
    private static Button button;
    private static ImageView imageView;
    private static Group root;
    private static Group root2;
    private static boolean generated;
    private static ListView<String> roomSize;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //FIRST WINDOW

        //At the start of the program
        //The grid window doesn't show.
        generated = false;

        //This connects everything together
        root = new Group();
        button = new Button();
        //This is the text that is displayed ontop of the button
        button.setText("Generate new Dungeon");
        //whenever the button is pressed it does something
        button.setOnAction(this);

        //This arranges the layout in the controller window
        FlowPane layout = new FlowPane();
        layout.getChildren().add(button);

        //adds the entire layout to the root
        root.getChildren().add(layout);

        //makes a new scene and sets it as black background
        Scene scene = new Scene(root, 300, 200);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("Controller");
        primaryStage.setScene(scene);
        primaryStage.show();

        ///////////////////////////////////////////////////////////

        //SECOND WINDOW

        //This connects everything together
        root2 = new Group();



        //Makes the second window with a green background (for contrast)
        Scene scene2 = new Scene(root2, WIDTH, HEIGHT);
        scene2.setFill(Color.GREEN);
        secondStage = new Stage();
        secondStage.setScene(scene2);
        secondStage.setTitle("Grid");
    }

    //This runs every time a button is clicked
    @Override
    public void handle(ActionEvent event) {
        //enter button
        if(event.getSource() == button){
            root2.getChildren().clear();
            //Creates a grid to scale
            for (int i = 0; i < WIDTH; i = i + SCALE){
                root2.getChildren().add(new Line(i, 0, i, HEIGHT));
            }
            for (int i = 0; i < HEIGHT; i = i + SCALE){
                root2.getChildren().add(new Line(0, i, WIDTH, i));
            }

            Integrate mazeMaker = new Integrate();
            String[] maze = mazeMaker.fill();
            System.out.println();
            System.out.println(maze.length);

            for(int i = 0; i < maze.length; i ++){
                String bleh = maze[i];
                if(maze[i] != null){
                    imageView = new ImageView(bleh + "a.png");
                    imageView.setX(i % 40 * SCALE);
                    int y = i / 40;
                    System.out.println(i);
                    System.out.println(y);
                    imageView.setY(y * SCALE);
                    imageView.setFitHeight(SCALE);
                    imageView.setFitWidth(SCALE);
                    root2.getChildren().add(imageView);
                }
            }


            if(!generated){
                //if the second window has not
                //appeared yet, make it appear
                generated = true;
                secondStage.show();
            }
        }

    }

}