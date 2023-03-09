package org.sfml_dev.window;

public class JoystickMoveEvent extends Event {
    
    public int joystickId;
    public Joystick.Axis axis;
    public float position;

    public JoystickMoveEvent(int joystickId, Joystick.Axis axis, float position) {
        this.joystickId = joystickId;
        this.axis = axis;
        this.position = position;
    }

    public String toString() {
        return "{joystickId=" + joystickId +
                ", axis=" + axis +
                ", position=" + position + "}";
    }
}
