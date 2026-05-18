package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;

public class menu_barang extends javax.swing.JPanel {
    
    menu_utama menuutama;
    
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public menu_barang() {
        initComponents();
        txt_idbarang.setText(generateIdBarang());
        k.connect();
        refreshTable();
    }
    
    public void kosong(){
        txt_idbarang.setText("");
        txt_namabarang.setText("");
        combo_kategori.setSelectedItem(0);
        txt_deskripsi.setText("");
        txt_hargabeli.setText("");
        txt_hargajual.setText("");
        combo_satuan.setSelectedItem(0);
        txt_namasupplier.setText("");
        txt_alamatsupplier.setText("");
    }
    
    public void cariData() {
        DefaultTableModel model = (DefaultTableModel) tabel_pengemudi1.getModel();
        model.setRowCount(0); // kosongkan tabel

        try {
            String sql = "SELECT * FROM tb_barang WHERE id_barang LIKE ? OR nama_supplier LIKE ? OR kategori LIKE ?";
            PreparedStatement stat = k.connect().prepareStatement(sql);

            stat.setString(1, "%" + tCari.getText() + "%");
            stat.setString(2, "%" + tCari.getText() + "%");
            stat.setString(3, "%" + tCari.getText() + "%");

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("kategori"),
                    rs.getString("deskripsi"),
                    rs.getString("harga_beli"),
                    rs.getString("harga_jual"),
                    rs.getString("satuan"),
                    rs.getString("nama_supplier"),
                    rs.getString("alamat_supplier")
                };

                model.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Nama");
        model.addColumn("Kategori");
        model.addColumn("Deskripsi");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Satruan");
        model.addColumn("Nama Supplier");
        model.addColumn("Alamat Supplier");
        tabel_pengemudi1.setModel(model);
        try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_barang");
            this.rs = stat.executeQuery();
            while(rs.next()){
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
                };
                model.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        kosong();
    }
    
    public String generateIdBarang() {
        String idBarang = "BRG001";
        try {
            String sql = "SELECT id_barang FROM tb_barang ORDER BY id_barang ASC";
            this.stat = k.connect().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            int nomor = 1;
            while (rs.next()) {
                String id = rs.getString("id_barang");
                int angkaDatabase = Integer.parseInt(id.substring(3));
                if (angkaDatabase != nomor) {
                    break;
                }
                nomor++;
            }
            idBarang = String.format("BRG%03d", nomor);
        } catch (Exception e) {
            System.out.println("Generate ID Error : " + e.getMessage());
        }
        return idBarang;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_dasar = new javax.swing.JPanel();
        pn_data_pengemudi = new javax.swing.JPanel();
        judul = new asset.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        data_identitas_pribadi = new javax.swing.JPanel();
        txt_idbarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JTextField();
        txt_deskripsi = new javax.swing.JTextField();
        combo_kategori = new javax.swing.JComboBox<>();
        tabel_barang = new javax.swing.JScrollPane();
        tabel_pengemudi1 = new javax.swing.JTable();
        data_harga = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_hargabeli = new javax.swing.JTextField();
        txt_hargajual = new javax.swing.JTextField();
        combo_satuan = new javax.swing.JComboBox<>();
        data_supplier = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_namasupplier = new javax.swing.JTextField();
        txt_alamatsupplier = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        pn_dasar.setBackground(new java.awt.Color(255, 255, 255));

        pn_data_pengemudi.setBackground(new java.awt.Color(255, 255, 255));

        judul.setBackground(new java.awt.Color(9, 146, 194));
        judul.setPreferredSize(new java.awt.Dimension(193, 59));
        judul.setShadowSize(2);
        judul.setShadowType(asset.ShadowType.BOT_RIGHT);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Barang");

        javax.swing.GroupLayout judulLayout = new javax.swing.GroupLayout(judul);
        judul.setLayout(judulLayout);
        judulLayout.setHorizontalGroup(
            judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, judulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        judulLayout.setVerticalGroup(
            judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_data_pengemudiLayout = new javax.swing.GroupLayout(pn_data_pengemudi);
        pn_data_pengemudi.setLayout(pn_data_pengemudiLayout);
        pn_data_pengemudiLayout.setHorizontalGroup(
            pn_data_pengemudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_data_pengemudiLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(942, 942, 942))
        );
        pn_data_pengemudiLayout.setVerticalGroup(
            pn_data_pengemudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_data_pengemudiLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        data_identitas_pribadi.setBackground(new java.awt.Color(255, 255, 255));
        data_identitas_pribadi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_idbarang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_idbarang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setText("Data Barang");

        txt_namabarang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_namabarang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_namabarang.addActionListener(this::txt_namabarangActionPerformed);

        txt_deskripsi.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_deskripsi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deskripsi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_deskripsi.addActionListener(this::txt_deskripsiActionPerformed);

        combo_kategori.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Air Konsumsi", "Air Nonkonsumsi" }));
        combo_kategori.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kategori", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        combo_kategori.addActionListener(this::combo_kategoriActionPerformed);

        javax.swing.GroupLayout data_identitas_pribadiLayout = new javax.swing.GroupLayout(data_identitas_pribadi);
        data_identitas_pribadi.setLayout(data_identitas_pribadiLayout);
        data_identitas_pribadiLayout.setHorizontalGroup(
            data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_namabarang)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_idbarang, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_kategori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        data_identitas_pribadiLayout.setVerticalGroup(
            data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_kategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_deskripsi))
                .addContainerGap())
        );

        tabel_pengemudi1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_pengemudi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pengemudi1MouseClicked(evt);
            }
        });
        tabel_barang.setViewportView(tabel_pengemudi1);

        data_harga.setBackground(new java.awt.Color(255, 255, 255));
        data_harga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setText("Data Harga");

        txt_hargabeli.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_hargabeli.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Harga Beli", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        txt_hargajual.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_hargajual.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Harga Jual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        combo_satuan.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Liter" }));
        combo_satuan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Satuan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        combo_satuan.addActionListener(this::combo_satuanActionPerformed);

        javax.swing.GroupLayout data_hargaLayout = new javax.swing.GroupLayout(data_harga);
        data_harga.setLayout(data_hargaLayout);
        data_hargaLayout.setHorizontalGroup(
            data_hargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_hargaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_hargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo_satuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(data_hargaLayout.createSequentialGroup()
                        .addGroup(data_hargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_hargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        data_hargaLayout.setVerticalGroup(
            data_hargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_hargaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(data_hargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_hargajual)
                    .addComponent(txt_hargabeli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(combo_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        data_supplier.setBackground(new java.awt.Color(255, 255, 255));
        data_supplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setText("Data Supplier");

        txt_namasupplier.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_namasupplier.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        txt_alamatsupplier.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_alamatsupplier.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alamat Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        javax.swing.GroupLayout data_supplierLayout = new javax.swing.GroupLayout(data_supplier);
        data_supplier.setLayout(data_supplierLayout);
        data_supplierLayout.setHorizontalGroup(
            data_supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_supplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(txt_namasupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(txt_alamatsupplier))
                .addContainerGap())
        );
        data_supplierLayout.setVerticalGroup(
            data_supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_supplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_namasupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_alamatsupplier)
                .addContainerGap())
        );

        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariKeyPressed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setPreferredSize(new java.awt.Dimension(90, 30));
        btnBatal.addActionListener(this::btnBatalActionPerformed);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete20x20.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/pen20x20.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(this::btnUbahActionPerformed);

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/diskette20x20.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pn_data_pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pn_dasarLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(data_identitas_pribadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(data_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(data_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_dasarLayout.createSequentialGroup()
                                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn_dasarLayout.createSequentialGroup()
                                        .addGap(194, 194, 194)
                                        .addComponent(btnHapus))
                                    .addGroup(pn_dasarLayout.createSequentialGroup()
                                        .addComponent(btnSimpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUbah)
                                        .addGap(100, 100, 100)
                                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(388, 388, 388)
                                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari))
                            .addComponent(tabel_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_data_pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(data_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_harga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_identitas_pribadi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCari)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUbah)
                        .addComponent(btnHapus)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSimpan)))
                .addGap(18, 18, 18)
                .addComponent(tabel_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        add(pn_dasar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_deskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_deskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deskripsiActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String idBarang = generateIdBarang();
        try{
            this.stat = k.connect().prepareStatement("INSERT INTO `tb_barang` "
                    + "(`id_barang`, `nama_barang`, `kategori`, `deskripsi`, "
                    + "`harga_beli`, `harga_jual`, `satuan`, `nama_supplier`, "
                    + "`alamat_supplier`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)");
            stat.setString(1, idBarang);
            stat.setString(2, txt_namabarang.getText());
            stat.setString(3, combo_kategori.getSelectedItem().toString());
            stat.setString(4, txt_deskripsi.getText());
            stat.setString(5, txt_hargabeli.getText());
            stat.setString(6, txt_hargajual.getText());
            stat.setString(7, combo_satuan.getSelectedItem().toString());
            stat.setString(8, txt_namasupplier.getText());
            stat.setString(9, txt_alamatsupplier.getText());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tabel_pengemudi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pengemudi1MouseClicked
       txt_idbarang.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),0).toString());
       txt_namabarang.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),1).toString());
       combo_kategori.setSelectedItem(model.getValueAt(tabel_pengemudi1.getSelectedRow(),2).toString());
       txt_deskripsi.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),3).toString());
       txt_hargabeli.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),4).toString());
       txt_hargajual.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),5).toString());
       combo_satuan.setSelectedItem(model.getValueAt(tabel_pengemudi1.getSelectedRow(),6).toString());
       txt_namasupplier.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),7).toString());
       txt_alamatsupplier.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),8).toString());
       
       
    }//GEN-LAST:event_tabel_pengemudi1MouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try{
            stat = k.connect().prepareStatement(
                "UPDATE tb_barang SET " +
                "nama_barang=?, kategori=?, deskripsi=?, " +
                "harga_beli=?, harga_jual=?, satuan=?, nama_supplier=?, " +
                "alamat_supplier=? " +
                "WHERE id_barang=?"
            );
            stat.setString(1, txt_namabarang.getText());
            stat.setString(2, combo_kategori.getSelectedItem().toString());
            stat.setString(3, txt_deskripsi.getText());
            stat.setString(4, txt_hargabeli.getText());
            stat.setString(5, txt_hargajual.getText());
            stat.setString(6, combo_satuan.getSelectedItem().toString());
            stat.setString(7, txt_namasupplier.getText());
            stat.setString(8, txt_alamatsupplier.getText());
            stat.setString(9, txt_idbarang.getText());

            stat.executeUpdate();
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            this.stat = k.connect().prepareStatement("DELETE FROM tb_barang WHERE id_barang=?");
            stat.setString(1, txt_idbarang.getText());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        kosong();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void combo_satuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_satuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_satuanActionPerformed

    private void combo_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_kategoriActionPerformed

    private void tCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyPressed
        cariData();
    }//GEN-LAST:event_tCariKeyPressed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariData();
    }//GEN-LAST:event_btnCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> combo_kategori;
    private javax.swing.JComboBox<String> combo_satuan;
    private javax.swing.JPanel data_harga;
    private javax.swing.JPanel data_identitas_pribadi;
    private javax.swing.JPanel data_supplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private asset.PanelShadow judul;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_data_pengemudi;
    private javax.swing.JTextField tCari;
    private javax.swing.JScrollPane tabel_barang;
    private javax.swing.JTable tabel_pengemudi1;
    private javax.swing.JTextField txt_alamatsupplier;
    private javax.swing.JTextField txt_deskripsi;
    private javax.swing.JTextField txt_hargabeli;
    private javax.swing.JTextField txt_hargajual;
    private javax.swing.JTextField txt_idbarang;
    private javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_namasupplier;
    // End of variables declaration//GEN-END:variables
}
