import java.util.*;

import org.sfml_dev.system.*;
import org.sfml_dev.window.*;
import org.sfml_dev.graphics.*;

public class Main {
    public static void main(String[] args) {
        Window window = new Window(new VideoMode(800, 600), "title");
        window.setFramerateLimit(60);
        window.closed = (w, e) -> w.close();

        System.out.println(Joystick.getIdentification(0));

        while (window.isOpen()) {
            window.dispatchEvents();
            window.display();
        }
    }
}
