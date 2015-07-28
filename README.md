# JavaStartup
A java library for Installing a File to multiple operating system startups

This project is currently a work in progress. So far the library has the options to Install a file to:
* Windows
  * Registry
    * LOCAL_MACHINE
    * CURRENT_USER
  * Startup Folder
    * LOCAL_MACHINE
    * CURRENT_USER
    
I am currently working on support for Mac and Linux operating systems.

Example code usage:
    public void installToWindowsRegistryStartup() {
        boolean isAdmin = false; //Refers to whether the current user as Administrator privileges
        WindowsRegistry installer = new WindowsRegistry(new File("C:\\example.jar"), "My App");
        if(isAdmin) {
            installer.installLocalMachine();
        } else {
            installer.installCurrentUser();
        }
    }

    public void installToWindowsStartupFolder() {
        boolean isAdmin = false; //Refers to whether the current user as Administrator privileges
        WindowsStartupFolder installer = new WindowsStartupFolder(new File("C:\\example.jar"));
        if(isAdmin) {
            installer.installLocalMachine();
        } else {
            installer.installCurrentUser();
        }
    }