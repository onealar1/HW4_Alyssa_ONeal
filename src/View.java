
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class View extends BorderPane{
    private Pane centerPane = new Pane();
    private HBox bottomPane = new HBox();
    private Stage stage;
    private Doodle doodle;
    private int score = 0;
    private int sceneWidth = 300;
    private int sceneHeight = 500;
    private Platform platform;
    private double doodleWidth = 25, doodleHeight = 50;
    private Button quit;
    private double doodleX, doodleY;

    public View(Stage stage){
        this.stage = stage;
        displaySetup();
    }


    public void displaySetup(){
        doodle = new Doodle();
        centerPane.getChildren().add(doodle);

        Label label = new Label("Total score: " + score);
        bottomPane.getChildren().add(label);

        quit = new Button("Quit");
        bottomPane.setSpacing(90);
        bottomPane.getChildren().add(quit);

        setCenter(centerPane);
        setBottom(bottomPane);

        Scene scene = new Scene(this, sceneWidth, sceneHeight);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    public void showPlatforms(Node platform){
        centerPane.getChildren().addAll(platform);
    }

    public void updateDoodlePosition(double doodleX, double doodleY){
        doodle.setX(doodleX);
        doodle.setY(doodleY);
    }

    public void show(){
        stage.show();
        requestFocus();
    }

    public double getSceneHeight(){
        return this.sceneHeight;
    }

    public double getSceneWidth(){
        return this.sceneWidth;
    }

    public void setLabel(int score){
        Label label = (Label)bottomPane.getChildren().get(0);
        label.setText("Total score: " + score);
    }

    public Rectangle getDoodle(){
        return this.doodle;
    }

    public Button getQuitButton(){
        return this.quit;
    }

    public void animateDoodle(){
        doodle.applyGravity(); // add animation timeline thing
    }
}
