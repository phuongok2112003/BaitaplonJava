/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

/**
 *
 * @author X.Phuong
 */
public class Doanhthu {
    int thang;
    Long doanhthu;
    Long chiphi;
    Long loinhuan;

    public Doanhthu(int thang, Long doanhthu, Long chiphi, Long loinhuan) {
        this.thang = thang;
        this.doanhthu = doanhthu;
        this.chiphi = chiphi;
        this.loinhuan = loinhuan;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public Long getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(Long doanhthu) {
        this.doanhthu = doanhthu;
    }

    public Long getChiphi() {
        return chiphi;
    }

    public void setChiphi(Long chiphi) {
        this.chiphi = chiphi;
    }

    public Long getLoinhuan() {
        return loinhuan;
    }

    public void setLoinhuan(Long loinhuan) {
        this.loinhuan = loinhuan;
    }
    
    
}
