package com.window;

import com.database.Account;
import com.media.Gambar;
import java.awt.Color;

/**
 * Digunakan untuk login bagi user/admin
 * 
 * @author Achmad Baihaqi
 * @since 22-11-2020
 */
public class LoginWindow extends javax.swing.JFrame {

    private Account acc = new Account();
    private String user, password;
    private int x = 0, y = 0;
    
    public LoginWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Gambar.getWindowIcon());
        this.btnLogin.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.lblLogoSmk.setIcon(Gambar.scaleImage(new java.io.File("src\\resources\\image\\icons\\logo-smkn1kts.png"), 130, 170));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        lblLogoSmk = new javax.swing.JLabel();
        lblSekolah = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        lblTop = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        inpUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblClose = new javax.swing.JLabel();
        lblMinimaze = new javax.swing.JLabel();
        inpPassword = new javax.swing.JPasswordField();
        lblEye = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(21, 20, 20));
        pnlMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlMainMouseDragged(evt);
            }
        });
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMainMousePressed(evt);
            }
        });

        pnlLeft.setBackground(new java.awt.Color(33, 33, 37));

        lblLogoSmk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoSmk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-school.png"))); // NOI18N
        lblLogoSmk.setToolTipText("");
        lblLogoSmk.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblSekolah.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblSekolah.setForeground(new java.awt.Color(255, 255, 255));
        lblSekolah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSekolah.setText("SMK Negeri 1 Kertosono");

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoSmk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSekolah, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addComponent(lblLogoSmk, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlRight.setBackground(new java.awt.Color(21, 20, 20));

        lblTop.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblTop.setForeground(new java.awt.Color(44, 119, 238));
        lblTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTop.setText("Login Petugas");
        lblTop.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("ID / Username");

        inpUsername.setBackground(new java.awt.Color(36, 37, 39));
        inpUsername.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpUsername.setForeground(new java.awt.Color(255, 255, 255));
        inpUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inpUsername.setCaretColor(new java.awt.Color(255, 255, 255));
        inpUsername.setMaximumSize(new java.awt.Dimension(2147483647, 35));
        inpUsername.setMinimumSize(new java.awt.Dimension(6, 35));
        inpUsername.setPreferredSize(new java.awt.Dimension(6, 35));

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Password");

        btnLogin.setBackground(new java.awt.Color(250, 56, 56));
        btnLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblClose.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-close-white.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });

        lblMinimaze.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMinimaze.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinimaze.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-minimaze-white.png"))); // NOI18N
        lblMinimaze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimazeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimazeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimazeMouseExited(evt);
            }
        });

        inpPassword.setBackground(new java.awt.Color(36, 37, 39));
        inpPassword.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpPassword.setForeground(new java.awt.Color(255, 255, 255));
        inpPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inpPassword.setCaretColor(new java.awt.Color(255, 255, 255));

        lblEye.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-eye-close.png"))); // NOI18N
        lblEye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEyeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEyeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEyeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMinimaze)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(inpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(inpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEye, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClose, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblMinimaze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(lblTop)
                .addGap(37, 37, 37)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEye, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(inpPassword))
                .addGap(36, 36, 36)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_pnlMainMousePressed

    private void pnlMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseDragged
        int xx = evt.getXOnScreen(),
        yy = evt.getYOnScreen();

        this.setLocation(xx-x, yy-y);
    }//GEN-LAST:event_pnlMainMouseDragged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.out.println("Menutup Window SignIn");
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("-->     APLIKASI DITUTUP");
    }//GEN-LAST:event_formWindowClosing

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        this.btnLogin.setBackground(new Color(23,24,26));
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        this.btnLogin.setBackground(new Color(250,56,56));
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        user = this.inpUsername.getText();
        password = this.inpPassword.getText();
        boolean login = acc.loginAsPetugas(user, password);
        if(login){
            java.awt.EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    new DashboardTest().setVisible(true);
                }
            });
            dispose();
        }else{
            this.inpUsername.setText("");
            this.inpPassword.setText("");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblMinimazeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimazeMouseExited
        this.lblMinimaze.setIcon(Gambar.getIcon(Gambar.IC_MINIMAZE_WHITE));
    }//GEN-LAST:event_lblMinimazeMouseExited

    private void lblMinimazeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimazeMouseEntered
        this.lblMinimaze.setIcon(Gambar.getIcon(Gambar.IC_MINIMAZE_ENTERED));
    }//GEN-LAST:event_lblMinimazeMouseEntered

    private void lblMinimazeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimazeMouseClicked
        this.setExtendedState(javax.swing.JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimazeMouseClicked

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        this.lblClose.setIcon(Gambar.getIcon(Gambar.IC_CLOSE_WHITE));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        this.lblClose.setIcon(Gambar.getIcon(Gambar.IC_CLOSE_ENTERED));
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblEyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEyeMouseClicked

    }//GEN-LAST:event_lblEyeMouseClicked

    private void lblEyeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEyeMouseEntered
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.lblEye.setIcon(Gambar.getIcon("ic-eye-open.png"));
        this.inpPassword.setEchoChar((char)0);
    }//GEN-LAST:event_lblEyeMouseEntered

    private void lblEyeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEyeMouseExited
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.lblEye.setIcon(Gambar.getIcon("ic-eye-close.png"));
        this.inpPassword.setEchoChar('•');
    }//GEN-LAST:event_lblEyeMouseExited


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
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField inpPassword;
    private javax.swing.JTextField inpUsername;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblEye;
    private javax.swing.JLabel lblLogoSmk;
    private javax.swing.JLabel lblMinimaze;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSekolah;
    private javax.swing.JLabel lblTop;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRight;
    // End of variables declaration//GEN-END:variables
}
