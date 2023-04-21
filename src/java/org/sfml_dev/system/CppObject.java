package org.sfml_dev.system;

import java.lang.ref.Cleaner;
import java.util.function.LongConsumer;

import static org.sfml_dev.system.sys.new_.*;

public abstract class CppObject {
    
    private static final Cleaner CLEANER = Cleaner.create();

    static class State implements Runnable {

        final long ptr;
        final LongConsumer destructor;

        State(long sizeof, LongConsumer destructor) {
            this.ptr = operator_new(sizeof);
            this.destructor = destructor;
        }

        State(long ptr) {
            this.ptr = ptr;
            this.destructor = null;
        }

        public void run() {
            destructor.accept(ptr);
            operator_delete(ptr);
        }
    }

    private final State state;

    public CppObject() {
        this.state = new State(sizeof(), getDestructor());
        Cleaner.Cleanable cleanable = CLEANER.register(this, state);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> cleanable.clean()));
    }

    public CppObject(long ptr) {
        this.state = new State(ptr);
    }

    public final long getPtr() {
        return state.ptr;
    }

    protected abstract long sizeof();

    protected LongConsumer getDestructor() {
        return ptr -> {};
    }
}
