import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class BouncePlatform extends Platform{
    private final double BOOST = -300;
    private Image platform_img = new Image("images\\bounce-platform.png");
    
    public BouncePlatform(double x, double y){
        super(x, y);
        setHeight(40);
        setWidth(70);
        this.setFill(new ImagePattern(platform_img));
    }

    public double getBoost(){
        return BOOST;
    }
}
