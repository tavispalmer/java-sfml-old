package org.sfml_dev.system;

import java.lang.ref.Cleaner;
import java.util.function.LongConsumer;

import static org.sfml_dev.system.sys.new_.*;

public class CppObject {
    
    private static final Cleaner CLEANER = Cleaner.create();

    static class State implements Runnable {

        long ptr;
        LongConsumer destructor;

        State(long sizeof, LongConsumer destructor) {
            this.ptr = operator_new(sizeof);
            this.destructor = destructor;
        }

        public void run() {
            destructor.accept(ptr);
            operator_delete(ptr);
        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;

    public CppObject(long sizeof, LongConsumer destructor) {
        this.state = new State(sizeof, destructor);
        this.cleanable = CLEANER.register(this, state);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> this.cleanable.clean()));
    }

    public long getPtr() {
        return state.ptr;
    }
}
