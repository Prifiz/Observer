import gui.ImageMerger;
import gui.PaintPane;
import model.constructor.ConstructedSmile;
import model.drawing.Smile;
import observer.Observable;

public class ObservableFactory {
    public static Observable getObservable(boolean enableConstructorMode, int width, int height) {
        if(enableConstructorMode) {
            return new ImageMerger(new ConstructedSmile(width, height));
        } else {
            return new PaintPane(new Smile(width, height));
        }
    }
}
