import org.sfml_dev.window.*;

public class Main {
    public static void main(String[] args) {
        Clipboard.setString(null);
        System.out.println(Clipboard.getString());
    }
}
