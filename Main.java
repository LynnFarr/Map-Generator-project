import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent>{

    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static final int SCALE = 50;

    private static TextField imageName;
    private static TextField imageX;
    private static TextField imageY;
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
        button.setText("Enter");
        //whenever the button is pressed it does something
        button.setOnAction(this);

        //This text is initially in the text field
        imageName = new TextField("What Image?");
        imageX = new TextField("X Position");
        imageY = new TextField("Y Position");

        //This is the drop box for all the diffrent sizes of scales
        roomSize = new ListView<String>();
        roomSize.getItems().addAll("Halfling", "Human", "Giant", "Dragon");

        //This arranges the layout in the controller window
        FlowPane layout = new FlowPane();
        layout.getChildren().add(imageName);
        layout.getChildren().add(imageX);
        layout.getChildren().add(imageY);
        layout.getChildren().add(button);
        layout.getChildren().add(roomSize);

        //adds the entire layout to the root
        root.getChildren().add(layout);

        //debuging purposes
        System.out.println(imageName.getCharacters());

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

        //Creates a grid to scale
        for (int i = 0; i < WIDTH; i = i + SCALE){
            root2.getChildren().add(new Line(i, 0, i, HEIGHT));
        }
        for (int i = 0; i < HEIGHT; i = i + SCALE){
            root2.getChildren().add(new Line(0, i, WIDTH, i));
        }

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
            //prints the name of the file we typed in for debuging purposes
            System.out.println(imageName.getCharacters());

            //loads up image, puts it where we want it, and shrinks it to scale
            imageView = new ImageView(imageName.getCharacters() + ".png");
            imageView.setX(Integer.parseInt(imageX.getCharacters().toString()) * SCALE);
            imageView.setY(Integer.parseInt(imageY.getCharacters().toString()) * SCALE);
            imageView.setFitHeight(SCALE);
            imageView.setFitWidth(SCALE);

            //adds the image to the second window
            root2.getChildren().add(imageView);
            if(!generated){
                //if the second window has not
                //appeared yet, make it appear
                generated = true;
                secondStage.show();
            }
        }

    }

}