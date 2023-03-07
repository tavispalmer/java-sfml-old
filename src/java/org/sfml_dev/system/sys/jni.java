package org.sfml_dev.system.sys;

public class jni {
    static {
        SharedLib.load();
    }
    private jni() {}

    /**
     * Constructs a new {@link java.lang.String} object from an array of Unicode characters.
     * 
     * @param unicodeChars pointer to a Unicode string.
     * @param len length of the Unicode string.
     * @return Returns a Java string object, or {@code null} if the string cannot be constructed
     * @throws OutOfMemoryError if the system runs out of memory
     */
    public static native String NewString(long unicodeChars, int len);

    /**
     * Returns a pointer to the array of Unicode characters of the string. This pointer is valid until {@link #ReleaseStringChars} is called.
     * 
     * <p>If {@code isCopy} is not {@code NULL}, then {@code *isCopy} is set to {@code JNI_TRUE} if a copy is made; or it is set to {@code JNI_FALSE} if no copy is made.
     * 
     * @param string a Java string object.
     * @param isCopy a pointer to a boolean.
     * @return Returns a pointer to a Unicode string, or {@code NULL} if the operation fails.
     */
    public static native long GetStringChars(String string, long isCopy);

    /**
     * Informs the VM that the native code no longer needs access to {@code chars}. The {@code chars} argument is a pointer obtained from {@code string} using {@link #GetStringChars}.
     * 
     * @param string a Java string object.
     * @param chars a pointer to a Unicode string.
     */
    public static native void ReleaseStringChars(String string, long chars);
}
