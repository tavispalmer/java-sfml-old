package org.sfml_dev.window;

@FunctionalInterface
public interface ContextDestroyCallback {
    void invoke(long arg);
}
