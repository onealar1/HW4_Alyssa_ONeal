import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Controller {

    private Stage stage;
    private View view = new View(stage);
    private Doodle doodle = new Doodle();
    private ArrayList<Platform> platforms = new ArrayList<>();

    public Controller(Doodle doodle, View view) {
    }

    public void start() {
    }

    public void setKeyControls(){
        view.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT) {
                doodle.moveDoodle(1);
            }
        });
    }

    public void addPlatforms(){
        // add logic for generating platforms until game ends
    }
    
}
