package org.sfml_dev.system;

import static org.sfml_dev.system.sys.SFML_System.*;

public class Time extends CppObject implements Comparable<Time>, Cloneable {

    public static final Time ZERO = new Time(sf_Time_Zero);

    public Time() {
        sf_Time_Time(getPtr());
    }

    Time(boolean dummy) {
    }

    private Time(long ptr) {
        super(ptr);
    }

    public float asSeconds() {
        return sf_Time_asSeconds(getPtr());
    }

    public int asMilliseconds() {
        return sf_Time_asMilliseconds(getPtr());
    }

    public long asMicroseconds() {
        return sf_Time_asMicroseconds(getPtr());
    }
    
    public static Time fromSeconds(float amount) {
        Time time = new Time(false);
        sf_seconds(time.getPtr(), amount);
        return time;
    }

    public static Time fromMilliseconds(int amount) {
        Time time = new Time(false);
        sf_milliseconds(time.getPtr(), amount);
        return time;
    }

    public static Time fromMicroseconds(long amount) {
        Time time = new Time(false);
        sf_microseconds(time.getPtr(), amount);
        return time;
    }

    public boolean equals(Object val) {
        if (val instanceof Time time) {
            return operator_eq__sf_Time(getPtr(), time.getPtr());
        }
        return false;
    }

    public int compareTo(Time val) {
        return operator_lt__sf_Time(getPtr(), val.getPtr()) ? -1 : (operator_eq__sf_Time(getPtr(), val.getPtr()) ? 0 : 1);
    }

    public Time negate() {
        Time time = new Time(false);
        operator_neg__sf_Time(time.getPtr(), getPtr());
        return time;
    }

    public Time add(Time val) {
        Time time = new Time(false);
        operator_add__sf_Time(time.getPtr(), getPtr(), val.getPtr());
        return time;
    }

    public Time subtract(Time val) {
        Time time = new Time(false);
        operator_sub__sf_Time(time.getPtr(), getPtr(), val.getPtr());
        return time;
    }

    public Time multiply(float val) {
        Time time = new Time(false);
        operator_mul__sf_Time(time.getPtr(), getPtr(), val);
        return time;
    }

    public Time multiply(long val) {
        Time time = new Time(false);
        operator_mul__sf_Time(time.getPtr(), getPtr(), val);
        return time;
    }

    public Time divide(float val) {
        Time time = new Time(false);
        operator_div__sf_Time(time.getPtr(), getPtr(), val);
        return time;
    }

    public Time divide(long val) {
        Time time = new Time(false);
        operator_div__sf_Time(time.getPtr(), getPtr(), val);
        return time;
    }

    public float divide(Time val) {
        return operator_div__sf_Time(getPtr(), val.getPtr());
    }

    public Time remainder(Time val) {
        Time time = new Time(false);
        operator_rem__sf_Time(time.getPtr(), getPtr(), val.getPtr());
        return time;
    }

    public Time clone() {
        Time time = new Time(false);
        sf_Time_Time(time.getPtr(), getPtr());
        return time;
    }

    protected long sizeof() {
        return sf_Time_sizeof;
    }
}
