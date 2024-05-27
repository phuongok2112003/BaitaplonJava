/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class DateUtils {
    public static Date parseDate(String dateString) {
        String format = "dd-MM-yyyy";   
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            
            return formatter.parse(dateString);
        } catch (ParseException e) {
            // Xử lý ngoại lệ nếu có lỗi khi chuyển đổi
            JOptionPane.showMessageDialog(null, "Invalid date format.");
            return null;
        }
    }
    
}
