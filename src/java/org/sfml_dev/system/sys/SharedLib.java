package org.sfml_dev.system.sys;

import java.io.*;

public class SharedLib {
    private SharedLib() {}
    
    public static void load() {
        try {
            InputStream sharedLib = SharedLib.class.getResourceAsStream("/libsfml-java-system.so");
            File tempFile = File.createTempFile("libsfml-java-system-", ".so");
            tempFile.deleteOnExit();

            OutputStream tempFileStream = new FileOutputStream(tempFile);
            tempFileStream.write(sharedLib.readAllBytes());
            tempFileStream.close();
            sharedLib.close();

            System.load(tempFile.getAbsolutePath());
        } catch (IOException e) {
        }
    }
}
