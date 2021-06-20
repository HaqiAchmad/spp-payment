package com.data.app;

import com.manage.FileManager;
import java.io.File;

/**
 * Class ini digunakan untuk memanajemen penyimpanan pada aplikasi. Penyimpanan yang akan 
 * dimanage adalah penyimpanan data seperti cache, log, user dan backup. 
 * 
 * @author Infinite World
 * @since 2021-06-04
 */
public class Storage {
    
    private final FileManager fm = new FileManager();
    
    private final String directory = this.getHome() + "\\AppData\\Local\\Punya Haqi\\SPP Payment 1.0.0\\";
    
    private String getHome(){
        return System.getProperty("user.home");
    }
    
    public String getDirectory(){
        return this.directory;
    }
    
    public String getBackupDirectory(){
        return this.getDirectory() + "Backup\\";
    }
    
    public String getCacheDirectory(){
        return this.getDirectory() + "Cache\\";
    }
    
    public String getLogDirectory(){
        return this.getDirectory() + "Log\\DataInput\\";
    }
    
    public String getSettingDirectory(){
        return this.getDirectory() + "Setting\\";
    }
    
    public String getUsersDirectory(){
        return this.getDirectory() + "Users\\";
    }
    
    public boolean isExistStorage(){
        return new File(this.getBackupDirectory()).exists() && new File(this.getCacheDirectory()).exists() && 
               new File(this.getLogDirectory()).exists() && new File(this.getSettingDirectory()).exists() && 
               new File(this.getUsersDirectory()).exists();
    }
    
    public static void main(String[] args) {
        
        Storage storage = new Storage();
        System.out.println(storage.isExistStorage());
        
    }
    
}
