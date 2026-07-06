package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;
import javax.swing.JDialog;

public class pop_up_kendaraan extends javax.swing.JPanel {
    
    private surat_jalan suratjalan;
    private JDialog dialog;
    
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();

    public pop_up_kendaraan(surat_jalan suratjalan){
        initComponents();
        this.suratjalan = suratjalan;
        k.connect();
        refreshTable();
    }
    
    public void cariData() {
        DefaultTableModel model = (DefaultTableModel) tabel_barang1.getModel();
        model.setRowCount(0); 

        try {
            String sql = "SELECT * FROM tb_kendaraan WHERE id_kendaraan LIKE ? OR merk_kendaraan LIKE ?";
            PreparedStatement stat = k.connect().prepareStatement(sql);

            stat.setString(1, "%" + tCari.getText() + "%");
            stat.setString(2, "%" + tCari.getText() + "%");
            stat.setString(3, "%" + tCari.getText() + "%");

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_kendaraan"),
                    rs.getString("merk_kendaraan"),
                    rs.getString("platnomor")
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID Kendaraan");
        model.addColumn("Nama Kendaraan");
        model.addColumn("Plat Nomor");
        tabel_barang1.setModel(model);
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
    }
    
    public void setDialog(JDialog dialog){
        this.dialog = dialog;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pn_button1 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        tabel_karyawan = new javax.swing.JScrollPane();
        tabel_barang1 = new javax.swing.JTable();
        pn_data_pengemudi4 = new javax.swing.JPanel();
        judul4 = new asset.PanelShadow();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pn_button1.setBackground(new java.awt.Color(255, 255, 255));

        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pn_button1Layout = new javax.swing.GroupLayout(pn_button1);
        pn_button1.setLayout(pn_button1Layout);
        pn_button1Layout.setHorizontalGroup(
            pn_button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_button1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_button1Layout.setVerticalGroup(
            pn_button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCari)
                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jLabel5.setText("Data Kendaraan");

        javax.swing.GroupLayout judul4Layout = new javax.swing.GroupLayout(judul4);
        judul4.setLayout(judul4Layout);
        judul4Layout.setHorizontalGroup(
            judul4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judul4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(judul4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        pn_data_pengemudi4Layout.setVerticalGroup(
            pn_data_pengemudi4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_data_pengemudi4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(judul4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabel_karyawan, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pn_button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pn_data_pengemudi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pn_data_pengemudi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabel_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariData();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyPressed
        cariData();
    }//GEN-LAST:event_tCariKeyPressed

    private void tabel_barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barang1MouseClicked
        int row = tabel_barang1.getSelectedRow();
        String id = tabel_barang1.getValueAt(row, 0).toString();
        String nama = tabel_barang1.getValueAt(row, 1).toString();
        String plat = tabel_barang1.getValueAt(row, 2).toString();

        suratjalan.setIdKendaraan(id);
        suratjalan.setNamaKendaraan(nama);
        suratjalan.setPlatNomor(plat);
        dialog.dispose();
    }//GEN-LAST:event_tabel_barang1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private asset.PanelShadow judul4;
    private javax.swing.JPanel pn_button1;
    private javax.swing.JPanel pn_data_pengemudi4;
    private javax.swing.JTextField tCari;
    private javax.swing.JTable tabel_barang1;
    private javax.swing.JScrollPane tabel_karyawan;
    // End of variables declaration//GEN-END:variables
}
