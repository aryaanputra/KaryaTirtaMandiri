package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;
import java.util.HashMap;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.jasperreports.engine.util.JRLoader;

public class surat_jalan extends javax.swing.JPanel {
    
    menu_utama mu;
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();

    public surat_jalan(){
        initComponents();
        txt_no_surat.setText(generatenoSurat());
        k.connect();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd"); 
        txt_tanggal_surat.setText(s.format(date));
        refreshTable();
        refreshTable1();
    }
    
    public void cariData() {
        DefaultTableModel model = (DefaultTableModel) tabel_barang1.getModel();
        model.setRowCount(0); 

        try {
            String sql = "SELECT * FROM tb_pemesanan WHERE no_faktur LIKE ? OR id_pelanggan LIKE ? OR nama_pelanggan LIKE ?";
            PreparedStatement stat = k.connect().prepareStatement(sql);

            stat.setString(1, "%" + tCari.getText() + "%");
            stat.setString(2, "%" + tCari.getText() + "%");
            stat.setString(3, "%" + tCari.getText() + "%");

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("no_faktur"),
                    rs.getString("id_pelanggan"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("tanggal"),
                    rs.getString("bayar"),
                    rs.getString("total"),
                    rs.getString("kembalian")
                };

                model.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String generatenoSurat() {
        String no_surat_jalan;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ssmmHHddMMyyyy");
        no_surat_jalan = sdf.format(now);
        return no_surat_jalan;
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("No Faktur");
        model.addColumn("ID Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Tanggal");
        model.addColumn("Bayar");
        model.addColumn("Total");
        model.addColumn("Kembalian");
        tabel_barang1.setModel(model);
        try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_pemesanan ORDER BY no_faktur DESC");
            this.rs = stat.executeQuery();
            while(rs.next()){
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
                };
                model.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void refreshTable1(){
        model = new DefaultTableModel();
        model.addColumn("No Surat Jalan");
        model.addColumn("No Faktur");
        model.addColumn("Tanggal Surat");
        model.addColumn("Id Kendaraan");
        model.addColumn("Id Pengemudi");
        tabel_surat.setModel(model);
        try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_surat_jalan ORDER BY no_surat_jalan DESC");
            this.rs = stat.executeQuery();
            while(rs.next()){
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                };
                model.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void setIdKendaraan(String id_kendaraan){
        txtidbarang1.setText(id_kendaraan);
    }
    
    public void setNamaKendaraan(String merk_kendaraan){
        txtnamabarang1.setText(merk_kendaraan);
    }
    
    public void setIdPengemudi(String id_pengemudi){
        txtidbarang.setText(id_pengemudi);
    }
    
    public void setNamaPengemudi(String nama_pengemudi){
        txtnamabarang.setText(nama_pengemudi);
    }
    
    public void setPlatNomor(String platnomor){
//        txtnamabarang.setText(platnomor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pn_button1 = new javax.swing.JPanel();
        tabel_karyawan = new javax.swing.JScrollPane();
        tabel_barang1 = new javax.swing.JTable();
        pn_data_pengemudi4 = new javax.swing.JPanel();
        judul4 = new asset.PanelShadow();
        jLabel5 = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        txt_nofaktur = new javax.swing.JTextField();
        txtidbarang = new javax.swing.JTextField();
        btnDataBarang = new javax.swing.JButton();
        txtnamabarang = new javax.swing.JTextField();
        txtidbarang1 = new javax.swing.JTextField();
        txtnamabarang1 = new javax.swing.JTextField();
        btnDataBarang1 = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        tabel_karyawan1 = new javax.swing.JScrollPane();
        tabel_surat = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        txt_tanggal_surat = new javax.swing.JTextField();
        txt_no_surat = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pn_button1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_button1Layout = new javax.swing.GroupLayout(pn_button1);
        pn_button1.setLayout(pn_button1Layout);
        pn_button1Layout.setHorizontalGroup(
            pn_button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        pn_button1Layout.setVerticalGroup(
            pn_button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        tabel_barang1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_barang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barang1MouseClicked(evt);
            }
        });
        tabel_karyawan.setViewportView(tabel_barang1);

        pn_data_pengemudi4.setBackground(new java.awt.Color(255, 255, 255));

        judul4.setBackground(new java.awt.Color(9, 146, 194));
        judul4.setShadowSize(2);
        judul4.setShadowType(asset.ShadowType.BOT_RIGHT);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Surat Jalan");

        javax.swing.GroupLayout judul4Layout = new javax.swing.GroupLayout(judul4);
        judul4.setLayout(judul4Layout);
        judul4Layout.setHorizontalGroup(
            judul4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judul4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        judul4Layout.setVerticalGroup(
            judul4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judul4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_data_pengemudi4Layout = new javax.swing.GroupLayout(pn_data_pengemudi4);
        pn_data_pengemudi4.setLayout(pn_data_pengemudi4Layout);
        pn_data_pengemudi4Layout.setHorizontalGroup(
            pn_data_pengemudi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_data_pengemudi4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(judul4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_data_pengemudi4Layout.setVerticalGroup(
            pn_data_pengemudi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_data_pengemudi4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(judul4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(this::btnCetakActionPerformed);

        txtidbarang.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtidbarang.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Pengemudi"));
        txtidbarang.setEnabled(false);

        btnDataBarang.setText("...");
        btnDataBarang.addActionListener(this::btnDataBarangActionPerformed);

        txtnamabarang.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtnamabarang.setBorder(javax.swing.BorderFactory.createTitledBorder("Nama Pengemudi"));
        txtnamabarang.setEnabled(false);

        txtidbarang1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtidbarang1.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Kendaraan"));
        txtidbarang1.setEnabled(false);

        txtnamabarang1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtnamabarang1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nama Kendaraan"));
        txtnamabarang1.setEnabled(false);

        btnDataBarang1.setText("...");
        btnDataBarang1.addActionListener(this::btnDataBarang1ActionPerformed);

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariKeyPressed(evt);
            }
        });

        tabel_surat.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_surat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_suratMouseClicked(evt);
            }
        });
        tabel_karyawan1.setViewportView(tabel_surat);

        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pn_data_pengemudi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(656, 656, 656)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCari))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDataBarang))
                                    .addComponent(txt_no_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidbarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDataBarang1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tanggal_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnamabarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tabel_karyawan)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSimpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCetak))
                                    .addComponent(tabel_karyawan1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(2, 2, 2)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pn_data_pengemudi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(pn_button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txt_tanggal_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_no_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnDataBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtidbarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtnamabarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetak)
                    .addComponent(btnSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabel_karyawan1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabel_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariData();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyPressed
        cariData();
    }//GEN-LAST:event_tCariKeyPressed

    private void tabel_barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barang1MouseClicked
        int row = tabel_barang1.getSelectedRow();
        String no_faktur = tabel_barang1.getValueAt(row, 0).toString();
        
        txt_nofaktur.setText(no_faktur);
    }//GEN-LAST:event_tabel_barang1MouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    int row = tabel_surat.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!");
            return;
        }
        String noFaktur = tabel_surat.getValueAt(row, 1).toString();
        try {
            HashMap<String, Object> param = new HashMap<>();
            param.put("no_faktur", noFaktur);

            InputStream input = getClass().getResourceAsStream(
                "/karyatirtamandiri/surat_jalan.jasper"
            );
            JasperReport jr = (JasperReport) JRLoader.loadObject(input);
            JasperPrint jp  = JasperFillManager.fillReport(jr, param, k.connect());
            JasperViewer.viewReport(jp, false);
            
           

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal cetak: " + e.getMessage());
        }  
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBarangActionPerformed
        pop_up_pengemudi datapengemudi = new pop_up_pengemudi(this);
        JDialog dialog = new JDialog(mu, "Cari Data Pengemudi", true);
        datapengemudi.setDialog(dialog);
        dialog.setContentPane(datapengemudi);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnDataBarangActionPerformed

    private void btnDataBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBarang1ActionPerformed
        
        pop_up_kendaraan datakendaraan = new pop_up_kendaraan(this);
        JDialog dialog = new JDialog(mu, "Cari Data Kendaraan", true);
        datakendaraan.setDialog(dialog);
        dialog.setContentPane(datakendaraan);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnDataBarang1ActionPerformed

    private void tabel_suratMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratMouseClicked
        int row = tabel_surat.getSelectedRow();
        String no_surat = tabel_surat.getValueAt(row, 0).toString();
        String no_faktur = tabel_surat.getValueAt(row, 1).toString();
        String tanggal_surat = tabel_surat.getValueAt(row, 2).toString();
        String id_kendaraan = tabel_surat.getValueAt(row, 3).toString();
        String id_pengemudi = tabel_surat.getValueAt(row, 4).toString();
        
        txt_nofaktur.setText(no_faktur);
    }//GEN-LAST:event_tabel_suratMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String no_surat_jalan = generatenoSurat();
        try {
            String sql = "INSERT INTO tb_surat_jalan "
                    + "(no_surat_jalan, no_faktur, tanggal_surat, id_kendaraan, id_pengemudi) "
                    + "VALUES (?,?,?,?,?)";
            stat = k.connect().prepareStatement(sql);
            stat.setString(1, no_surat_jalan);
            stat.setString(2, txt_nofaktur.getText());
            stat.setString(3, txt_tanggal_surat.getText());
            stat.setString(4, txtidbarang1.getText());
            stat.setString(5, txtidbarang.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            refreshTable1();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDataBarang;
    private javax.swing.JButton btnDataBarang1;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private asset.PanelShadow judul4;
    private javax.swing.JPanel pn_button1;
    private javax.swing.JPanel pn_data_pengemudi4;
    private javax.swing.JTextField tCari;
    private javax.swing.JTable tabel_barang1;
    private javax.swing.JScrollPane tabel_karyawan;
    private javax.swing.JScrollPane tabel_karyawan1;
    private javax.swing.JTable tabel_surat;
    private javax.swing.JTextField txt_no_surat;
    private javax.swing.JTextField txt_nofaktur;
    private javax.swing.JTextField txt_tanggal_surat;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtidbarang1;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnamabarang1;
    // End of variables declaration//GEN-END:variables
}
