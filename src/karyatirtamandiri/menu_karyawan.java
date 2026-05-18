package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;

public class menu_karyawan extends javax.swing.JPanel {
    
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public menu_karyawan() {
        initComponents();
        txt_idkaryawan.setText(generateIdKaryawan());
        k.connect();
        refreshTable();
    }
    
    public String generateIdKaryawan() {
        String idKaryawan = "KRY001";
        try {
            String sql = "SELECT id_karyawan FROM tb_karyawan ORDER BY id_karyawan ASC";
            this.stat = k.connect().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            int nomor = 1;
            while (rs.next()) {
                String id = rs.getString("id_karyawan");
                int angkaDatabase = Integer.parseInt(id.substring(3));
                if (angkaDatabase != nomor) {
                    break;
                }
                nomor++;
            }
            idKaryawan = String.format("KRY%03d", nomor);
        } catch (Exception e) {
            System.out.println("Generate ID Error : " + e.getMessage());
        }
        return idKaryawan;
    }
    
    public void kosong(){
        txt_idkaryawan.setText("");
        txt_namakaryawan.setText("");
        txt_tempatlahir.setText("");
        tanggal_lahir.setDate(null);
        combo_jeniskelamin.setSelectedItem(0);
        txt_alamat.setText("");
        txt_notelepon.setText("");
        combo_status_bekerja.setSelectedItem(0);
        combo_status.setSelectedItem(0);
        tanggal_bergabung.setDate(null);
        txt_nomorrekening.setText("");
        txt_namabank.setText("");
        txt_nama_kontak_darurat.setText("");
        txt_no_telepon_darurat.setText("");
        combo_hubungan.setSelectedItem(0);
    }
    
    public void cariData() {
        DefaultTableModel model = (DefaultTableModel) tabel_karyawan1.getModel();
        model.setRowCount(0); 

        try {
            String sql = "SELECT * FROM tb_karyawan WHERE id_karyawan LIKE ? OR nama_karyawan LIKE ?";
            PreparedStatement stat = k.connect().prepareStatement(sql);

            stat.setString(1, "%" + tCari.getText() + "%");
            stat.setString(2, "%" + tCari.getText() + "%");

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_karyawan"),
                    rs.getString("nama_karyawan"),
                    rs.getString("tempat_lahir"),
                    rs.getDate("tanggal_lahir"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("alamat"),
                    rs.getString("nomor_telepon"),
                    rs.getString("status_bekerja"),
                    rs.getString("status"),
                    rs.getDate("tanggal_bergabung"),
                    rs.getString("nomor_rekening"),
                    rs.getString("bank"),
                    rs.getString("nama_kontak_darurat"),
                    rs.getString("nomor_telepon_darurat"),
                    rs.getString("hubungan")
                };

                model.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Alamat");
        model.addColumn("No Telepon");
        model.addColumn("Status Kerja");
        model.addColumn("Status");
        model.addColumn("Tanggal Bergabung");
        model.addColumn("Nomor Rekening");
        model.addColumn("Bank");
        model.addColumn("Nama Kontak");
        model.addColumn("Nomor Kontak");
        model.addColumn("Hubungan");
        tabel_karyawan1.setModel(model);
        try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_karyawan");
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
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15)
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

        pn_dasar = new javax.swing.JPanel();
        pn_data_pengemudi = new javax.swing.JPanel();
        judul = new asset.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        data_identitas_pribadi = new javax.swing.JPanel();
        txt_idkaryawan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_namakaryawan = new javax.swing.JTextField();
        txt_tempatlahir = new javax.swing.JTextField();
        tanggal_lahir = new de.wannawork.jcalendar.JCalendarComboBox();
        combo_jeniskelamin = new javax.swing.JComboBox<>();
        txt_alamat = new javax.swing.JTextField();
        tabel_karyawan = new javax.swing.JScrollPane();
        tabel_karyawan1 = new javax.swing.JTable();
        data_legalitas = new javax.swing.JPanel();
        txt_notelepon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        data_keanggotaan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        combo_status_bekerja = new javax.swing.JComboBox<>();
        tanggal_bergabung = new de.wannawork.jcalendar.JCalendarComboBox();
        combo_status = new javax.swing.JComboBox<>();
        data_keuangan = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_nomorrekening = new javax.swing.JTextField();
        txt_namabank = new javax.swing.JTextField();
        data_keuangan1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_nama_kontak_darurat = new javax.swing.JTextField();
        txt_no_telepon_darurat = new javax.swing.JTextField();
        combo_hubungan = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        pn_dasar.setBackground(new java.awt.Color(255, 255, 255));

        pn_data_pengemudi.setBackground(new java.awt.Color(255, 255, 255));

        judul.setBackground(new java.awt.Color(9, 146, 194));
        judul.setShadowSize(2);
        judul.setShadowType(asset.ShadowType.BOT_RIGHT);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Karyawan");

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

        javax.swing.GroupLayout pn_data_pengemudiLayout = new javax.swing.GroupLayout(pn_data_pengemudi);
        pn_data_pengemudi.setLayout(pn_data_pengemudiLayout);
        pn_data_pengemudiLayout.setHorizontalGroup(
            pn_data_pengemudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_data_pengemudiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
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

        txt_idkaryawan.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_idkaryawan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Karyawan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setText("Data Identitas Pribadi");

        txt_namakaryawan.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_namakaryawan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama Lengkap", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_namakaryawan.addActionListener(this::txt_namakaryawanActionPerformed);

        txt_tempatlahir.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_tempatlahir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tempat Lahir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_tempatlahir.addActionListener(this::txt_tempatlahirActionPerformed);

        tanggal_lahir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanggal Lahir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        combo_jeniskelamin.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        combo_jeniskelamin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jenis Kelamin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        txt_alamat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_alamat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alamat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_alamat.addActionListener(this::txt_alamatActionPerformed);

        javax.swing.GroupLayout data_identitas_pribadiLayout = new javax.swing.GroupLayout(data_identitas_pribadi);
        data_identitas_pribadi.setLayout(data_identitas_pribadiLayout);
        data_identitas_pribadiLayout.setHorizontalGroup(
            data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                        .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_namakaryawan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_idkaryawan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggal_lahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(combo_jeniskelamin, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txt_alamat)
                    .addComponent(txt_tempatlahir))
                .addContainerGap())
        );
        data_identitas_pribadiLayout.setVerticalGroup(
            data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_idkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_namakaryawan)
                    .addComponent(combo_jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_alamat)
                .addContainerGap())
        );

        tabel_karyawan1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_karyawan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_karyawan1MouseClicked(evt);
            }
        });
        tabel_karyawan.setViewportView(tabel_karyawan1);

        data_legalitas.setBackground(new java.awt.Color(255, 255, 255));
        data_legalitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_notelepon.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_notelepon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No Telepon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("Data Kontak");

        javax.swing.GroupLayout data_legalitasLayout = new javax.swing.GroupLayout(data_legalitas);
        data_legalitas.setLayout(data_legalitasLayout);
        data_legalitasLayout.setHorizontalGroup(
            data_legalitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_legalitasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_legalitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_legalitasLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_notelepon))
                .addContainerGap())
        );
        data_legalitasLayout.setVerticalGroup(
            data_legalitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_legalitasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_notelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_keanggotaan.setBackground(new java.awt.Color(255, 255, 255));
        data_keanggotaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setText("Data Keanggotaan");

        combo_status_bekerja.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_status_bekerja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tetap", "Kontrak" }));
        combo_status_bekerja.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status Bekerja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        tanggal_bergabung.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanggal Bergabung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        combo_status.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Nonaktif" }));
        combo_status.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        javax.swing.GroupLayout data_keanggotaanLayout = new javax.swing.GroupLayout(data_keanggotaan);
        data_keanggotaan.setLayout(data_keanggotaanLayout);
        data_keanggotaanLayout.setHorizontalGroup(
            data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keanggotaanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggal_bergabung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(data_keanggotaanLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(data_keanggotaanLayout.createSequentialGroup()
                        .addComponent(combo_status_bekerja, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        data_keanggotaanLayout.setVerticalGroup(
            data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keanggotaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_status)
                    .addComponent(combo_status_bekerja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggal_bergabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_keuangan.setBackground(new java.awt.Color(255, 255, 255));
        data_keuangan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel11.setText("Data Keuangan");

        txt_nomorrekening.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_nomorrekening.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nomor Rekening", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        txt_namabank.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_namabank.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama Bank", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        javax.swing.GroupLayout data_keuanganLayout = new javax.swing.GroupLayout(data_keuangan);
        data_keuangan.setLayout(data_keuanganLayout);
        data_keuanganLayout.setHorizontalGroup(
            data_keuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keuanganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_keuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txt_nomorrekening, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_namabank)
                .addContainerGap())
        );
        data_keuanganLayout.setVerticalGroup(
            data_keuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keuanganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(data_keuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nomorrekening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_namabank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_keuangan1.setBackground(new java.awt.Color(255, 255, 255));
        data_keuangan1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel12.setText("Kontak Darurat");

        txt_nama_kontak_darurat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_nama_kontak_darurat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        txt_no_telepon_darurat.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_no_telepon_darurat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No Telepon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_no_telepon_darurat.addActionListener(this::txt_no_telepon_daruratActionPerformed);

        combo_hubungan.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_hubungan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pasangan", "Orangtua", "Adik", "Kakak", "Teman" }));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel13.setText("Hubungan");

        javax.swing.GroupLayout data_keuangan1Layout = new javax.swing.GroupLayout(data_keuangan1);
        data_keuangan1.setLayout(data_keuangan1Layout);
        data_keuangan1Layout.setHorizontalGroup(
            data_keuangan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keuangan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_keuangan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_keuangan1Layout.createSequentialGroup()
                        .addGroup(data_keuangan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(data_keuangan1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 89, Short.MAX_VALUE))
                            .addComponent(txt_nama_kontak_darurat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_no_telepon_darurat, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(data_keuangan1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(combo_hubungan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        data_keuangan1Layout.setVerticalGroup(
            data_keuangan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keuangan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(data_keuangan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nama_kontak_darurat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_no_telepon_darurat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_hubungan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

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

        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_data_pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 864, Short.MAX_VALUE))
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabel_karyawan)
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addComponent(data_identitas_pribadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data_legalitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data_keanggotaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data_keuangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data_keuangan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)))
                .addGap(20, 20, 20))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_data_pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addComponent(data_legalitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_keanggotaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(data_identitas_pribadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addComponent(data_keuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_keuangan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabel_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        add(pn_dasar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namakaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namakaryawanActionPerformed
    }//GEN-LAST:event_txt_namakaryawanActionPerformed

    private void txt_tempatlahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tempatlahirActionPerformed
    }//GEN-LAST:event_txt_tempatlahirActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String idKaryawan = generateIdKaryawan();
        try{
            this.stat = k.connect().prepareStatement("INSERT INTO tb_karyawan (\n" +
            "    id_karyawan,\n" +
            "    nama_karyawan,\n" +
            "    tempat_lahir,\n" +
            "    tanggal_lahir,\n" +
            "    jenis_kelamin,\n" +
            "    alamat,\n" +
            "    nomor_telepon,\n" +
            "    status_bekerja,\n" +
            "    status,\n" +
            "    tanggal_bergabung,\n" +
            "    nomor_rekening,\n" +
            "    bank,\n" +
            "    nama_kontak_darurat,\n" +
            "    nomor_telepon_darurat,\n" +
            "    hubungan\n" +
            ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stat.setString(1, idKaryawan);
            stat.setString(2, txt_namakaryawan.getText());
            stat.setString(3, txt_tempatlahir.getText());
            stat.setDate(4, new java.sql.Date(tanggal_lahir.getDate().getTime()));
            stat.setString(5, combo_jeniskelamin.getSelectedItem().toString());
            stat.setString(6, txt_alamat.getText());
            stat.setString(7, txt_notelepon.getText());
            stat.setString(8, combo_status_bekerja.getSelectedItem().toString());
            stat.setString(9, combo_status.getSelectedItem().toString());
            stat.setDate(10, new java.sql.Date(tanggal_bergabung.getDate().getTime()));
            stat.setString(11, txt_nomorrekening.getText());
            stat.setString(12, txt_namabank.getText());
            stat.setString(13, txt_nama_kontak_darurat.getText());
            stat.setString(14, txt_no_telepon_darurat.getText());
            stat.setString(15, combo_hubungan.getSelectedItem().toString());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tabel_karyawan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_karyawan1MouseClicked
       txt_idkaryawan.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),0).toString());
       txt_namakaryawan.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),1).toString());
       txt_tempatlahir.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),2).toString());
       try {
            String tanggallahir = tabel_karyawan1.getValueAt(tabel_karyawan1.getSelectedRow(), 3).toString();
            java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(tanggallahir);
            tanggal_lahir.setDate(date);
       } catch (Exception e) {
           e.printStackTrace();
       }
       combo_jeniskelamin.setSelectedItem(model.getValueAt(tabel_karyawan1.getSelectedRow(),4).toString());
       txt_alamat.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),5).toString());
       txt_notelepon.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),6).toString());
       combo_status_bekerja.setSelectedItem(model.getValueAt(tabel_karyawan1.getSelectedRow(),7).toString());
       combo_status.setSelectedItem(model.getValueAt(tabel_karyawan1.getSelectedRow(),8).toString());
       try {
            String tanggalbergabung = tabel_karyawan1.getValueAt(tabel_karyawan1.getSelectedRow(), 9).toString();
            java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(tanggalbergabung);
            tanggal_bergabung.setDate(date);
       } catch (Exception e) {
           e.printStackTrace();
       }
       txt_nomorrekening.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),10).toString());
       txt_namabank.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),11).toString());
       txt_nama_kontak_darurat.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),12).toString());
       txt_no_telepon_darurat.setText(model.getValueAt(tabel_karyawan1.getSelectedRow(),13).toString());
       combo_hubungan.setSelectedItem(model.getValueAt(tabel_karyawan1.getSelectedRow(), 14).toString());
       
       
    }//GEN-LAST:event_tabel_karyawan1MouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try{
            stat = k.connect().prepareStatement(
                "UPDATE tb_karyawan SET " +
                "nama_karyawan=?, tempat_lahir=?, tanggal_lahir=?, " +
                "jenis_kelamin=?, alamat=?, nomor_telepon=?,  " +
                "status_bekerja=?, status=?, tanggal_bergabung=?,  " +
                "nomor_rekening=?, bank=?, nama_kontak_darurat=?, nomor_telepon_darurat=?, hubungan=? " +
                "WHERE id_karyawan=?"
            );

            stat.setString(1, txt_namakaryawan.getText());
            stat.setString(2, txt_tempatlahir.getText());
            stat.setDate(3, new java.sql.Date(tanggal_lahir.getDate().getTime()));
            stat.setString(4, combo_jeniskelamin.getSelectedItem().toString());
            stat.setString(5, txt_alamat.getText());
            stat.setString(6, txt_notelepon.getText());
            stat.setString(7, combo_status_bekerja.getSelectedItem().toString());
            stat.setString(8, combo_status.getSelectedItem().toString());
            stat.setDate(9, new java.sql.Date(tanggal_bergabung.getDate().getTime()));
            stat.setString(10, txt_nomorrekening.getText());
            stat.setString(11, txt_namabank.getText());
            stat.setString(12, txt_nama_kontak_darurat.getText());
            stat.setString(13, txt_no_telepon_darurat.getText());
            stat.setString(14, combo_hubungan.getSelectedItem().toString());
            stat.setString(15, txt_idkaryawan.getText());

            stat.executeUpdate();
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            this.stat = k.connect().prepareStatement("DELETE FROM tb_karyawan WHERE id_karyawan=?");
            stat.setString(1, txt_idkaryawan.getText());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        kosong();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyPressed
        cariData();
    }//GEN-LAST:event_tCariKeyPressed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariData();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txt_no_telepon_daruratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_no_telepon_daruratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_no_telepon_daruratActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> combo_hubungan;
    private javax.swing.JComboBox<String> combo_jeniskelamin;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JComboBox<String> combo_status_bekerja;
    private javax.swing.JPanel data_identitas_pribadi;
    private javax.swing.JPanel data_keanggotaan;
    private javax.swing.JPanel data_keuangan;
    private javax.swing.JPanel data_keuangan1;
    private javax.swing.JPanel data_legalitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private asset.PanelShadow judul;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_data_pengemudi;
    private javax.swing.JTextField tCari;
    private javax.swing.JScrollPane tabel_karyawan;
    private javax.swing.JTable tabel_karyawan1;
    private de.wannawork.jcalendar.JCalendarComboBox tanggal_bergabung;
    private de.wannawork.jcalendar.JCalendarComboBox tanggal_lahir;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_idkaryawan;
    private javax.swing.JTextField txt_nama_kontak_darurat;
    private javax.swing.JTextField txt_namabank;
    private javax.swing.JTextField txt_namakaryawan;
    private javax.swing.JTextField txt_no_telepon_darurat;
    private javax.swing.JTextField txt_nomorrekening;
    private javax.swing.JTextField txt_notelepon;
    private javax.swing.JTextField txt_tempatlahir;
    // End of variables declaration//GEN-END:variables
}
