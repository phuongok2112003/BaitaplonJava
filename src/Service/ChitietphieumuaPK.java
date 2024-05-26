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
public class ChitietphieumuaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "SoPhieu")
    private int soPhieu;
    @Basic(optional = false)
    @Column(name = "MaSach")
    private int maSach;

    public ChitietphieumuaPK() {
    }

    public ChitietphieumuaPK(int soPhieu, int maSach) {
        this.soPhieu = soPhieu;
        this.maSach = maSach;
    }

    public int getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(int soPhieu) {
        this.soPhieu = soPhieu;
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
        hash += (int) soPhieu;
        hash += (int) maSach;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitietphieumuaPK)) {
            return false;
        }
        ChitietphieumuaPK other = (ChitietphieumuaPK) object;
        if (this.soPhieu != other.soPhieu) {
            return false;
        }
        if (this.maSach != other.maSach) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.ChitietphieumuaPK[ soPhieu=" + soPhieu + ", maSach=" + maSach + " ]";
    }
    
}
