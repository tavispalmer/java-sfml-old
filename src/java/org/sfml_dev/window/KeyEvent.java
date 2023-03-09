package org.sfml_dev.window;

public class KeyEvent extends Event {
    
    public Keyboard.Key code;
    public boolean alt;
    public boolean control;
    public boolean shift;
    public boolean system;

    public KeyEvent(Keyboard.Key code, boolean alt, boolean control, boolean shift, boolean system) {
        this.code = code;
        this.alt = alt;
        this.control = control;
        this.shift = shift;
        this.system = system;
    }

    public String toString() {
        return "{code=" + code +
                ", alt=" + alt +
                ", control=" + control +
                ", shift=" + shift +
                ", system=" + system + "}";
    }
}
