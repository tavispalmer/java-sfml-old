package org.sfml_dev.window;

import org.sfml_dev.system.CppObject;
import static org.sfml_dev.window.sys.SFML_Window.*;

public class GlResource extends CppObject {
    
    protected GlResource() {
        super(sf_GlResource_sizeof, ptr -> sf_GlResource_destructor(ptr));
        sf_GlResource_GlResource(getPtr());
    }

    protected static void registerContextDestroyCallback(long callback, long arg) {
        sf_GlResource_registerContextDestroyCallback(callback, arg);
    }

    protected static class TransientContextLock extends CppObject {

        public TransientContextLock() {
            super(sf_GlResource_TransientContextLock_sizeof, ptr -> sf_GlResource_TransientContextLock_destructor(ptr));
            sf_GlResource_TransientContextLock_TransientContextLock(getPtr());
        }
    }
}
