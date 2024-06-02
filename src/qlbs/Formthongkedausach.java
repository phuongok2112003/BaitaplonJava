/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qlbs;

import Service.Chitiethoadon;
import Service.Controller;
import Service.Hoadonban;
import Service.Phieumuasach;
import Service.Sach;
import Service.Soluongsachban;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author X.Phuong
 */
public class Formthongkedausach extends javax.swing.JFrame {

    DefaultTableModel model;
    Controller<Hoadonban> hoadonban=new Controller<>(Hoadonban.class);
    Controller<Sach> sach=new Controller<>(Sach.class);
    public Formthongkedausach() {
        initComponents();
        model=(DefaultTableModel) jTable1.getModel();
    }

    List<Soluongsachban> getdata(int thang,int nam){
         List<Soluongsachban> result=new ArrayList<>();
         List<Hoadonban> listhoadon=hoadonban.getAll().stream().filter(a->
         a.getNgayHoaDondate().getYear()==nam&& a.getNgayHoaDondate().getMonthValue()==thang&&a.getThanhToan()==true
         ).collect(Collectors.toList());
         
         
       List<Chitiethoadon> listchitiethoadon=new ArrayList<>();
       listhoadon.forEach(hoadon -> listchitiethoadon.addAll(hoadon.getChitiethoadonCollection()));
       
       
            Map<Integer,List<Chitiethoadon>> soluongsachTheoThang=listchitiethoadon.stream()
                .collect(Collectors.groupingBy(phieu->
                       phieu.getSach().getMaSach()
                ));
       
        for (Map.Entry<Integer, List<Chitiethoadon>> entry : soluongsachTheoThang.entrySet()) {      
            int masach = entry.getKey();
            Sach sach1=sach.findById(masach);
            
            List<Chitiethoadon> hoadonsTrongThang = entry.getValue();
            long tongTienTrongThang = hoadonsTrongThang.stream()
                .mapToLong(Chitiethoadon::gettongtien)
                .sum();
            int tongsoluong=hoadonsTrongThang.stream()
                .mapToInt(Chitiethoadon::getSoLuong)
                .sum();
            Soluongsachban soluong1=new Soluongsachban(
                    masach,sach1.getTenSach(),
                    tongsoluong,tongTienTrongThang,(long)tongsoluong*tongTienTrongThang);
           result.add(soluong1);
        }
         
         
         
         return result;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_thang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Thống Kế Đầu Sách");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng", "Giá bán", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Tháng");

        jLabel2.setText("Năm");

        jButton1.setText("run");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("IN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jButton1)
                .addGap(45, 45, 45)
                .addComponent(jButton2)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!txt_nam.getText().isEmpty()&&!txt_thang.getText().isEmpty()){
            model.setRowCount(0);
            int thang=Integer.parseInt(txt_thang.getText());
            int nam=Integer.parseInt(txt_nam.getText());
            List<Soluongsachban> soluong=getdata(thang, nam);
            for(Soluongsachban a :soluong){
                model.addRow(new Object[]{a.getMasach(),a.getTensach(),a.getSoluong(),a.getGiaban(),a.getThanhtien()});
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Formthongkedausach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formthongkedausach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formthongkedausach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formthongkedausach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formthongkedausach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_nam;
    private javax.swing.JTextField txt_thang;
    // End of variables declaration//GEN-END:variables
}
