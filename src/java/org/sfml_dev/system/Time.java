package org.sfml_dev.system;

public class Time implements Comparable<Time>, Cloneable {

    public static final Time ZERO = new Time();

    private long microseconds;

    public Time() {
        this.microseconds = 0;
    }

    private Time(long microseconds) {
        this.microseconds = microseconds;
    }

    public float asSeconds() {
        return microseconds / 1000000.f;
    }

    public int asMilliseconds() {
        return (int)(microseconds / 1000);
    }

    public long asMicroseconds() {
        return microseconds;
    }
    
    public static Time fromSeconds(float amount) {
        return new Time((long)(amount * 1000000));
    }

    public static Time fromMilliseconds(int amount) {
        return new Time((long)amount * 1000);
    }

    public static Time fromMicroseconds(long amount) {
        return new Time(amount);
    }

    public boolean equals(Object val) {
        if (val instanceof Time time) {
            return this.asMicroseconds() == time.asMicroseconds();
        }
        return false;
    }

    public int compareTo(Time val) {
        return Long.compare(this.asMicroseconds(), val.asMicroseconds());
    }

    public Time negate() {
        return Time.fromMicroseconds(-this.asMicroseconds());
    }

    public Time add(Time val) {
        return Time.fromMicroseconds(this.asMicroseconds() + val.asMicroseconds());
    }

    public Time subtract(Time val) {
        return Time.fromMicroseconds(this.asMicroseconds() - val.asMicroseconds());
    }

    public Time multiply(float val) {
        return Time.fromSeconds(this.asSeconds() * val);
    }

    public Time multiply(long val) {
        return Time.fromMicroseconds(this.asMicroseconds() * val);
    }

    public Time divide(float val) {
        return Time.fromSeconds(this.asSeconds() / val);
    }

    public Time divide(long val) {
        return Time.fromMicroseconds(this.asMicroseconds() / val);
    }

    public float divide(Time val) {
        return this.asSeconds() / val.asSeconds();
    }

    public Time remainder(Time val) {
        return Time.fromMicroseconds(this.asMicroseconds() % val.asMicroseconds());
    }

    public Time clone() {
        return new Time(this.microseconds);
    }
}
