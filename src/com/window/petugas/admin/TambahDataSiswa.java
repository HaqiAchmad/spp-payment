package com.window.petugas.admin;

import com.database.Account;
import com.media.Audio;
import com.media.Gambar;
import com.window.all.ConfirmCancelInput;
import com.window.all.ConfirmClose;
import com.window.petugas.DataSiswa;
import java.awt.Color;

import java.awt.Cursor;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-24
 */
public class TambahDataSiswa extends javax.swing.JFrame {

    int x, y;
    private final Account acc = new Account();
    private String nis, namaSiswa, jenisKelamin, tempatLhr, tanggalLhr, kelas, alamat,
                   jurusan, noHp, email, level, password, konfirmasi;
    
    public TambahDataSiswa() {
        initComponents();
        this.setIconImage(Gambar.getWindowIcon());
        this.setLocationRelativeTo(null);
        this.btnBatal.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnReset.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnTambah.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.pnlInput.setBackground(new java.awt.Color(0,0,0,1));
        this.lblLogoSmk.setIcon(Gambar.scaleImage(new java.io.File("src\\resources\\image\\icons\\logo-smkn1kts.png"), 31, 38));
    }
    
    private void getInput(){
        this.nis = this.inpNis.getText();
        this.namaSiswa = this.inpNamaSiswa.getText();
        this.jenisKelamin = this.inpGender.getSelectedItem().toString();
        this.tempatLhr = this.inpTempatLahir.getText();
        this.alamat = this.inpAlamat.getText();
        this.noHp = this.inpNoHp.getText();
        this.kelas = this.inpKelas.getSelectedItem().toString();
        this.jurusan = this.inpJurusan.getSelectedItem().toString();
        this.email = this.inpEmail.getText();
        
        if(jenisKelamin.equalsIgnoreCase("Laki-Laki")){
            jenisKelamin = "L";
        }else{
            jenisKelamin = "P";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimaze = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        lblTop = new javax.swing.JLabel();
        lineTop = new javax.swing.JSeparator();
        lblNis = new javax.swing.JLabel();
        inpNis = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        lblNamaSiswa = new javax.swing.JLabel();
        inpNamaSiswa = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblTempatLahir = new javax.swing.JLabel();
        inpTempatLahir = new javax.swing.JTextField();
        lblTanggalLahir = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        inpAlamat = new javax.swing.JTextField();
        lblKelas = new javax.swing.JLabel();
        lblJurusan = new javax.swing.JLabel();
        lblGelombang = new javax.swing.JLabel();
        lblNoHp = new javax.swing.JLabel();
        inpNoHp = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        inpEmail = new javax.swing.JTextField();
        lblNamaWali = new javax.swing.JLabel();
        inpNamaWali = new javax.swing.JTextField();
        lblIdSpp = new javax.swing.JLabel();
        lblAddFoto = new javax.swing.JLabel();
        lineBottom = new javax.swing.JSeparator();
        inpGender = new javax.swing.JComboBox();
        inpTanggalLahir = new com.toedter.calendar.JDateChooser();
        inpKelas = new javax.swing.JComboBox();
        inpJurusan = new javax.swing.JComboBox();
        inpGelombang = new javax.swing.JComboBox();
        inpIdSpp = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        btnBatal = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        lblLogoSmk = new javax.swing.JLabel();
        lblNamaSekolah = new javax.swing.JLabel();
        lblNamaApp = new javax.swing.JLabel();
        lblBgImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(0, 0, 0));
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
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-manipulasi-close-white.png"))); // NOI18N
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
        pnlMain.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 30, 30));

        lblMinimaze.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinimaze.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_minus_23px_8.png"))); // NOI18N
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
        pnlMain.add(lblMinimaze, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 20, 30));

        pnlInput.setBackground(new java.awt.Color(0, 0, 0));
        pnlInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblTop.setFont(new java.awt.Font("Dialog", 1, 23)); // NOI18N
        lblTop.setForeground(new java.awt.Color(253, 20, 20));
        lblTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTop.setText("Tambah Data Siswa");

        lineTop.setBackground(new java.awt.Color(245, 237, 237));
        lineTop.setForeground(new java.awt.Color(245, 237, 237));

        lblNis.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNis.setForeground(new java.awt.Color(255, 255, 255));
        lblNis.setText("NIS");

        inpNis.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpNis.setCaretColor(new java.awt.Color(10, 79, 223));

        lblFoto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setText("Foto Siswa");
        lblFoto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblNamaSiswa.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNamaSiswa.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaSiswa.setText("Nama Siswa");

        inpNamaSiswa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNamaSiswa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpNamaSiswa.setCaretColor(new java.awt.Color(10, 79, 223));

        lblGender.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Jenis Kelamin");

        lblTempatLahir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblTempatLahir.setForeground(new java.awt.Color(255, 255, 255));
        lblTempatLahir.setText("Tempat Lahir");

        inpTempatLahir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpTempatLahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpTempatLahir.setCaretColor(new java.awt.Color(10, 79, 223));

        lblTanggalLahir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblTanggalLahir.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggalLahir.setText("Tanggal Lahir");

        lblAlamat.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(255, 255, 255));
        lblAlamat.setText("Alamat");

        inpAlamat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpAlamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpAlamat.setCaretColor(new java.awt.Color(10, 79, 223));

        lblKelas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblKelas.setForeground(new java.awt.Color(255, 255, 255));
        lblKelas.setText("Kelas");

        lblJurusan.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblJurusan.setForeground(new java.awt.Color(255, 255, 255));
        lblJurusan.setText("Jurusan");

        lblGelombang.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblGelombang.setForeground(new java.awt.Color(255, 255, 255));
        lblGelombang.setText("Gelombang");

        lblNoHp.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNoHp.setForeground(new java.awt.Color(255, 255, 255));
        lblNoHp.setText("Nomor HP");

        inpNoHp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNoHp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpNoHp.setCaretColor(new java.awt.Color(10, 79, 223));

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");

        inpEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpEmail.setCaretColor(new java.awt.Color(10, 79, 223));

        lblNamaWali.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNamaWali.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaWali.setText("Nama Wali");

        inpNamaWali.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpNamaWali.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpNamaWali.setCaretColor(new java.awt.Color(10, 79, 223));

        lblIdSpp.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblIdSpp.setForeground(new java.awt.Color(255, 255, 255));
        lblIdSpp.setText("ID SPP");

        lblAddFoto.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        lblAddFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblAddFoto.setText("Tambahkan Foto");
        lblAddFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddFotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddFotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddFotoMouseExited(evt);
            }
        });

        lineBottom.setBackground(new java.awt.Color(245, 237, 237));
        lineBottom.setForeground(new java.awt.Color(245, 237, 237));

        inpGender.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-Laki", "Perempuan" }));

        inpTanggalLahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        inpTanggalLahir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        inpKelas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "X (sepuluh)", "XI (sebelas)", "XII (dua belas)", "XIII (tiga belas)" }));

        inpJurusan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpJurusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Teknik Pemesinan", "Teknik Instalasi Tenaga Listrik", "Teknik Otomasi Industri", "Tata Boga", "Tata Busana", "Rekayasa Perangkat Lunak" }));

        inpGelombang.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpGelombang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 (satu)", "2 (dua)", "3 (tiga)" }));

        inpIdSpp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inpIdSpp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "17", "18", "19", "20" }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbFoto.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lbFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFoto.setText("3 x 4");
        lbFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbFotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbFotoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lineTop)
                    .addComponent(lineBottom)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inpKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInputLayout.createSequentialGroup()
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inpTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addComponent(lblIdSpp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInputLayout.createSequentialGroup()
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTempatLahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inpNis, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpGender, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNamaWali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJurusan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGelombang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNoHp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inpJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(inpIdSpp, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inpNamaWali, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inpEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inpNoHp, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(inpGelombang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addComponent(lblTop, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAddFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inpKelas)
                            .addComponent(lblKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpNis, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inpJurusan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblJurusan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGelombang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpGelombang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inpGender, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTanggalLahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNamaWali, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inpNamaWali, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inpTanggalLahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inpAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIdSpp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inpIdSpp, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addComponent(lineBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlMain.add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 950, 510));

        btnBatal.setBackground(new java.awt.Color(220, 41, 41));
        btnBatal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-manipulasi-cancel.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBatalMouseExited(evt);
            }
        });
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        pnlMain.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 90, -1));

        btnReset.setBackground(new java.awt.Color(17, 159, 77));
        btnReset.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-manipulasi-reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetMouseExited(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnlMain.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 90, -1));

        btnTambah.setBackground(new java.awt.Color(34, 119, 237));
        btnTambah.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-manipulasi-save.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahMouseExited(evt);
            }
        });
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        pnlMain.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 550, -1, -1));

        lblLogoSmk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoSmk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-nav-logosekolah.png"))); // NOI18N
        pnlMain.add(lblLogoSmk, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 40, 60));

        lblNamaSekolah.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblNamaSekolah.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaSekolah.setText("SMK Negeri 1 Kertosono");
        pnlMain.add(lblNamaSekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 270, -1));

        lblNamaApp.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblNamaApp.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaApp.setText("Sistem Aplikasi Pembayaran SPP");
        pnlMain.add(lblNamaApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 250, -1));

        lblBgImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/bgimages/bg-login.jpg"))); // NOI18N
        pnlMain.add(lblBgImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
    }//GEN-LAST:event_formWindowClosed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        Audio.play(Audio.SOUND_INFO);
        new ConfirmClose(this, true).setVisible(true);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        this.lblClose.setIcon(Gambar.getIcon("ic-manipulasi-close-entered.png"));
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        this.lblClose.setIcon(Gambar.getIcon("ic-manipulasi-close-white.png"));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblMinimazeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimazeMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimazeMouseClicked

    private void lblMinimazeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimazeMouseEntered
        this.lblMinimaze.setIcon(Gambar.getIcon("ic-manipulasi-minimaze-entered.png"));
    }//GEN-LAST:event_lblMinimazeMouseEntered

    private void lblMinimazeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimazeMouseExited
        this.lblMinimaze.setIcon(Gambar.getIcon("ic-manipulasi-minimaze-white.png"));
    }//GEN-LAST:event_lblMinimazeMouseExited

    private void lblAddFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddFotoMouseClicked
        
    }//GEN-LAST:event_lblAddFotoMouseClicked

    private void lblAddFotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddFotoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblAddFotoMouseEntered

    private void lblAddFotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddFotoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblAddFotoMouseExited

    private void lbFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFotoMouseClicked
        
    }//GEN-LAST:event_lbFotoMouseClicked

    private void lbFotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFotoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbFotoMouseEntered

    private void lbFotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFotoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lbFotoMouseExited

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if(acc.buatAkunSiswa(4444, namaSiswa, jenisKelamin, "xii.rpl1", noHp, email, 18, Account.DEFAULT_FOTO)){
            Audio.play(Audio.SOUND_INFO);
            JOptionPane.showMessageDialog(null, "Siswa berhasil ditambahkan!", "Infor", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Ssiwa gagal ditambahkan!", "Infor", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnTambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseEntered
        this.btnTambah.setBackground(this.btnTambah.getBackground().darker());
        this.btnTambah.setIcon(Gambar.getIcon("ic-manipulasi-save-entered.png"));
    }//GEN-LAST:event_btnTambahMouseEntered

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
        this.btnTambah.setBackground(new Color(34,119,237));
        this.btnTambah.setIcon(Gambar.getIcon("ic-manipulasi-save.png"));
    }//GEN-LAST:event_btnTambahMouseExited

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseEntered
        this.btnReset.setBackground(this.btnReset.getBackground().darker());
        this.btnReset.setIcon(Gambar.getIcon("ic-manipulasi-reset-entered.png"));
    }//GEN-LAST:event_btnResetMouseEntered

    private void btnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseExited
        this.btnReset.setBackground(new Color(17,159,77));
        this.btnReset.setIcon(Gambar.getIcon("ic-manipulasi-reset.png"));
    }//GEN-LAST:event_btnResetMouseExited

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        Audio.play(Audio.SOUND_INFO);
        new ConfirmCancelInput(this, true, new DataSiswa()).setVisible(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnBatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseEntered
        this.btnBatal.setBackground(this.btnBatal.getBackground().darker());
        this.btnBatal.setIcon(Gambar.getIcon("ic-manipulasi-cancel-entered.png"));
    }//GEN-LAST:event_btnBatalMouseEntered

    private void btnBatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseExited
        this.btnBatal.setBackground(new Color(220,41,41));
        this.btnBatal.setIcon(Gambar.getIcon("ic-manipulasi-cancel.png"));
    }//GEN-LAST:event_btnBatalMouseExited


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahDataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TambahDataSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTextField inpAlamat;
    private javax.swing.JTextField inpEmail;
    private javax.swing.JComboBox inpGelombang;
    private javax.swing.JComboBox inpGender;
    private javax.swing.JComboBox inpIdSpp;
    private javax.swing.JComboBox inpJurusan;
    private javax.swing.JComboBox inpKelas;
    private javax.swing.JTextField inpNamaSiswa;
    private javax.swing.JTextField inpNamaWali;
    private javax.swing.JTextField inpNis;
    private javax.swing.JTextField inpNoHp;
    private com.toedter.calendar.JDateChooser inpTanggalLahir;
    private javax.swing.JTextField inpTempatLahir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lblAddFoto;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblBgImage;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblGelombang;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIdSpp;
    private javax.swing.JLabel lblJurusan;
    private javax.swing.JLabel lblKelas;
    private javax.swing.JLabel lblLogoSmk;
    private javax.swing.JLabel lblMinimaze;
    private javax.swing.JLabel lblNamaApp;
    private javax.swing.JLabel lblNamaSekolah;
    private javax.swing.JLabel lblNamaSiswa;
    private javax.swing.JLabel lblNamaWali;
    private javax.swing.JLabel lblNis;
    private javax.swing.JLabel lblNoHp;
    private javax.swing.JLabel lblTanggalLahir;
    private javax.swing.JLabel lblTempatLahir;
    private javax.swing.JLabel lblTop;
    private javax.swing.JSeparator lineBottom;
    private javax.swing.JSeparator lineTop;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
