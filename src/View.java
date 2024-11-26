
import javafx.geometry.Pos;
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
    private Rectangle doodle;
    private int score = 0;
    private int sceneWidth = 300;
    private int sceneHeight = 500;
    private Rectangle platform;
    private double doodleWidth = 25, doodleHeight = 50;
    private Button quit;

    public View(Stage stage, double doodleX, double doodleY){
        this.stage = stage;
        displaySetup(doodleX, doodleY, doodleWidth, doodleHeight);
    }


    public void displaySetup(double doodleX, double doodleY, double doodleWidth, double doodleHeight){
        doodle = new Rectangle(doodleX, doodleY, doodleWidth, doodleHeight);
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

    public void showPlatforms(){

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
}
