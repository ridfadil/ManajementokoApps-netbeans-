
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class datatransaksi extends javax.swing.JFrame {
    Connection c = koneksi.koneksi.getConnection();
    DefaultTableModel model;
    int datastok;
    int harga;
    int hasil;

    public datatransaksi() {
        initComponents();
        setTabel();
        tampil_combo();
    }
    
    public void reset(){
        tanggal.setCalendar(null);
        nama_pelanggan.setText(null);
        nomor_ktp.setText(null);
        kode_barang.setSelectedItem(null);
        quantity.setValue(0);
        cicilan.setSelectedItem(null);
        total.setText(null);
        merk.setText(null);
        tampilharga.setText(null);
        cari.setText(null);
        tampilin.setText(null);
        stok.setText(null); 
        uang_muka.setText(null);
    }
    
    public void tampil_combo()
    {
        try {
        Connection con = koneksi.koneksi.getConnection();
        Statement stt = con.createStatement();
        String sql = "select kode_barang from  barang order by kode_barang asc";      
        ResultSet res = stt.executeQuery(sql);                                
            while(res.next()){
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);

                kode_barang.addItem(ob[0]);                                     
            }
        res.close(); stt.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil(){
            
        try {
            Connection con = koneksi.koneksi.getConnection();
            Statement stt = con.createStatement();
            String sql = "select quantity_barang, harga_barang,merk_barang from barang where kode_barang ='"+kode_barang.getSelectedItem()+"'";  
            ResultSet res = stt.executeQuery(sql);

            while(res.next()){
                Object[] ob = new Object[4];
                ob[0]=  res.getString(1);
                ob[1]= res.getString(2);
                ob[2]= res.getString(3);

                String tampilstok = res.getString(1);
                String hargatampil = res.getString(2);


                stok.setText(tampilstok);
                tampilharga.setText(hargatampil);
                merk.setText((String) ob [2]);

                datastok = Integer.parseInt(res.getString(1));
                harga  = Integer.parseInt(res.getString(2));

            }
            res.close(); stt.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }       
    }    

    private void setTabel(){
        String field[]={"No Transaksi","tanggal","Nama","No Ktp","Kode Barang","Quantity","cicilan","Uang Muka","Bayar Perbulan"};
        model = new DefaultTableModel(null, field);
        tbl.setModel(model);
            try {
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery("select * from transaksikredit");

                while(r.next()){
                    Object data[]={r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),
                                  r.getString(6),r.getString(7),r.getString(8),r.getString(9)};
                    model.addRow(data);
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"salah");
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nama_pelanggan = new javax.swing.JTextField();
        uang_muka = new javax.swing.JTextField();
        nomor_ktp = new javax.swing.JTextField();
        quantity = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        tampilin = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        cicilan = new javax.swing.JComboBox();
        kode_barang = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        tampilharga = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        stok = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        merk = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("DATA TRANSAKSI KREDIT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Quantity");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel3.setText("Kode Barang");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jLabel4.setText("Nomor KTP");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jLabel5.setText("Nama Pelanggan");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jLabel6.setText("Uang Muka");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel7.setText("Cicilan");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        jLabel8.setText("bayar perbulan");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));
        jPanel2.add(nama_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 244, -1));

        uang_muka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uang_mukaActionPerformed(evt);
            }
        });
        jPanel2.add(uang_muka, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 250, -1));
        jPanel2.add(nomor_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 244, -1));
        jPanel2.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 52, -1));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Transaksi", "Nama", "No.  KTP", "Kode Barang", "Quantity", "Cicilan", "Uang muka", "Bayar perbulan"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 990, 101));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai kembali_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 562, 150, 40));

        jLabel9.setText("Search Nomor KTP");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 463, -1, -1));

        tambah.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai simpan.png"))); // NOI18N
        tambah.setText("ADD");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel2.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 370, 40));

        jButton3.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai sampah.png"))); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 210, 50));
        jPanel2.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 258, 20));

        tampilin.setEditable(false);
        jPanel2.add(tampilin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 258, 51));

        jButton5.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai search.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 210, 30));

        jLabel11.setText("Tanggal");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));
        jPanel2.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 240, -1));

        jButton6.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai printer.png"))); // NOI18N
        jButton6.setText("PRINT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 330, 90));

        cicilan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih", "3 bulan", "6 bulan", "9 bulan", "12 bulan" }));
        cicilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cicilanActionPerformed(evt);
            }
        });
        jPanel2.add(cicilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 250, -1));

        kode_barang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        kode_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_barangActionPerformed(evt);
            }
        });
        jPanel2.add(kode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 240, -1));

        jLabel12.setText("Harga Satuan  ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 110, -1));

        tampilharga.setBackground(new java.awt.Color(255, 204, 204));
        tampilharga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel2.add(tampilharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 150, 30));

        jLabel13.setText("Stok Tersedia ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));

        stok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel2.add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 150, 30));

        jLabel14.setText("merk ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));

        merk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel2.add(merk, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 150, 30));

        total.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 250, 50));

        reset.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai reset.png"))); // NOI18N
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 286, 370, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 350, 150));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 270, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new menukasir().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);        
    }//GEN-LAST:event_formWindowOpened

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        int DP=0;
        java.util.Date tgl = (java.util.Date) this.tanggal.getDate();
        String nama = nama_pelanggan.getText();
        String ktp = nomor_ktp.getText();
        String kode = (String) kode_barang.getSelectedItem();
        int quantiti = (Integer) quantity.getValue();
        String cicil = (String) cicilan.getSelectedItem();
        String dp = uang_muka.getText();
        int uang = Integer.parseInt(dp);
        String jumlah = total.getText();
        //SIMPAN
        if(nama.isEmpty()|| kode.isEmpty()||ktp.isEmpty()||dp.isEmpty()||cicil.isEmpty()||uang>harga)
                {
                    JOptionPane.showMessageDialog(this, "data tidak sesuai");
                }
        else 
                {
                    DP = Integer.parseInt(dp);
                    //CICILAN    
                    if(cicil.equals("3 bulan")){
                        hasil=(((harga - DP)/3)+10000)*quantiti;
                    }
                    else if(cicil.equals("6 bulan")){
                        hasil=(((harga-DP)/6)+10000)*quantiti;
                    }
                    else if(cicil.equals("9 bulan")){
                        hasil=(((harga-DP)/9)+10000)*quantiti;
                    }
                    else if(cicil.equals("12 bulan")){
                        hasil=(((harga-DP)/12)+10000)*quantiti;
                    }
                    String Hasil = String.valueOf(hasil);
                    total.setText(Hasil);
                    //MENGENAI JUMLAH BARANG
                    if(quantiti>datastok || quantiti==0){
                        JOptionPane.showMessageDialog(rootPane, " Maaf jumlah quantiti tidak sesuai");
                    }
                    else{
                        //UPDATE QUANTITY
                        try{
                            int jum2 =(int) quantity.getValue();
                            int jum = datastok - jum2;
                            String sql = "update barang set quantity_barang = '"+jum+"' where kode_barang = '"+kode_barang.getSelectedItem()+"'" ;
                            PreparedStatement ps = c.prepareStatement(sql);
                            ps.executeUpdate();
                            setTabel();
                                String sql2 = "INSERT INTO transaksikredit (tanggal,namapelanggan,nomorktp,kodebarang,quantity,cicilan,uangmuka,total) VALUES('"+new java.sql.Date(tgl.getTime()).toString()+
                                "','"+nama+"','"+ktp+"','"+kode+"','"+quantiti+"','"+cicil+"','"+dp+"','"+hasil+"')";
                                java.sql.Connection conn;
                                conn = (java.sql.Connection)koneksi.koneksi.getConnection();
                                java.sql.PreparedStatement pst = conn.prepareStatement(sql2);
                                pst.execute();
                                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                        } 
                        catch (SQLException | HeadlessException e) {
                                JOptionPane.showMessageDialog(null, "error!");
                        }  
                    }    
                }
        setTabel();
    }//GEN-LAST:event_tambahActionPerformed

    private void kode_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_barangActionPerformed
        tampil();
    }//GEN-LAST:event_kode_barangActionPerformed

    private void uang_mukaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uang_mukaActionPerformed

    }//GEN-LAST:event_uang_mukaActionPerformed

    private void cicilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cicilanActionPerformed

    }//GEN-LAST:event_cicilanActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            String sql = "delete from transaksikredit where nomorktp = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cari.getText());
            ps.executeUpdate();
            
            cari.setText(null);
            setTabel();
            tampilin.setText("");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String data=cari.getText();
        try {
            Statement s=c.createStatement();
            ResultSet r = s.executeQuery("select * from transaksikredit where nomorktp = '"+data+"'");
            
            while(r.next()){
                String tampil1=r.getString(3);
                String tampil2=r.getString(5);
                tampilin.setText("Nama : "+tampil1+", Kode barang : "+tampil2+"");
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Map<String,Object> param=new HashMap<String,Object>();
        try {
            String reportSource = System.getProperty("user.dir")+"\\src\\print\\transaksikredit.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param,c);
            JasperViewer.viewReport(jasperPrint,false);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datatransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox cicilan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox kode_barang;
    private javax.swing.JLabel merk;
    private javax.swing.JTextField nama_pelanggan;
    private javax.swing.JTextField nomor_ktp;
    private javax.swing.JSpinner quantity;
    private javax.swing.JButton reset;
    private javax.swing.JLabel stok;
    private javax.swing.JButton tambah;
    private javax.swing.JLabel tampilharga;
    private javax.swing.JTextField tampilin;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTable tbl;
    private javax.swing.JLabel total;
    private javax.swing.JTextField uang_muka;
    // End of variables declaration//GEN-END:variables
}
