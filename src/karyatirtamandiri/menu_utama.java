package karyatirtamandiri;

import Koneksi.koneksi;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;

public class menu_utama extends javax.swing.JFrame {
    
    String id_user="", role="", nama_user="";
    String menuAktif="";
    koneksi k= new koneksi();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(menu_utama.class.getName());
    
    public menu_utama() {
        initComponents();
        k.connect();
    }
    
    private void hakAkses() {
        boolean owner = "owner".equalsIgnoreCase(role);
        boolean admin = "admin".equalsIgnoreCase(role);
        boolean kasir = "kasir".equalsIgnoreCase(role);
        
        System.out.println("Role aktif: [" + role + "]");
        
        dashboard.setVisible(true);
        pelanggan.setVisible(owner || admin || kasir);
        pemesanan.setVisible(owner || admin || kasir);
        logout.setVisible(true);

        
        karyawan.setVisible(owner || admin);
        pengemudi.setVisible(owner || admin);
        barang.setVisible(owner || admin);
        kendaraan.setVisible(owner || admin);
        pemesanan2.setVisible(owner || admin);
        
        laporanpemesanan.setVisible(owner);
        suratjalan.setVisible(owner);
        hakakses.setVisible(owner);
        dokumen1.setVisible(owner);
        pengaturan1.setVisible(owner);

        System.out.println("Karyawan terlihat: " + karyawan.isVisible());
        System.out.println("Barang terlihat: " + barang.isVisible());
        System.out.println("Riwayat terlihat: " + pemesanan2.isVisible());

        menubar.revalidate();
        menubar.repaint();
    }
    
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    
    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
        label_namauser.setText(nama_user);
    }

    public void setRole(String role) {
        this.role = role == null
            ? ""
            : role.trim().toLowerCase();

        hakAkses();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_dasar = new javax.swing.JPanel();
        pn_kiri = new javax.swing.JPanel();
        menubar = new asset.PanelShadow();
        masterdata = new javax.swing.JLabel();
        dashboard = new asset.PanelShadow();
        dashboard1 = new javax.swing.JLabel();
        karyawan = new asset.PanelShadow();
        karyawan1 = new javax.swing.JLabel();
        pengemudi = new asset.PanelShadow();
        pengemudi1 = new javax.swing.JLabel();
        kendaraan = new asset.PanelShadow();
        kendaraan1 = new javax.swing.JLabel();
        transaksi = new javax.swing.JLabel();
        pemesanan = new asset.PanelShadow();
        pemesanan1 = new javax.swing.JLabel();
        logout = new asset.PanelShadow();
        logout1 = new javax.swing.JLabel();
        barang = new asset.PanelShadow();
        barang1 = new javax.swing.JLabel();
        pelanggan = new asset.PanelShadow();
        pelanggan1 = new javax.swing.JLabel();
        pemesanan2 = new asset.PanelShadow();
        pemesanan3 = new javax.swing.JLabel();
        laporanpemesanan = new asset.PanelShadow();
        laporanpemesanan1 = new javax.swing.JLabel();
        dokumen1 = new javax.swing.JLabel();
        suratjalan = new asset.PanelShadow();
        suratjalan1 = new javax.swing.JLabel();
        pengaturan1 = new javax.swing.JLabel();
        hakakses = new asset.PanelShadow();
        hakakses1 = new javax.swing.JLabel();
        pn_header = new javax.swing.JPanel();
        masterdata1 = new javax.swing.JLabel();
        username = new asset.PanelShadow();
        label_namauser = new javax.swing.JLabel();
        pn_menuheader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        pn_kanan = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        pn_dasar.setBackground(new java.awt.Color(255, 255, 255));

        pn_kiri.setBackground(new java.awt.Color(255, 255, 255));

        menubar.setBackground(new java.awt.Color(9, 146, 194));
        menubar.setShadowSize(3);

        masterdata.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        masterdata.setForeground(new java.awt.Color(255, 255, 255));
        masterdata.setText("Master Data");

        dashboard.setBackground(new java.awt.Color(255, 255, 255));

        dashboard1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        dashboard1.setForeground(new java.awt.Color(9, 146, 194));
        dashboard1.setText("Dashboard");
        dashboard1.setEnabled(false);
        dashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(dashboard1)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(dashboard1)
                .addGap(14, 14, 14))
        );

        karyawan.setBackground(new java.awt.Color(255, 255, 255));

        karyawan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        karyawan1.setForeground(new java.awt.Color(9, 146, 194));
        karyawan1.setText("Karyawan");
        karyawan1.setEnabled(false);
        karyawan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                karyawan1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout karyawanLayout = new javax.swing.GroupLayout(karyawan);
        karyawan.setLayout(karyawanLayout);
        karyawanLayout.setHorizontalGroup(
            karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(karyawanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(karyawan1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        karyawanLayout.setVerticalGroup(
            karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, karyawanLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(karyawan1)
                .addGap(14, 14, 14))
        );

        pengemudi.setBackground(new java.awt.Color(255, 255, 255));
        pengemudi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengemudiMouseClicked(evt);
            }
        });
        pengemudi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pengemudiKeyPressed(evt);
            }
        });

        pengemudi1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        pengemudi1.setForeground(new java.awt.Color(9, 146, 194));
        pengemudi1.setText("Pengemudi");
        pengemudi1.setEnabled(false);
        pengemudi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengemudi1MouseClicked(evt);
            }
        });
        pengemudi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pengemudi1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pengemudiLayout = new javax.swing.GroupLayout(pengemudi);
        pengemudi.setLayout(pengemudiLayout);
        pengemudiLayout.setHorizontalGroup(
            pengemudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengemudiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pengemudi1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        pengemudiLayout.setVerticalGroup(
            pengemudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pengemudiLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pengemudi1)
                .addGap(14, 14, 14))
        );

        kendaraan.setBackground(new java.awt.Color(255, 255, 255));

        kendaraan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        kendaraan1.setForeground(new java.awt.Color(9, 146, 194));
        kendaraan1.setText("Kendaraan");
        kendaraan1.setEnabled(false);
        kendaraan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kendaraan1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kendaraanLayout = new javax.swing.GroupLayout(kendaraan);
        kendaraan.setLayout(kendaraanLayout);
        kendaraanLayout.setHorizontalGroup(
            kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kendaraan1)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        kendaraanLayout.setVerticalGroup(
            kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kendaraanLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(kendaraan1)
                .addGap(14, 14, 14))
        );

        transaksi.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        transaksi.setForeground(new java.awt.Color(255, 255, 255));
        transaksi.setText("Transaksi");

        pemesanan.setBackground(new java.awt.Color(255, 255, 255));

        pemesanan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        pemesanan1.setForeground(new java.awt.Color(9, 146, 194));
        pemesanan1.setText("Pemesanan");
        pemesanan1.setEnabled(false);
        pemesanan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pemesanan1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pemesananLayout = new javax.swing.GroupLayout(pemesanan);
        pemesanan.setLayout(pemesananLayout);
        pemesananLayout.setHorizontalGroup(
            pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pemesananLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pemesanan1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pemesananLayout.setVerticalGroup(
            pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pemesananLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pemesanan1)
                .addGap(14, 14, 14))
        );

        logout.setBackground(new java.awt.Color(255, 255, 255));

        logout1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        logout1.setForeground(new java.awt.Color(9, 146, 194));
        logout1.setText("Logout");
        logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(logout1)
                .addGap(14, 14, 14))
        );

        barang.setBackground(new java.awt.Color(255, 255, 255));

        barang1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        barang1.setForeground(new java.awt.Color(9, 146, 194));
        barang1.setText("Barang");
        barang1.setEnabled(false);
        barang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barang1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout barangLayout = new javax.swing.GroupLayout(barang);
        barang.setLayout(barangLayout);
        barangLayout.setHorizontalGroup(
            barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(barang1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        barangLayout.setVerticalGroup(
            barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barangLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(barang1)
                .addGap(14, 14, 14))
        );

        pelanggan.setBackground(new java.awt.Color(255, 255, 255));

        pelanggan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        pelanggan1.setForeground(new java.awt.Color(9, 146, 194));
        pelanggan1.setText("Pelanggan");
        pelanggan1.setEnabled(false);
        pelanggan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelanggan1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pelangganLayout = new javax.swing.GroupLayout(pelanggan);
        pelanggan.setLayout(pelangganLayout);
        pelangganLayout.setHorizontalGroup(
            pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pelangganLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pelanggan1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pelangganLayout.setVerticalGroup(
            pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pelangganLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pelanggan1)
                .addGap(14, 14, 14))
        );

        pemesanan2.setBackground(new java.awt.Color(255, 255, 255));

        pemesanan3.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        pemesanan3.setForeground(new java.awt.Color(9, 146, 194));
        pemesanan3.setText("Riwayat Pemesanan");
        pemesanan3.setEnabled(false);
        pemesanan3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pemesanan3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pemesanan2Layout = new javax.swing.GroupLayout(pemesanan2);
        pemesanan2.setLayout(pemesanan2Layout);
        pemesanan2Layout.setHorizontalGroup(
            pemesanan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pemesanan2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pemesanan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pemesanan2Layout.setVerticalGroup(
            pemesanan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pemesanan2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pemesanan3)
                .addGap(14, 14, 14))
        );

        laporanpemesanan.setBackground(new java.awt.Color(255, 255, 255));

        laporanpemesanan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        laporanpemesanan1.setForeground(new java.awt.Color(9, 146, 194));
        laporanpemesanan1.setText("Laporan Pemesanan");
        laporanpemesanan1.setEnabled(false);
        laporanpemesanan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanpemesanan1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout laporanpemesananLayout = new javax.swing.GroupLayout(laporanpemesanan);
        laporanpemesanan.setLayout(laporanpemesananLayout);
        laporanpemesananLayout.setHorizontalGroup(
            laporanpemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanpemesananLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(laporanpemesanan1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        laporanpemesananLayout.setVerticalGroup(
            laporanpemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanpemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(laporanpemesanan1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        dokumen1.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        dokumen1.setForeground(new java.awt.Color(255, 255, 255));
        dokumen1.setText("Dokumen");

        suratjalan.setBackground(new java.awt.Color(255, 255, 255));

        suratjalan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        suratjalan1.setForeground(new java.awt.Color(9, 146, 194));
        suratjalan1.setText("Dokumentasi & Surat Jalan");
        suratjalan1.setEnabled(false);
        suratjalan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suratjalan1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout suratjalanLayout = new javax.swing.GroupLayout(suratjalan);
        suratjalan.setLayout(suratjalanLayout);
        suratjalanLayout.setHorizontalGroup(
            suratjalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suratjalanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suratjalan1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        suratjalanLayout.setVerticalGroup(
            suratjalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suratjalanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suratjalan1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        pengaturan1.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        pengaturan1.setForeground(new java.awt.Color(255, 255, 255));
        pengaturan1.setText("Pengaturan");

        hakakses.setBackground(new java.awt.Color(255, 255, 255));

        hakakses1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        hakakses1.setForeground(new java.awt.Color(9, 146, 194));
        hakakses1.setText("Pengaturan Hak Akses");
        hakakses1.setEnabled(false);
        hakakses1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hakakses1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hakaksesLayout = new javax.swing.GroupLayout(hakakses);
        hakakses.setLayout(hakaksesLayout);
        hakaksesLayout.setHorizontalGroup(
            hakaksesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hakaksesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(hakakses1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hakaksesLayout.setVerticalGroup(
            hakaksesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hakaksesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hakakses1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout menubarLayout = new javax.swing.GroupLayout(menubar);
        menubar.setLayout(menubarLayout);
        menubarLayout.setHorizontalGroup(
            menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menubarLayout.createSequentialGroup()
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menubarLayout.createSequentialGroup()
                        .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(menubarLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(masterdata))
                                .addGroup(menubarLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(menubarLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(karyawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(menubarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menubarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suratjalan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pemesanan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laporanpemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(menubarLayout.createSequentialGroup()
                                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(pelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(barang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(kendaraan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(transaksi, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(dokumen1)
                                    .addComponent(pengaturan1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(hakakses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        menubarLayout.setVerticalGroup(
            menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menubarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterdata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pemesanan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laporanpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dokumen1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suratjalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengaturan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hakakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_kiriLayout = new javax.swing.GroupLayout(pn_kiri);
        pn_kiri.setLayout(pn_kiriLayout);
        pn_kiriLayout.setHorizontalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(menubar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pn_kiriLayout.setVerticalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menubar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_header.setBackground(new java.awt.Color(9, 146, 194));

        masterdata1.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        masterdata1.setForeground(new java.awt.Color(255, 255, 255));
        masterdata1.setText("Karya Tirta Mandiri");

        username.setBackground(new java.awt.Color(10, 128, 169));
        username.setShadowSize(3);

        label_namauser.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        label_namauser.setForeground(new java.awt.Color(255, 255, 255));
        label_namauser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout usernameLayout = new javax.swing.GroupLayout(username);
        username.setLayout(usernameLayout);
        usernameLayout.setHorizontalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(label_namauser, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        usernameLayout.setVerticalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_namauser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_headerLayout = new javax.swing.GroupLayout(pn_header);
        pn_header.setLayout(pn_headerLayout);
        pn_headerLayout.setHorizontalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_headerLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(masterdata1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_headerLayout.setVerticalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(masterdata1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        pn_menuheader.setBackground(new java.awt.Color(255, 255, 255));

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("X");
        btnExit.addActionListener(this::btnExitActionPerformed);

        javax.swing.GroupLayout pn_menuheaderLayout = new javax.swing.GroupLayout(pn_menuheader);
        pn_menuheader.setLayout(pn_menuheaderLayout);
        pn_menuheaderLayout.setHorizontalGroup(
            pn_menuheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_menuheaderLayout.createSequentialGroup()
                .addGap(0, 1238, Short.MAX_VALUE)
                .addComponent(btnExit))
        );
        pn_menuheaderLayout.setVerticalGroup(
            pn_menuheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit)
        );

        pn_kanan.setBackground(new java.awt.Color(255, 255, 255));
        pn_kanan.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_kiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_kanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pn_header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_menuheader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_menuheader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_kanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addComponent(pn_kiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_dasar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_dasar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pengemudi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pengemudi1KeyPressed
//        menu_pengemudi pengemudi = new pengemudi();
        
    }//GEN-LAST:event_pengemudi1KeyPressed

    private void pengemudiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pengemudiKeyPressed
       
    }//GEN-LAST:event_pengemudiKeyPressed

    private void pengemudi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengemudi1MouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke menu Pengemudi."
            );
            return;
        }
        
        pn_kanan.removeAll();

        menu_pengemudi form = new menu_pengemudi();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pengemudi1MouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void dashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard1MouseClicked
        
    }//GEN-LAST:event_dashboard1MouseClicked

    private void karyawan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawan1MouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke menu Karyawan."
            );
            return;
        }
        
        pn_kanan.removeAll();
        
        menu_karyawan form = new menu_karyawan();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);
        
        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_karyawan1MouseClicked

    private void kendaraan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kendaraan1MouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke menu Kendaraan."
            );
            return;
        }

        pn_kanan.removeAll();

        menu_kendaraan form = new menu_kendaraan();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_kendaraan1MouseClicked

    private void pengemudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengemudiMouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke menu Pengemudi."
            );
            return;
        }

        pn_kanan.removeAll();

        menu_pengemudi form = new menu_pengemudi();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pengemudiMouseClicked

    private void logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseClicked
        login l = new login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logout1MouseClicked

    private void barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barang1MouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke menu Barang."
            );
            return;
        }
        
        pn_kanan.removeAll();

        menu_barang form = new menu_barang();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);
        
        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_barang1MouseClicked

    private void pemesanan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemesanan1MouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)
                && !"kasir".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke menu Pemesanan."
            );
            return;
        }

        pn_kanan.removeAll();

        menu_pemesanan form = new menu_pemesanan();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pemesanan1MouseClicked

    private void pelanggan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelanggan1MouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)
                && !"kasir".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke menu Pelanggan."
            );
            return;
        }

        pn_kanan.removeAll();

        menu_pelanggan form = new menu_pelanggan();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pelanggan1MouseClicked

    private void pemesanan3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemesanan3MouseClicked
        if (!"owner".equalsIgnoreCase(role)
                && !"admin".equalsIgnoreCase(role)) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Anda tidak memiliki hak akses ke Riwayat Pemesanan."
            );
            return;
        }

        pn_kanan.removeAll();

        riwayat_pemesanan form = new riwayat_pemesanan();
        javax.swing.JScrollPane scroll =
                new javax.swing.JScrollPane(form);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pemesanan3MouseClicked

    private void laporanpemesanan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanpemesanan1MouseClicked
        pn_kanan.removeAll();

        menu_laporanpemesanan form =
                new menu_laporanpemesanan();

        form.setSize(pn_kanan.getSize());
        form.setVisible(true);

        pn_kanan.add(form);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_laporanpemesanan1MouseClicked

    private void suratjalan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suratjalan1MouseClicked
        pn_kanan.removeAll();

        menu_suratjalan form = new menu_suratjalan();

        form.setSize(pn_kanan.getSize());
        form.setVisible(true);

        pn_kanan.add(form);
        pn_kanan.revalidate();
        pn_kanan.repaint();

    }//GEN-LAST:event_suratjalan1MouseClicked

    private void hakakses1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hakakses1MouseClicked
        pn_kanan.removeAll();

        menu_hakakses form = new menu_hakakses();

        form.setSize(pn_kanan.getSize());
        form.setVisible(true);

        pn_kanan.add(form);
        pn_kanan.revalidate();
        pn_kanan.repaint();

    }//GEN-LAST:event_hakakses1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new menu_utama().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private asset.PanelShadow barang;
    private javax.swing.JLabel barang1;
    private javax.swing.JButton btnExit;
    private asset.PanelShadow dashboard;
    private javax.swing.JLabel dashboard1;
    private javax.swing.JLabel dokumen1;
    private asset.PanelShadow hakakses;
    private javax.swing.JLabel hakakses1;
    private asset.PanelShadow karyawan;
    private javax.swing.JLabel karyawan1;
    private asset.PanelShadow kendaraan;
    private javax.swing.JLabel kendaraan1;
    private javax.swing.JLabel label_namauser;
    private asset.PanelShadow laporanpemesanan;
    private javax.swing.JLabel laporanpemesanan1;
    private asset.PanelShadow logout;
    private javax.swing.JLabel logout1;
    private javax.swing.JLabel masterdata;
    private javax.swing.JLabel masterdata1;
    private asset.PanelShadow menubar;
    private asset.PanelShadow pelanggan;
    private javax.swing.JLabel pelanggan1;
    private asset.PanelShadow pemesanan;
    private javax.swing.JLabel pemesanan1;
    private asset.PanelShadow pemesanan2;
    private javax.swing.JLabel pemesanan3;
    private asset.PanelShadow pemesanan4;
    private javax.swing.JLabel pengaturan1;
    private asset.PanelShadow pengemudi;
    private javax.swing.JLabel pengemudi1;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_header;
    private javax.swing.JPanel pn_kanan;
    private javax.swing.JPanel pn_kiri;
    private javax.swing.JPanel pn_menuheader;
    private asset.PanelShadow suratjalan;
    private javax.swing.JLabel suratjalan1;
    private javax.swing.JLabel transaksi;
    private asset.PanelShadow username;
    // End of variables declaration//GEN-END:variables
}
