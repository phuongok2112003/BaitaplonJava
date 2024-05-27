/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n"),
    @NamedQuery(name = "Nhanvien.findByMaNV", query = "SELECT n FROM Nhanvien n WHERE n.maNV = :maNV"),
    @NamedQuery(name = "Nhanvien.findByTenNV", query = "SELECT n FROM Nhanvien n WHERE n.tenNV = :tenNV"),
    @NamedQuery(name = "Nhanvien.findByNgaySinh", query = "SELECT n FROM Nhanvien n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nhanvien.findByGioiTinh", query = "SELECT n FROM Nhanvien n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Nhanvien.findByDiaChiNV", query = "SELECT n FROM Nhanvien n WHERE n.diaChiNV = :diaChiNV"),
    @NamedQuery(name = "Nhanvien.findByDienThoaiNV", query = "SELECT n FROM Nhanvien n WHERE n.dienThoaiNV = :dienThoaiNV")})
public class Nhanvien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNV")
    private Integer maNV;
    @Column(name = "TenNV")
    private String tenNV;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "DiaChiNV")
    private String diaChiNV;
    @Column(name = "DienThoaiNV")
    private String dienThoaiNV;
    @OneToMany(mappedBy = "maNhanVien")
    private Collection<Hoadonban> hoadonbanCollection;
    @OneToMany(mappedBy = "maNV")
    private Collection<Phieumuasach> phieumuasachCollection;

    public Nhanvien() {
    }

    public Nhanvien(Integer maNV) {
        this.maNV = maNV;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaySinh() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(ngaySinh);
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

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public String getDienThoaiNV() {
        return dienThoaiNV;
    }

    public void setDienThoaiNV(String dienThoaiNV) {
        this.dienThoaiNV = dienThoaiNV;
    }

    @XmlTransient
    public Collection<Hoadonban> getHoadonbanCollection() {
        return hoadonbanCollection;
    }

    public void setHoadonbanCollection(Collection<Hoadonban> hoadonbanCollection) {
        this.hoadonbanCollection = hoadonbanCollection;
    }

    @XmlTransient
    public Collection<Phieumuasach> getPhieumuasachCollection() {
        return phieumuasachCollection;
    }

    public void setPhieumuasachCollection(Collection<Phieumuasach> phieumuasachCollection) {
        this.phieumuasachCollection = phieumuasachCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Nhanvien[ maNV=" + maNV + " ]";
    }
    
}
