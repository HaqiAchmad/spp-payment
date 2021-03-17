package com.window;

import com.database.Account;
import com.database.Database;
import com.database.Transaksi;
import com.media.Gambar;

/**
 *
 * @author Infinite World
 */
public class DashboardTestDup extends javax.swing.JFrame {

    private final Database dbase = new Database();
    private final Account acc = new Account();
    private final Transaksi tr = new Transaksi();
    
    private int user, admin, petugas, siswa, kelas, spp, nis;
    private String foto;
    
    public DashboardTestDup() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.btnDashboard.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnInfoAkun.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataPetugas.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataSiswa.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataKelas.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataSpp.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnPembayaranSpp.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnTentangApp.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.lblSekolah.setIcon(Gambar.scaleImage(new java.io.File("src\\resources\\image\\icons\\logo-smkn1kts.png"), 28, 35));
//        

        acc.closeConnection();
        dbase.closeConnection();
        tr.closeConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        pnlAccount = new javax.swing.JPanel();
        lblPhotoProfile = new javax.swing.JLabel();
        lblNamaUser = new javax.swing.JLabel();
        lblEditProfile = new javax.swing.JLabel();
        btnInfoAkun = new javax.swing.JButton();
        btnDataPetugas = new javax.swing.JButton();
        btnDataSiswa = new javax.swing.JButton();
        btnDataKelas = new javax.swing.JButton();
        btnPembayaranSpp = new javax.swing.JButton();
        pnlLeftBottom = new javax.swing.JPanel();
        btnDataSpp = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        btnTentangApp = new javax.swing.JButton();
        pnlTop = new javax.swing.JPanel();
        lblSekolah = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblMinimaze = new javax.swing.JLabel();
        pnlData = new javax.swing.JPanel();
        pnlDataJam = new javax.swing.JPanel();
        lblDataTop = new javax.swing.JLabel();
        lblDataJam = new javax.swing.JLabel();
        pnlDataUser = new javax.swing.JPanel();
        pnlDataUserIcon = new javax.swing.JPanel();
        lblDataUserIcon = new javax.swing.JLabel();
        lblDataUser = new javax.swing.JLabel();
        valDataUser = new javax.swing.JLabel();
        pnlDataPetugas = new javax.swing.JPanel();
        pnlDataPetugasIcon = new javax.swing.JPanel();
        lblDataPetugasIcon = new javax.swing.JLabel();
        lblDataPetugas = new javax.swing.JLabel();
        valDataPetugas = new javax.swing.JLabel();
        pnlDataKelas = new javax.swing.JPanel();
        pnlDataKelasIcon = new javax.swing.JPanel();
        lblDataKelasIcon = new javax.swing.JLabel();
        lblDataKelas = new javax.swing.JLabel();
        valDataKelas = new javax.swing.JLabel();
        pnlDataAdmin = new javax.swing.JPanel();
        pnlDataAdminIcon = new javax.swing.JPanel();
        lblDataAdminIcon = new javax.swing.JLabel();
        lblDataAdmin = new javax.swing.JLabel();
        valDataAdmin = new javax.swing.JLabel();
        pnlDataSiswa = new javax.swing.JPanel();
        pnlDataSiswaIcon = new javax.swing.JPanel();
        lblDataSiswaIcon = new javax.swing.JLabel();
        lblDataSiswa = new javax.swing.JLabel();
        valDataSiswa = new javax.swing.JLabel();
        pnlDataSpp = new javax.swing.JPanel();
        pnlDataSppIcon = new javax.swing.JPanel();
        lblDataSppIcon = new javax.swing.JLabel();
        lblDataSpp = new javax.swing.JLabel();
        valDataSpp = new javax.swing.JLabel();
        lblDashboard = new javax.swing.JLabel();
        pnlBottom = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblBgImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(22, 24, 24));
        sidePanel.setMaximumSize(new java.awt.Dimension(218, 555));

        btnDashboard.setBackground(new java.awt.Color(22, 24, 24));
        btnDashboard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-home.png"))); // NOI18N
        btnDashboard.setText(" Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        pnlAccount.setBackground(new java.awt.Color(41, 52, 71));
        pnlAccount.setMaximumSize(new java.awt.Dimension(194, 82));

        lblPhotoProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhotoProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-profile.png"))); // NOI18N
        lblPhotoProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPhotoProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhotoProfileMouseClicked(evt);
            }
        });

        lblNamaUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNamaUser.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaUser.setText("Achmad Baihaqi");
        lblNamaUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNamaUser.setInheritsPopupMenu(false);

        lblEditProfile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblEditProfile.setText("Informasi Akun");
        lblEditProfile.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditProfileMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlAccountLayout = new javax.swing.GroupLayout(pnlAccount);
        pnlAccount.setLayout(pnlAccountLayout);
        pnlAccountLayout.setHorizontalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPhotoProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNamaUser, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        pnlAccountLayout.setVerticalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhotoProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAccountLayout.createSequentialGroup()
                        .addComponent(lblNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEditProfile)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnInfoAkun.setBackground(new java.awt.Color(22, 24, 24));
        btnInfoAkun.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInfoAkun.setForeground(new java.awt.Color(255, 255, 255));
        btnInfoAkun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-akun.png"))); // NOI18N
        btnInfoAkun.setText(" Informasi Akun");
        btnInfoAkun.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnInfoAkun.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInfoAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoAkunActionPerformed(evt);
            }
        });

        btnDataPetugas.setBackground(new java.awt.Color(22, 24, 24));
        btnDataPetugas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataPetugas.setForeground(new java.awt.Color(255, 255, 255));
        btnDataPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-admin.png"))); // NOI18N
        btnDataPetugas.setText(" Data Petugas");
        btnDataPetugas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataPetugas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPetugasActionPerformed(evt);
            }
        });

        btnDataSiswa.setBackground(new java.awt.Color(22, 24, 24));
        btnDataSiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataSiswa.setForeground(new java.awt.Color(255, 255, 255));
        btnDataSiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-siswa.png"))); // NOI18N
        btnDataSiswa.setText(" Data Siswa");
        btnDataSiswa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataSiswa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataSiswaActionPerformed(evt);
            }
        });

        btnDataKelas.setBackground(new java.awt.Color(22, 24, 24));
        btnDataKelas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataKelas.setForeground(new java.awt.Color(255, 255, 255));
        btnDataKelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-kelas.png"))); // NOI18N
        btnDataKelas.setText(" Data Kelas");
        btnDataKelas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataKelas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKelasActionPerformed(evt);
            }
        });

        btnPembayaranSpp.setBackground(new java.awt.Color(22, 24, 24));
        btnPembayaranSpp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPembayaranSpp.setForeground(new java.awt.Color(255, 255, 255));
        btnPembayaranSpp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-pembayaran.png"))); // NOI18N
        btnPembayaranSpp.setText(" Pembayaran SPP");
        btnPembayaranSpp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPembayaranSpp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPembayaranSpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembayaranSppActionPerformed(evt);
            }
        });

        pnlLeftBottom.setBackground(new java.awt.Color(22, 24, 24));

        javax.swing.GroupLayout pnlLeftBottomLayout = new javax.swing.GroupLayout(pnlLeftBottom);
        pnlLeftBottom.setLayout(pnlLeftBottomLayout);
        pnlLeftBottomLayout.setHorizontalGroup(
            pnlLeftBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLeftBottomLayout.setVerticalGroup(
            pnlLeftBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        btnDataSpp.setBackground(new java.awt.Color(22, 24, 24));
        btnDataSpp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataSpp.setForeground(new java.awt.Color(255, 255, 255));
        btnDataSpp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-spp.png"))); // NOI18N
        btnDataSpp.setText(" Data SPP");
        btnDataSpp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataSpp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataSpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataSppActionPerformed(evt);
            }
        });

        btnLaporan.setBackground(new java.awt.Color(22, 24, 24));
        btnLaporan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-laporan.png"))); // NOI18N
        btnLaporan.setText(" Laporan");
        btnLaporan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLaporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        btnTentangApp.setBackground(new java.awt.Color(22, 24, 24));
        btnTentangApp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTentangApp.setForeground(new java.awt.Color(255, 255, 255));
        btnTentangApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-petugas-tentangApp.png"))); // NOI18N
        btnTentangApp.setText(" Tentang Aplikasi");
        btnTentangApp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTentangApp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTentangApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTentangAppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeftBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTentangApp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLaporan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPembayaranSpp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnDataSpp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataKelas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataSiswa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataPetugas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInfoAkun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(pnlAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInfoAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDataPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDataKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDataSpp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPembayaranSpp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTentangApp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(pnlLeftBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMain.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlTop.setBackground(new java.awt.Color(11, 114, 238));

        lblSekolah.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSekolah.setForeground(new java.awt.Color(255, 255, 255));
        lblSekolah.setText("SMK Negeri 1 Kertosono | Aplikasi Pembayaran SPP");
        lblSekolah.setIconTextGap(6);

        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-close-white.png"))); // NOI18N

        lblMinimaze.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinimaze.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-minimaze-white.png"))); // NOI18N

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(lblMinimaze)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSekolah, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClose, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblMinimaze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlMain.add(pnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 990, 50));

        pnlData.setBackground(new java.awt.Color(255, 255, 255));
        pnlData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 121, 173), 3));

        pnlDataJam.setBackground(new java.awt.Color(26, 121, 173));

        lblDataTop.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDataTop.setForeground(new java.awt.Color(255, 255, 255));
        lblDataTop.setText("Data Aplikasi Pembayaran SPP");

        lblDataJam.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDataJam.setForeground(new java.awt.Color(255, 255, 255));
        lblDataJam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDataJam.setText("Minggu, 04 Agustus 2020 | 08:30:45");

        javax.swing.GroupLayout pnlDataJamLayout = new javax.swing.GroupLayout(pnlDataJam);
        pnlDataJam.setLayout(pnlDataJamLayout);
        pnlDataJamLayout.setHorizontalGroup(
            pnlDataJamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataJamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDataTop, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(lblDataJam, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDataJamLayout.setVerticalGroup(
            pnlDataJamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataTop, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(lblDataJam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDataUser.setBackground(new java.awt.Color(255, 255, 255));
        pnlDataUser.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        pnlDataUserIcon.setBackground(new java.awt.Color(226, 72, 72));

        lblDataUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_user_60px.png"))); // NOI18N

        javax.swing.GroupLayout pnlDataUserIconLayout = new javax.swing.GroupLayout(pnlDataUserIcon);
        pnlDataUserIcon.setLayout(pnlDataUserIconLayout);
        pnlDataUserIconLayout.setHorizontalGroup(
            pnlDataUserIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataUserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlDataUserIconLayout.setVerticalGroup(
            pnlDataUserIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataUserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        lblDataUser.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDataUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDataUser.setText("Total Keseluruhan User");
        lblDataUser.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        valDataUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valDataUser.setText("1,446 User");
        valDataUser.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDataUserLayout = new javax.swing.GroupLayout(pnlDataUser);
        pnlDataUser.setLayout(pnlDataUserLayout);
        pnlDataUserLayout.setHorizontalGroup(
            pnlDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataUserLayout.createSequentialGroup()
                .addComponent(pnlDataUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataUser, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(valDataUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDataUserLayout.setVerticalGroup(
            pnlDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataUserLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDataUserLayout.createSequentialGroup()
                        .addComponent(lblDataUser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valDataUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlDataPetugas.setBackground(new java.awt.Color(255, 255, 255));
        pnlDataPetugas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        pnlDataPetugasIcon.setBackground(new java.awt.Color(57, 146, 228));

        lblDataPetugasIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataPetugasIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_school_director_60px.png"))); // NOI18N

        javax.swing.GroupLayout pnlDataPetugasIconLayout = new javax.swing.GroupLayout(pnlDataPetugasIcon);
        pnlDataPetugasIcon.setLayout(pnlDataPetugasIconLayout);
        pnlDataPetugasIconLayout.setHorizontalGroup(
            pnlDataPetugasIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataPetugasIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlDataPetugasIconLayout.setVerticalGroup(
            pnlDataPetugasIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataPetugasIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        lblDataPetugas.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDataPetugas.setText("Total Keseluruhan Petugas");
        lblDataPetugas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        valDataPetugas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valDataPetugas.setText("7 Petugas");
        valDataPetugas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDataPetugasLayout = new javax.swing.GroupLayout(pnlDataPetugas);
        pnlDataPetugas.setLayout(pnlDataPetugasLayout);
        pnlDataPetugasLayout.setHorizontalGroup(
            pnlDataPetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataPetugasLayout.createSequentialGroup()
                .addComponent(pnlDataPetugasIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataPetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valDataPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDataPetugasLayout.setVerticalGroup(
            pnlDataPetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataPetugasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDataPetugasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataPetugasIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDataPetugasLayout.createSequentialGroup()
                        .addComponent(lblDataPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valDataPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlDataKelas.setBackground(new java.awt.Color(255, 255, 255));
        pnlDataKelas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        pnlDataKelasIcon.setBackground(new java.awt.Color(215, 159, 43));

        lblDataKelasIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataKelasIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_class_60px.png"))); // NOI18N

        javax.swing.GroupLayout pnlDataKelasIconLayout = new javax.swing.GroupLayout(pnlDataKelasIcon);
        pnlDataKelasIcon.setLayout(pnlDataKelasIconLayout);
        pnlDataKelasIconLayout.setHorizontalGroup(
            pnlDataKelasIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataKelasIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlDataKelasIconLayout.setVerticalGroup(
            pnlDataKelasIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataKelasIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        lblDataKelas.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDataKelas.setText("Total Kelas");
        lblDataKelas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        valDataKelas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valDataKelas.setText("40 Kelas");
        valDataKelas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDataKelasLayout = new javax.swing.GroupLayout(pnlDataKelas);
        pnlDataKelas.setLayout(pnlDataKelasLayout);
        pnlDataKelasLayout.setHorizontalGroup(
            pnlDataKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataKelasLayout.createSequentialGroup()
                .addComponent(pnlDataKelasIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataKelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valDataKelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDataKelasLayout.setVerticalGroup(
            pnlDataKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataKelasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDataKelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataKelasIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDataKelasLayout.createSequentialGroup()
                        .addComponent(lblDataKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valDataKelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlDataAdmin.setBackground(new java.awt.Color(255, 255, 255));
        pnlDataAdmin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        pnlDataAdminIcon.setBackground(new java.awt.Color(17, 229, 17));

        lblDataAdminIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataAdminIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_administrative_tools_60px.png"))); // NOI18N

        javax.swing.GroupLayout pnlDataAdminIconLayout = new javax.swing.GroupLayout(pnlDataAdminIcon);
        pnlDataAdminIcon.setLayout(pnlDataAdminIconLayout);
        pnlDataAdminIconLayout.setHorizontalGroup(
            pnlDataAdminIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataAdminIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlDataAdminIconLayout.setVerticalGroup(
            pnlDataAdminIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataAdminIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        lblDataAdmin.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDataAdmin.setText("Total Keseluruhan Admin");
        lblDataAdmin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        valDataAdmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valDataAdmin.setText("5 Admin");
        valDataAdmin.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDataAdminLayout = new javax.swing.GroupLayout(pnlDataAdmin);
        pnlDataAdmin.setLayout(pnlDataAdminLayout);
        pnlDataAdminLayout.setHorizontalGroup(
            pnlDataAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataAdminLayout.createSequentialGroup()
                .addComponent(pnlDataAdminIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(valDataAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDataAdminLayout.setVerticalGroup(
            pnlDataAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataAdminLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDataAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataAdminIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDataAdminLayout.createSequentialGroup()
                        .addComponent(lblDataAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valDataAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlDataSiswa.setBackground(new java.awt.Color(255, 255, 255));
        pnlDataSiswa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        pnlDataSiswaIcon.setBackground(new java.awt.Color(217, 67, 207));

        lblDataSiswaIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataSiswaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_student_male_60px.png"))); // NOI18N

        javax.swing.GroupLayout pnlDataSiswaIconLayout = new javax.swing.GroupLayout(pnlDataSiswaIcon);
        pnlDataSiswaIcon.setLayout(pnlDataSiswaIconLayout);
        pnlDataSiswaIconLayout.setHorizontalGroup(
            pnlDataSiswaIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataSiswaIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlDataSiswaIconLayout.setVerticalGroup(
            pnlDataSiswaIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataSiswaIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        lblDataSiswa.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDataSiswa.setText("Total Keseluruhan Siswa");
        lblDataSiswa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        valDataSiswa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valDataSiswa.setText("1.430 Siswa");
        valDataSiswa.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDataSiswaLayout = new javax.swing.GroupLayout(pnlDataSiswa);
        pnlDataSiswa.setLayout(pnlDataSiswaLayout);
        pnlDataSiswaLayout.setHorizontalGroup(
            pnlDataSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataSiswaLayout.createSequentialGroup()
                .addComponent(pnlDataSiswaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valDataSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDataSiswaLayout.setVerticalGroup(
            pnlDataSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataSiswaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDataSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataSiswaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDataSiswaLayout.createSequentialGroup()
                        .addComponent(lblDataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valDataSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlDataSpp.setBackground(new java.awt.Color(255, 255, 255));
        pnlDataSpp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        pnlDataSppIcon.setBackground(new java.awt.Color(55, 61, 64));

        lblDataSppIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataSppIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_card_payment_60px.png"))); // NOI18N

        javax.swing.GroupLayout pnlDataSppIconLayout = new javax.swing.GroupLayout(pnlDataSppIcon);
        pnlDataSppIcon.setLayout(pnlDataSppIconLayout);
        pnlDataSppIconLayout.setHorizontalGroup(
            pnlDataSppIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataSppIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlDataSppIconLayout.setVerticalGroup(
            pnlDataSppIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataSppIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        lblDataSpp.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDataSpp.setText("Total SPP Yang Dibayar");
        lblDataSpp.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        valDataSpp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valDataSpp.setText("Rp. 390.340.000");
        valDataSpp.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDataSppLayout = new javax.swing.GroupLayout(pnlDataSpp);
        pnlDataSpp.setLayout(pnlDataSppLayout);
        pnlDataSppLayout.setHorizontalGroup(
            pnlDataSppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataSppLayout.createSequentialGroup()
                .addComponent(pnlDataSppIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataSppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataSpp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valDataSpp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDataSppLayout.setVerticalGroup(
            pnlDataSppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataSppLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDataSppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataSppIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDataSppLayout.createSequentialGroup()
                        .addComponent(lblDataSpp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valDataSpp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDataJam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDataPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDataKelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDataAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDataSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDataSpp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDataLayout.createSequentialGroup()
                                .addComponent(pnlDataJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlDataUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlDataAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDataPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlDataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDataKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDataSpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pnlMain.add(pnlData, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 910, 420));

        lblDashboard.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/icons8_speedometer_35px_1.png"))); // NOI18N
        lblDashboard.setText("Dashboard");
        lblDashboard.setIconTextGap(6);
        pnlMain.add(lblDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 64, 400, -1));

        pnlBottom.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Copyright © 2021. Achmad Baihaqi. All Rights Reserved.");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMain.add(pnlBottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 990, 40));

        lblBgImage.setBackground(new java.awt.Color(41, 52, 71));
        pnlMain.add(lblBgImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed

    }//GEN-LAST:event_btnDashboardActionPerformed

    private void lblPhotoProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoProfileMouseClicked

    }//GEN-LAST:event_lblPhotoProfileMouseClicked

    private void lblEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditProfileMouseClicked

    }//GEN-LAST:event_lblEditProfileMouseClicked

    private void lblEditProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditProfileMouseEntered
        this.lblEditProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.lblEditProfile.setText("<html><p style=\"text-decoration:underline;\">Informasi Akun</p></html>");
    }//GEN-LAST:event_lblEditProfileMouseEntered

    private void lblEditProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditProfileMouseExited
        this.lblEditProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.lblEditProfile.setText("<html><p style=\"text-decoration:none;\">Informasi Akun</p></html>");
    }//GEN-LAST:event_lblEditProfileMouseExited

    private void btnInfoAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoAkunActionPerformed

    }//GEN-LAST:event_btnInfoAkunActionPerformed

    private void btnDataPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPetugasActionPerformed

    }//GEN-LAST:event_btnDataPetugasActionPerformed

    private void btnDataSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataSiswaActionPerformed

    }//GEN-LAST:event_btnDataSiswaActionPerformed

    private void btnDataKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKelasActionPerformed

    }//GEN-LAST:event_btnDataKelasActionPerformed

    private void btnPembayaranSppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembayaranSppActionPerformed

    }//GEN-LAST:event_btnPembayaranSppActionPerformed

    private void btnDataSppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataSppActionPerformed

    }//GEN-LAST:event_btnDataSppActionPerformed

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed

    }//GEN-LAST:event_btnLaporanActionPerformed

    private void btnTentangAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTentangAppActionPerformed

    }//GEN-LAST:event_btnTentangAppActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DashboardTestDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardTestDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardTestDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardTestDup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DashboardTestDup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDataKelas;
    private javax.swing.JButton btnDataPetugas;
    private javax.swing.JButton btnDataSiswa;
    private javax.swing.JButton btnDataSpp;
    private javax.swing.JButton btnInfoAkun;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnPembayaranSpp;
    private javax.swing.JButton btnTentangApp;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel lblBgImage;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblDataAdmin;
    private javax.swing.JLabel lblDataAdminIcon;
    private javax.swing.JLabel lblDataJam;
    private javax.swing.JLabel lblDataKelas;
    private javax.swing.JLabel lblDataKelasIcon;
    private javax.swing.JLabel lblDataPetugas;
    private javax.swing.JLabel lblDataPetugasIcon;
    private javax.swing.JLabel lblDataSiswa;
    private javax.swing.JLabel lblDataSiswaIcon;
    private javax.swing.JLabel lblDataSpp;
    private javax.swing.JLabel lblDataSppIcon;
    private javax.swing.JLabel lblDataTop;
    private javax.swing.JLabel lblDataUser;
    private javax.swing.JLabel lblDataUserIcon;
    private javax.swing.JLabel lblEditProfile;
    private javax.swing.JLabel lblMinimaze;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JLabel lblPhotoProfile;
    private javax.swing.JLabel lblSekolah;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlDataAdmin;
    private javax.swing.JPanel pnlDataAdminIcon;
    private javax.swing.JPanel pnlDataJam;
    private javax.swing.JPanel pnlDataKelas;
    private javax.swing.JPanel pnlDataKelasIcon;
    private javax.swing.JPanel pnlDataPetugas;
    private javax.swing.JPanel pnlDataPetugasIcon;
    private javax.swing.JPanel pnlDataSiswa;
    private javax.swing.JPanel pnlDataSiswaIcon;
    private javax.swing.JPanel pnlDataSpp;
    private javax.swing.JPanel pnlDataSppIcon;
    private javax.swing.JPanel pnlDataUser;
    private javax.swing.JPanel pnlDataUserIcon;
    private javax.swing.JPanel pnlLeftBottom;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel valDataAdmin;
    private javax.swing.JLabel valDataKelas;
    private javax.swing.JLabel valDataPetugas;
    private javax.swing.JLabel valDataSiswa;
    private javax.swing.JLabel valDataSpp;
    private javax.swing.JLabel valDataUser;
    // End of variables declaration//GEN-END:variables
}
