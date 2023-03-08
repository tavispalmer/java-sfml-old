package org.sfml_dev.window;

public class WindowHandle {
    
    private final long ptr;

    public WindowHandle(long ptr) {
        this.ptr = ptr;
    }

    public long getPtr() {
        return ptr;
    }
}
