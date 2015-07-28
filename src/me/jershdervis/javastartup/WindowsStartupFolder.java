package me.jershdervis.javastartup;

import me.jershdervis.javastartup.util.Utilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by Josh on 28/07/2015.
 */
public class WindowsStartupFolder extends Utilities {

    private final File file;

    /**
     * Call 'file' as the File to be installed to startup folder
     * @param file
     */
    public WindowsStartupFolder(File file) throws IOException {
        this.file = file;
    }

    /**
     * Runs the current user installation process
     * @throws IOException
     */
    public void installCurrentUser() throws IOException {
        File userStartupFolder = new File(this.getAppdata(), this.startupLocation());
        this.copyFile(this.file, new File(userStartupFolder, this.file.getName()));
    }

    /**
     * Runs the local machine installation process
     * @throws IOException
     */
    public void installLocalMachine() throws IOException {
        File systemStartupFolder = new File(this.getProgramData(), this.startupLocation());
        this.copyFile(this.file, new File(systemStartupFolder, this.file.getName()));
    }

    private String startupLocation() {
        return "Microsoft\\Windows\\Start Menu\\Programs\\Startup";
    }
}
