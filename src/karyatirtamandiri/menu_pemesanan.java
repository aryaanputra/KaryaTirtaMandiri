package karyatirtamandiri;

import java.sql.Connection;
import Koneksi.koneksi;
import java.awt.Dialog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class menu_pemesanan extends javax.swing.JPanel {
    
    menu_utama mu;
    
    String tanggal;
    private DefaultTableModel model;
     
    private Connection conn = new koneksi().connect();
     
    public void totalbiaya(){
        int jumlahbaris = jTable1.getRowCount();
        int totalbiaya = 0;
        int jumlahbarang, hargabarang;
        for(int i = 0; i <jumlahbaris; i++){
            jumlahbarang = Integer.parseInt(jTable1.getValueAt(i, 2).toString());
            hargabarang = Integer.parseInt(jTable1.getValueAt (i, 3).toString());
            totalbiaya = totalbiaya + (jumlahbarang * hargabarang);
        }
        txttotal.setText(String.valueOf(totalbiaya));
    }
    
    public void loadData() {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.addRow(new Object[]{
//            txtnotrans.getText(),
            txtidbarang.getText(),
            txtnamabarang.getText(),
            txtjumlah.getText(),
            txtharga.getText(),
            txttotal.getText()
        });
    }
    public void kosong() {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
     
    public void utama () {
        txtnotrans.setText("");
        txtidbarang.setText("");
        txtnamabarang.setText("");
        txtharga.setText("");
        txtjumlah.setText("");
    }
    
    public void clear() {
        txtnotrans.setText("");
        txtnamacustomer.setText("");
        txtidcustomer.setText("");
        txttanggal_kirim.setDate(new java.util.Date());
        txtketerangan.setText("");
        txttotal.setText("0");
        txtbayar.setText("0");
        txtkembalian.setText("0");
    }
    
    public void clear2() {
        txtidbarang.setText("");
        txtnamabarang.setText("");
        txtharga.setText("");
        txtjumlah.setText("");
    }
    
    public void tambahtransaksi() {
        int jumlah, harga, total;

        jumlah = Integer.valueOf(txtjumlah.getText());
        harga = Integer.valueOf(txtharga.getText());
        total = jumlah * harga;

        txttotal.setText(String.valueOf(total));

        loadData();
        totalbiaya();
        clear2();
        txtidbarang.requestFocus();
    }
    
    public String generateNoFaktur() {
        String no_faktur;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        no_faktur = sdf.format(now);
        return no_faktur;
    }
    
    
    public menu_pemesanan() {
        initComponents();
        txtnotrans.setText(generateNoFaktur());
//        setPreferredSize(new Dimension(2000, 800));
        model = new DefaultTableModel();
        jTable1.setModel(model);
//        model.addColumn("No Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Subtotal");
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd"); 
        txttanggal.setText(s.format(date));
        txtketerangan.setText("");
        txttotal.setText("0");
        txtbayar.setText("0");
        txtkembalian.setText("0");
        txtidcustomer.requestFocus();
    }

    public void setIdBarang(String id_barang){
        txtidbarang.setText(id_barang);
    }
    
    public void setNamaBarang(String nama_barang){
        txtnamabarang.setText(nama_barang);
    }
    
    public void setHargaJual(String harga_jual){
        txtharga.setText(harga_jual);
    }
    
    public void setIdPelanggan(String id_pelanggan){
        txtidcustomer.setText(id_pelanggan);
    }
    
    public void setNamaPelanggan(String nama_pelanggan){
        txtnamacustomer.setText(nama_pelanggan);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_dasar = new javax.swing.JPanel();
        pn_tampiltransaksi = new javax.swing.JPanel();
        pn_transaksi = new javax.swing.JPanel();
        pn_yourshopping = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        pn_yourshopping1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pn_yourshopping2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        pn_yourshopping3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtkembalian = new javax.swing.JTextField();
        pn_transaksi1 = new javax.swing.JPanel();
        txtidbarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtnamabarang = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        btnDataBarang = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        pn_inputdata = new javax.swing.JPanel();
        panelShadow1 = new asset.PanelShadow();
        jLabel2 = new javax.swing.JLabel();
        txtnotrans = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnamacustomer = new javax.swing.JTextField();
        txtidcustomer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtketerangan = new javax.swing.JTextField();
        btnDataPelanggan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txttanggal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttanggal_kirim = new de.wannawork.jcalendar.JCalendarComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 619));

        pn_dasar.setBackground(new java.awt.Color(255, 255, 255));

        pn_tampiltransaksi.setBackground(new java.awt.Color(255, 255, 255));

        pn_transaksi.setBackground(new java.awt.Color(255, 255, 255));

        pn_yourshopping.setBackground(new java.awt.Color(255, 102, 102));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bayar");

        txtbayar.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtbayar.addActionListener(this::txtbayarActionPerformed);

        javax.swing.GroupLayout pn_yourshoppingLayout = new javax.swing.GroupLayout(pn_yourshopping);
        pn_yourshopping.setLayout(pn_yourshoppingLayout);
        pn_yourshoppingLayout.setHorizontalGroup(
            pn_yourshoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_yourshoppingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_yourshoppingLayout.setVerticalGroup(
            pn_yourshoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_yourshoppingLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_yourshoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pn_yourshopping1.setBackground(new java.awt.Color(7, 124, 165));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Your Shopping :");

        javax.swing.GroupLayout pn_yourshopping1Layout = new javax.swing.GroupLayout(pn_yourshopping1);
        pn_yourshopping1.setLayout(pn_yourshopping1Layout);
        pn_yourshopping1Layout.setHorizontalGroup(
            pn_yourshopping1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_yourshopping1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_yourshopping1Layout.setVerticalGroup(
            pn_yourshopping1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        pn_yourshopping2.setBackground(new java.awt.Color(9, 146, 194));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total");

        txttotal.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txttotal.setText("Rp.0");
        txttotal.setEnabled(false);

        javax.swing.GroupLayout pn_yourshopping2Layout = new javax.swing.GroupLayout(pn_yourshopping2);
        pn_yourshopping2.setLayout(pn_yourshopping2Layout);
        pn_yourshopping2Layout.setHorizontalGroup(
            pn_yourshopping2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_yourshopping2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_yourshopping2Layout.setVerticalGroup(
            pn_yourshopping2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_yourshopping2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_yourshopping2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pn_yourshopping3.setBackground(new java.awt.Color(0, 255, 0));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kembali");

        txtkembalian.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtkembalian.setEnabled(false);

        javax.swing.GroupLayout pn_yourshopping3Layout = new javax.swing.GroupLayout(pn_yourshopping3);
        pn_yourshopping3.setLayout(pn_yourshopping3Layout);
        pn_yourshopping3Layout.setHorizontalGroup(
            pn_yourshopping3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_yourshopping3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_yourshopping3Layout.setVerticalGroup(
            pn_yourshopping3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_yourshopping3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_yourshopping3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_transaksiLayout = new javax.swing.GroupLayout(pn_transaksi);
        pn_transaksi.setLayout(pn_transaksiLayout);
        pn_transaksiLayout.setHorizontalGroup(
            pn_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_transaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_yourshopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_yourshopping1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_yourshopping2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_yourshopping3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_transaksiLayout.setVerticalGroup(
            pn_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_transaksiLayout.createSequentialGroup()
                .addComponent(pn_yourshopping1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_yourshopping2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_yourshopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_yourshopping3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_transaksi1.setBackground(new java.awt.Color(255, 255, 255));

        txtidbarang.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtidbarang.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Barang"));
        txtidbarang.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        txtnamabarang.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtnamabarang.setBorder(javax.swing.BorderFactory.createTitledBorder("Nama Barang"));
        txtnamabarang.setEnabled(false);

        txtharga.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtharga.setBorder(javax.swing.BorderFactory.createTitledBorder("Harga"));
        txtharga.setEnabled(false);

        txtjumlah.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtjumlah.setBorder(javax.swing.BorderFactory.createTitledBorder("Jumlah"));

        btnDataBarang.setText("...");
        btnDataBarang.addActionListener(this::btnDataBarangActionPerformed);

        javax.swing.GroupLayout pn_transaksi1Layout = new javax.swing.GroupLayout(pn_transaksi1);
        pn_transaksi1.setLayout(pn_transaksi1Layout);
        pn_transaksi1Layout.setHorizontalGroup(
            pn_transaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_transaksi1Layout.createSequentialGroup()
                .addGroup(pn_transaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_transaksi1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnDataBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtharga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_transaksi1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pn_transaksi1Layout.setVerticalGroup(
            pn_transaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_transaksi1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_transaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_transaksi1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_transaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsimpan.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 12)); // NOI18N
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/diskette20x20.png"))); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.setMaximumSize(new java.awt.Dimension(90, 30));
        btnsimpan.setMinimumSize(new java.awt.Dimension(90, 30));
        btnsimpan.setPreferredSize(new java.awt.Dimension(90, 30));
        btnsimpan.addActionListener(this::btnsimpanActionPerformed);

        btntambah.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        btntambah.setText("+");
        btntambah.addActionListener(this::btntambahActionPerformed);

        btnhapus.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        btnhapus.setText("-");
        btnhapus.addActionListener(this::btnhapusActionPerformed);

        javax.swing.GroupLayout pn_tampiltransaksiLayout = new javax.swing.GroupLayout(pn_tampiltransaksi);
        pn_tampiltransaksi.setLayout(pn_tampiltransaksiLayout);
        pn_tampiltransaksiLayout.setHorizontalGroup(
            pn_tampiltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tampiltransaksiLayout.createSequentialGroup()
                .addGroup(pn_tampiltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_tampiltransaksiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_transaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tampiltransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btntambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnhapus)
                .addGap(40, 40, 40))
        );
        pn_tampiltransaksiLayout.setVerticalGroup(
            pn_tampiltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tampiltransaksiLayout.createSequentialGroup()
                .addGroup(pn_tampiltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tampiltransaksiLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(pn_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_tampiltransaksiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pn_transaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_tampiltransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnhapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_inputdata.setBackground(new java.awt.Color(255, 255, 255));

        panelShadow1.setBackground(new java.awt.Color(9, 146, 194));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No Transaksi");

        txtnotrans.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtnotrans.setEnabled(false);
        txtnotrans.addActionListener(this::txtnotransActionPerformed);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Customer");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Customer");

        txtnamacustomer.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N

        txtidcustomer.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtidcustomer.addActionListener(this::txtidcustomerActionPerformed);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Catatan");

        txtketerangan.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N

        btnDataPelanggan.setText("...");
        btnDataPelanggan.addActionListener(this::btnDataPelangganActionPerformed);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanggal Pengiriman");

        txttanggal.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txttanggal.addActionListener(this::txttanggalActionPerformed);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tanggal");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnotrans, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(txtidcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDataPelanggan))
                    .addComponent(txtnamacustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttanggal_kirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(467, 467, 467))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttanggal_kirim, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtidcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(btnDataPelanggan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnamacustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnotrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout pn_inputdataLayout = new javax.swing.GroupLayout(pn_inputdata);
        pn_inputdata.setLayout(pn_inputdataLayout);
        pn_inputdataLayout.setHorizontalGroup(
            pn_inputdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_inputdataLayout.setVerticalGroup(
            pn_inputdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_inputdataLayout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_tampiltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_inputdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_inputdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_tampiltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1377, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pn_dasar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pn_dasar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        String noFaktur = generateNoFaktur();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String no_faktur = noFaktur;
        String tanggal = txttanggal.getText();
        String id_pelanggan = txtidcustomer.getText();
        String nama_pelanggan = txtnamacustomer.getText();
        String bayar = txtbayar.getText();
        String total = txttotal.getText();
        String kembalian = txtkembalian.getText();
        String keterangan = txtketerangan.getText();
        String tanggal_pengiriman;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (txttanggal_kirim.getDate() != null) {
            tanggal_pengiriman = sdf.format(txttanggal_kirim.getDate());
        } else {
            tanggal_pengiriman = sdf.format(new java.util.Date());
        }
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO tb_pemesanan "
                    + "(no_faktur, id_pelanggan, nama_pelanggan, tanggal, "
                    + "tanggal_pengiriman, keterangan, bayar, total, kembalian) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, no_faktur);
            p.setString(2, id_pelanggan);
            p.setString(3, nama_pelanggan);
            p.setString(4, tanggal);
            p.setString(5, tanggal_pengiriman);
            p.setString(6, keterangan);
            p.setString(7, bayar);
            p.setString(8, total);
            p.setString(9, kembalian);
            p.executeUpdate();
            p.close();
            String sqlDetail = "INSERT INTO tb_detail_pemesanan "
                    + "(no_faktur, id_barang, nama_barang, jumlah, harga_jual) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pd = conn.prepareStatement(sqlDetail);
            for (int i = 0; i < model.getRowCount(); i++) {
                pd.setString(1, no_faktur);
                pd.setString(2, model.getValueAt(i, 0).toString());
                pd.setString(3, model.getValueAt(i, 1).toString());
                pd.setString(4, model.getValueAt(i, 2).toString());
                pd.setString(5, model.getValueAt(i, 3).toString());
                pd.executeUpdate();
            }
            pd.close();
            conn.commit();
            conn.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            clear();
            utama();
            kosong();
            txtnotrans.setText(generateNoFaktur());
        } catch (Exception e) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data!\n" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void txtnotransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnotransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnotransActionPerformed

    private void txtidcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcustomerActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        int total, bayar, kembalian;
        total = Integer.valueOf(txttotal.getText());
        bayar = Integer.valueOf(txtbayar.getText());
        if (total > bayar) {
            JOptionPane.showMessageDialog(this, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txtkembalian.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_txtbayarActionPerformed

    private void btnDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBarangActionPerformed
       pop_up_pelanggan datapelanggan = new pop_up_pelanggan(this);
       JDialog dialog = new JDialog(mu, "Cari Data Barang", true);
       datapelanggan.setDialog(dialog);
       dialog.setContentPane(datapelanggan);
       dialog.pack();
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_btnDataBarangActionPerformed

    private void btnDataPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPelangganActionPerformed
       pop_up_barang pelanggan = new pop_up_barang(this);
       JDialog dialog = new JDialog(mu, "Data Pelanggan", true);
       pelanggan.setDialog(dialog);
       dialog.setContentPane(pelanggan);
       dialog.pack();
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
    }//GEN-LAST:event_btnDataPelangganActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            model.removeRow(row);
        }
        totalbiaya();
        txtbayar.setText("0");
        txtkembalian.setText("0");
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        tambahtransaksi();
    }//GEN-LAST:event_btntambahActionPerformed

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataBarang;
    private javax.swing.JButton btnDataPelanggan;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private asset.PanelShadow panelShadow1;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_inputdata;
    private javax.swing.JPanel pn_tampiltransaksi;
    private javax.swing.JPanel pn_transaksi;
    private javax.swing.JPanel pn_transaksi1;
    private javax.swing.JPanel pn_yourshopping;
    private javax.swing.JPanel pn_yourshopping1;
    private javax.swing.JPanel pn_yourshopping2;
    private javax.swing.JPanel pn_yourshopping3;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtidcustomer;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtketerangan;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnamacustomer;
    private javax.swing.JTextField txtnotrans;
    private javax.swing.JTextField txttanggal;
    private de.wannawork.jcalendar.JCalendarComboBox txttanggal_kirim;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
