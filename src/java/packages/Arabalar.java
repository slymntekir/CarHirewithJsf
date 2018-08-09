/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author suleyman
 */
@MappedSuperclass
@Table(name = "arabalar", catalog = "rent_a_car", schema = "")
@XmlRootElement
public class Arabalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "arac_id", nullable = false)
    private Integer aracId;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "marka", nullable = false, length = 45)
     String marka;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "model", nullable = false, length = 45)
    private String model;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "renk", nullable = false, length = 30)
    private String renk;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "km", nullable = false, length = 45)
    private String km;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "fiyat", nullable = false, length = 45)
    private String fiyat;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "yakit_turu", nullable = false, length = 45)
    private String yakitTuru;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "resim", nullable = false, length = 30)
    private String resim;

    public Arabalar() {
    }

    public Arabalar(Integer aracId) {
        this.aracId = aracId;
    }

    public Arabalar(Integer aracId, String marka, String model, String renk, String km, String fiyat, String yakitTuru, String resim) {
        this.aracId = aracId;
        this.marka = marka;
        this.model = model;
        this.renk = renk;
        this.km = km;
        this.fiyat = fiyat;
        this.yakitTuru = yakitTuru;
        this.resim = resim;
    }

    public Integer getAracId() {
        return aracId;
    }

    public void setAracId(Integer aracId) {
        this.aracId = aracId;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getYakitTuru() {
        return yakitTuru;
    }

    public void setYakitTuru(String yakitTuru) {
        this.yakitTuru = yakitTuru;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aracId != null ? aracId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arabalar)) {
            return false;
        }
        Arabalar other = (Arabalar) object;
        if ((this.aracId == null && other.aracId != null) || (this.aracId != null && !this.aracId.equals(other.aracId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packages.Arabalar[ aracId=" + aracId + " ]";
    }
    
}
