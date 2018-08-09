/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author suleyman
 */
public class kullaniciKaydiManagedBean {
    private Kullanicilar k;

    public Kullanicilar getK() {
        return k;
    }

    public void setK(Kullanicilar k) {
        this.k = k;
    }
    /**
     * Creates a new instance of kullaniciKaydiManagedBean
     */
    public kullaniciKaydiManagedBean(){
        k = new Kullanicilar();
        k.setKullaniciId(Integer.MIN_VALUE);
        k.setKullaniciAdi("");
        k.setAdi("");
        k.setSoyadi("");
        k.setSifre("");
        k.setEmail("");
        k.setTel("");
        k.setCinsiyet("");
        k.setYetki("");
    }
    Connection c;
    baglanti b = new baglanti();
    
    public String kaydet()
    {
        String sonuc = "";
        try
        {
            c=b.baglan();
            String sorgu = "insert into kullanicilar values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setInt(1,getMaxId());
            ps.setString(2,k.getKullaniciAdi());
            ps.setString(3,k.getAdi());
            ps.setString(4,k.getSoyadi());
            ps.setString(5,k.getSifre());
            ps.setString(6,k.getEmail());
            ps.setString(7,k.getTel());
            ps.setString(8,k.getCinsiyet());
            ps.setString(9,"Hayir");
            ps.executeUpdate();
            sonuc = "basarili?faces-redirect=true";
        }catch(Exception e)
        {
            sonuc = "basarisiz?faces-redirect=true";
            System.err.println("hata !!!");
        }
        return sonuc;
    }
    
    public int getMaxId()
    {
        int sayi;
        try
        {
            c=b.baglan();
            PreparedStatement ps=c.prepareStatement("select max(kullanici_id) from kullanicilar");
            ResultSet rs = ps.executeQuery();
            rs.next();
            sayi=rs.getInt(1)+1;
        }catch(Exception e)
        {
            return 0;
        }
        return sayi;
    }
    
}
