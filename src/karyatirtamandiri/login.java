package karyatirtamandiri;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Koneksi.koneksi;
import java.awt.Color;

public class login extends javax.swing.JFrame {
    
    
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(login.class.getName());
    public login() {
        initComponents();
        k.connect();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_dasar = new javax.swing.JPanel();
        pn_judul = new javax.swing.JPanel();
        labelexit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_loggin = new asset.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pn_dasar.setBackground(new java.awt.Color(255, 255, 255));

        pn_judul.setBackground(new java.awt.Color(9, 146, 194));

        labelexit.setBackground(new java.awt.Color(255, 0, 0));
        labelexit.setForeground(new java.awt.Color(255, 255, 255));
        labelexit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelexit.setText("X");
        labelexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelexitMouseClicked(evt);
            }
        });
        labelexit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                labelexitKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Karya Tirta Mandiri");

        javax.swing.GroupLayout pn_judulLayout = new javax.swing.GroupLayout(pn_judul);
        pn_judul.setLayout(pn_judulLayout);
        pn_judulLayout.setHorizontalGroup(
            pn_judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_judulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelexit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pn_judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_judulLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(76, 76, 76)))
        );
        pn_judulLayout.setVerticalGroup(
            pn_judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_judulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelexit, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_judulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_judulLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pn_loggin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hello,");

        txt_username.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_username.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 13), new java.awt.Color(153, 153, 153))); // NOI18N
        txt_username.addActionListener(this::txt_usernameActionPerformed);

        txt_password.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 13), new java.awt.Color(153, 153, 153))); // NOI18N
        txt_password.addActionListener(this::txt_passwordActionPerformed);

        btnLogin.setBackground(new java.awt.Color(153, 153, 255));
        btnLogin.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/TAMBAHAN  JASA  DESIGN SABLON DTF SUBLIM TOTE BAG.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 3, 23)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Welcome");

        javax.swing.GroupLayout pn_logginLayout = new javax.swing.GroupLayout(pn_loggin);
        pn_loggin.setLayout(pn_logginLayout);
        pn_logginLayout.setHorizontalGroup(
            pn_logginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_logginLayout.createSequentialGroup()
                .addGroup(pn_logginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_logginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_logginLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_logginLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pn_logginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_logginLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_logginLayout.setVerticalGroup(
            pn_logginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_logginLayout.createSequentialGroup()
                .addGroup(pn_logginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_logginLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_logginLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_judul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_loggin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addComponent(pn_judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_loggin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String id_user="", role="", nama_user="";
        try{
            this.stat = k.connect().prepareStatement("SELECT * FROM tb_user WHERE username=? AND password=?"
            );
            stat.setString(1, txt_username.getText());
            stat.setString(2, txt_password.getText());

            this.rs = stat.executeQuery();
            while(rs.next()){
                nama_user =rs.getString("nama_user");
                role = rs.getString("role");
            }if(role.equals("")){
                JOptionPane.showMessageDialog(null, "Akun tidak ditemukan!");
            }else{
                dispose();
                menu_utama mu =new menu_utama();
                mu.setNama_user(nama_user);
                mu.setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void labelexitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelexitKeyPressed
        //        dispose();
    }//GEN-LAST:event_labelexitKeyPressed

    private void labelexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelexitMouseClicked
        this.dispose();
    }//GEN-LAST:event_labelexitMouseClicked

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setBackground(new Color (153,0,255));
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(new Color (153,153,255));
    }//GEN-LAST:event_btnLoginMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelexit;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_judul;
    private asset.PanelShadow pn_loggin;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
