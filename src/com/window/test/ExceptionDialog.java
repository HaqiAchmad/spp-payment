package com.window.test;

import java.awt.Cursor;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-08
 */
public class ExceptionDialog extends javax.swing.JDialog {
    
    private Throwable e;
    
    private java.awt.Frame parent;
    
    public ExceptionDialog(Frame parent, boolean modal, Throwable e) {
        this(parent, modal, e, "Terjadi kesalahan!", "Pesan");
    }
        
    public ExceptionDialog(Frame parent, boolean modal, Throwable e, String message){
        this(parent, modal, e, message, "Pesan");
    }

    public ExceptionDialog(Frame parent, boolean modal, Throwable e, String message, String title){
        super(parent, modal);
        initComponents();
        this.e = e;
        this.parent = parent;
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.btnOK.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.lblMessage.setText(message);
        
        if(message.length() > 25){
            int lebar = getWidth(), tinggi = getHeight();
            for(int i = 25; i <= message.length(); i++){
                this.setSize(lebar+=5, tinggi);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        line = new javax.swing.JSeparator();
        btnOK = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-message-error.png"))); // NOI18N
        lblIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        line.setBackground(new java.awt.Color(0, 0, 0));
        line.setForeground(new java.awt.Color(0, 0, 0));
        line.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnOK.setBackground(new java.awt.Color(42, 119, 212));
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblMessage.setText("Terjadi Kesalahan!");

        lblDetail.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        lblDetail.setForeground(new java.awt.Color(51, 51, 51));
        lblDetail.setText("Tampilkan Detail...");
        lblDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDetailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDetailMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOK)
                        .addContainerGap())
                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(line)
                            .addComponent(lblIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(btnOK)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void lblDetailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.lblDetail.setText("<html><p style=\"text-decoration:underline; color:red;\">Tampilkan Detail...</p></html>");
    }//GEN-LAST:event_lblDetailMouseEntered

    private void lblDetailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.lblDetail.setText("<html><p style=\"text-none:underline; color:rgb(51, 51, 51);\">Tampilkan Detail...</p></html>");
    }//GEN-LAST:event_lblDetailMouseExited

    private void lblDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetailMouseClicked
        JOptionPane.showMessageDialog(this, String.format("Detail Error!\nPesan : %s\nLokasi : %s\nThrown : %s", e.getMessage(), parent.getClass().getName(), e.getClass().getName()), "Detail Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_lblDetailMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExceptionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExceptionDialog dialog = new ExceptionDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JSeparator line;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
