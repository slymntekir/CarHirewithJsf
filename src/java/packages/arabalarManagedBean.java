/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suleyman
 */
public class arabalarManagedBean {
    
    private Arabalar araba;
    private Kiralananlar kiralanan;

    public Kiralananlar getKiralanan() {
        return kiralanan;
    }

    public void setKiralanan(Kiralananlar kiralanan) {
        this.kiralanan = kiralanan;
    }
    List<Arabalar> ana_araba = new ArrayList<>();

    public List<Arabalar> getAna_araba() {
        return ana_araba;
    }

    public void setAna_araba(List<Arabalar> ana_araba) {
        this.ana_araba = ana_araba;
    }
    
    public Arabalar getAraba() {
        return araba;
    }

    public void setAraba(Arabalar araba) {
        this.araba = araba;
    }
    
    public arabalarManagedBean() {
        araba = new Arabalar();
    }
    
    Connection c = null;
    baglanti b = new baglanti();
    
    public List<Arabalar> getArabalar()
    {
        List<Arabalar> araba1 = new ArrayList<>();
        c = b.baglan();
        String sorgu = "select * from arabalar";
        try
        {
            PreparedStatement ps = c.prepareStatement(sorgu);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Arabalar arabalar = new Arabalar();
                arabalar.setAracId(rs.getInt("arac_id"));
                arabalar.setMarka(rs.getString("marka"));
                arabalar.setModel(rs.getString("model"));
                arabalar.setRenk(rs.getString("renk"));
                arabalar.setKm(rs.getString("km"));
                arabalar.setFiyat(rs.getString("fiyat"));
                arabalar.setYakitTuru(rs.getString("yakit_turu"));
                arabalar.setResim(rs.getString("resim"));
                araba1.add(arabalar);
            }
        }catch(Exception e){
            return null;
        }
        return araba1;
    }
    
    public String ismeGore()
    {
        List<Arabalar> arabaa = new ArrayList<>();
        try
        {
            arabaa.clear();
            c = b.baglan();
            String sorgu = "select * from arabalar where marka like '%"+String.valueOf(araba.getMarka())+"%'";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Arabalar a = new Arabalar();
                a.setAracId(rs.getInt(1));
                a.setMarka(sorgu);
                a.setModel(sorgu);
                a.setRenk(sorgu);
                a.setKm(sorgu);
                a.setFiyat(sorgu);
                a.setYakitTuru(sorgu);
                a.setResim(sorgu);
                arabaa.add(a);
            }
            ana_araba=arabaa;
        }
        catch(Exception e){
            return "arabalar?faces-redirect=true";
        }
        return "arabalar?faces-redirect=true";
    }
    
    public String arabaDetay()
    {
        return "arabaDetay?faces-redirect=true";
    }
    
    
    public List<Kiralananlar> getKiralananlar()
    {
        List<Kiralananlar> kira = new ArrayList<>();
        c = b.baglan();
        String sorgu = "select * from kiralananlar";
        try
        {
            PreparedStatement ps = c.prepareStatement(sorgu);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Kiralananlar kiralanan = new Kiralananlar();
                kiralanan.setKiraId(rs.getInt(1));
                kiralanan.setAracId(rs.getInt(2));
                kiralanan.setKullaniciId(rs.getInt(3));
                kiralanan.setTFiyat(rs.getString(4));
                kiralanan.setGunSayisi(rs.getString(5));
                kira.add(kiralanan);
            }
        }catch(Exception e){
            return null;
        }
        return kira;
    }
}
