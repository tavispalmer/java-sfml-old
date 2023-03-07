package org.sfml_dev.window.sys;

import java.io.*;

class SharedLib {
    private static boolean loaded = false;

    private SharedLib() {}

    public static void load() {
        if (!loaded) {
            try {
                InputStream sharedLib = SharedLib.class.getResourceAsStream("/libsfml-java-window.so");
                File tempFile = File.createTempFile("libsfml-java-window-", ".so");
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
