package com.main;

/**
 *
 * @author Achmad Baihaqi
 */
public class Main {
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            
            @Override
            public void run(){
                new com.window.Login().setVisible(true);
            }
        });
    }
}
