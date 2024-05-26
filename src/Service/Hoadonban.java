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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "hoadonban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadonban.findAll", query = "SELECT h FROM Hoadonban h"),
    @NamedQuery(name = "Hoadonban.findBySoHoaDon", query = "SELECT h FROM Hoadonban h WHERE h.soHoaDon = :soHoaDon"),
    @NamedQuery(name = "Hoadonban.findByNgayHoaDon", query = "SELECT h FROM Hoadonban h WHERE h.ngayHoaDon = :ngayHoaDon"),
    @NamedQuery(name = "Hoadonban.findByThanhToan", query = "SELECT h FROM Hoadonban h WHERE h.thanhToan = :thanhToan")})
public class Hoadonban implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SoHoaDon")
    private Integer soHoaDon;
    @Column(name = "NgayHoaDon")
    @Temporal(TemporalType.DATE)
    private Date ngayHoaDon;
    @Column(name = "ThanhToan")
    private Boolean thanhToan;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne
    private Khachhang maKH;
    @JoinColumn(name = "MaNhanVien", referencedColumnName = "MaNV")
    @ManyToOne
    private Nhanvien maNhanVien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoadonban")
    private Collection<Chitiethoadon> chitiethoadonCollection;

    public Hoadonban() {
    }

    public Hoadonban(Integer soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Integer getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(Integer soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Date getNgayHoaDon() {
        return ngayHoaDon;
    }

    public void setNgayHoaDon(Date ngayHoaDon) {
        this.ngayHoaDon = ngayHoaDon;
    }

    public Boolean getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(Boolean thanhToan) {
        this.thanhToan = thanhToan;
    }

    public Khachhang getMaKH() {
        return maKH;
    }

    public void setMaKH(Khachhang maKH) {
        this.maKH = maKH;
    }

    public Nhanvien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Nhanvien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    @XmlTransient
    public Collection<Chitiethoadon> getChitiethoadonCollection() {
        return chitiethoadonCollection;
    }

    public void setChitiethoadonCollection(Collection<Chitiethoadon> chitiethoadonCollection) {
        this.chitiethoadonCollection = chitiethoadonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soHoaDon != null ? soHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadonban)) {
            return false;
        }
        Hoadonban other = (Hoadonban) object;
        if ((this.soHoaDon == null && other.soHoaDon != null) || (this.soHoaDon != null && !this.soHoaDon.equals(other.soHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Hoadonban[ soHoaDon=" + soHoaDon + " ]";
    }
    
}
