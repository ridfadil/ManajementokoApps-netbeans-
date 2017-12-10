
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class transaksitunai extends javax.swing.JFrame {
    Connection c = koneksi.koneksi.getConnection();
    DefaultTableModel model;
    int datastok;
    int harga;
    int pembayaran;
    int hasil;
    int uangkembali;
    int hasilbayar;

    public void reset(){
        tanggaltransaksi.setCalendar(null);
        namapembeli.setText(null);
        kodebarang.setSelectedItem(null);
        tquantity.setValue(0);
        tbayar.setText(null);
        merkbarang.setText(null);
        hargabarang.setText(null);
        cari.setText(null);
        kembalian.setText(null);
        tampilin.setText(null);
        quantitytersedia.setText(null);
        
    }
    
        public void reset2(){
        tanggaltransaksi.setCalendar(null);
        namapembeli.setText(null);
        kodebarang.setSelectedItem(null);
        tquantity.setValue(0);
        tbayar.setText(null);
        merkbarang.setText(null);
        hargabarang.setText(null);
        cari.setText(null);
        tampilin.setText(null);
        quantitytersedia.setText(null);
        
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

                    kodebarang.addItem(ob[0]);                                     
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
            String sql = "select quantity_barang, harga_barang,merk_barang from barang where kode_barang ='"+kodebarang.getSelectedItem()+"'";  
            ResultSet res = stt.executeQuery(sql);

                while(res.next()){
                    Object[] ob = new Object[4];
                    ob[0]=  res.getString(1);
                    ob[1]= res.getString(2);
                    ob[2]= res.getString(3);

                    String tampilstok = res.getString(1);
                    String hargatampil = res.getString(2);
                    String merk = res.getString(3);
                    quantitytersedia.setText(tampilstok);
                    hargabarang.setText(hargatampil);
                    merkbarang.setText(merk);
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
        String field[]={"No faktur","Nama","tanggal","kode barang","Quantity","bayar","kembali"};
        model = new DefaultTableModel(null, field);
        tbl.setModel(model);
        try {
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("select * from transaksitunai");
                while(r.next()){
                    Object data[]={r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7)};
                    model.addRow(data);
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public transaksitunai() {
        initComponents();
        tampil_combo();
        setTabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tanggaltransaksi = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kodebarang = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        quantitytersedia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hargabarang = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        merkbarang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tquantity = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        kembalian = new javax.swing.JLabel();
        tbayar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        namapembeli = new javax.swing.JTextField();
        cari = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        tampilin = new javax.swing.JTextField();
        cetak = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        printnama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(tanggaltransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 193, -1));

        jLabel3.setText("Tanggal Transaksi");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setText("Kode Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        kodebarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih" }));
        kodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodebarangActionPerformed(evt);
            }
        });
        jPanel1.add(kodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 190, -1));

        quantitytersedia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel2.setText("Harga Barang");

        jLabel7.setText("Quantity Tersedia");

        hargabarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel10.setText("Merk Barang");

        merkbarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62)
                        .addComponent(hargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(42, 42, 42)
                            .addComponent(quantitytersedia, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(merkbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(merkbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(hargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(quantitytersedia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel8.setText("Quantity");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(tquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 190, -1));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 855, 145));

        save.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai simpan.png"))); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 46));

        reset.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai reset.png"))); // NOI18N
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 220, 46));

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai search.png"))); // NOI18N
        search.setText("SEARCH NO FAKTUR");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 220, 30));

        jLabel11.setText("Bayar");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel13.setText("Uang Kembalian");

        kembalian.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        kembalian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addComponent(kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 367, -1));
        jPanel1.add(tbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 193, -1));

        jLabel16.setText("Nama Pembeli");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        namapembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namapembeliActionPerformed(evt);
            }
        });
        jPanel1.add(namapembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 193, -1));
        jPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 330, 30));

        delete.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai sampah.png"))); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 220, 50));

        tampilin.setEditable(false);
        jPanel1.add(tampilin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 330, 60));

        cetak.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai printer.png"))); // NOI18N
        cetak.setText("PRINT");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        jPanel1.add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 280, 50));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai kembali_1.png"))); // NOI18N
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        jPanel1.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 590, 130, 40));
        jPanel1.add(printnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 280, -1));

        jLabel5.setText("Masukan Nama yang ingin di print");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 280, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 904, 650));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("TRANSAKSI TUNAI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(349, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(297, 297, 297))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 904, 58));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        java.util.Date tgl = (java.util.Date) this.tanggaltransaksi.getDate();
        tanggaltransaksi.getCalendar();
        String nama = namapembeli.getText();
        String kode = (String) kodebarang.getSelectedItem();
        int quantiti = (int) tquantity.getValue();
        String bayaran = tbayar.getText();

        if(nama.isEmpty()|| kode.isEmpty()||bayaran.isEmpty()||quantiti<1)
            {
                JOptionPane.showMessageDialog(this, "data masih ada yang kosong");
            }
        else 
        {
            pembayaran  = Integer.parseInt(bayaran);
            //MENGENAI JUMLAH BARANG
            if(quantiti>datastok){
                JOptionPane.showMessageDialog(rootPane, " Maaf jumlah quantity yang di pesan melebihi stok");
            }
            else{
                hasilbayar=quantiti*harga;
                if(pembayaran < hasilbayar){
                JOptionPane.showMessageDialog(rootPane, " Maaf Uang Pembayaran Kurang,Mohon perhatikan Uang pembayaran atau  jumlah quantity");
                }
                //UPDATE QUANTITY
                else{
                    try{
                        int jum = datastok - quantiti;
                        uangkembali=pembayaran-hasilbayar;
                        String moneyback=Integer.toString(uangkembali);
                        String sql = "update barang set quantity_barang = '"+jum+"' where kode_barang = '"+kodebarang.getSelectedItem()+"'" ;
                        PreparedStatement ps = c.prepareStatement(sql);
                        ps.executeUpdate();
                        setTabel();
                            String sql2 = "INSERT INTO transaksitunai (nama_pembeli,tanggal_transaksi,kode_barang,quantity,bayar,kembali) VALUES('"+nama+"','"+new java.sql.Date(tgl.getTime()).toString()+
                            "','"+kode+"','"+quantiti+"','"+bayaran+"','"+uangkembali+"')";
                            java.sql.Connection conn;
                            conn = (java.sql.Connection)koneksi.koneksi.getConnection();
                            java.sql.PreparedStatement pst = conn.prepareStatement(sql2);
                            pst.execute();
                            kembalian.setText(moneyback);
                            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                            reset2();
                        } 
                    catch (SQLException | HeadlessException e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                }
            }   
        }
        setTabel();   
    }//GEN-LAST:event_saveActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String data=cari.getText();
        try {
            Statement s=c.createStatement();
            ResultSet r = s.executeQuery("select * from transaksitunai where nomor_faktur = '"+data+"'");
                while(r.next()){
                    String tampil1=r.getString(2);
                    String tampil2=r.getString(4);
                   tampilin.setText("Nama : "+tampil1+", Kode barang : "+tampil2+"");
                }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void namapembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namapembeliActionPerformed

    }//GEN-LAST:event_namapembeliActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try{
            String sql = "delete from transaksitunai where nomor_faktur = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cari.getText());
            ps.executeUpdate();
            cari.setText(null);
            setTabel();
            tampilin.setText("");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data error");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
    tampil();
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("namapembeli", printnama.getText());
                try {
                    String reportSource = System.getProperty("user.dir")+"\\src\\print\\transaksitunai.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param,c);
                    JasperViewer.viewReport(jasperPrint,false);
                    
                } 
                catch (Exception e) {
                    System.out.println(e);
                }
    }//GEN-LAST:event_cetakActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
    new menukasir().setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_kembaliActionPerformed

    private void kodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodebarangActionPerformed
        tampil();
    }//GEN-LAST:event_kodebarangActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null); 
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksitunai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton cetak;
    private javax.swing.JButton delete;
    private javax.swing.JLabel hargabarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel kembalian;
    private javax.swing.JComboBox kodebarang;
    private javax.swing.JLabel merkbarang;
    private javax.swing.JTextField namapembeli;
    private javax.swing.JTextField printnama;
    private javax.swing.JLabel quantitytersedia;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField tampilin;
    private com.toedter.calendar.JDateChooser tanggaltransaksi;
    private javax.swing.JTextField tbayar;
    private javax.swing.JTable tbl;
    private javax.swing.JSpinner tquantity;
    // End of variables declaration//GEN-END:variables
}
