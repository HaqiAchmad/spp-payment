package com.window;

import com.database.Database;
import com.media.Gambar;
import javax.swing.JOptionPane;


/**
 *
 * @author Achmad Baihaqi
 */
public class SplashWindow extends javax.swing.JFrame {

    private final Database db = new Database();
    
    public SplashWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Gambar.getWindowIcon());
        this.lblLogoSmk.setIcon(Gambar.scaleImage(new java.io.File("src\\resources\\image\\icons\\logo-smkn1kts.png"), 130, 160));
        loading();
    }
    
    private void loading(){
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                try{
//                    lblTop.setText("");
//                    lblLogoSmk.setIcon(null);
//                    lblSekolah.setText("");
//                    Thread.sleep(90);
//                    lblTop.setText("Aplikasi Pembayaran SPP");
//                    Thread.sleep(60);
//                    lblLogoSmk.setIcon(Gambar.scaleImage(new java.io.File("src\\resources\\image\\icons\\logo-smkn1kts.png"), 130, 160));
//                    String text = "SMK Negeri 1 Kertosono";
//                    Thread.sleep(500);
//                    for(int i = 0; i <= text.length(); i++){
//                        lblSekolah.setText(text.substring(0, i));
//                        Thread.sleep(85);
//                    }
//                    Thread.sleep(300);
                    int val = 0, delay = 50;
                    while(val <= 100){
                        proLoad.setValue(val);
                        if(val >= 0 && val < 9){
                            delay = 100;
                            lblMessage.setText("  Menyiapkan Aplikasi...");
                        }else if(val >= 9 && val < 15){
                            lblMessage.setText("  Memulai Aplikasi...");
                        }else if(val >= 15 && val < 25){
                            delay = 40;
                            lblMessage.setText("  Mengecek Database...");
                        }else if(val >= 25 && val < 40){
                            Thread.sleep(440);
                            delay = 40;
                            val = 40;
                            lblMessage.setText("  Menghubungkan ke Database...");
                            db.startConnection();
                            db.closeConnection();
                        }else{
                            lblMessage.setText("  Membuka Aplikasi...");
                        }
                        lblLoadVal.setText("" + val + " %  ");
                        val++;
                        Thread.sleep(50);
                    }
                    if(val >= 100){
                        java.awt.EventQueue.invokeLater(new Runnable(){
                            @Override
                            public void run(){
                                new DashboardTest().setVisible(true);
                            }
                        });
                        dispose();
                    }
                }catch(InterruptedException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        proLoad = new javax.swing.JProgressBar();
        lblTop = new javax.swing.JLabel();
        lblLogoSmk = new javax.swing.JLabel();
        lblLoadVal = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        lblSekolah = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        proLoad.setBackground(new java.awt.Color(242, 245, 249));
        proLoad.setForeground(new java.awt.Color(0, 16, 255));

        lblTop.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTop.setText("Aplikasi Pembayaran SPP");

        lblLogoSmk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoSmk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-school.png"))); // NOI18N

        lblLoadVal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblLoadVal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLoadVal.setText("85%  ");

        lblMessage.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblMessage.setText("  Membuka Aplikasi...");

        lblSekolah.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSekolah.setForeground(new java.awt.Color(255, 0, 0));
        lblSekolah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSekolah.setText("SMK Negeri 1 Kertosono");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(proLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLogoSmk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(lblLoadVal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblSekolah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTop, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogoSmk, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoadVal)
                    .addComponent(lblMessage))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SplashWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLoadVal;
    private javax.swing.JLabel lblLogoSmk;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblSekolah;
    private javax.swing.JLabel lblTop;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JProgressBar proLoad;
    // End of variables declaration//GEN-END:variables
}
