import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Controller {

    private View view;
    private Doodle doodle;
    private ArrayList<Platform> platforms = new ArrayList<>();
    private Timeline timeline;
    private Platform platform;

    public Controller(Doodle doodle, View view) {
        this.doodle = doodle;
        this.view = view;
        setKeyControls();
        animateDoodle(doodle);
        setupQuitButton();
        setUpScore();
    }

    public void setupQuitButton(){
        view.getQuitButton().setOnAction(e ->{
            System.exit(0);
        });
    }

    public void setUpScore(){
        doodle.getScore().addListener(ov -> {
            view.setLabel(doodle.getScore().getValue());
        });
    }

    public void start() {
        generatePlatforms();
        view.show();
    }

    public void setKeyControls(){
        view.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT) {
               doodle.moveDirection(1);
            }
            else if(e.getCode() == KeyCode.LEFT){
               doodle.moveDirection(-1);
            }
        });

        view.setOnKeyReleased(e -> {
            if(e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.LEFT){
                doodle.moveDirection(0);
            }
        });
    }

    public void generatePlatforms(){
        if(platforms.isEmpty()){
            platform = new RegularPlatform(view.getSceneWidth() / 2, view.getSceneHeight() - 50);
            platforms.add(platform);
            view.showPlatforms(platform);
        }

        Platform topPlatform = platforms.get(platforms.size() - 1);

        final double X_OFFSET = 100; 
        final double Y_OFFSET_MIN = 50; 
        final double Y_OFFSET_MAX = 90; 

        while (topPlatform.getY() > 0) {

            double lowX = Math.max(0, topPlatform.getX() - X_OFFSET);
            double highX = Math.min(view.getSceneWidth() - Platform.getPlatformWidth(), topPlatform.getX() + X_OFFSET);
            double newX = lowX + Math.random() * (highX - lowX);

            double lowY = topPlatform.getY() - Y_OFFSET_MIN;
            double highY = topPlatform.getY() - Y_OFFSET_MAX;
            double newY = lowY + Math.random() * (highY - lowY);

            Platform newPlatform = randomPlatform(newX, newY);

            if (newPlatform instanceof MovingPlatform) {
                MovingPlatform movingPlatform = (MovingPlatform) newPlatform;
                animatePlatform(movingPlatform);
            }

            platforms.add(newPlatform);
            view.showPlatforms(newPlatform);

            topPlatform = newPlatform;
        }

        
    }

    public Platform randomPlatform(double x, double y){
        int platformType = (int) (Math.random() * 4);
        final double BOUNDARY_OFFSET = 150;
        switch(platformType){
            case 0:
                return new RegularPlatform(x, y);
            case 1: 
                double leftBound = Math.max(0, x - BOUNDARY_OFFSET);
                double rightBound = Math.min(view.getSceneWidth() - Platform.getPlatformWidth(), x + BOUNDARY_OFFSET);
                return new MovingPlatform(x, y, leftBound, rightBound);
            case 2:
                return new BreakablePlatform(x, y);
            case 3:
                return new BouncePlatform(x, y);
            default:
                return new RegularPlatform(x, y);
        }
    }

    public void animatePlatform(MovingPlatform platform){
        timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> platform.movePlatform()));
        timeline.setCycleCount(Timeline.INDEFINITE); 
        timeline.play();
    }

    public void animateDoodle(Doodle doodle){
        timeline = new Timeline(new KeyFrame(Duration.millis(50), e ->moveDoodle()));
        timeline.setCycleCount(Timeline.INDEFINITE); 
        timeline.play();
    }

    public void gameOver(){
        Label label = new Label("Game Over");
        Font font = new Font(30);
        label.setFont(font);
        label.setAlignment(Pos.CENTER);

        view.getCenterPane().getChildren().add(label);

        view.getCenterPane().layout();
        
        double centerx = (view.getCenterPane().getWidth() - 225);
        double centery = (view.getCenterPane().getHeight() - 250);

        label.setLayoutX(centerx);
        label.setLayoutY(centery);


        timeline.stop();
    }
        
    public void moveDoodle(){
        doodle.move(view.getSceneWidth(), view.getSceneHeight(), platforms);

        if(doodle.getIsGameOver()){
            gameOver();
            return;
        }

        double threshold = view.getSceneHeight() / 2;
        if(doodle.getDoodleY() < threshold){
            double scroll = threshold - doodle.getDoodleY();
            Iterator<Platform> iter = platforms.iterator();

            while(iter.hasNext()){
                platform = iter.next();
                platform.setY(platform.getY() + scroll);

                if(platform.getY() > view.getSceneHeight()){
                    iter.remove();
                    view.removePlatform(platform);
                }

            }

            doodle.setDoodleY(threshold);
        }

        view.updateDoodlePosition(doodle.getDoodleX(), doodle.getDoodleY());
        generatePlatforms();
    }
    
}
