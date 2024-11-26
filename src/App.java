import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        View gameView = new View(primaryStage, 100, 100);
        gameView.show();

        // gameDoodle = new Doodle();
        //Controller gameController = new Controller(gameDoodle, gameView);
        //gameController.start();
    }
}
