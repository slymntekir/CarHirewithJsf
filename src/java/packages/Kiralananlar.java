/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author suleyman
 */
@Entity
@Table(name = "kiralananlar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kiralananlar.findAll", query = "SELECT k FROM Kiralananlar k"),
    @NamedQuery(name = "Kiralananlar.findByKiraId", query = "SELECT k FROM Kiralananlar k WHERE k.kiraId = :kiraId"),
    @NamedQuery(name = "Kiralananlar.findByAracId", query = "SELECT k FROM Kiralananlar k WHERE k.aracId = :aracId"),
    @NamedQuery(name = "Kiralananlar.findByKullaniciId", query = "SELECT k FROM Kiralananlar k WHERE k.kullaniciId = :kullaniciId"),
    @NamedQuery(name = "Kiralananlar.findByTFiyat", query = "SELECT k FROM Kiralananlar k WHERE k.tFiyat = :tFiyat"),
    @NamedQuery(name = "Kiralananlar.findByGunSayisi", query = "SELECT k FROM Kiralananlar k WHERE k.gunSayisi = :gunSayisi")})
public class Kiralananlar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kira_id")
    private Integer kiraId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arac_id")
    private int aracId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kullanici_id")
    private int kullaniciId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "t_fiyat")
    private String tFiyat;
    @Size(max = 20)
    @Column(name = "gun_sayisi")
    private String gunSayisi;

    public Kiralananlar() {
    }

    public Kiralananlar(Integer kiraId) {
        this.kiraId = kiraId;
    }

    public Kiralananlar(Integer kiraId, int aracId, int kullaniciId, String tFiyat) {
        this.kiraId = kiraId;
        this.aracId = aracId;
        this.kullaniciId = kullaniciId;
        this.tFiyat = tFiyat;
    }

    public Integer getKiraId() {
        return kiraId;
    }

    public void setKiraId(Integer kiraId) {
        this.kiraId = kiraId;
    }

    public int getAracId() {
        return aracId;
    }

    public void setAracId(int aracId) {
        this.aracId = aracId;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getTFiyat() {
        return tFiyat;
    }

    public void setTFiyat(String tFiyat) {
        this.tFiyat = tFiyat;
    }

    public String getGunSayisi() {
        return gunSayisi;
    }

    public void setGunSayisi(String gunSayisi) {
        this.gunSayisi = gunSayisi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kiraId != null ? kiraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kiralananlar)) {
            return false;
        }
        Kiralananlar other = (Kiralananlar) object;
        if ((this.kiraId == null && other.kiraId != null) || (this.kiraId != null && !this.kiraId.equals(other.kiraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packages.Kiralananlar[ kiraId=" + kiraId + " ]";
    }
    
}
