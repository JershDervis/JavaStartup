package me.jershdervis.javastartup;

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

    /**
     * Call 'file' as the file to be installed to startup
     * Call 'regKeyName' as the registry name to be assigned
     * @param file
     * @param regKeyName
     */
    public WindowsRegistry(File file, String regKeyName) throws InvocationTargetException, IllegalAccessException {
        this.file = file;
        this.regKeyName = regKeyName;
    }

    public void installCurrentUser() throws InvocationTargetException, IllegalAccessException {
        RegistryUtil.writeStringValue(RegistryUtil.HKEY_CURRENT_USER,
                "Software\\Microsoft\\Windows\\CurrentVersion\\Run",
                this.regKeyName,
                "\"" + this.getJavaHome() + " -jar " + file.getAbsolutePath() + "\"",
                RegistryUtil.KEY_WOW64_32KEY);
    }

    public void installLocalMachine() throws InvocationTargetException, IllegalAccessException {
        RegistryUtil.writeStringValue(RegistryUtil.HKEY_LOCAL_MACHINE,
                "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run",
                this.regKeyName,
                "\"" + this.getJavaHome() + " -jar " + file.getAbsolutePath() + "\"",
                RegistryUtil.KEY_WOW64_32KEY);
    }
}
