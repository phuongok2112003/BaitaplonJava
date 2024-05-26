/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "sach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sach.findAll", query = "SELECT s FROM Sach s"),
    @NamedQuery(name = "Sach.findByMaSach", query = "SELECT s FROM Sach s WHERE s.maSach = :maSach"),
    @NamedQuery(name = "Sach.findByTenSach", query = "SELECT s FROM Sach s WHERE s.tenSach = :tenSach"),
    @NamedQuery(name = "Sach.findByTheLoai", query = "SELECT s FROM Sach s WHERE s.theLoai = :theLoai"),
    @NamedQuery(name = "Sach.findByTacgia", query = "SELECT s FROM Sach s WHERE s.tacgia = :tacgia"),
    @NamedQuery(name = "Sach.findByNxb", query = "SELECT s FROM Sach s WHERE s.nxb = :nxb"),
    @NamedQuery(name = "Sach.findByGiaBan", query = "SELECT s FROM Sach s WHERE s.giaBan = :giaBan"),
    @NamedQuery(name = "Sach.findByNamXB", query = "SELECT s FROM Sach s WHERE s.namXB = :namXB"),
    @NamedQuery(name = "Sach.findBySoLuong", query = "SELECT s FROM Sach s WHERE s.soLuong = :soLuong")})
public class Sach implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSach")
    private Integer maSach;
    @Column(name = "TenSach")
    private String tenSach;
    @Column(name = "TheLoai")
    private String theLoai;
    @Column(name = "Tacgia")
    private String tacgia;
    @Column(name = "NXB")
    private String nxb;
    @Column(name = "GiaBan")
    private Long giaBan;
    @Column(name = "NamXB")
    private Integer namXB;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sach")
    private Collection<Chitietphieumua> chitietphieumuaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sach")
    private Collection<Chitiethoadon> chitiethoadonCollection;

    public Sach() {
    }

    public Sach(Integer maSach) {
        this.maSach = maSach;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getNamXB() {
        return namXB;
    }

    public void setNamXB(Integer namXB) {
        this.namXB = namXB;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @XmlTransient
    public Collection<Chitietphieumua> getChitietphieumuaCollection() {
        return chitietphieumuaCollection;
    }

    public void setChitietphieumuaCollection(Collection<Chitietphieumua> chitietphieumuaCollection) {
        this.chitietphieumuaCollection = chitietphieumuaCollection;
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
        hash += (maSach != null ? maSach.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sach)) {
            return false;
        }
        Sach other = (Sach) object;
        if ((this.maSach == null && other.maSach != null) || (this.maSach != null && !this.maSach.equals(other.maSach))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Sach[ maSach=" + maSach + " ]";
    }
    
}
