package karyatirtamandiri;

import Koneksi.koneksi;
import java.awt.Color;
import java.awt.Cursor;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class menu_utama extends javax.swing.JFrame {
    
    String id_user="", role="", nama_user="";   
    String menuAktif="";
    koneksi k= new koneksi();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(menu_utama.class.getName());
    public menu_utama() {
        initComponents();
        updateWaktu();
        k.connect();
    }
    
    public void setId_user(String id_user){
        this.id_user = id_user;
    }
    public void setNama_user(String nama_user){
        this.nama_user = nama_user;
        label_namauser.setText(""+nama_user);
    }
    public void setRole(String role){
        this.role = role;
        if(this.role.equals("owner")){
            dashboard1.setEnabled(true);
            karyawan1.setEnabled(true);
            pengemudi1.setEnabled(true);
            kendaraan1.setEnabled(true);
        }else if(this.role.equals("admin")){
            dashboard1.setEnabled(true);
            karyawan1.setEnabled(true);
            pengemudi1.setEnabled(true);
            kendaraan1.setEnabled(true);
        }
    }
    
    public void resetMenu(){
        dashboard1.setForeground(new Color(9,146,194));
        karyawan1.setForeground(new Color(9,146,194));
        pengemudi1.setForeground(new Color(9,146,194));
        barang1.setForeground(new Color(9,146,194));
        kendaraan1.setForeground(new Color(9,146,194));
        pelanggan1.setForeground(new Color(9,146,194));
        pemesanan1.setForeground(new Color(9,146,194));
        laporanpemesanan1.setForeground(new Color(9,146,194));
        suratjalan1.setForeground(new Color(9,146,194));
    }
    
    private void updateWaktu() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Timer timer = new Timer(1000, e -> {
            LocalDateTime waktu = LocalDateTime.now();
            waktuUpdate1.setText(waktu.format(format));
        });
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
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
        laporanpemesanan = new asset.PanelShadow();
        laporanpemesanan1 = new javax.swing.JLabel();
        transaksi1 = new javax.swing.JLabel();
        suratjalan = new asset.PanelShadow();
        suratjalan1 = new javax.swing.JLabel();
        pn_kanan = new javax.swing.JPanel();
        pn_header = new javax.swing.JPanel();
        masterdata1 = new javax.swing.JLabel();
        username = new asset.PanelShadow();
        label_namauser = new javax.swing.JLabel();
        waktuUpdate = new asset.PanelShadow();
        waktuUpdate1 = new javax.swing.JLabel();
        pn_menuheader = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        btnFS = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();

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
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardMouseEntered(evt);
            }
        });

        dashboard1.setBackground(new java.awt.Color(255, 255, 255));
        dashboard1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        dashboard1.setForeground(new java.awt.Color(9, 146, 194));
        dashboard1.setText("Dashboard");
        dashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboard1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboard1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        karyawan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                karyawan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                karyawan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                karyawan1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout karyawanLayout = new javax.swing.GroupLayout(karyawan);
        karyawan.setLayout(karyawanLayout);
        karyawanLayout.setHorizontalGroup(
            karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(karyawanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(karyawan1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        karyawanLayout.setVerticalGroup(
            karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(karyawanLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(karyawan1)
                .addContainerGap(14, Short.MAX_VALUE))
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
        pengemudi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pengemudi1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pengemudi1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pengemudi1MouseExited(evt);
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
                .addComponent(pengemudi1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        kendaraan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kendaraan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kendaraan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kendaraan1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout kendaraanLayout = new javax.swing.GroupLayout(kendaraan);
        kendaraan.setLayout(kendaraanLayout);
        kendaraanLayout.setHorizontalGroup(
            kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kendaraan1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        pemesanan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pemesanan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pemesanan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pemesanan1MouseExited(evt);
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
        logout1.setForeground(new java.awt.Color(255, 102, 102));
        logout1.setText("Logout");
        logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout1MouseExited(evt);
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
        barang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barang1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barang1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barang1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout barangLayout = new javax.swing.GroupLayout(barang);
        barang.setLayout(barangLayout);
        barangLayout.setHorizontalGroup(
            barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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
        pelanggan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelanggan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pelanggan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pelanggan1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pelangganLayout = new javax.swing.GroupLayout(pelanggan);
        pelanggan.setLayout(pelangganLayout);
        pelangganLayout.setHorizontalGroup(
            pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pelangganLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pelangganLayout.setVerticalGroup(
            pelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pelangganLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pelanggan1)
                .addGap(14, 14, 14))
        );

        laporanpemesanan.setBackground(new java.awt.Color(255, 255, 255));

        laporanpemesanan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        laporanpemesanan1.setForeground(new java.awt.Color(9, 146, 194));
        laporanpemesanan1.setText("Laporan Pemesanan");
        laporanpemesanan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanpemesanan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laporanpemesanan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laporanpemesanan1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout laporanpemesananLayout = new javax.swing.GroupLayout(laporanpemesanan);
        laporanpemesanan.setLayout(laporanpemesananLayout);
        laporanpemesananLayout.setHorizontalGroup(
            laporanpemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanpemesananLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(laporanpemesanan1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        laporanpemesananLayout.setVerticalGroup(
            laporanpemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporanpemesananLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(laporanpemesanan1)
                .addGap(14, 14, 14))
        );

        transaksi1.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        transaksi1.setForeground(new java.awt.Color(255, 255, 255));
        transaksi1.setText("Dokumen");

        suratjalan.setBackground(new java.awt.Color(255, 255, 255));

        suratjalan1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        suratjalan1.setForeground(new java.awt.Color(9, 146, 194));
        suratjalan1.setText("Surat Jalan");
        suratjalan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suratjalan1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suratjalan1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suratjalan1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout suratjalanLayout = new javax.swing.GroupLayout(suratjalan);
        suratjalan.setLayout(suratjalanLayout);
        suratjalanLayout.setHorizontalGroup(
            suratjalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suratjalanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(suratjalan1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        suratjalanLayout.setVerticalGroup(
            suratjalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suratjalanLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(suratjalan1)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout menubarLayout = new javax.swing.GroupLayout(menubar);
        menubar.setLayout(menubarLayout);
        menubarLayout.setHorizontalGroup(
            menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menubarLayout.createSequentialGroup()
                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menubarLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(masterdata)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menubarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pengemudi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laporanpemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suratjalan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(menubarLayout.createSequentialGroup()
                                .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(kendaraan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(menubarLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(menubarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(transaksi)
                                            .addComponent(transaksi1))))
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addComponent(karyawan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(laporanpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaksi1)
                .addGap(20, 20, 20)
                .addComponent(suratjalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pn_kanan.setBackground(new java.awt.Color(255, 255, 255));
        pn_kanan.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pn_kiriLayout = new javax.swing.GroupLayout(pn_kiri);
        pn_kiri.setLayout(pn_kiriLayout);
        pn_kiriLayout.setHorizontalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(menubar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_kanan, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_kiriLayout.setVerticalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menubar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addComponent(pn_kanan, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pn_header.setBackground(new java.awt.Color(9, 146, 194));

        masterdata1.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        masterdata1.setForeground(new java.awt.Color(255, 255, 255));
        masterdata1.setText("Karya Tirta Mandiri");

        username.setBackground(new java.awt.Color(10, 128, 169));
        username.setShadowOpacity(0.1F);
        username.setShadowSize(1);

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

        waktuUpdate.setBackground(new java.awt.Color(10, 128, 169));
        waktuUpdate.setShadowOpacity(0.1F);
        waktuUpdate.setShadowSize(1);

        waktuUpdate1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        waktuUpdate1.setForeground(new java.awt.Color(255, 255, 255));
        waktuUpdate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout waktuUpdateLayout = new javax.swing.GroupLayout(waktuUpdate);
        waktuUpdate.setLayout(waktuUpdateLayout);
        waktuUpdateLayout.setHorizontalGroup(
            waktuUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waktuUpdateLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(waktuUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        waktuUpdateLayout.setVerticalGroup(
            waktuUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(waktuUpdate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_headerLayout = new javax.swing.GroupLayout(pn_header);
        pn_header.setLayout(pn_headerLayout);
        pn_headerLayout.setHorizontalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_headerLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(masterdata1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(waktuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_headerLayout.setVerticalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(masterdata1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(waktuUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        pn_menuheader.setBackground(new java.awt.Color(255, 255, 255));

        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExit.setText("     X");
        btnExit.setPreferredSize(new java.awt.Dimension(8, 20));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        btnFS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFS.setText("     🗖");
        btnFS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFSMouseExited(evt);
            }
        });

        btnMinimize.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMinimize.setText("    -");
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_menuheaderLayout = new javax.swing.GroupLayout(pn_menuheader);
        pn_menuheader.setLayout(pn_menuheaderLayout);
        pn_menuheaderLayout.setHorizontalGroup(
            pn_menuheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_menuheaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnFS, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pn_menuheaderLayout.setVerticalGroup(
            pn_menuheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_menuheaderLayout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnFS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_menuheader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_kiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_menuheader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pn_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_kiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_dasar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_dasar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        resetMenu();
        pengemudi1.setForeground(new Color (0,0,0));
        pn_kanan.removeAll();
        
        menu_pengemudi m = new menu_pengemudi();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(m);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pengemudi1MouseClicked

    private void dashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard1MouseClicked
//        dashboard.setBackground(new Color (242,242,242));
    }//GEN-LAST:event_dashboard1MouseClicked

    private void karyawan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawan1MouseClicked
        resetMenu();
        karyawan1.setForeground(new Color (0,0,0));
        pn_kanan.removeAll();

        menu_karyawan m = new menu_karyawan();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(m);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_karyawan1MouseClicked

    private void kendaraan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kendaraan1MouseClicked
        resetMenu();
        kendaraan1.setForeground(new Color (0,0,0));
        pn_kanan.removeAll();

        menu_kendaraan m = new menu_kendaraan();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(m);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_kendaraan1MouseClicked

    private void pengemudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengemudiMouseClicked
//        resetMenu();
//        pn_kanan.removeAll();
//        menu_pengemudi pengemudi = new menu_pengemudi();
//        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(pengemudi);
//
//        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
//        pn_kanan.revalidate();
//        pn_kanan.repaint();
    }//GEN-LAST:event_pengemudiMouseClicked

    private void logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseClicked
        logout.setBackground(new Color (220, 220, 220));
        login l = new login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logout1MouseClicked

    private void barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barang1MouseClicked
        resetMenu();
        barang1.setForeground(new Color (0, 0, 0));
        pn_kanan.removeAll();
        menu_barang m = new menu_barang();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(m);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_barang1MouseClicked

    private void pemesanan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemesanan1MouseClicked
        resetMenu();
        pemesanan1.setForeground(new Color (0,0,0));
        pn_kanan.removeAll();
        menu_pemesanan m = new menu_pemesanan();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(m);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pemesanan1MouseClicked

    private void dashboard1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard1MouseEntered
//        dashboard.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_dashboard1MouseEntered

    private void dashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseEntered

    }//GEN-LAST:event_dashboardMouseEntered

    private void karyawan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawan1MouseExited
//        karyawan.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_karyawan1MouseExited

    private void karyawan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawan1MouseEntered
//        karyawan.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_karyawan1MouseEntered

    private void dashboard1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard1MouseExited
//       dashboard.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_dashboard1MouseExited

    private void pengemudi1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengemudi1MouseEntered
//        pengemudi.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_pengemudi1MouseEntered

    private void pengemudi1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengemudi1MouseExited
//        pengemudi.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_pengemudi1MouseExited

    private void barang1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barang1MouseEntered
//        barang.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_barang1MouseEntered

    private void barang1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barang1MouseExited
//        barang.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_barang1MouseExited

    private void kendaraan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kendaraan1MouseEntered
//        kendaraan.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_kendaraan1MouseEntered

    private void kendaraan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kendaraan1MouseExited
//        kendaraan.setBackground(new Color (255, 255, 255));
    }//GEN-LAST:event_kendaraan1MouseExited

    private void pemesanan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemesanan1MouseEntered
//        pemesanan.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_pemesanan1MouseEntered

    private void pemesanan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemesanan1MouseExited
//        pemesanan.setBackground(new Color (255, 255, 255));
    }//GEN-LAST:event_pemesanan1MouseExited

    private void logout1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseEntered
//        logout.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_logout1MouseEntered

    private void logout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseExited
//        logout.setBackground(new Color (255, 255, 255));
    }//GEN-LAST:event_logout1MouseExited

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(Color.RED);
        btnExit.setOpaque(true);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(0,0,0,0));
        btnExit.setOpaque(false);
    }//GEN-LAST:event_btnExitMouseExited

    private void btnFSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFSMouseClicked
        if (this.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    } else {
        this.setExtendedState(JFrame.NORMAL);
}
    }//GEN-LAST:event_btnFSMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnFSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFSMouseEntered
        btnFS.setBackground(new Color (220,220,220));
        btnFS.setOpaque(true);
    }//GEN-LAST:event_btnFSMouseEntered

    private void btnFSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFSMouseExited
        btnFS.setBackground(new Color (255, 255, 255));
        btnFS.setOpaque(false);
    }//GEN-LAST:event_btnFSMouseExited

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        btnMinimize.setBackground(new Color (220,220,220));
        btnMinimize.setOpaque(true);
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        btnMinimize.setBackground(new Color (255, 255, 255));
        btnMinimize.setOpaque(false);
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void pelanggan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelanggan1MouseClicked
        resetMenu();
        pelanggan1.setForeground(new Color (0,0,0));
        pn_kanan.removeAll();
        menu_pelanggan pelanggan = new menu_pelanggan();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(pelanggan);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_pelanggan1MouseClicked

    private void pelanggan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelanggan1MouseEntered
//        pelanggan1.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_pelanggan1MouseEntered

    private void pelanggan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelanggan1MouseExited
//        pelanggan.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_pelanggan1MouseExited

    private void laporanpemesanan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanpemesanan1MouseClicked
        resetMenu();
        laporanpemesanan1.setForeground(new Color (0, 0, 0));
        pn_kanan.removeAll();
        riwayat_pemesanan m = new riwayat_pemesanan();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(m);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_laporanpemesanan1MouseClicked

    private void laporanpemesanan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanpemesanan1MouseEntered
//        laporanpemesanan1.setBackground(new Color (220, 220, 220));
    }//GEN-LAST:event_laporanpemesanan1MouseEntered

    private void laporanpemesanan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanpemesanan1MouseExited
//        laporanpemesanan1.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_laporanpemesanan1MouseExited

    private void suratjalan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suratjalan1MouseClicked
        resetMenu();
        suratjalan1.setForeground(new Color (0, 0, 0));
        pn_kanan.removeAll();
        riwayat_pemesanan m = new riwayat_pemesanan();
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(m);

        pn_kanan.add(scroll, java.awt.BorderLayout.CENTER);
        pn_kanan.revalidate();
        pn_kanan.repaint();
    }//GEN-LAST:event_suratjalan1MouseClicked

    private void suratjalan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suratjalan1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_suratjalan1MouseEntered

    private void suratjalan1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suratjalan1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_suratjalan1MouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new menu_utama().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private asset.PanelShadow barang;
    private javax.swing.JLabel barang1;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnFS;
    private javax.swing.JLabel btnMinimize;
    private asset.PanelShadow dashboard;
    private javax.swing.JLabel dashboard1;
    private javax.swing.JProgressBar jProgressBar1;
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
    private javax.swing.JLabel transaksi1;
    private asset.PanelShadow username;
    private asset.PanelShadow waktuUpdate;
    private javax.swing.JLabel waktuUpdate1;
    // End of variables declaration//GEN-END:variables
}
