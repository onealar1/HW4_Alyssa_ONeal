import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends BorderPane{
    private Pane centerPane = new Pane();
    private HBox bottomPane = new HBox();
    private HBox topPane = new HBox();
    private Stage stage;
    private Doodle doodle;
    private int score = 0;
    private int sceneWidth = 300;
    private int sceneHeight = 500;
    private Button quit;

    public View(Stage stage){
        this.stage = stage;
        displaySetup();
    }


    public void displaySetup(){
        doodle = new Doodle();
        centerPane.getChildren().add(doodle);

        Image image = new Image("images\\background.png");

        BackgroundImage backgroundImage = new BackgroundImage(
            image,
            BackgroundRepeat.REPEAT, 
            BackgroundRepeat.REPEAT, 
            BackgroundPosition.CENTER,  
            new BackgroundSize(sceneWidth, sceneHeight, true, true, true, false) 
        );

        this.setBackground(new Background(backgroundImage));

        Label label = new Label("Total score: " + score);
        topPane.getChildren().add(label);

        quit = new Button("Quit");
        bottomPane.getChildren().add(quit);

        setTop(topPane);
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
        Label label = (Label)topPane.getChildren().get(0);
        label.setText("Total score: " + score);
    }

    public Doodle getDoodle(){
        return this.doodle;
    }

    public Button getQuitButton(){
        return this.quit;
    }

    public void removePlatform(Platform platform){
        centerPane.getChildren().remove(platform);
    }

    public Pane getCenterPane(){
        return this.centerPane;
    }
}
