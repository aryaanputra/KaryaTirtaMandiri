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
import net.sf.jasperreports.engine.util.JRLoader;

public class riwayat_pemesanan extends javax.swing.JPanel {
    
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();

    public riwayat_pemesanan(){
        initComponents();
        k.connect();
        refreshTable();
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
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                };
                model.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        btnCetak = new javax.swing.JButton();
        txt_nofaktur = new javax.swing.JTextField();

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
        jLabel5.setText("Data Riwayat Pemesanan");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pn_data_pengemudi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCetak)
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabel_karyawan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pn_button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pn_data_pengemudi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(pn_button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabel_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak)
                .addContainerGap(180, Short.MAX_VALUE))
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
        String nama = tabel_barang1.getValueAt(row, 2).toString();
        String hargajual = tabel_barang1.getValueAt(row, 5).toString();
    }//GEN-LAST:event_tabel_barang1MouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    int row = tabel_barang1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!");
            return;
        }
        String noFaktur = tabel_barang1.getValueAt(row, 0).toString();
        try {
            HashMap<String, Object> param = new HashMap<>();
            param.put("no_faktur", noFaktur);

            InputStream input = getClass().getResourceAsStream(
                "/karyatirtamandiri/struk_pembelian.jasper"
            );
            JasperReport jr = (JasperReport) JRLoader.loadObject(input);
            JasperPrint jp  = JasperFillManager.fillReport(jr, param, k.connect());
            JasperViewer.viewReport(jp, false);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal cetak: " + e.getMessage());
        }  
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private asset.PanelShadow judul4;
    private javax.swing.JPanel pn_button1;
    private javax.swing.JPanel pn_data_pengemudi4;
    private javax.swing.JTextField tCari;
    private javax.swing.JTable tabel_barang1;
    private javax.swing.JScrollPane tabel_karyawan;
    private javax.swing.JTextField txt_nofaktur;
    // End of variables declaration//GEN-END:variables
}
