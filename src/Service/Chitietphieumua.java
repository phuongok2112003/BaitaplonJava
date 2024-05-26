/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "chitietphieumua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitietphieumua.findAll", query = "SELECT c FROM Chitietphieumua c"),
    @NamedQuery(name = "Chitietphieumua.findBySoPhieu", query = "SELECT c FROM Chitietphieumua c WHERE c.chitietphieumuaPK.soPhieu = :soPhieu"),
    @NamedQuery(name = "Chitietphieumua.findByMaSach", query = "SELECT c FROM Chitietphieumua c WHERE c.chitietphieumuaPK.maSach = :maSach"),
    @NamedQuery(name = "Chitietphieumua.findBySoLuong", query = "SELECT c FROM Chitietphieumua c WHERE c.soLuong = :soLuong"),
    @NamedQuery(name = "Chitietphieumua.findByGiaMua", query = "SELECT c FROM Chitietphieumua c WHERE c.giaMua = :giaMua")})
public class Chitietphieumua implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChitietphieumuaPK chitietphieumuaPK;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Column(name = "GiaMua")
    private Long giaMua;
    @JoinColumn(name = "SoPhieu", referencedColumnName = "SoPhieu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phieumuasach phieumuasach;
    @JoinColumn(name = "MaSach", referencedColumnName = "MaSach", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sach sach;

    public Chitietphieumua() {
    }

    public Chitietphieumua(ChitietphieumuaPK chitietphieumuaPK) {
        this.chitietphieumuaPK = chitietphieumuaPK;
    }

    public Chitietphieumua(int soPhieu, int maSach) {
        this.chitietphieumuaPK = new ChitietphieumuaPK(soPhieu, maSach);
    }

    public ChitietphieumuaPK getChitietphieumuaPK() {
        return chitietphieumuaPK;
    }

    public void setChitietphieumuaPK(ChitietphieumuaPK chitietphieumuaPK) {
        this.chitietphieumuaPK = chitietphieumuaPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Long getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(Long giaMua) {
        this.giaMua = giaMua;
    }

    public Phieumuasach getPhieumuasach() {
        return phieumuasach;
    }

    public void setPhieumuasach(Phieumuasach phieumuasach) {
        this.phieumuasach = phieumuasach;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chitietphieumuaPK != null ? chitietphieumuaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitietphieumua)) {
            return false;
        }
        Chitietphieumua other = (Chitietphieumua) object;
        if ((this.chitietphieumuaPK == null && other.chitietphieumuaPK != null) || (this.chitietphieumuaPK != null && !this.chitietphieumuaPK.equals(other.chitietphieumuaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Chitietphieumua[ chitietphieumuaPK=" + chitietphieumuaPK + " ]";
    }
    
}
