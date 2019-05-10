import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application implements EventHandler<ActionEvent> {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static final int SCALE = 50;

    private static TextField imageName;
    private static TextField imageX;
    private static TextField imageY;
    private static Stage secondStage;
    private static Button button;
    private static Image image;
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
        generated = false;

        root = new Group();
        button = new Button();
        button.setText("Enter");
        button.setOnAction(this);

        imageName = new TextField("What Image?");
        imageX = new TextField("X Position");
        imageY = new TextField("Y Position");


        HBox layout = new HBox();
        layout.getChildren().add(imageName);
        layout.getChildren().add(imageX);
        layout.getChildren().add(imageY);
        layout.getChildren().add(button);

        roomSize = new ListView<String>();
        roomSize.getItems().addAll("Halfling", "Human", "Giant", "Dragon");

        layout.getChildren().add(roomSize);
        //layout.setAlignment(Pos.TOP_LEFT);

        root.getChildren().add(layout);
        System.out.println(imageName.getCharacters());


        Scene scene = new Scene(root, 490, 25);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("Controller");
        primaryStage.setScene(scene);
        primaryStage.show();

        ///////////////////////////////////////////////////////////

        root2 = new Group();
        for (int i = 0; i < WIDTH; i = i + SCALE){
            root2.getChildren().add(new Line(i, 0, i, HEIGHT));
        }
        for (int i = 0; i < HEIGHT; i = i + SCALE){
            root2.getChildren().add(new Line(0, i, WIDTH, i));
        }

        Scene scene2 = new Scene(root2, WIDTH, HEIGHT);
        scene2.setFill(Color.GREEN);
        secondStage = new Stage();
        secondStage.setScene(scene2);
        secondStage.setTitle("Grid");
        //secondStage.show();

    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button){
            System.out.println(imageName.getCharacters());

            imageView = new ImageView(imageName.getCharacters() + ".png");

            imageView.setX(Integer.parseInt(imageX.getCharacters().toString()) * SCALE);
            imageView.setY(Integer.parseInt(imageY.getCharacters().toString()) * SCALE);

            imageView.setFitHeight(SCALE);
            imageView.setFitWidth(SCALE);
            root2.getChildren().add(imageView);
            if(!generated){
                generated = true;
                secondStage.show();
            }
        }

    }
}