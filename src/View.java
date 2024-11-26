
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends BorderPane{
    Pane centerPane = new Pane();
    HBox bottomPane = new HBox();
    Stage stage;
    Doodle doodle;
    int score;
    int sceneWidth = 300;
    int sceneHeight = 500;
    double doodleX;
    double doodleY;

    public View(Stage stage){
        this.stage = stage;
        displaySetup();
    }

    public void displaySetup(){
        doodle = new Doodle();
        //centerPane.getChildren().add(doodle);

        Label label = new Label("Total score: " + score);
        bottomPane.getChildren().add(label);

        setCenter(centerPane);
        setBottom(bottomPane);

        Scene scene = new Scene(this, sceneWidth, sceneHeight);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    public void updateDoodlePosition(){
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

    public double getDoodleX(){
        return this.doodleX;
    }

    public double getDoodleY(){
        return doodleY;
    }

    public Doodle getDoodle(){
        return this.doodle;
    }
}
