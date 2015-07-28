package me.jershdervis.javastartup;

import me.jershdervis.javastartup.util.InstallType;
import me.jershdervis.javastartup.util.Utilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by Josh on 28/07/2015.
 */
public class WindowsStartupFolder extends Utilities {

    private final File file;
    private final InstallType installType;

    /**
     * Call 'file' as the File to be installed to startup folder
     * @param file
     */
    public WindowsStartupFolder(File file, InstallType installType) throws IOException {
        this.file = file;
        this.installType = installType;
        this.run();
    }

    /**
     * Runs the file startup folder installation process
     */
    private void run() throws IOException {
        switch (installType) {
            case CURRENT_USER:
                File userStartupFolder = new File(this.getAppdata(), this.startupLocation());
                this.copyFile(this.file, new File(userStartupFolder, this.file.getName()));
                break;
            case LOCAL_MACHINE:
                File systemStartupFolder = new File(this.getProgramData(), this.startupLocation());
                this.copyFile(this.file, new File(systemStartupFolder, this.file.getName()));
                break;
        }
    }

    private String startupLocation() {
        return "Microsoft\\Windows\\Start Menu\\Programs\\Startup";
    }
}
