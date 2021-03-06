package com.main;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-01
 */
public class Main {
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            
            @Override
            public void run(){
                new com.window.LoginWindow().setVisible(true);
            }
        });
    }
}
