/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "taikhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taikhoan.findAll", query = "SELECT t FROM Taikhoan t"),
    @NamedQuery(name = "Taikhoan.findByTendangnhap", query = "SELECT t FROM Taikhoan t WHERE t.tendangnhap = :tendangnhap"),
    @NamedQuery(name = "Taikhoan.findByMatkhau", query = "SELECT t FROM Taikhoan t WHERE t.matkhau = :matkhau")})
public class Taikhoan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tendangnhap")
    private String tendangnhap;
    @Column(name = "matkhau")
    private String matkhau;

    public Taikhoan() {
    }

    public Taikhoan(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tendangnhap != null ? tendangnhap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taikhoan)) {
            return false;
        }
        Taikhoan other = (Taikhoan) object;
        if ((this.tendangnhap == null && other.tendangnhap != null) || (this.tendangnhap != null && !this.tendangnhap.equals(other.tendangnhap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Taikhoan[ tendangnhap=" + tendangnhap + " ]";
    }
    
}
