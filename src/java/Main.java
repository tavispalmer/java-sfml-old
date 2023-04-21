import java.util.*;

import org.sfml_dev.system.*;
import org.sfml_dev.window.*;
import org.sfml_dev.graphics.*;

public class Main {
    public static void main(String[] args) {

        Window window = new Window(
            new VideoMode(
                800,
                600
            ),
            "title"
        );
        window.setFramerateLimit(60);
        
        window.closed = (w, e) -> w.close();

        window.keyPressed = (w, e) -> {
            if (e.code == Keyboard.Key.ESCAPE) {
                w.close();
            }
        };

        while (window.isOpen()) {
            window.dispatchEvents();
            window.display();
        }
    }
}
