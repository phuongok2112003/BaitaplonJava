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
public class Soluongsachban {
    int masach;
    String tensach;
    int soluong;
    Long giaban;
    Long thanhtien;

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Long getGiaban() {
        return giaban;
    }

    public void setGiaban(Long giaban) {
        this.giaban = giaban;
    }

    public Long getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Long thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Soluongsachban(int masach, String tensach, int soluong, Long giaban, Long thanhtien) {
        this.masach = masach;
        this.tensach = tensach;
        this.soluong = soluong;
        this.giaban = giaban;
        this.thanhtien = thanhtien;
    }
}
