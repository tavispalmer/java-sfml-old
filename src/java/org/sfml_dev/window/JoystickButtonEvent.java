package org.sfml_dev.window;

public class JoystickButtonEvent extends Event {
    
    public int joystickId;
    public int button;

    public JoystickButtonEvent(int joystickId, int button) {
        this.joystickId = joystickId;
        this.button = button;
    }

    public String toString() {
        return "{joystickId=" + joystickId +
                ", button=" + button + "}";
    }
}
