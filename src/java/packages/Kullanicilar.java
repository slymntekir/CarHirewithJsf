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
@Table(name = "kullanicilar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanicilar.findAll", query = "SELECT k FROM Kullanicilar k"),
    @NamedQuery(name = "Kullanicilar.findByKullaniciId", query = "SELECT k FROM Kullanicilar k WHERE k.kullaniciId = :kullaniciId"),
    @NamedQuery(name = "Kullanicilar.findByKullaniciAdi", query = "SELECT k FROM Kullanicilar k WHERE k.kullaniciAdi = :kullaniciAdi"),
    @NamedQuery(name = "Kullanicilar.findByAdi", query = "SELECT k FROM Kullanicilar k WHERE k.adi = :adi"),
    @NamedQuery(name = "Kullanicilar.findBySoyadi", query = "SELECT k FROM Kullanicilar k WHERE k.soyadi = :soyadi"),
    @NamedQuery(name = "Kullanicilar.findBySifre", query = "SELECT k FROM Kullanicilar k WHERE k.sifre = :sifre"),
    @NamedQuery(name = "Kullanicilar.findByEmail", query = "SELECT k FROM Kullanicilar k WHERE k.email = :email"),
    @NamedQuery(name = "Kullanicilar.findByTel", query = "SELECT k FROM Kullanicilar k WHERE k.tel = :tel"),
    @NamedQuery(name = "Kullanicilar.findByCinsiyet", query = "SELECT k FROM Kullanicilar k WHERE k.cinsiyet = :cinsiyet"),
    @NamedQuery(name = "Kullanicilar.findByYetki", query = "SELECT k FROM Kullanicilar k WHERE k.yetki = :yetki")})
public class Kullanicilar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kullanici_id")
    private Integer kullaniciId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kullanici_adi")
    private String kullaniciAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "adi")
    private String adi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "soyadi")
    private String soyadi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sifre")
    private String sifre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "cinsiyet")
    private String cinsiyet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "yetki")
    private String yetki;

    public Kullanicilar() {
    }

    public Kullanicilar(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Kullanicilar(Integer kullaniciId, String kullaniciAdi, String adi, String soyadi, String sifre, String email, String tel, String cinsiyet, String yetki) {
        this.kullaniciId = kullaniciId;
        this.kullaniciAdi = kullaniciAdi;
        this.adi = adi;
        this.soyadi = soyadi;
        this.sifre = sifre;
        this.email = email;
        this.tel = tel;
        this.cinsiyet = cinsiyet;
        this.yetki = yetki;
    }

    public Integer getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciId != null ? kullaniciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanicilar)) {
            return false;
        }
        Kullanicilar other = (Kullanicilar) object;
        if ((this.kullaniciId == null && other.kullaniciId != null) || (this.kullaniciId != null && !this.kullaniciId.equals(other.kullaniciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packages.Kullanicilar[ kullaniciId=" + kullaniciId + " ]";
    }
    
}
