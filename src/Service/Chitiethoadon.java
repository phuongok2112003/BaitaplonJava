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
@Table(name = "chitiethoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitiethoadon.findAll", query = "SELECT c FROM Chitiethoadon c"),
    @NamedQuery(name = "Chitiethoadon.findBySoHoaDon", query = "SELECT c FROM Chitiethoadon c WHERE c.chitiethoadonPK.soHoaDon = :soHoaDon"),
    @NamedQuery(name = "Chitiethoadon.findByMaSach", query = "SELECT c FROM Chitiethoadon c WHERE c.chitiethoadonPK.maSach = :maSach"),
    @NamedQuery(name = "Chitiethoadon.findBySoLuong", query = "SELECT c FROM Chitiethoadon c WHERE c.soLuong = :soLuong")})
public class Chitiethoadon implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChitiethoadonPK chitiethoadonPK;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @JoinColumn(name = "SoHoaDon", referencedColumnName = "SoHoaDon", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hoadonban hoadonban;
    @JoinColumn(name = "MaSach", referencedColumnName = "MaSach", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sach sach;

    public Chitiethoadon() {
    }

    public Chitiethoadon(ChitiethoadonPK chitiethoadonPK) {
        this.chitiethoadonPK = chitiethoadonPK;
    }

    public Chitiethoadon(int soHoaDon, int maSach) {
        this.chitiethoadonPK = new ChitiethoadonPK(soHoaDon, maSach);
    }
    public String getinforChiTiet(){
        return hoadonban.getSoHoaDon().toString() ;
    }
    public ChitiethoadonPK getChitiethoadonPK() {
        return chitiethoadonPK;
    }

    public void setChitiethoadonPK(ChitiethoadonPK chitiethoadonPK) {
        this.chitiethoadonPK = chitiethoadonPK;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Hoadonban getHoadonban() {
        return hoadonban;
    }
    
    public void setHoadonban(Hoadonban hoadonban) {
        this.hoadonban = hoadonban;
    }

    public Sach getSach() {
        return sach;
    }
    public String getInfoSach(){
        return getSach().getMaSach().toString()+"-"+getSach().getTenSach().toString();
    }
    public void setSach(Sach sach) {
        this.sach = sach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chitiethoadonPK != null ? chitiethoadonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitiethoadon)) {
            return false;
        }
        Chitiethoadon other = (Chitiethoadon) object;
        if ((this.chitiethoadonPK == null && other.chitiethoadonPK != null) || (this.chitiethoadonPK != null && !this.chitiethoadonPK.equals(other.chitiethoadonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Chitiethoadon[ chitiethoadonPK=" + chitiethoadonPK + " ]";
    }
    
}
