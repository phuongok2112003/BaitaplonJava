/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbs;
import Service.Controller;
import Service.Chitietphieumua;
import Service.Sach;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class FormChiTietPhieuMua extends javax.swing.JFrame {

    /**
     * Creates new form FormChiTietPhieuMua
     */
    Controller<Chitietphieumua> ketNoi_CTPM = new Controller<>(Chitietphieumua.class);
    Controller<Sach> ketNoi_Sach = new Controller<>(Sach.class);
    DefaultTableModel model;
    public FormChiTietPhieuMua() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
    }
    
    void loadData() {
        //ketNoi_CTPM.loaddata(model, new String[] {})
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoPhieu = new javax.swing.JTextField();
        cboMaSach = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGiaMua = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHI TIẾT PHIẾU MUA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Số phiếu");

        txtSoPhieu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSoPhieu.setEnabled(false);

        cboMaSach.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã sách");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Giá mua");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Số lượng");

        txtGiaMua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số phiếu", "Mã - Tên sách", "Giá mua", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoPhieu)
                            .addComponent(cboMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(188, 188, 188)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaMua)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(32, 32, 32)
                .addComponent(btnSua)
                .addGap(28, 28, 28)
                .addComponent(btnXoa)
                .addGap(37, 37, 37)
                .addComponent(btnClear)
                .addGap(106, 106, 106))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa)
                    .addComponent(btnClear)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        Phieumuasach pms = new Phieumuasach();
//
//        pms.setNgay(dtpNgayGiaoDich.getDate());
//        pms.setTenNCC(txtTenNCC.getText());
//
//        Object selectedMaNV = cboMaNV.getSelectedItem();
//        if (selectedMaNV != null) {
//            String selectedValue = selectedMaNV.toString();
//            String[] parts = selectedValue.split(" - ");
//            if (parts.length >= 1) {
//                try {
//                    int maNV = Integer.parseInt(parts[0]);
//                    Nhanvien nhanVien = new Nhanvien(maNV); // Tạo một đối tượng Nhanvien mới với maNV
//                    pms.setMaNV(nhanVien);
//                } catch (NumberFormatException e) {
//                    JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                    return; // Dừng lại nếu có lỗi
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Dữ liệu nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                return; // Dừng lại nếu không có mã nhân viên hợp lệ được chọn
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            return; // Dừng lại nếu không có mã nhân viên được chọn
//        }
//
//        pms.setThanhToan(false);
//
//        ketNoi_PMS.addSv(pms);
//        clear();
//        loadData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
//        if (txtSoPhieu.getText() != null) {
//            Phieumuasach pms = new Phieumuasach();
//            pms.setSoPhieu(Integer.parseInt(txtSoPhieu.getText()));
//            pms.setNgay(dtpNgayGiaoDich.getDate());
//            pms.setTenNCC(txtTenNCC.getText());
//
//            Object selectedMaNV = cboMaNV.getSelectedItem();
//            if (selectedMaNV != null) {
//                String selectedValue = selectedMaNV.toString();
//                String[] parts = selectedValue.split(" - ");
//                if (parts.length >= 1) {
//                    try {
//                        int maNV = Integer.parseInt(parts[0]);
//                        Nhanvien nhanVien = new Nhanvien(maNV); // Tạo một đối tượng Nhanvien mới với maNV
//                        pms.setMaNV(nhanVien);
//                    } catch (NumberFormatException e) {
//                        JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                        return; // Dừng lại nếu có lỗi
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Dữ liệu nhân viên không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                    return; // Dừng lại nếu không có mã nhân viên hợp lệ được chọn
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Vui lòng chọn mã nhân viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                return; // Dừng lại nếu không có mã nhân viên được chọn
//            }
//
//            boolean thanhToan = (boolean) jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getColumnCount() - 1);
//            pms.setThanhToan(thanhToan);
//
//            ketNoi_PMS.sua(pms);
//            clear();
//            loadData();
//        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//        if (txtSoPhieu.getText() != null) {
//            ketNoi_PMS.xoa(txtSoPhieu.getText());
//            clear();
//            loadData();
//        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
//        clear();
//        loadData();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormChiTietPhieuMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormChiTietPhieuMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormChiTietPhieuMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormChiTietPhieuMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormChiTietPhieuMua().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboMaSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtGiaMua;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoPhieu;
    // End of variables declaration//GEN-END:variables
}