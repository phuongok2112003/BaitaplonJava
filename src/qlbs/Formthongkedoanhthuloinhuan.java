/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qlbs;

import Service.Chitiethoadon;
import Service.Chitietphieumua;
import Service.Controller;
import Service.Doanhthu;
import Service.Hoadonban;
import Service.Phieumuasach;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author X.Phuong
 */
public class Formthongkedoanhthuloinhuan extends javax.swing.JFrame {

    LocalDateTime currentTime = LocalDateTime.now();
    int nam=currentTime.getYear();
   
      Controller<Hoadonban> hoadonban=new Controller<>(Hoadonban.class);
       Controller<Phieumuasach> phieumuasach=new Controller<>(Phieumuasach.class);
    
     DefaultTableModel model;
    public Formthongkedoanhthuloinhuan() {
        initComponents();
                for(int i=nam;i>=0;i--){
            cb_nam.addItem(i);
        }
        model=(DefaultTableModel) jTable1.getModel();

    }

    List<Doanhthu> getdata(int chosenam){
      
        List<Doanhthu> listthuchi = new ArrayList<>();
        List<Hoadonban> listhoadon = hoadonban.getAll().stream().filter(rootPane->
                rootPane.getNgayHoaDondate().getYear()==chosenam&&rootPane.getThanhToan()==true
        ).collect(Collectors.toList());

        Map<Integer, List<Hoadonban>> hoadonTheoThang = listhoadon.stream()
            .collect(Collectors.groupingBy(hoadon->
                   hoadon.getNgayHoaDondate().getMonthValue()
            ));
  
       Map<Integer, Long> doanhthuTheoThang = new HashMap<>();
        for (Map.Entry<Integer, List<Hoadonban>> entry : hoadonTheoThang.entrySet()) {
            int thang = entry.getKey();
            List<Hoadonban> hoadonsTrongThang = entry.getValue();
            long tongTienTrongThang = hoadonsTrongThang.stream()
                .mapToLong(Hoadonban::gettongtien)
                .sum();
            doanhthuTheoThang.put(thang, tongTienTrongThang);
        }
 
        List<Phieumuasach>listmuasach=phieumuasach.getAll().stream().filter(rootPane->
        rootPane.getNgaydate().getYear()==chosenam&&rootPane.getThanhToan()==true
        ).collect(Collectors.toList());
        
        Map<Integer,List<Phieumuasach>> phieumuaTheoThang=listmuasach.stream()
                .collect(Collectors.groupingBy(phieu->
                        phieu.getNgaydate().getMonthValue()
                ));
        
    Map<Integer, Long> chiphiTheoThang = new HashMap<>();
        for (Map.Entry<Integer, List<Phieumuasach>> entry : phieumuaTheoThang.entrySet()) {
            int thang = entry.getKey();
            List<Phieumuasach> phieumuaTrongThang = entry.getValue();
            long tongTienTrongThang = phieumuaTrongThang.stream()
                .mapToLong(Phieumuasach::gettongtien)
                .sum();
            chiphiTheoThang.put(thang, tongTienTrongThang);
        }
  
        List<Integer> allMonths = IntStream.rangeClosed(1, 12).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
       for (Integer month : allMonths) {
            long doanhThu = doanhthuTheoThang.getOrDefault(month, 0L);
            long chiPhi = chiphiTheoThang.getOrDefault(month, 0L);
            long loiNhuan = doanhThu - chiPhi;
            Doanhthu thuchi = new Doanhthu(month, doanhThu, chiPhi, loiNhuan);
            listthuchi.add(thuchi);
        }

        return listthuchi;
      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cb_nam = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        txt_tong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Thống Kế Lợi Nhuận");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tháng", "Doanh Thu", "Chi Phí", "Lợi nhuận"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        cb_nam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_namItemStateChanged(evt);
            }
        });

        jButton1.setText("Run");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_tong.setEnabled(false);

        jLabel1.setText("Tổng tiền");

        jButton2.setText("IN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)
                        .addGap(66, 66, 66)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(txt_tong, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_namItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_namItemStateChanged
       
    }//GEN-LAST:event_cb_namItemStateChanged
 public long calculateColumnTotal(JTable table, int columnIndex) {
        long total = 0;

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        
        for (int row = 0; row < rowCount; row++) {
            // Lấy giá trị từ mỗi ô trong cột được chỉ định và cộng vào tổng
            Object value = model.getValueAt(row, columnIndex);
            if (value instanceof Number) {
                total += ((Number) value).longValue();
            }
        }
        
        return total;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    model.setRowCount(0);
        String chose=cb_nam.getSelectedItem().toString();
       List<Doanhthu> list=getdata(Integer.parseInt(chose));
       for(Doanhthu a:list){
           model.addRow(new Object[]{a.getThang(),a.getDoanhthu(),a.getChiphi(),a.getLoinhuan()});
       }
       txt_tong.setText( String.valueOf(calculateColumnTotal(jTable1, 3)) );
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
            java.util.logging.Logger.getLogger(Formthongkedoanhthuloinhuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formthongkedoanhthuloinhuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formthongkedoanhthuloinhuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formthongkedoanhthuloinhuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formthongkedoanhthuloinhuan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_nam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_tong;
    // End of variables declaration//GEN-END:variables
}
