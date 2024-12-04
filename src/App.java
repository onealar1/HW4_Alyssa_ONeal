import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        View gameView = new View(primaryStage);
        gameView.show();

        Doodle doodle = gameView.getDoodle();
        Controller gameController = new Controller(doodle, gameView);
        gameController.start();
    }
}
