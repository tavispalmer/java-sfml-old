package org.sfml_dev.window;

@FunctionalInterface
public interface EventHandler<E extends Event> {
    void invoke(Window sender, E event);
}
