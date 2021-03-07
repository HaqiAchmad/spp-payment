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
