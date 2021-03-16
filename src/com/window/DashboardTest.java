package com.window;

import com.database.Account;
import com.database.Database;
import com.database.Transaksi;
import com.media.Gambar;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Infinite World
 * @since 2021-03-20
 */
public class DashboardTest extends javax.swing.JFrame {

    private final Database dbase = new Database();
    private final Account acc = new Account();
    private final Transaksi tr = new Transaksi();
    
    private int user, admin, petugas, siswa, kelas, spp, nis;
    private String foto = "null", name = "Achmad Baihaqi", sekolah = "SMK Negeri 1 Kertosono | Aplikasi Pembayaran SPP";
    private int x, y;
    
    public DashboardTest() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setIconImage(Gambar.getWindowIcon());
        this.btnDashboard.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnInfoAkun.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataPetugas.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataSiswa.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataKelas.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnDataSpp.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnPembayaranSpp.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnLaporan.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnTentangApp.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnMinimaze.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.btnClose.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        this.lblSekolah.setIcon(Gambar.scaleImage(new java.io.File("src\\resources\\image\\icons\\logo-smkn1kts-circle.png"), 35, 35));
        this.lblSekolahBottom.setIcon(Gambar.scaleImage(new java.io.File("src\\resources\\image\\icons\\logo-smkn1kts.png"), 30, 37));       

        JButton[] btns = new JButton[]{
            this.btnInfoAkun, this.btnDataPetugas, this.btnDataSiswa, this.btnDataKelas, 
            this.btnDataSpp, this.btnPembayaranSpp, this.btnLaporan, this.btnTentangApp
        };
        
        for(JButton btn : btns){
            btn.addMouseListener(new java.awt.event.MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(13,88,149));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(22,24,24));
                }
            });
        }
        
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
        lblTipeAkun = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnMinimaze = new javax.swing.JButton();
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
        lblCopyright = new javax.swing.JLabel();
        lblSekolahBottom = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        lblNamaAplikasiBottom = new javax.swing.JLabel();
        lblNamaSekolahBottom = new javax.swing.JLabel();
        lblBgImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
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

        sidePanel.setBackground(new java.awt.Color(22, 24, 24));
        sidePanel.setMaximumSize(new java.awt.Dimension(218, 555));

        btnDashboard.setBackground(new java.awt.Color(85, 101, 114));
        btnDashboard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-home.png"))); // NOI18N
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashboard.setIconTextGap(6);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        pnlAccount.setBackground(new java.awt.Color(43, 61, 93));
        pnlAccount.setMaximumSize(new java.awt.Dimension(194, 82));

        lblPhotoProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhotoProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-profile.png"))); // NOI18N
        lblPhotoProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPhotoProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhotoProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPhotoProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPhotoProfileMouseExited(evt);
            }
        });

        lblNamaUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNamaUser.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaUser.setText("Achmad Baihaqi");
        lblNamaUser.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblNamaUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNamaUser.setInheritsPopupMenu(false);
        lblNamaUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNamaUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNamaUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNamaUserMouseExited(evt);
            }
        });

        lblTipeAkun.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblTipeAkun.setForeground(new java.awt.Color(255, 255, 255));
        lblTipeAkun.setText("Admin User");
        lblTipeAkun.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblTipeAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTipeAkunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTipeAkunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTipeAkunMouseExited(evt);
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
                    .addComponent(lblTipeAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(lblTipeAkun)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnInfoAkun.setBackground(new java.awt.Color(22, 24, 24));
        btnInfoAkun.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInfoAkun.setForeground(new java.awt.Color(255, 255, 255));
        btnInfoAkun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-akun.png"))); // NOI18N
        btnInfoAkun.setText("Informasi Akun");
        btnInfoAkun.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnInfoAkun.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInfoAkun.setIconTextGap(6);
        btnInfoAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoAkunActionPerformed(evt);
            }
        });

        btnDataPetugas.setBackground(new java.awt.Color(22, 24, 24));
        btnDataPetugas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataPetugas.setForeground(new java.awt.Color(255, 255, 255));
        btnDataPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-admin.png"))); // NOI18N
        btnDataPetugas.setText("Data Petugas");
        btnDataPetugas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataPetugas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataPetugas.setIconTextGap(6);
        btnDataPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPetugasActionPerformed(evt);
            }
        });

        btnDataSiswa.setBackground(new java.awt.Color(22, 24, 24));
        btnDataSiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataSiswa.setForeground(new java.awt.Color(255, 255, 255));
        btnDataSiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-siswa.png"))); // NOI18N
        btnDataSiswa.setText("Data Siswa");
        btnDataSiswa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataSiswa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataSiswa.setIconTextGap(6);
        btnDataSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataSiswaActionPerformed(evt);
            }
        });

        btnDataKelas.setBackground(new java.awt.Color(22, 24, 24));
        btnDataKelas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDataKelas.setForeground(new java.awt.Color(255, 255, 255));
        btnDataKelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-kelas.png"))); // NOI18N
        btnDataKelas.setText("Data Kelas");
        btnDataKelas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataKelas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataKelas.setIconTextGap(6);
        btnDataKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKelasActionPerformed(evt);
            }
        });

        btnPembayaranSpp.setBackground(new java.awt.Color(22, 24, 24));
        btnPembayaranSpp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPembayaranSpp.setForeground(new java.awt.Color(255, 255, 255));
        btnPembayaranSpp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-pembayaran.png"))); // NOI18N
        btnPembayaranSpp.setText("Pembayaran SPP");
        btnPembayaranSpp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPembayaranSpp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPembayaranSpp.setIconTextGap(6);
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
        btnDataSpp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-spp.png"))); // NOI18N
        btnDataSpp.setText("Data SPP");
        btnDataSpp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDataSpp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataSpp.setIconTextGap(6);
        btnDataSpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataSppActionPerformed(evt);
            }
        });

        btnLaporan.setBackground(new java.awt.Color(22, 24, 24));
        btnLaporan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-laporan.png"))); // NOI18N
        btnLaporan.setText("Laporan");
        btnLaporan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLaporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLaporan.setIconTextGap(6);
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        btnTentangApp.setBackground(new java.awt.Color(22, 24, 24));
        btnTentangApp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTentangApp.setForeground(new java.awt.Color(255, 255, 255));
        btnTentangApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-window-sidemenu-petugas-tentangApp.png"))); // NOI18N
        btnTentangApp.setText("Tentang Aplikasi");
        btnTentangApp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTentangApp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTentangApp.setIconTextGap(6);
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
        lblSekolah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-nav-logosekolah.png"))); // NOI18N
        lblSekolah.setText("SMK Negeri 1 Kertosono | Aplikasi Pembayaran SPP");
        lblSekolah.setIconTextGap(10);
        lblSekolah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSekolahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSekolahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSekolahMouseExited(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(11, 114, 238));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setBackground(new java.awt.Color(11, 114, 238));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-app-close.png"))); // NOI18N
        btnClose.setText(" ");
        btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 1, 40, 48));

        btnMinimaze.setBackground(new java.awt.Color(11, 114, 238));
        btnMinimaze.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-app-minimaze.png"))); // NOI18N
        btnMinimaze.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMinimaze.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnMinimaze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimazeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimazeMouseExited(evt);
            }
        });
        btnMinimaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimazeActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinimaze, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 30, 48));

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSekolah, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMain.add(pnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 990, 50));

        pnlData.setBackground(new java.awt.Color(255, 255, 255));
        pnlData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 121, 173), 3));

        pnlDataJam.setBackground(new java.awt.Color(26, 121, 173));

        lblDataTop.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDataTop.setForeground(new java.awt.Color(255, 255, 255));
        lblDataTop.setText("Data Aplikasi Pembayaran SPP");

        lblDataJam.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDataJam.setForeground(new java.awt.Color(255, 255, 255));
        lblDataJam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDataJam.setText("Jumat, 19 Maret 2021 | 08:30:45");

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
        lblDataUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-data-user.png"))); // NOI18N

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
        lblDataPetugasIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-data-petugas.png"))); // NOI18N

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

        pnlDataKelasIcon.setBackground(new java.awt.Color(228, 133, 44));

        lblDataKelasIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataKelasIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-data-kelas.png"))); // NOI18N

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

        pnlDataAdminIcon.setBackground(new java.awt.Color(40, 178, 85));

        lblDataAdminIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataAdminIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-data-admin.png"))); // NOI18N

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
        lblDataSiswaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-data-siswa.png"))); // NOI18N

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
        lblDataSppIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-data-spp.png"))); // NOI18N

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

        lblDashboard.setFont(new java.awt.Font("Ebrima", 1, 21)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(22, 19, 19));
        lblDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-logo.png"))); // NOI18N
        lblDashboard.setText("Dashboard");
        lblDashboard.setIconTextGap(6);
        pnlMain.add(lblDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 64, 400, -1));

        pnlBottom.setBackground(new java.awt.Color(255, 255, 255));

        lblCopyright.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblCopyright.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCopyright.setText("Copyright © 2021. Achmad Baihaqi. All Rights Reserved.");
        lblCopyright.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblSekolahBottom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSekolahBottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/icons/ic-dashboard-logo-dark.png"))); // NOI18N
        lblSekolahBottom.setIconTextGap(8);

        lblVersion.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblVersion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVersion.setText("Version 1.0.0");

        lblNamaAplikasiBottom.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblNamaAplikasiBottom.setForeground(new java.awt.Color(16, 81, 200));
        lblNamaAplikasiBottom.setText("Aplikasi Pembayaran SPP");

        lblNamaSekolahBottom.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lblNamaSekolahBottom.setForeground(new java.awt.Color(231, 38, 38));
        lblNamaSekolahBottom.setText("SMK Negeri 1 Kertosono");

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblSekolahBottom)
                .addGap(18, 18, 18)
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNamaSekolahBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(lblNamaAplikasiBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(237, 237, 237)
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCopyright, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(lblVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSekolahBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlBottomLayout.createSequentialGroup()
                        .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBottomLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblVersion))
                            .addGroup(pnlBottomLayout.createSequentialGroup()
                                .addComponent(lblNamaSekolahBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCopyright)
                            .addGroup(pnlBottomLayout.createSequentialGroup()
                                .addComponent(lblNamaAplikasiBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))))
                .addGap(12, 12, 12))
        );

        pnlMain.add(pnlBottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 990, 50));

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
    // NO 12
    private void lblPhotoProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoProfileMouseClicked

    }//GEN-LAST:event_lblPhotoProfileMouseClicked
    @Deprecated
    private void lblTipeAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipeAkunMouseClicked

    }//GEN-LAST:event_lblTipeAkunMouseClicked
    @Deprecated
    private void lblTipeAkunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipeAkunMouseEntered

    }//GEN-LAST:event_lblTipeAkunMouseEntered
    @Deprecated
    private void lblTipeAkunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipeAkunMouseExited

    }//GEN-LAST:event_lblTipeAkunMouseExited
   
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
    // NO 2
    private void pnlMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_pnlMainMousePressed
    // NO 3
    private void pnlMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseDragged
        int xx = evt.getXOnScreen(),
            yy = evt.getYOnScreen();
        this.setLocation(xx-x, yy-y);
    }//GEN-LAST:event_pnlMainMouseDragged
    
    // NO 1
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed
    // NO 4
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    }//GEN-LAST:event_btnCloseActionPerformed
    // NO 5
    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        this.btnClose.setBackground(new Color(15,92,186));
        this.btnClose.setIcon(Gambar.getIcon("ic-app-close-entered.png"));
    }//GEN-LAST:event_btnCloseMouseEntered
    // NO 6
    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        this.btnClose.setBackground(new Color(11,114,238));
        this.btnClose.setIcon(Gambar.getIcon("ic-app-close.png"));
    }//GEN-LAST:event_btnCloseMouseExited
    // NO 7
    private void btnMinimazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimazeActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimazeActionPerformed
    // No 8
    private void btnMinimazeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimazeMouseEntered
        this.btnMinimaze.setBackground(new Color(15,92,186));
        this.btnMinimaze.setIcon(Gambar.getIcon("ic-app-minimaze-entered.png"));
    }//GEN-LAST:event_btnMinimazeMouseEntered
    private void btnMinimazeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimazeMouseExited
        this.btnMinimaze.setBackground(new Color(11,114,238));
        this.btnMinimaze.setIcon(Gambar.getIcon("ic-app-minimaze.png"));
    }//GEN-LAST:event_btnMinimazeMouseExited
    // NO 9
    private void lblNamaUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNamaUserMouseEntered
        this.lblNamaUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.lblNamaUser.setText("<html><p style=\"text-decoration:underline;\">"+name+"</p></html>");
    }//GEN-LAST:event_lblNamaUserMouseEntered
    // NO 10
    private void lblNamaUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNamaUserMouseExited
        this.lblNamaUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.lblNamaUser.setText("<html><p style=\"text-decoration:none;\">"+name+"</p></html>");
    }//GEN-LAST:event_lblNamaUserMouseExited
    // NO 11
    private void lblNamaUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNamaUserMouseClicked
        
    }//GEN-LAST:event_lblNamaUserMouseClicked
    // NO 13
    private void lblPhotoProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoProfileMouseEntered
        this.lblPhotoProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblPhotoProfileMouseEntered
    // NO 14
    private void lblPhotoProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoProfileMouseExited
        this.lblPhotoProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblPhotoProfileMouseExited

    @Deprecated
    private void lblSekolahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSekolahMouseEntered

    }//GEN-LAST:event_lblSekolahMouseEntered

    @Deprecated
    private void lblSekolahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSekolahMouseExited

    }//GEN-LAST:event_lblSekolahMouseExited

    @Deprecated
    private void lblSekolahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSekolahMouseClicked

    }//GEN-LAST:event_lblSekolahMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DashboardTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDataKelas;
    private javax.swing.JButton btnDataPetugas;
    private javax.swing.JButton btnDataSiswa;
    private javax.swing.JButton btnDataSpp;
    private javax.swing.JButton btnInfoAkun;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMinimaze;
    private javax.swing.JButton btnPembayaranSpp;
    private javax.swing.JButton btnTentangApp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBgImage;
    private javax.swing.JLabel lblCopyright;
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
    private javax.swing.JLabel lblNamaAplikasiBottom;
    private javax.swing.JLabel lblNamaSekolahBottom;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JLabel lblPhotoProfile;
    private javax.swing.JLabel lblSekolah;
    private javax.swing.JLabel lblSekolahBottom;
    private javax.swing.JLabel lblTipeAkun;
    private javax.swing.JLabel lblVersion;
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
