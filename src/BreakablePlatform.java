import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class BreakablePlatform extends Platform{

    private boolean isBroken = false;
    private Image platform_img = new Image("images\\platform-broken.png");
    
    public BreakablePlatform(double x, double y){
        super(x, y);
        this.setFill(new ImagePattern(platform_img));
    }

    public boolean getIsBroken(){
        return this.isBroken;
    }

    public void setIsBroken(boolean isBroken){
        this.isBroken =isBroken;
    }
}
