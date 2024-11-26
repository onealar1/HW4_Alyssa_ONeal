import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    private Stage stage;
    private View view;
    private Rectangle doodle;
    private ArrayList<Platform> platforms = new ArrayList<>();
    private final double GRAVITY = 100;
    private final double DURATION = 0.015;
    Timeline timeline;

    public Controller(Rectangle doodle, View view) {
        this.doodle = doodle;
        this.view = view;
        // setKeyControls();
    }

    public void quitGame(){
        view.getQuitButton().setOnAction(e ->{
            System.exit(1);
        });
    }

    public void start() {
    }

    /*public void setKeyControls(){
        view.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT) {
               // doodle.moveDoodle(1);
            }
            else if(e.getCode() == KeyCode.LEFT){
               // doodle.moveDoodle(-1);
            }
        });
    }*/

    public void generatePlatforms(){
        
    }

    public void updatePlatforms(){
        for (Platform platform: platforms) {

            if(platform instanceof BreakablePlatform){ // this will remove the breakable platform from the screen - still need to implement the intersects method to change the state of isBroken
                BreakablePlatform breakablePlatform = (BreakablePlatform) platform;
                if(breakablePlatform.getIsBroken() == true){
                    platforms.remove(breakablePlatform);
                }
            }
            else if(platform instanceof MovingPlatform){

            }
        }
    }

    /*public void animateDoodle(Rectangle doodle){
        timeline = new Timeline(new KeyFrame(Duration.millis(50), e ->moveDoodle()));
        timeline.setCycleCount(Timeline.INDEFINITE); 
    }*/
        
    /*public void moveDoodle(){
        
        doodle.moveBall(view.getSceneWidth(), view.getSceneHeight());
        view.updateBallPosition(doodle.getCenterX(), doodle.getCenterY());
        
    }*/

    
    
}
