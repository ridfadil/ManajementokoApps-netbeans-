
import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import static com.sun.webkit.perf.WCGraphicsPerfLogger.reset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class datakaryawan extends javax.swing.JFrame {
    Connection c = koneksi.koneksi.getConnection();
    DefaultTableModel model;
        int gaji;
        int gapok = 0;
        int hasil;
        int tunjangan = 0;
        int hitung=0;
        int hasilhitung = 0;
        String ambiljabatan;
        
    public datakaryawan() {
        initComponents();
        tampil_combo();
        setTabel();
        tabel2();
    }
    
    public void tampil_combo()
    {
        try {
            Connection con = koneksi.koneksi.getConnection();
            Statement stt = con.createStatement();
            String sql = "select NIK from  karyawan order by NIk asc";      
            ResultSet res = stt.executeQuery(sql);                               
                while(res.next()){
                    Object[] ob = new Object[3];
                    ob[0] = res.getString(1);

                    combobox.addItem(ob[0]);                                      
                }
            res.close(); stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void tampil()
    {
        try {
            Connection con = koneksi.koneksi.getConnection();
            Statement stt = con.createStatement();
            String sql = "select Nama, Jabatan from karyawan where NIK='"+combobox.getSelectedItem()+"'";  
            ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    Object[] ob = new Object[3];
                    ob[0]=  res.getString(1);
                    ob[1]= res.getString(2);
                    namacari.setText((String) ob[0]);
                    jabatancari.setText((String) ob[1]);
                }
            res.close(); stt.close();
         
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        gajipokok();
    }
    private void setTabel(){
        String field[]={"NIK","Nama","Alamat","jenis kelamin","jabatan"};
        model = new DefaultTableModel(null, field);
        tbl.setModel(model);
            try {
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery("select * from karyawan");
                    while(r.next()){
                        Object data[]={r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5)};
                        model.addRow(data);
                    }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
    }
    private void tabel2(){
        String field[]={"NIK","Total Gaji "};
        model = new DefaultTableModel(null, field);
        tblgaji.setModel(model);
            try {
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery("select NIK,gaji from karyawan where gaji is not null ");
                    while(r.next()){
                        Object data[]={r.getString(1),r.getString(2)};
                        model.addRow(data);
                    }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
    }
    public void gajipokok(){
        String pejabat=jabatancari.getText();
        switch (pejabat) {
            case "direktur":
                gapok = 12500000;
                tunjangan = 2000000;
                hitung = 200000;
                break;
            case "manager":
                gapok=82500000;
                tunjangan=1200000;
                hitung = 120000;
                break;
            case "supervisor":
                gapok=5000000;
                tunjangan = 1000000;
                hitung = 100000;
                break;
            case "staff":
                gapok=3550000;
                tunjangan = 800000;
                hitung = 80000;
                break;
            case "sales":
                gapok=3100000;
                tunjangan = 500000;
                hitung = 50000;
                break;
            case "kasir":
                gapok=3200000;
                hitung = 50000;
                tunjangan = 400000;
                break;
            }
        String tampilgapok = Integer.toString(gapok);
        gajipokokcari.setText(tampilgapok);
        }
        
    public void hitunggaji(){
        String Status = (String) status.getSelectedItem();
            if (Status .equals("menikah")){
                hasil= gapok + tunjangan;
            }
            else{
                hasil=gapok;
            }
        int jumlah = (Integer) lembur.getValue();
        if(jumlah<26 && jumlah>0) hasilhitung=hitung*jumlah;
        else JOptionPane.showMessageDialog(null,",Maaf jumlah lembur tidak sesuai");
        gaji= gapok+tunjangan+hasilhitung;
        int ubah;
        String tampil = Double.toString(gaji);
        String gajiquery = (String) combobox.getSelectedItem();
        //ke query
            try{         
                String sql = ("update karyawan set gaji=? where NIK = '"+gajiquery+"'");
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, tampil);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Tersimpan");
                tabel2();

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    public void reset2(){
        namacari.setText(null);
        jabatancari.setText(null);
        pencarian.setText(null);
        gajipokokcari.setText(null);
        tampilcari.setText(null);
        combobox.setSelectedItem("pilih");
        status.setSelectedItem("pilih");
        lembur.setValue(0);       
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
        JK = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        add = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jabatan = new javax.swing.JComboBox();
        caritxt = new javax.swing.JTextField();
        NIK = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        cari = new javax.swing.JButton();
        tampilin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        lembur = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        addcari = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblgaji = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        tampilcari = new javax.swing.JTextField();
        pencarian = new javax.swing.JTextField();
        hapustampil = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        resetcari = new javax.swing.JButton();
        tambahcari = new javax.swing.JButton();
        jabatancari = new javax.swing.JTextField();
        namacari = new javax.swing.JTextField();
        gajipokokcari = new javax.swing.JTextField();
        combobox = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(189, 195, 199));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("DATA KARYAWAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setText("Nama");

        jLabel3.setText("NIK");

        jLabel4.setText("Alamat");

        jLabel5.setText("JK");

        JK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih", "laki laki", "perempuan" }));
        JK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JKActionPerformed(evt);
            }
        });

        jLabel6.setText("Jabatan");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIK", "Nama", "Alamat", "JK", "Jabatan"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        add.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai simpan.png"))); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai sampah.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai update.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel7.setText("Search NIK");

        jabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih", "direktur", "manager", "supervisor", "staff", "sales", "kasir" }));

        NIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIKActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai reset.png"))); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        cari.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai search.png"))); // NOI18N
        cari.setText("Search");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        tampilin.setEditable(false);

        jButton1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai print.png"))); // NOI18N
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(NIK, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alamat)
                                    .addComponent(JK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tampilin, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(caritxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(NIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(JK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(caritxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addComponent(jLabel7)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(tampilin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        jLabel9.setText("Masukan NIK");

        jLabel10.setText("Nama");

        jLabel11.setText("Jabatan");

        jLabel12.setText("Gaji Pokok");

        jLabel14.setText("Status ");

        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih", "menikah", "belum menikah" }));

        jLabel16.setText("Jumlah Lembur");

        jLabel17.setText("Hari/Bulan");

        addcari.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        addcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai hitung gaji.png"))); // NOI18N
        addcari.setText("Add Salary");
        addcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcariActionPerformed(evt);
            }
        });

        tblgaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NIK", "TOTAL GAJI"
            }
        ));
        jScrollPane3.setViewportView(tblgaji);

        jLabel18.setText("Search NIK");

        tampilcari.setEditable(false);

        hapustampil.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        hapustampil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai sampah.png"))); // NOI18N
        hapustampil.setText("Delete");
        hapustampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapustampilActionPerformed(evt);
            }
        });

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai kembali_1.png"))); // NOI18N
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        resetcari.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        resetcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai reset.png"))); // NOI18N
        resetcari.setText("Reset");
        resetcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetcariActionPerformed(evt);
            }
        });

        tambahcari.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        tambahcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai search.png"))); // NOI18N
        tambahcari.setText("Search");
        tambahcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahcariActionPerformed(evt);
            }
        });

        jabatancari.setEditable(false);
        jabatancari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatancariActionPerformed(evt);
            }
        });

        namacari.setEditable(false);
        namacari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namacariActionPerformed(evt);
            }
        });

        gajipokokcari.setEditable(false);
        gajipokokcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gajipokokcariActionPerformed(evt);
            }
        });

        combobox.setMaximumRowCount(100);
        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih" }));
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(25, 25, 25)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jabatancari)
                                                    .addComponent(namacari)
                                                    .addComponent(gajipokokcari)
                                                    .addComponent(combobox, 0, 170, Short.MAX_VALUE))
                                                .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(lembur, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(164, 164, 164)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(239, 239, 239)
                                            .addComponent(jLabel18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(addcari, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(resetcari, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tampilcari, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(377, 377, 377)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tambahcari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hapustampil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(373, 373, 373))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel13))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tambahcari)
                                        .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(namacari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jabatancari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(gajipokokcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hapustampil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tampilcari, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(lembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addcari, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetcari, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(189, 195, 199));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel8.setText("HITUNG GAJI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(392, 392, 392))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

         try{
            String sql = "update karyawan set nama=?,alamat=?,jk=?,jabatan=? where NIK=?";
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, nama.getText());
            ps.setString(2, alamat.getText());
            ps.setString(3, (String) JK.getSelectedItem());
            ps.setString(4, (String) jabatan.getSelectedItem());
            ps.setString(5, NIK.getText());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Terubah");
            reset.doClick();
            setTabel();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String nik = NIK.getText();
        String Nama = nama.getText();
        String Alamat = alamat.getText();
        String jk = (String) JK.getSelectedItem();
        String jab = (String) jabatan.getSelectedItem();
        if(nik.isEmpty()||Nama.isEmpty()||Alamat.isEmpty()||jk.isEmpty()||jab.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Maf Data masih ada yang kosong");
        }
        else{
            try{
               String sql = "insert into karyawan(NIK,nama,alamat,jk,jabatan) values(?,?,?,?,?)";
               PreparedStatement ps = c.prepareStatement(sql);
               ps.setString(1, NIK.getText());
               ps.setString(2, nama.getText());
               ps.setString(3, alamat.getText());
               ps.setString(4, (String) JK.getSelectedItem());
               ps.setString(5, (String) jabatan.getSelectedItem());
               ps.executeUpdate();

               JOptionPane.showMessageDialog(null, "Data Tersimpan");
               setTabel();
               tampil_combo();
           }
           catch (SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
        }
    }//GEN-LAST:event_addActionPerformed

    private void JKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JKActionPerformed

    }//GEN-LAST:event_JKActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed

    new menuadmin().setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_kembaliActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

            this.setLocationRelativeTo(null);

    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            String sql = "delete from karyawan where NIK=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, caritxt.getText());
            ps.executeUpdate();
            reset.doClick();
            setTabel();
            tabel2();
            tampilin.setText("");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        NIK.setText(null);
        nama.setText(null);
        alamat.setText(null);
        JK.setSelectedItem("pilih");
        jabatan.setSelectedItem("pilih");
        caritxt.setText(null);
    }//GEN-LAST:event_resetActionPerformed

    private void addcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcariActionPerformed
        hitunggaji();
        reset2();
    }//GEN-LAST:event_addcariActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        String data=caritxt.getText();
        try {
            Statement s=c.createStatement();
            ResultSet r = s.executeQuery("select * from karyawan where NIK = '"+data+"'");
                while(r.next()){
                    String tampil1=r.getString(1);
                    String tampil2=r.getString(2);
                    String tampil3=r.getString(3);
                    String tampil4=r.getString(4);
                    String tampil5=r.getString(5);
                   tampilin.setText("Nama : "+tampil2+", asal : "+tampil3+", JK : "+tampil4+", jabatan : "+tampil5);
                }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }     
        
    }//GEN-LAST:event_cariActionPerformed

    private void jabatancariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatancariActionPerformed


    }//GEN-LAST:event_jabatancariActionPerformed

    private void namacariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namacariActionPerformed

    }//GEN-LAST:event_namacariActionPerformed

    private void gajipokokcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gajipokokcariActionPerformed
        gajipokok();
    }//GEN-LAST:event_gajipokokcariActionPerformed

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        tampil_combo();
        tampil();
    }//GEN-LAST:event_comboboxActionPerformed

    private void NIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIKActionPerformed

    }//GEN-LAST:event_NIKActionPerformed

    private void resetcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetcariActionPerformed
        reset2();
    }//GEN-LAST:event_resetcariActionPerformed

    private void tambahcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahcariActionPerformed
        String data=pencarian.getText();
        try {
            Statement s=c.createStatement();
            ResultSet r = s.executeQuery("select * from karyawan where NIK = '"+data+"'");
            
            while(r.next()){
                String tampil1=r.getString(1);
                String tampil6=r.getString(6);
                tampilcari.setText("NIK : "+tampil1+", Gaji : "+tampil6+"");
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }  
    }//GEN-LAST:event_tambahcariActionPerformed

    private void hapustampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapustampilActionPerformed
       String gajian=null;
       try{         
            String sql = ("update karyawan set gaji=? where NIK = '"+pencarian.getText()+"'");
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, gajian);
            ps.executeUpdate();
            tabel2();
            reset2(); 
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_hapustampilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Map<String,Object> param=new HashMap<String,Object>();
        try {
            String reportSource = System.getProperty("user.dir")+"\\src\\print\\karyawan.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param,c);
            JasperViewer.viewReport(jasperPrint,false);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datakaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JK;
    private javax.swing.JTextField NIK;
    private javax.swing.JButton add;
    private javax.swing.JButton addcari;
    private javax.swing.JTextField alamat;
    private javax.swing.JButton cari;
    private javax.swing.JTextField caritxt;
    private javax.swing.JComboBox combobox;
    private javax.swing.JTextField gajipokokcari;
    private javax.swing.JButton hapustampil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox jabatan;
    private javax.swing.JTextField jabatancari;
    private javax.swing.JButton kembali;
    private javax.swing.JSpinner lembur;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField namacari;
    private javax.swing.JTextField pencarian;
    private javax.swing.JButton reset;
    private javax.swing.JButton resetcari;
    private javax.swing.JComboBox status;
    private javax.swing.JButton tambahcari;
    private javax.swing.JTextField tampilcari;
    private javax.swing.JTextField tampilin;
    private javax.swing.JTable tbl;
    private javax.swing.JTable tblgaji;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
