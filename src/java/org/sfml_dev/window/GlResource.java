package org.sfml_dev.window;

import org.sfml_dev.system.CppObject;
import static org.sfml_dev.window.sys.SFML_Window.*;

import java.util.function.LongConsumer;

public class GlResource extends CppObject {
    
    protected GlResource() {
        if (!(this instanceof Window)) {
            System.out.println("This is a GlResource!");
        }
        sf_GlResource_GlResource(getPtr());
    }

    protected static void registerContextDestroyCallback(long callback, long arg) {
        sf_GlResource_registerContextDestroyCallback(callback, arg);
    }

    protected long sizeof() {
        return sf_GlResource_sizeof;
    }

    protected LongConsumer getDestructor() {
        return ptr -> sf_GlResource_destructor(ptr);
    }

    protected static class TransientContextLock extends CppObject {

        public TransientContextLock() {
            sf_GlResource_TransientContextLock_TransientContextLock(getPtr());
        }

        protected long sizeof() {
            return sf_GlResource_TransientContextLock_sizeof;
        }

        protected LongConsumer getDestructor() {
            return ptr -> sf_GlResource_TransientContextLock_destructor(ptr);
        }
    }
}
