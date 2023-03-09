package org.sfml_dev.window;

public class JoystickConnectEvent extends Event {

    public int joystickId;

    public JoystickConnectEvent(int joystickId) {
        this.joystickId = joystickId;
    }

    public String toString() {
        return "{joystickId=" + joystickId + "}";
    }
}
