package com.media;

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
    
    private static final ImageIcon icWindow = new ImageIcon("src\\resources\\image\\icons\\logo-smkn1kts.png");
    
    private static final String DIREKTORY_ICONS = "src\\resources\\image\\icons\\";
    
    public static Image getWindowIcon(){
        return icWindow.getImage();
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
    
}
