package me.jershdervis.javastartup.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Josh on 28/07/2015.
 */
public class Utilities {

    public String getJavaHome() {
        return System.getProperty("java.home");
    }

    /**
     * Gets the location of Windows %APPDATA% folder
     * @return
     */
    public String getAppdata() {
        return System.getenv("APPDATA");
    }

    /**
     * Gets the location of Windows Program Data folder
     * @return
     */
    public String getProgramData() {
        return System.getenv("ProgramData");
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }
}
