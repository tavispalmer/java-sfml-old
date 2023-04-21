package org.sfml_dev.system;

import static org.sfml_dev.system.sys.SFML_System.*;

public class Clock extends CppObject implements Cloneable {

    public Clock() {
        sf_Clock_Clock(getPtr());
    }

    private Clock(boolean dummy) {
    }

    public Time getElapsedTime() {
        return Time.fromMicroseconds(sf_Clock_getElapsedTime(getPtr()));
    }

    public Time restart() {
        return Time.fromMicroseconds(sf_Clock_restart(getPtr()));
    }

    public Clock clone() {
        Clock clock = new Clock(false);
        sf_Clock_Clock(clock.getPtr(), getPtr());
        return clock;
    }

    protected long sizeof() {
        return sf_Clock_sizeof;
    }
}
