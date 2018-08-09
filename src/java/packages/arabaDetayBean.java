/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author suleyman
 */
public class arabaDetayBean {
    
    private Arabalar arb;
    private Kullanicilar kul;
    private String gun_sayisi;
    private int toplam_fiyat;

    public Kullanicilar getKul() {
        return kul;
    }

    public void setKul(Kullanicilar kul) {
        this.kul = kul;
    }

    public int getToplam_fiyat() {
        return toplam_fiyat;
    }

    public void setToplam_fiyat(int toplam_fiyat) {
        this.toplam_fiyat = toplam_fiyat;
    }
    

    public String getGun_sayisi() {
        return gun_sayisi;
    }

    public void setGun_sayisi(String gun_sayisi) {
        this.gun_sayisi = gun_sayisi;
    }
    

    public Arabalar getArb() {
        return arb;
    }

    public void setArb(Arabalar arb) {
        this.arb = arb;
    }
        
    Connection c;
    baglanti b = new baglanti();
    
    public arabaDetayBean() {
        arb = new Arabalar();
        kul = new Kullanicilar();
        kul.setKullaniciAdi("");
        kul.setAdi("");
        kul.setSoyadi("");
        kul.setCinsiyet("");
        kul.setEmail("");
        kul.setSifre("");
        kul.setYetki("");
        kul.setTel("");
        arb.setMarka("");
        arb.setModel("");
        arb.setFiyat("");
        arb.setRenk("");
        arb.setKm("");
        arb.setResim("");
        arb.setYakitTuru("");
    }
    
    public String arabaGetir()
    {
        try
        {
            c=b.baglan();
            String sorgu = "select * from arabalar where arac_id=?";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setInt(1,arb.getAracId());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                arb.setAracId(rs.getInt("arac_id"));
                arb.setMarka(rs.getString("marka"));
                arb.setModel(rs.getString("model"));
                arb.setRenk(rs.getString("renk"));
                arb.setKm(rs.getString("km"));
                arb.setFiyat(rs.getString("fiyat"));
                arb.setYakitTuru(rs.getString("yakit_turu"));
                arb.setResim(rs.getString("resim"));
            }
        }catch(Exception e)
        {
            System.err.println("hata !!!"+e.getMessage());
        }
        return "arabaDetay";
    }
    
    public String arabaGetir1()
    {
        try
        {
            c=b.baglan();
            String sorgu = "select arac_id,marka from arabalar where arac_id=?";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setInt(1,arb.getAracId());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                arb.setAracId(rs.getInt("arac_id"));
                arb.setMarka(rs.getString("marka"));
            }
        }catch(Exception e)
        {
            System.err.println("hata !!!"+e.getMessage());
        }
        return "son";
    }
    
    public String arabaEkle()
    {
        try
        {
            c = b.baglan();
            String sorgu = "insert into arabalar values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setInt(1,arb.getAracId());
            ps.setString(2,arb.getMarka());
            ps.setString(3,arb.getModel());
            ps.setString(4,arb.getRenk());
            ps.setString(5,arb.getKm());
            ps.setString(6,arb.getFiyat());
            ps.setString(7,arb.getYakitTuru());
            ps.setString(8,arb.getResim());
            ps.executeUpdate();
        }catch(Exception e)
        {
            System.out.println("hata var !!!"+e.getMessage());
        }
        return "arabaDetay?faces-redirect=true";
    }
    
    public String arabaSil()
    {
        try
        {
            c=b.baglan();
            PreparedStatement ps = c.prepareStatement("delete from arabalar where arac_id=?");
            ps.setInt(1,arb.getAracId());
            ps.executeUpdate();
        }catch(Exception e)
        {
            System.err.println(e.getMessage()+" hata var !!!");
        }
        return "arabaDetay?faces-redirect=true";
    }
    
    public String arabaGuncelle()
    {
        try
        {
            c=b.baglan();
            String sorgu = "update arabalar set marka=?,model=?,"
                    + "renk=?,km=?,fiyat=?,yakit_turu=?,resim=? where arac_id=?";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setString(1,arb.getMarka());
            ps.setString(2,arb.getModel());
            ps.setString(3,arb.getRenk());
            ps.setString(4,arb.getKm());
            ps.setString(5,arb.getFiyat());
            ps.setString(6,arb.getYakitTuru());
            ps.setString(7,arb.getResim());
            ps.setInt(8,arb.getAracId());
            ps.executeUpdate();
        }catch(Exception e)
        {
            System.err.println("hata !!! "+e.getMessage());
        }
        return "arabaDetay?faces-redirect=true";
    }
    
    public int fiyat(String marka) throws SQLException
    {
        c=b.baglan();
        PreparedStatement ps = c.prepareStatement("select fiyat from arabalar where marka=?");
        ps.setString(1,marka);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    
    public String gunHesapla() throws SQLException
    {
        toplam_fiyat = Integer.parseInt(gun_sayisi)*fiyat(arb.getMarka());
        if(kiralanan_ekle())
            return "son?faces-redirect=true";
        return null;        
    }
    
    public boolean kiralanan_ekle()
    {
        try
        {
            c=b.baglan();
            PreparedStatement ps = c.prepareStatement("update kiralananlar set arac_id=?,t_fiyat=?,gun_sayisi=? where kira_id=?");
            ps.setInt(1,idCek());
            ps.setString(2,String.valueOf(toplam_fiyat));
            ps.setString(3,gun_sayisi);
            ps.setInt(4,getMax());
            ps.executeUpdate();                   
            return true;
        }catch(Exception e)
        {
            System.out.println("hata !!"+e.getMessage());
        }
        return false;
    }
      
    public int idCek()
    {
        try
        {
            c=b.baglan();
            PreparedStatement ps = c.prepareStatement("select arac_id from arabalar where marka=?");
            ps.setString(1,arb.getMarka());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch(Exception e)
        {
            return -1;
        }
    }
    
    public int getMax()
    {
        try
        {
            c = b.baglan();
            String sorgu = "select max(kira_id) from kiralananlar";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if(rs.getInt(1)<=0)
                return 0;
            else if(rs.getInt(1)>0)
                return rs.getInt(1);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
}