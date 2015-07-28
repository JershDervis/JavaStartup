package me.jershdervis.javastartup;

import me.jershdervis.javastartup.util.InstallType;
import me.jershdervis.javastartup.util.RegistryUtil;
import me.jershdervis.javastartup.util.Utilities;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Josh on 28/07/2015.
 */
public class WindowsRegistry extends Utilities {

    private final File file;
    private final String regKeyName;
    private final InstallType installType;

    /**
     * Call 'file' as the file to be installed to startup
     * Call 'regKeyName' as the registry name to be assigned
     * Call 'registryType' as the registry directory type (LOCAL_MACHINE requires admin rights)
     * @param file
     * @param regKeyName
     * @param installType
     */
    public WindowsRegistry(File file, String regKeyName, InstallType installType) throws InvocationTargetException, IllegalAccessException {
        this.file = file;
        this.regKeyName = regKeyName;
        this.installType = installType;
        this.run();
    }

    /**
     * Runs the file registry installation process
     */
    public void run() throws InvocationTargetException, IllegalAccessException {
        switch (installType) {
            case CURRENT_USER:
                RegistryUtil.writeStringValue(RegistryUtil.HKEY_CURRENT_USER,
                        "Software\\Microsoft\\Windows\\CurrentVersion\\Run",
                        this.regKeyName,
                        "\"" + this.getJavaHome() + " -jar " + file.getAbsolutePath() + "\"",
                        RegistryUtil.KEY_WOW64_32KEY);
                break;
            case LOCAL_MACHINE:
                RegistryUtil.writeStringValue(RegistryUtil.HKEY_LOCAL_MACHINE,
                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run",
                        this.regKeyName,
                        "\"" + this.getJavaHome() + " -jar " + file.getAbsolutePath() + "\"",
                        RegistryUtil.KEY_WOW64_32KEY);
                break;
        }
    }
}
