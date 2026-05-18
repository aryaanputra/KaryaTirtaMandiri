package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;
import javax.swing.JDialog;

public class menu_pelanggan extends javax.swing.JPanel {
    
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public menu_pelanggan() {
        initComponents();
        txt_idpelanggan.setText(generateIdPelanggan());
        k.connect();
        refreshTable();
    }
    
    public String generateIdPelanggan() {
        String idPelanggan = "PLG001";
        try {
            String sql = "SELECT id_pelanggan FROM tb_pelanggan ORDER BY id_pelanggan ASC";
            this.stat = k.connect().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            int nomor = 1;
            while (rs.next()) {
                String id = rs.getString("id_pelanggan");
                int angkaDatabase = Integer.parseInt(id.substring(3));
                if (angkaDatabase != nomor) {
                    break;
                }
                nomor++;
            }
            idPelanggan = String.format("PLG%03d", nomor);
        } catch (Exception e) {
            System.out.println("Generate ID Error : " + e.getMessage());
        }
        return idPelanggan;
    }
    
    public void kosong(){
        txt_idpelanggan.setText("");
        txt_namapelanggan.setText("");
        txt_notelp.setText("");
    }
    
    public void cariData() {
        DefaultTableModel model = (DefaultTableModel) tabel_pelanggan.getModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Nomor Telepon");

        try {
            String sql = "SELECT * FROM tb_pelanggan WHERE id_pelanggan LIKE ? OR nama_pelanggan LIKE ?";
            PreparedStatement stat = k.connect().prepareStatement(sql);

            stat.setString(1, "%" + tCari.getText() + "%");
            stat.setString(2, "%" + tCari.getText() + "%");

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_pelanggan"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("no_telp"),
                };

                model.addRow(data);
            }
            
            tabel_pelanggan.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Nomor Telepon");
        tabel_pelanggan.setModel(model);
    try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_pelanggan");
            this.rs = stat.executeQuery();
            while(rs.next()){
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                };
                model.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        kosong();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        judul = new asset.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_idpelanggan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_namapelanggan = new javax.swing.JTextField();
        txt_notelp = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pelanggan = new javax.swing.JTable();
        tCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        judul.setBackground(new java.awt.Color(9, 146, 194));
        judul.setShadowSize(2);
        judul.setShadowType(asset.ShadowType.BOT_RIGHT);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Pelanggan");

        javax.swing.GroupLayout judulLayout = new javax.swing.GroupLayout(judul);
        judul.setLayout(judulLayout);
        judulLayout.setHorizontalGroup(
            judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        judulLayout.setVerticalGroup(
            judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setText("Data Kendaraan");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setText("ID Pelanggan");

        txt_idpelanggan.addActionListener(this::txt_idpelangganActionPerformed);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setText("Nama Pelanggan");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setText("No Telepon");

        txt_namapelanggan.addActionListener(this::txt_namapelangganActionPerformed);

        txt_notelp.addActionListener(this::txt_notelpActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_idpelanggan)
                            .addComponent(txt_namapelanggan)
                            .addComponent(txt_notelp, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_idpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_namapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_notelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/diskette20x20.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/pen20x20.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(this::btnUbahActionPerformed);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete20x20.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnBatal.setText("Batal");
        btnBatal.setPreferredSize(new java.awt.Dimension(90, 30));
        btnBatal.addActionListener(this::btnBatalActionPerformed);

        tabel_pelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_pelanggan);

        tCari.addActionListener(this::tCariActionPerformed);
        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariKeyPressed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);
        btnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
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

    private void txt_idpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpelangganActionPerformed
    }//GEN-LAST:event_txt_idpelangganActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String idPelanggan = generateIdPelanggan();
        try{
            this.stat = k.connect().prepareStatement("INSERT INTO tb_pelanggan (\n" +
            "    id_pelanggan,\n" +
            "    nama_pelanggan,\n" +
            "    no_telp\n" +
            
            ") VALUES (?,?,?)");
            stat.setString(1, idPelanggan);
            stat.setString(2, txt_namapelanggan.getText());
            stat.setString(3, txt_notelp.getText());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txt_namapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namapelangganActionPerformed
    }//GEN-LAST:event_txt_namapelangganActionPerformed

    private void txt_notelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_notelpActionPerformed
    }//GEN-LAST:event_txt_notelpActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try{
            stat = k.connect().prepareStatement(
                "UPDATE tb_pelanggan SET " +
                "nama_pelanggan=?, no_telp=?" +
                "WHERE id_pelanggan=?"
            );

            stat.setString(1, txt_namapelanggan.getText());
            stat.setString(2, txt_notelp.getText());
            stat.setString(3, txt_idpelanggan.getText());

            stat.executeUpdate();
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try{
            this.stat = k.connect().prepareStatement("DELETE FROM tb_pelanggan WHERE id_pelanggan=?");
            stat.setString(1, txt_idpelanggan.getText());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        kosong();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        cariData();
    }//GEN-LAST:event_tCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariData();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCariKeyPressed
        cariData();
    }//GEN-LAST:event_btnCariKeyPressed

    private void tabel_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pelangganMouseClicked
        // TODO add your handling code here:
        txt_idpelanggan.setText(model.getValueAt(tabel_pelanggan.getSelectedRow(),0).toString());
        txt_namapelanggan.setText(model.getValueAt(tabel_pelanggan.getSelectedRow(),1).toString());
        txt_notelp.setText(model.getValueAt(tabel_pelanggan.getSelectedRow(),2).toString());
    }//GEN-LAST:event_tabel_pelangganMouseClicked

    private void tCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyPressed
        cariData();
    }//GEN-LAST:event_tCariKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private asset.PanelShadow judul;
    private javax.swing.JTextField tCari;
    private javax.swing.JTable tabel_pelanggan;
    private javax.swing.JTextField txt_idpelanggan;
    private javax.swing.JTextField txt_namapelanggan;
    private javax.swing.JTextField txt_notelp;
    // End of variables declaration//GEN-END:variables
}
