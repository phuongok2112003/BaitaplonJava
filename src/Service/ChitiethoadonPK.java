/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author X.Phuong
 */
@Embeddable
public class ChitiethoadonPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "SoHoaDon")
    private int soHoaDon;
    @Basic(optional = false)
    @Column(name = "MaSach")
    private int maSach;

    public ChitiethoadonPK() {
    }

    public ChitiethoadonPK(int soHoaDon, int maSach) {
        this.soHoaDon = soHoaDon;
        this.maSach = maSach;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) soHoaDon;
        hash += (int) maSach;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitiethoadonPK)) {
            return false;
        }
        ChitiethoadonPK other = (ChitiethoadonPK) object;
        if (this.soHoaDon != other.soHoaDon) {
            return false;
        }
        if (this.maSach != other.maSach) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.ChitiethoadonPK[ soHoaDon=" + soHoaDon + ", maSach=" + maSach + " ]";
    }
    
}
