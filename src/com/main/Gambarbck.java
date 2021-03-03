package com.main;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 * @since 2020-11-23
 */
public class Gambar {
    
    private static final ImageIcon icWindow = new ImageIcon("src\\com\\media\\gambar\\icons\\window-icon.png");
    
    private static final String DIREKTORY_BENDERA = "src\\com\\media\\gambar\\flags\\",
                                DIREKTORY_LAMBANG_PROVINSI = "src\\com\\media\\gambar\\lambang\\",
                                DIREKTORY_ICONS = "src\\com\\media\\gambar\\icons\\";
    
    public static final String IC_CLOSE_BLACK = "ic-close-black.png", IC_CLOSE_WHITE = "ic-close-white.png", 
                               IC_MINIMAZE_BLACK = "ic-minimaze-black.png", IC_MINIMAZE_WHITE = "ic-minimaze-white.png",
                               IC_BACK = "ic-back.png", IC_BACK_ENTERED = "ic-back-entered.png",
                               IC_CLOSE_ENTERED = "ic-close-entered.png", IC_MINIMAZE_ENTERED = "ic-minimaze-entered.png";
    
    
    
    public static Image getWindowIcon(){
        return icWindow.getImage();
    }
    
    public static ImageIcon getFlag(final String fileBendera){
        
        File file = new File(Gambar.DIREKTORY_BENDERA + fileBendera);
        
        // mengecek apakah file bendera bernilai default atau tidak 
        if(!fileBendera.equalsIgnoreCase("default")){
            // mengecek apakah file bendera ada atau tidak
            if(file.exists()){
                System.out.println("bendera ditemukan --> " + fileBendera);
                return scaleImage(file, 65, 40);
            }else{
                JOptionPane.showMessageDialog(null, "Tidak dapat menemukan file bendera '" + fileBendera + "'", "Warning", JOptionPane.WARNING_MESSAGE);
                return null;
            }            
        }else{
            return null;
        }
    }
    
    public static ImageIcon getLambangProvinsi(final String fileLambang){
        File file = new File(Gambar.DIREKTORY_LAMBANG_PROVINSI + fileLambang);
        
        // mengecek apakah file lambang provinsi bernilai default atau tidak
        if(!fileLambang.equalsIgnoreCase("default")){
            // mengecek apakah file lambang bendera ada atau tidak
            if(file.exists()){
                System.out.println("lambang provinsi ditemukan -> " + fileLambang);
                return scaleImage(file, 40, 50);
            }else{
                JOptionPane.showMessageDialog(null, "Tidak dapat menemukan file lambang provinsi '" + fileLambang + "'", "Warning", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        }else{
            return null;
        }
    }
    
    public static ImageIcon getIcon(final String icon){
        File file = new File(Gambar.DIREKTORY_ICONS + icon);
        
        // mengecek apakah file icon ada atau tidak
        if(file.exists()){
            return new ImageIcon(file.toString());
        }else{
            JOptionPane.showMessageDialog(null, "Tidak dapat menemukan file '" + icon + "'", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
        
    // start
    public static ImageIcon scaleImage(File fileImage, final int x, final int y){
        ImageIcon icon, scaleIcon;
        Image img, imgScale;
        if(fileImage.exists()){
            icon = new ImageIcon(fileImage.toString());
            img = icon.getImage();
            imgScale = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
            scaleIcon = new ImageIcon(imgScale);
            return scaleIcon;
        }  
        return null;
    }
    // end
}
