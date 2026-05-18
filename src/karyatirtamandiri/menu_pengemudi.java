package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.koneksi;

public class menu_pengemudi extends javax.swing.JPanel {
    
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public menu_pengemudi() {
        initComponents();
        txt_idpengemudi.setText(generateIdPengemudi());
        k.connect();
        refreshTable();
    }
    
    public String generateIdPengemudi() {
        String idPengemudi = "DR001";
        try {
            String sql = "SELECT id_pengemudi FROM tb_pengemudi ORDER BY id_pengemudi ASC";
            this.stat = k.connect().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            int nomor = 1;
            while (rs.next()) {
                String id = rs.getString("id_pengemudi");
                int angkaDatabase = Integer.parseInt(id.substring(3));
                if (angkaDatabase != nomor) {
                    break;
                }
                nomor++;
            }
            idPengemudi = String.format("DR%03d", nomor);
        } catch (Exception e) {
            System.out.println("Generate ID Error : " + e.getMessage());
        }
        return idPengemudi;
    }
    
    public void kosong(){
        txt_idpengemudi.setText("");
        txt_namapengemudi.setText("");
        txt_tempatlahir.setText("");
        tanggal_lahir.setDate(null);
        combo_jeniskelamin.setSelectedItem(0);
        txt_alamat.setText("");
        txt_notelepon.setText("");
        txt_nomor_sim.setText("");
        masa_berlaku.setDate(null);
        combo_status_bekerja.setSelectedItem(0);
        tanggal_bergabung.setDate(null);
        combo_status.setSelectedItem(0);
        txt_nomorrekening.setText("");
        txt_namabank.setText("");
        txt_nama_kontak_darurat.setText("");
        txt_no_telepon_darurat.setText("");
        combo_hubungan.setSelectedItem(0);
    }
    
    public void cariData() {
        DefaultTableModel model = (DefaultTableModel) tabel_pengemudi1.getModel();
        model.setRowCount(0); // kosongkan tabel

        try {
            String sql = "SELECT * FROM tb_pengemudi WHERE id_pengemudi LIKE ? OR nama_pengemudi LIKE ?";
            PreparedStatement stat = k.connect().prepareStatement(sql);

            stat.setString(1, "%" + tCari.getText() + "%");
            stat.setString(2, "%" + tCari.getText() + "%");

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_pengemudi"),
                    rs.getString("nama_pengemudi"),
                    rs.getString("tempat_lahir"),
                    rs.getDate("tanggal_lahir"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("alamat_pengemudi"),
                    rs.getString("nomor_telepon"),
                    rs.getString("nomor_sim"),
                    rs.getDate("masa_berlaku"),
                    rs.getString("status_kerja"),
                    rs.getDate("tanggal_bergabung"),
                    rs.getString("status_aktif"),
                    rs.getString("nomor_rekening"),
                    rs.getString("bank"),
                    rs.getString("nama_kontak_darurat"),
                    rs.getString("nomor_kontak_darurat"),
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
        model.addColumn("No SIM");
        model.addColumn("Masa Berlaku SIM");
        model.addColumn("Status Kerja");
        model.addColumn("Tanggal Bergabung");
        model.addColumn("Status");
        model.addColumn("Nomor Rekening");
        model.addColumn("Bank");
        model.addColumn("Nama Kontak");
        model.addColumn("Nomor Kontak");
        model.addColumn("Hubungan");
        tabel_pengemudi1.setModel(model);
        try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_pengemudi");
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
                    rs.getString(15),
                    rs.getString(16),
                    rs.getString(17)
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
        txt_idpengemudi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_namapengemudi = new javax.swing.JTextField();
        txt_tempatlahir = new javax.swing.JTextField();
        txt_notelepon = new javax.swing.JTextField();
        tanggal_lahir = new de.wannawork.jcalendar.JCalendarComboBox();
        combo_jeniskelamin = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JTextField();
        tabel_pengemudi = new javax.swing.JScrollPane();
        tabel_pengemudi1 = new javax.swing.JTable();
        data_legalitas = new javax.swing.JPanel();
        txt_nomor_sim = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        masa_berlaku = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel5 = new javax.swing.JLabel();
        data_keanggotaan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        combo_status_bekerja = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tanggal_bergabung = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel10 = new javax.swing.JLabel();
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
        tCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

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
        jLabel1.setText("Data Pengemudi");

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

        txt_idpengemudi.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_idpengemudi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Pengemudi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setText("Data Identitas Pribadi");

        txt_namapengemudi.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_namapengemudi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama Lengkap", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_namapengemudi.addActionListener(this::txt_namapengemudiActionPerformed);

        txt_tempatlahir.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_tempatlahir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Termpat Lahir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_tempatlahir.addActionListener(this::txt_tempatlahirActionPerformed);

        txt_notelepon.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_notelepon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No Telepon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N
        txt_notelepon.addActionListener(this::txt_noteleponActionPerformed);

        combo_jeniskelamin.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("Tanggal Lahir");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel7.setText("Jenis Kelamin");

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
                        .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_tempatlahir)
                            .addComponent(txt_namapengemudi)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_idpengemudi, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tanggal_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(combo_jeniskelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2)
                            .addComponent(txt_notelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_alamat))
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
                        .addComponent(txt_idpengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_namapengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(data_identitas_pribadiLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(data_identitas_pribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_notelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_alamat)
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
        tabel_pengemudi.setViewportView(tabel_pengemudi1);

        data_legalitas.setBackground(new java.awt.Color(255, 255, 255));
        data_legalitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_nomor_sim.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_nomor_sim.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nomor SIM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("Data Legalitas");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("Masa Berlaku");

        javax.swing.GroupLayout data_legalitasLayout = new javax.swing.GroupLayout(data_legalitas);
        data_legalitas.setLayout(data_legalitasLayout);
        data_legalitasLayout.setHorizontalGroup(
            data_legalitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_legalitasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_legalitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nomor_sim)
                    .addGroup(data_legalitasLayout.createSequentialGroup()
                        .addGroup(data_legalitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(data_legalitasLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(masa_berlaku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        data_legalitasLayout.setVerticalGroup(
            data_legalitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_legalitasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nomor_sim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masa_berlaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_keanggotaan.setBackground(new java.awt.Color(255, 255, 255));
        data_keanggotaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setText("Data Keanggotaan");

        combo_status_bekerja.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_status_bekerja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tetap", "Kontrak" }));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("Status Bekerja");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setText("Tanggal Bergabung");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel10.setText("Status");

        combo_status.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Nonaktif" }));

        javax.swing.GroupLayout data_keanggotaanLayout = new javax.swing.GroupLayout(data_keanggotaan);
        data_keanggotaan.setLayout(data_keanggotaanLayout);
        data_keanggotaanLayout.setHorizontalGroup(
            data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keanggotaanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addGroup(data_keanggotaanLayout.createSequentialGroup()
                        .addGroup(data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tanggal_bergabung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(combo_status_bekerja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        data_keanggotaanLayout.setVerticalGroup(
            data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keanggotaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(data_keanggotaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(data_keanggotaanLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_status_bekerja, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(data_keanggotaanLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
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
                    .addGroup(data_keuanganLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(data_keuanganLayout.createSequentialGroup()
                        .addComponent(txt_nomorrekening, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_namabank, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                .addContainerGap())
        );
        data_keuanganLayout.setVerticalGroup(
            data_keuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_keuanganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(27, 27, 27)
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

        combo_hubungan.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        combo_hubungan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Istri", "Ibu", "Adik", "Kakak", "Teman" }));

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
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_nama_kontak_darurat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combo_hubungan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_no_telepon_darurat, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(data_keuangan1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_hubungan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariKeyPressed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_data_pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 864, Short.MAX_VALUE))
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addComponent(data_identitas_pribadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data_legalitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data_keanggotaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data_keuangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data_keuangan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tabel_pengemudi, javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(data_identitas_pribadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_dasarLayout.createSequentialGroup()
                        .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dasarLayout.createSequentialGroup()
                                .addComponent(data_keuangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(data_keuangan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_dasarLayout.createSequentialGroup()
                                .addComponent(data_legalitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(data_keanggotaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSimpan)
                        .addComponent(btnUbah)
                        .addComponent(btnHapus)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCari)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabel_pengemudi, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        add(pn_dasar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namapengemudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namapengemudiActionPerformed
    }//GEN-LAST:event_txt_namapengemudiActionPerformed

    private void txt_tempatlahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tempatlahirActionPerformed
    }//GEN-LAST:event_txt_tempatlahirActionPerformed

    private void txt_noteleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noteleponActionPerformed
    }//GEN-LAST:event_txt_noteleponActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String idPengemudi = generateIdPengemudi();
        try{
            this.stat = k.connect().prepareStatement("INSERT INTO tb_pengemudi (\n" +
            "    id_pengemudi,\n" +
            "    nama_pengemudi,\n" +
            "    tempat_lahir,\n" +
            "    tanggal_lahir,\n" +
            "    jenis_kelamin,\n" +
            "    alamat_pengemudi,\n" +
            "    nomor_telepon,\n" +
            "    nomor_sim,\n" +
            "    masa_berlaku,\n" +
            "    status_kerja,\n" +
            "    tanggal_bergabung,\n" +
            "    status_aktif,\n" +
            "    nomor_rekening,\n" +
            "    bank,\n" +
            "    nama_kontak_darurat,\n" +
            "    nomor_kontak_darurat,\n" +
            "    hubungan\n" +
            ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stat.setString(1, idPengemudi);
            stat.setString(2, txt_namapengemudi.getText());
            stat.setString(3, txt_tempatlahir.getText());
            stat.setDate(4, new java.sql.Date(tanggal_lahir.getDate().getTime()));
            stat.setString(5, combo_jeniskelamin.getSelectedItem().toString());
            stat.setString(6, txt_alamat.getText());
            stat.setString(7, txt_notelepon.getText());
            stat.setString(8, txt_nomor_sim.getText());
            stat.setDate(9, new java.sql.Date(masa_berlaku.getDate().getTime()));
            stat.setString(10, combo_status_bekerja.getSelectedItem().toString());
           stat.setDate(11, new java.sql.Date(tanggal_bergabung.getDate().getTime()));
            stat.setString(12, combo_status.getSelectedItem().toString());
            stat.setString(13, txt_nomorrekening.getText());
            stat.setString(14, txt_namabank.getText());
            stat.setString(15, txt_nama_kontak_darurat.getText());
            stat.setString(16, txt_no_telepon_darurat.getText());
            stat.setString(17, combo_hubungan.getSelectedItem().toString());
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tabel_pengemudi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pengemudi1MouseClicked
       txt_idpengemudi.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),0).toString());
       txt_namapengemudi.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),1).toString());
       txt_tempatlahir.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),2).toString());
       try {
            String tanggallahir = tabel_pengemudi1.getValueAt(tabel_pengemudi1.getSelectedRow(), 3).toString();
            java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(tanggallahir);
            tanggal_lahir.setDate(date);
       } catch (Exception e) {
           e.printStackTrace();
       }
       combo_jeniskelamin.setSelectedItem(model.getValueAt(tabel_pengemudi1.getSelectedRow(),4).toString());
       txt_alamat.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),5).toString());
       txt_notelepon.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),6).toString());
       txt_nomor_sim.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),7).toString());
       try {
            String masaberlaku = tabel_pengemudi1.getValueAt(tabel_pengemudi1.getSelectedRow(), 8).toString();
            java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(masaberlaku);
            masa_berlaku.setDate(date);
       } catch (Exception e) {
           e.printStackTrace();
       }
       combo_status_bekerja.setSelectedItem(model.getValueAt(tabel_pengemudi1.getSelectedRow(),9).toString());
       try {
            String tanggalbergabung = tabel_pengemudi1.getValueAt(tabel_pengemudi1.getSelectedRow(), 10).toString();
            java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(tanggalbergabung);
            tanggal_bergabung.setDate(date);
       } catch (Exception e) {
           e.printStackTrace();
       }
       combo_status.setSelectedItem(model.getValueAt(tabel_pengemudi1.getSelectedRow(),11).toString());
       txt_nomorrekening.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),12).toString());
       txt_namabank.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),13).toString());
       txt_nama_kontak_darurat.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),14).toString());
       txt_no_telepon_darurat.setText(model.getValueAt(tabel_pengemudi1.getSelectedRow(),15).toString());
       combo_hubungan.setSelectedItem(model.getValueAt(tabel_pengemudi1.getSelectedRow(), 16).toString());
       
       
    }//GEN-LAST:event_tabel_pengemudi1MouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try{
            stat = k.connect().prepareStatement(
                "UPDATE tb_pengemudi SET " +
                "id_pengemudi=?, nama_pengemudi=?, tempat_lahir=?, tanggal_lahir=?, " +
                "jenis_kelamin=?, alamat_pengemudi=?, nomor_telepon=?, nomor_sim=?, " +
                "masa_berlaku=?, status_kerja=?, tanggal_bergabung=?, status_aktif=?, " +
                "nomor_rekening=?, bank=?, nama_kontak_darurat=?, nomor_kontak_darurat=?, hubungan=? " +
                "WHERE id_pengemudi=?"
            );

            stat.setString(1, txt_idpengemudi.getText());
            stat.setString(2, txt_namapengemudi.getText());
            stat.setString(3, txt_tempatlahir.getText());
            stat.setDate(4, new java.sql.Date(tanggal_lahir.getDate().getTime()));
            stat.setString(5, combo_jeniskelamin.getSelectedItem().toString());
            stat.setString(6, txt_alamat.getText());
            stat.setString(7, txt_notelepon.getText());
            stat.setString(8, txt_nomor_sim.getText());
            stat.setDate(9, new java.sql.Date(masa_berlaku.getDate().getTime()));
            stat.setString(10, combo_status_bekerja.getSelectedItem().toString());
            stat.setDate(11, new java.sql.Date(tanggal_bergabung.getDate().getTime()));
            stat.setString(12, combo_status.getSelectedItem().toString());
            stat.setString(13, txt_nomorrekening.getText());
            stat.setString(14, txt_namabank.getText());
            stat.setString(15, txt_nama_kontak_darurat.getText());
            stat.setString(16, txt_no_telepon_darurat.getText());
            stat.setString(17, combo_hubungan.getSelectedItem().toString());

            // parameter ke-18 (WHERE)
            stat.setString(18, txt_idpengemudi.getText());

            stat.executeUpdate();
            stat.executeUpdate();
            refreshTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            this.stat = k.connect().prepareStatement("DELETE FROM tb_pengemudi WHERE id_pengemudi=?");
            stat.setString(1, txt_idpengemudi.getText());
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private asset.PanelShadow judul;
    private de.wannawork.jcalendar.JCalendarComboBox masa_berlaku;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_data_pengemudi;
    private javax.swing.JTextField tCari;
    private javax.swing.JScrollPane tabel_pengemudi;
    private javax.swing.JTable tabel_pengemudi1;
    private de.wannawork.jcalendar.JCalendarComboBox tanggal_bergabung;
    private de.wannawork.jcalendar.JCalendarComboBox tanggal_lahir;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_idpengemudi;
    private javax.swing.JTextField txt_nama_kontak_darurat;
    private javax.swing.JTextField txt_namabank;
    private javax.swing.JTextField txt_namapengemudi;
    private javax.swing.JTextField txt_no_telepon_darurat;
    private javax.swing.JTextField txt_nomor_sim;
    private javax.swing.JTextField txt_nomorrekening;
    private javax.swing.JTextField txt_notelepon;
    private javax.swing.JTextField txt_tempatlahir;
    // End of variables declaration//GEN-END:variables
}
