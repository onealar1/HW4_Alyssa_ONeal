import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    private Stage stage;
    private View view;
    private Doodle doodle;
    private ArrayList<Platform> platforms = new ArrayList<>();
    private final double GRAVITY = 100;
    private final double DURATION = 0.015;
    private Timeline timeline;
    private double sceneWidth, sceneHeight;


    public Controller(Doodle doodle, View view) {
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
        generatePlatforms();
        view.show();
    }

    public void setKeyControls(){
        view.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT) {
               // doodle.moveDoodle(1);
            }
            else if(e.getCode() == KeyCode.LEFT){
               // doodle.moveDoodle(-1);
            }
        });
    }

    public void generatePlatforms(){
        if(platforms.isEmpty()){
            Platform firsPlatform = new RegularPlatform(view.getSceneWidth() / 2, view.getSceneHeight()-100);
            platforms.add(firsPlatform);
            view.showPlatforms(firsPlatform);
        }

        Platform topPlatform = platforms.get(platforms.size() - 1);

        final double X_OFFSET = 100; 
        final double Y_OFFSET_MIN = 50; 
        final double Y_OFFSET_MAX = 200; 

        while (topPlatform.getY() > 0) {

            double lowX = Math.max(0, topPlatform.getX() - X_OFFSET);
            double highX = Math.min(view.getSceneWidth() - Platform.getPlatformWidth(), topPlatform.getX() + X_OFFSET);
            double newX = lowX + Math.random() * (highX - lowX);

            double lowY = topPlatform.getY() - Y_OFFSET_MIN;
            double highY = topPlatform.getY() - Y_OFFSET_MAX;
            double newY = lowY + Math.random() * (highY - lowY);

            Platform newPlatform = new RegularPlatform(newX, newY);

            platforms.add(newPlatform);
            view.showPlatforms(newPlatform);

            topPlatform = newPlatform;
        }
        
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
