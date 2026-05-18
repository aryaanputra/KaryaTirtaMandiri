package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;

public class menu_kendaraan extends javax.swing.JPanel {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public menu_kendaraan() {
        initComponents();
        txt_idkendaraan.setText(generateIdKendaraan());
        k.connect();
        refreshTable();
    }
    
    public String generateIdKendaraan() {
        String idKendaraan = "DR001";
        try {
            String sql = "SELECT id_kendaraan FROM tb_kendaraan ORDER BY id_kendaraan ASC";
            this.stat = k.connect().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            int nomor = 1;
            while (rs.next()) {
                String id = rs.getString("id_kendaraaan");
                int angkaDatabase = Integer.parseInt(id.substring(3));
                if (angkaDatabase != nomor) {
                    break;
                }
                nomor++;
            }
            idKendaraan = String.format("DR%03d", nomor);
        } catch (Exception e) {
            System.out.println("Generate ID Error : " + e.getMessage());
        }
        return idKendaraan;
    }
    
    public void kosong(){
        txt_idkendaraan.setText("");
        txt_merkkendaraan.setText("");
        txt_platnomor.setText("");
    }
    
    public void cariData() {
        DefaultTableModel model = (DefaultTableModel) tabel_kendaraan1.getModel();
        model.addColumn("ID");
        model.addColumn("Merk");
        model.addColumn("Plat Nomor");

        try {
            String sql = "SELECT * FROM tb_kendaraan WHERE id_kendaraan LIKE ? OR merk_kendaraan LIKE ?";
            PreparedStatement stat = k.connect().prepareStatement(sql);

            stat.setString(1, "%" + tCari.getText() + "%");
            stat.setString(2, "%" + tCari.getText() + "%");

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_kendaraan"),
                    rs.getString("merk_kendaraan"),
                    rs.getString("platnomor"),
                };

                model.addRow(data);
            }
            
            tabel_kendaraan1.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Merk");
        model.addColumn("Plat Nomor");
        tabel_kendaraan1.setModel(model);
    try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_kendaraan");
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
        txt_idkendaraan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_merkkendaraan = new javax.swing.JTextField();
        txt_platnomor = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_kendaraan1 = new javax.swing.JTable();
        tCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        judul.setBackground(new java.awt.Color(9, 146, 194));
        judul.setShadowSize(2);
        judul.setShadowType(asset.ShadowType.BOT_RIGHT);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Kendaraan");

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
        jLabel3.setText("ID Kendaraan");

        txt_idkendaraan.addActionListener(this::txt_idkendaraanActionPerformed);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setText("Merk Kendaraan");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setText("Plat Nomor");

        txt_merkkendaraan.addActionListener(this::txt_merkkendaraanActionPerformed);

        txt_platnomor.addActionListener(this::txt_platnomorActionPerformed);

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_merkkendaraan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txt_idkendaraan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_platnomor))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_idkendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_merkkendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_platnomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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
        btnBatal.setMaximumSize(new java.awt.Dimension(90, 30));
        btnBatal.setMinimumSize(new java.awt.Dimension(90, 30));
        btnBatal.setPreferredSize(new java.awt.Dimension(90, 30));
        btnBatal.addActionListener(this::btnBatalActionPerformed);

        tabel_kendaraan1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_kendaraan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kendaraan1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_kendaraan1);

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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(400, 400, 400)
                                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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

    private void txt_idkendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idkendaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idkendaraanActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String idKendaraan = generateIdKendaraan();
        try{
            this.stat = k.connect().prepareStatement("INSERT INTO tb_kendaraan (\n" +
            "    id_kendaraan,\n" +
            "    merk_kendaraan,\n" +
            "    platnomor\n" +
            
            ") VALUES (?,?,?)");
            stat.setString(1, idKendaraan);
            stat.setString(2, txt_merkkendaraan.getText());
            stat.setString(3, txt_platnomor.getText());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txt_merkkendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_merkkendaraanActionPerformed
    }//GEN-LAST:event_txt_merkkendaraanActionPerformed

    private void txt_platnomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_platnomorActionPerformed
    }//GEN-LAST:event_txt_platnomorActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try{
            stat = k.connect().prepareStatement(
                "UPDATE tb_kendaraan SET " +
                "merk_kendaraan=?, platnomor=?" +
                "WHERE id_kendaraan=?"
            );

            stat.setString(1, txt_merkkendaraan.getText());
            stat.setString(2, txt_platnomor.getText());
            stat.setString(3, txt_idkendaraan.getText());

            stat.executeUpdate();
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            this.stat = k.connect().prepareStatement("DELETE FROM tb_kendaraan WHERE id_kendaraan=?");
            stat.setString(1, txt_idkendaraan.getText());
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

    private void tabel_kendaraan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kendaraan1MouseClicked
        txt_idkendaraan.setText(model.getValueAt(tabel_kendaraan1.getSelectedRow(),0).toString());
        txt_merkkendaraan.setText(model.getValueAt(tabel_kendaraan1.getSelectedRow(),1).toString());
        txt_platnomor.setText(model.getValueAt(tabel_kendaraan1.getSelectedRow(),2).toString());
    }//GEN-LAST:event_tabel_kendaraan1MouseClicked

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
    private javax.swing.JTable tabel_kendaraan1;
    private javax.swing.JTextField txt_idkendaraan;
    private javax.swing.JTextField txt_merkkendaraan;
    private javax.swing.JTextField txt_platnomor;
    // End of variables declaration//GEN-END:variables
}
