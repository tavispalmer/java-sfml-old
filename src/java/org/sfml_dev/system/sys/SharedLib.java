package org.sfml_dev.system.sys;

import java.io.*;

class SharedLib {
    private static boolean loaded = false;

    private SharedLib() {}

    public static void load() {
        if (!loaded) {
            try {
                InputStream sharedLib = SharedLib.class.getResourceAsStream("/libjava-sfml-system.so");
                File tempFile = File.createTempFile("libjava-sfml-system-", ".so");
                tempFile.deleteOnExit();

                OutputStream tempFileStream = new FileOutputStream(tempFile);
                tempFileStream.write(sharedLib.readAllBytes());
                tempFileStream.close();
                sharedLib.close();

                System.load(tempFile.getAbsolutePath());
                loaded = true;
            } catch (IOException e) {
            }
        }
    }
}
