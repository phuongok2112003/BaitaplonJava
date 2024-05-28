/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import Service.Nhanvien;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author X.Phuong
 */
public class Xuly {
    public static int layId(String a) {
        int id=-1;
        try{
           return Integer.parseInt(a.split("-")[0]);
        }catch(Exception e){
            return id;
        }
    }
     public static void selectComboBoxItem(String itemToSelect, JComboBox cb) {
        for (int i = 0; i < cb.getItemCount(); i++) {
            if (cb.getItemAt(i).equals(itemToSelect)) {
                cb.setSelectedIndex(i);
                break;
            }
        }
    }
     public static void mesLoi(Exception e,JFrame t){
           JOptionPane.showMessageDialog(t,e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
     }
     public static String calculateColumnTotal(JTable table, int columnIndex) {
        int rowCount = table.getRowCount();
        int total = 0;
        for (int i = 0; i < rowCount; i++) {
            Object value = table.getValueAt(i, columnIndex);
            if (value instanceof Number) {
                total += ((Number) value).intValue();
            } else {
                try {
                    total += Integer.parseInt(value.toString());
                } catch (NumberFormatException e) {
                    // Bỏ qua các giá trị không phải là số
                }
            }
        }
        return String.valueOf(total);
    }
}
