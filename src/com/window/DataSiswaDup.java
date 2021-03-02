package com.window;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-01
 */
public class DataSiswaDup extends javax.swing.JFrame {
    

    public DataSiswaDup() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTop = new javax.swing.JLabel();
        lblSpp = new javax.swing.JLabel();
        line = new javax.swing.JSeparator();
        lblTglLahir = new javax.swing.JLabel();
        lblNis = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        inpNis = new javax.swing.JTextField();
        inpTglLahir = new javax.swing.JTextField();
        inpKelas = new javax.swing.JComboBox<>();
        inpNama = new javax.swing.JTextField();
        lblTempatLhr = new javax.swing.JLabel();
        inpTempatLhr = new javax.swing.JTextField();
        lblKelas = new javax.swing.JLabel();
        inpGender = new javax.swing.JComboBox<>();
        lblNis1 = new javax.swing.JLabel();
        lblNama1 = new javax.swing.JLabel();
        lblGender1 = new javax.swing.JLabel();
        lblKelas1 = new javax.swing.JLabel();
        lblTglLahir1 = new javax.swing.JLabel();
        lblTempatLhr1 = new javax.swing.JLabel();
        inpTglLahir1 = new javax.swing.JTextField();
        inpTempatLhr1 = new javax.swing.JTextField();
        inpNama1 = new javax.swing.JTextField();
        inpNama2 = new javax.swing.JTextField();
        inpTglLahir2 = new javax.swing.JTextField();
        inpKelas1 = new javax.swing.JComboBox<>();
        line3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSpp1 = new javax.swing.JLabel();
        lblMain = new javax.swing.JLabel();
        line2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTop.setBackground(new java.awt.Color(0, 31, 255));
        lblTop.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        lblTop.setForeground(new java.awt.Color(0, 31, 255));
        lblTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTop.setText("SMKN 1 KERTOSONO");
        getContentPane().add(lblTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 50));

        lblSpp.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblSpp.setForeground(new java.awt.Color(255, 255, 255));
        lblSpp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSpp.setText("Menu Input Data Siswa");
        getContentPane().add(lblSpp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1370, 40));

        line.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1360, 20));

        lblTglLahir.setBackground(new java.awt.Color(255, 255, 255));
        lblTglLahir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTglLahir.setForeground(new java.awt.Color(255, 255, 255));
        lblTglLahir.setText("Tanggal Lahir");
        getContentPane().add(lblTglLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 140, 30));

        lblNis.setBackground(new java.awt.Color(255, 255, 255));
        lblNis.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNis.setForeground(new java.awt.Color(255, 255, 255));
        lblNis.setText("NIS");
        getContentPane().add(lblNis, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 140, 30));

        lblNama.setBackground(new java.awt.Color(255, 255, 255));
        lblNama.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Nama Siswa");
        getContentPane().add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 140, 30));

        lblGender.setBackground(new java.awt.Color(255, 255, 255));
        lblGender.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Jenis Kelamin");
        getContentPane().add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 140, 30));

        inpNis.setBackground(new java.awt.Color(55, 61, 75));
        inpNis.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNis.setForeground(new java.awt.Color(255, 255, 255));
        inpNis.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpNis, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 330, 30));

        inpTglLahir.setBackground(new java.awt.Color(55, 61, 75));
        inpTglLahir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpTglLahir.setForeground(new java.awt.Color(255, 255, 255));
        inpTglLahir.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpTglLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 330, 30));

        inpKelas.setBackground(new java.awt.Color(55, 61, 75));
        inpKelas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpKelas.setForeground(new java.awt.Color(255, 255, 255));
        inpKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tenik Pemesinan", "Teknik Instalasi Tenaga Listrik", "Teknik Otomasi", "Tata Boga", "Tata Busana", "Rekayasa Perangkat Lunak" }));
        getContentPane().add(inpKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, 330, 30));

        inpNama.setBackground(new java.awt.Color(55, 61, 75));
        inpNama.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNama.setForeground(new java.awt.Color(255, 255, 255));
        inpNama.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 330, 30));

        lblTempatLhr.setBackground(new java.awt.Color(255, 255, 255));
        lblTempatLhr.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTempatLhr.setForeground(new java.awt.Color(255, 255, 255));
        lblTempatLhr.setText("Tempat Lahir");
        getContentPane().add(lblTempatLhr, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 140, 30));

        inpTempatLhr.setBackground(new java.awt.Color(55, 61, 75));
        inpTempatLhr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpTempatLhr.setForeground(new java.awt.Color(255, 255, 255));
        inpTempatLhr.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpTempatLhr, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 330, 30));

        lblKelas.setBackground(new java.awt.Color(255, 255, 255));
        lblKelas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblKelas.setForeground(new java.awt.Color(255, 255, 255));
        lblKelas.setText("Kelas");
        getContentPane().add(lblKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 140, 30));

        inpGender.setBackground(new java.awt.Color(55, 61, 75));
        inpGender.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpGender.setForeground(new java.awt.Color(255, 255, 255));
        inpGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        getContentPane().add(inpGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 330, 30));

        lblNis1.setBackground(new java.awt.Color(255, 255, 255));
        lblNis1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNis1.setForeground(new java.awt.Color(255, 255, 255));
        lblNis1.setText("Jurusan");
        getContentPane().add(lblNis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 140, 30));

        lblNama1.setBackground(new java.awt.Color(255, 255, 255));
        lblNama1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNama1.setForeground(new java.awt.Color(255, 255, 255));
        lblNama1.setText("Alamat");
        getContentPane().add(lblNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 140, 30));

        lblGender1.setBackground(new java.awt.Color(255, 255, 255));
        lblGender1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblGender1.setForeground(new java.awt.Color(255, 255, 255));
        lblGender1.setText("No Hp");
        getContentPane().add(lblGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, 140, 30));

        lblKelas1.setBackground(new java.awt.Color(255, 255, 255));
        lblKelas1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblKelas1.setForeground(new java.awt.Color(255, 255, 255));
        lblKelas1.setText("Ibu");
        getContentPane().add(lblKelas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 140, 30));

        lblTglLahir1.setBackground(new java.awt.Color(255, 255, 255));
        lblTglLahir1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTglLahir1.setForeground(new java.awt.Color(255, 255, 255));
        lblTglLahir1.setText("Ayah");
        getContentPane().add(lblTglLahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 140, 30));

        lblTempatLhr1.setBackground(new java.awt.Color(255, 255, 255));
        lblTempatLhr1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTempatLhr1.setForeground(new java.awt.Color(255, 255, 255));
        lblTempatLhr1.setText("Email");
        getContentPane().add(lblTempatLhr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 140, 30));

        inpTglLahir1.setBackground(new java.awt.Color(55, 61, 75));
        inpTglLahir1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpTglLahir1.setForeground(new java.awt.Color(255, 255, 255));
        inpTglLahir1.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpTglLahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 330, 30));

        inpTempatLhr1.setBackground(new java.awt.Color(55, 61, 75));
        inpTempatLhr1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpTempatLhr1.setForeground(new java.awt.Color(255, 255, 255));
        inpTempatLhr1.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpTempatLhr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 330, 30));

        inpNama1.setBackground(new java.awt.Color(55, 61, 75));
        inpNama1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNama1.setForeground(new java.awt.Color(255, 255, 255));
        inpNama1.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 300, 330, 30));

        inpNama2.setBackground(new java.awt.Color(55, 61, 75));
        inpNama2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNama2.setForeground(new java.awt.Color(255, 255, 255));
        inpNama2.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpNama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, 330, 30));

        inpTglLahir2.setBackground(new java.awt.Color(55, 61, 75));
        inpTglLahir2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpTglLahir2.setForeground(new java.awt.Color(255, 255, 255));
        inpTglLahir2.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(inpTglLahir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 330, 30));

        inpKelas1.setBackground(new java.awt.Color(55, 61, 75));
        inpKelas1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpKelas1.setForeground(new java.awt.Color(255, 255, 255));
        inpKelas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X (sepuluh)", "XI (sebelas)", "XII (dua belas)", "XIII (tiga belas)" }));
        getContentPane().add(inpKelas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 330, 30));

        line3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(line3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1360, 20));

        jButton1.setBackground(new java.awt.Color(12, 76, 163));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ic-save-24.png"))); // NOI18N
        jButton1.setText("Simpan");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 590, -1, -1));

        jButton2.setBackground(new java.awt.Color(17, 159, 77));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ic-batal-24.png"))); // NOI18N
        jButton2.setText("Batal");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 590, 100, -1));

        jButton3.setBackground(new java.awt.Color(234, 34, 34));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/ic-keluar-24.png"))); // NOI18N
        jButton3.setText("Exit");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 590, 90, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Copyright © 2021. Achmad Baihaqi.");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 680, 1360, 90));

        lblSpp1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblSpp1.setForeground(new java.awt.Color(255, 0, 0));
        lblSpp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSpp1.setText("SISTEM INFORMASI PEMBAYARAN SPP");
        getContentPane().add(lblSpp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1370, 40));

        lblMain.setBackground(new java.awt.Color(255, 255, 255));
        lblMain.setForeground(new java.awt.Color(255, 255, 255));
        lblMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/bg2.jpg"))); // NOI18N
        getContentPane().add(lblMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        line2.setForeground(new java.awt.Color(255, 255, 255));
        line2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 20, 350));

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
            java.util.logging.Logger.getLogger(DataSiswaDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSiswaDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSiswaDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSiswaDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSiswaDup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> inpGender;
    private javax.swing.JComboBox<String> inpKelas;
    private javax.swing.JComboBox<String> inpKelas1;
    private javax.swing.JTextField inpNama;
    private javax.swing.JTextField inpNama1;
    private javax.swing.JTextField inpNama2;
    private javax.swing.JTextField inpNis;
    private javax.swing.JTextField inpTempatLhr;
    private javax.swing.JTextField inpTempatLhr1;
    private javax.swing.JTextField inpTglLahir;
    private javax.swing.JTextField inpTglLahir1;
    private javax.swing.JTextField inpTglLahir2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblKelas;
    private javax.swing.JLabel lblKelas1;
    private javax.swing.JLabel lblMain;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblNis;
    private javax.swing.JLabel lblNis1;
    private javax.swing.JLabel lblSpp;
    private javax.swing.JLabel lblSpp1;
    private javax.swing.JLabel lblTempatLhr;
    private javax.swing.JLabel lblTempatLhr1;
    private javax.swing.JLabel lblTglLahir;
    private javax.swing.JLabel lblTglLahir1;
    private javax.swing.JLabel lblTop;
    private javax.swing.JSeparator line;
    private javax.swing.JSeparator line2;
    private javax.swing.JSeparator line3;
    // End of variables declaration//GEN-END:variables
}
