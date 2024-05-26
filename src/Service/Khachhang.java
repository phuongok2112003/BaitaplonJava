/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "khachhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khachhang.findAll", query = "SELECT k FROM Khachhang k"),
    @NamedQuery(name = "Khachhang.findByMaKH", query = "SELECT k FROM Khachhang k WHERE k.maKH = :maKH"),
    @NamedQuery(name = "Khachhang.findByTenKH", query = "SELECT k FROM Khachhang k WHERE k.tenKH = :tenKH"),
    @NamedQuery(name = "Khachhang.findByDiaChiKh", query = "SELECT k FROM Khachhang k WHERE k.diaChiKh = :diaChiKh"),
    @NamedQuery(name = "Khachhang.findByDienThoaiKH", query = "SELECT k FROM Khachhang k WHERE k.dienThoaiKH = :dienThoaiKH"),
    @NamedQuery(name = "Khachhang.findByNgaySinh", query = "SELECT k FROM Khachhang k WHERE k.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Khachhang.findByGioiTinh", query = "SELECT k FROM Khachhang k WHERE k.gioiTinh = :gioiTinh")})
public class Khachhang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaKH")
    private Integer maKH;
    @Column(name = "TenKH")
    private String tenKH;
    @Column(name = "DiaChiKh")
    private String diaChiKh;
    @Column(name = "DienThoaiKH")
    private String dienThoaiKH;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @OneToMany(mappedBy = "maKH")
    private Collection<Hoadonban> hoadonbanCollection;

    public Khachhang() {
    }

    public Khachhang(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChiKh() {
        return diaChiKh;
    }

    public void setDiaChiKh(String diaChiKh) {
        this.diaChiKh = diaChiKh;
    }

    public String getDienThoaiKH() {
        return dienThoaiKH;
    }

    public void setDienThoaiKH(String dienThoaiKH) {
        this.dienThoaiKH = dienThoaiKH;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @XmlTransient
    public Collection<Hoadonban> getHoadonbanCollection() {
        return hoadonbanCollection;
    }

    public void setHoadonbanCollection(Collection<Hoadonban> hoadonbanCollection) {
        this.hoadonbanCollection = hoadonbanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khachhang)) {
            return false;
        }
        Khachhang other = (Khachhang) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Khachhang[ maKH=" + maKH + " ]";
    }
    
}
