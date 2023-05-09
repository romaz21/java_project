import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Main {
    static final Model model = new Model();

    private static final View view = new View(model);
    private static final Controller controller = new Controller(model, view);
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        //Main app = new Main();
        controller.start();
    }
}