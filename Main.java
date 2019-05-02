package sample;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //creating a Group object
        Group group = new Group();

        //Setting the title to Stage.
        primaryStage.setTitle("Sample Application");

        Text text = new Text();
        text.setText("hello world ");
        //Setting font to the text
        text.setFont(new Font(45));
        text.setX(300);
        text.setY(150);

        //Creating a Group object
        Group root = new Group();

        //Retrieving the observable list object
        ObservableList list = root.getChildren();

        list.add(text);

        //Creating a Scene by passing the group object, height and width
        Scene scene = new Scene(group ,600, 300);

        //setting color to the scene
        scene.setFill(Color.GREEN);


        //Adding the scene to Stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}