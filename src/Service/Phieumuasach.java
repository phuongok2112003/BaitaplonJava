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
@Table(name = "phieumuasach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieumuasach.findAll", query = "SELECT p FROM Phieumuasach p"),
    @NamedQuery(name = "Phieumuasach.findBySoPhieu", query = "SELECT p FROM Phieumuasach p WHERE p.soPhieu = :soPhieu"),
    @NamedQuery(name = "Phieumuasach.findByNgay", query = "SELECT p FROM Phieumuasach p WHERE p.ngay = :ngay"),
    @NamedQuery(name = "Phieumuasach.findByTenNCC", query = "SELECT p FROM Phieumuasach p WHERE p.tenNCC = :tenNCC"),
    @NamedQuery(name = "Phieumuasach.findByThanhToan", query = "SELECT p FROM Phieumuasach p WHERE p.thanhToan = :thanhToan")})
public class Phieumuasach implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SoPhieu")
    private Integer soPhieu;
    @Column(name = "Ngay")
    @Temporal(TemporalType.DATE)
    private Date ngay;
    @Column(name = "TenNCC")
    private String tenNCC;
    @Column(name = "ThanhToan")
    private Boolean thanhToan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phieumuasach")
    private Collection<Chitietphieumua> chitietphieumuaCollection;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne
    private Nhanvien maNV;

    public Phieumuasach() {
    }

    public Phieumuasach(Integer soPhieu) {
        this.soPhieu = soPhieu;
    }

    public Integer getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(Integer soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getNgay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(ngay);
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public Boolean getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(Boolean thanhToan) {
        this.thanhToan = thanhToan;
    }

    @XmlTransient
    public Collection<Chitietphieumua> getChitietphieumuaCollection() {
        return chitietphieumuaCollection;
    }

    public void setChitietphieumuaCollection(Collection<Chitietphieumua> chitietphieumuaCollection) {
        this.chitietphieumuaCollection = chitietphieumuaCollection;
    }

    public Nhanvien getMaNV() {
        return maNV;
    }

    public void setMaNV(Nhanvien maNV) {
        this.maNV = maNV;
    }
    
    public String getInforNhanVien() {
        if (maNV != null) {
            return maNV.getMaNV() + " - " + maNV.getTenNV();
        }
        return "No Info";
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soPhieu != null ? soPhieu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieumuasach)) {
            return false;
        }
        Phieumuasach other = (Phieumuasach) object;
        if ((this.soPhieu == null && other.soPhieu != null) || (this.soPhieu != null && !this.soPhieu.equals(other.soPhieu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Phieumuasach[ soPhieu=" + soPhieu + " ]";
    }
    
}
