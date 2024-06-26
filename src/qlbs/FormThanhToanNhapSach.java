/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbs;
import Service.Chitietphieumua;
import Service.Controller;
import Service.Phieumuasach;
import Service.Sach;
import java.util.Date;
import Utils.Xuly;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lenovo
 */
public class FormThanhToanNhapSach extends javax.swing.JFrame {

    /**
     * Creates new form FormThanhToanNhapSach
     */
    Controller<Phieumuasach> ketNoi_PMS = new Controller<>(Phieumuasach.class);
    Controller<Chitietphieumua> ketNoi_CTPM = new Controller<>(Chitietphieumua.class);
    Controller<Sach> ketNoi_Sach = new Controller<>(Sach.class);
    DefaultTableModel model;
    Phieumuasach phieumuasach;
    String soPhieu;
    String nhanVien;
    String nCC;
    Date ngayGiaoDich;
    List<Chitietphieumua> chiTietphieuMua;
    
    public FormThanhToanNhapSach(String so_phieu, String nhan_vien, 
            String nha_cung_cap, Date ngay_giao_dich) {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        
        this.soPhieu = so_phieu;
        txtSoPhieu.setText(so_phieu);
        
        this.nhanVien = nhan_vien;
        txtNhanVien.setText(nhan_vien);
        
        this.nCC = nha_cung_cap;
        txtNCC.setText(nha_cung_cap);
        
        this.ngayGiaoDich = ngay_giao_dich;
        dtpNgayGiaoDich.setDate(ngay_giao_dich);
        
        phieumuasach = ketNoi_PMS.findById(Integer.parseInt(so_phieu));
        
        chiTietphieuMua = ketNoi_CTPM.findByIdAll(Integer.parseInt(so_phieu));
        
        if(phieumuasach.getThanhToan()==true){
             btnThanhToan.setEnabled(false);
        }
        
        loadData();
    }
    
    void loadData() {
        ketNoi_CTPM.loaddataChitet(model, new String[] {"getMaSach", "getTenSach", 
            "getSoLuong", "getGiaMua", "tinhTongTien"}, soPhieu);
        
        tinhTongTien();
    }
    
    private void tinhTongTien() {
        double tongTien = 0.0;
        int rowCount = jTable1.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            Object value = jTable1.getValueAt(i, 4);
            if (value != null) {
                try {
                    tongTien += Double.parseDouble(value.toString());
                } catch (NumberFormatException e) {
                    Xuly.mesLoi(e, this);
                }
            }
        }

        txtTongTien.setText(String.format("%.2f", tongTien));
    }
    
    void tangSach(){
        for(Chitietphieumua ctpm : chiTietphieuMua){
            Sach kho = ketNoi_Sach.findById(ctpm.getSach().getMaSach());
            kho.setSoLuong(kho.getSoLuong() + ctpm.getSoLuong());
            ketNoi_Sach.sua(kho);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSoPhieu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNCC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtpNgayGiaoDich = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Thanh Toán Nhập Sách");
        setLocation(new java.awt.Point(500, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THANH TOÁN NHẬP SÁCH");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Số phiếu");

        txtSoPhieu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSoPhieu.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Nhân viên");

        txtNhanVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhanVien.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Nhà cung cấp");

        txtNCC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNCC.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Ngày giao dịch");

        dtpNgayGiaoDich.setEnabled(false);
        dtpNgayGiaoDich.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Tổng tiền");

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng", "Giá", "Tổng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtSoPhieu))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtpNgayGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(dtpNgayGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn muốn thanh toán?", 
                "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (result == JOptionPane.YES_OPTION) {
            phieumuasach.setThanhToan(true);
            ketNoi_PMS.sua(phieumuasach);
            btnThanhToan.setEnabled(false);
            tangSach();
            JOptionPane.showMessageDialog(this, "Thanh toán thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
     else {
        JOptionPane.showMessageDialog(this, "Thanh toán bị hủy", "Thông báo", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnThanhToanActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormThanhToanNhapSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThanhToanNhapSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThanhToanNhapSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThanhToanNhapSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThanhToanNhapSach().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private com.toedter.calendar.JDateChooser dtpNgayGiaoDich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNCC;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSoPhieu;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
