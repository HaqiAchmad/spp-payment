package com.main;

/**
 * Class ini adala class yang pertama kali dieksekusi saat program dijalankan
 * 
 * @author Achmad Baihaqi
 * @since 2021-03-07
 */
public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            
            @Override
            public void run(){
                new com.window.all.LoginWindow().setVisible(true);
            }
        });
    }
}
