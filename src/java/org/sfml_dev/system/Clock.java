package org.sfml_dev.system;

import static org.sfml_dev.system.sys.SFML_System.*;

public class Clock extends CppObject implements Cloneable {

    public Clock() {
        sf_Clock_Clock(getPtr());
    }

    private Clock(boolean dummy) {
    }

    public Time getElapsedTime() {
        Time time = new Time(false);
        sf_Clock_getElapsedTime(time.getPtr(), getPtr());
        return time;
    }

    public Time restart() {
        Time time = new Time(false);
        sf_Clock_restart(time.getPtr(), getPtr());
        return time;
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
