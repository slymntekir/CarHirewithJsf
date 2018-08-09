package packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class kullanicilarManagedBean{
    
    Kullanicilar k;

    public Kullanicilar getK() {
        return k;
    }

    public void setK(Kullanicilar k) {
        this.k = k;
    }
    
    public kullanicilarManagedBean() {
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
    String var_mi = "";
    baglanti b = new baglanti();
   
    
    public String giris()
    {
        try
        {
            c=b.baglan();
            String sorgu = "select * from kullanicilar where kullanici_adi=? and sifre=?";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setString(1,k.getKullaniciAdi());
            ps.setString(2,k.getSifre());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(k.getKullaniciAdi().equals(rs.getString(2)) &&
                        k.getSifre().equals(rs.getString(5))
                        && rs.getString(9).equals("Evet"))
                {
                    System.out.println(rs.getString(2)+" "+k.getKullaniciAdi()+" "+
                            rs.getString(5)+" "+k.getSifre());
                    var_mi = "Admin";
                    break;
                }
                else if(k.getKullaniciAdi().equals(rs.getString(2)) &&
                        k.getSifre().equals(rs.getString(5))
                        && rs.getString(9).equals("Hayir"))
                {
                    if(kiraEkle())
                        var_mi = "kullanici";
                }
            }
        }catch(Exception e){
            System.err.println("hata !!");
        }
        if(var_mi.equals("Admin"))
            return "arabalar?faces-redirect=true";
        else if(var_mi.equals("kullanici"))
            return "arabalar1?faces-redirect=true";
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Yanlış Veri Girdiniz"));
            return "kullaniciGiris?faces-redirect=true";
        }
    }
    
    public int idekle()
    {
        try
        {
            c=b.baglan();
            String sorgu = "select kullanici_id from kullanicilar where kullanici_adi=?";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setString(1,k.getKullaniciAdi());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch(Exception e)
        {
            return 0;
        }
    }
    
    public boolean kiraEkle()
    {
        try
        {
            c=b.baglan();
            String sorgu = "insert into kiralananlar values(?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setInt(1,getMax()+1);
            ps.setInt(2,0);
            ps.setInt(3,idekle());
            ps.setString(4,"a");
            ps.setString(5,"q");
            ps.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println("hata :"+e.getMessage());
            return false;
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
    
    public List<Kullanicilar> getKullanici()
    {
        List<Kullanicilar> kul = new ArrayList<>();
        c = b.baglan();
        String sorgu = "select * from kullanicilar where yetki=?";
        try
        {
            PreparedStatement ps = c.prepareStatement(sorgu);
            ps.setString(1,"Hayir");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Kullanicilar kullanicilar = new Kullanicilar();
                kullanicilar.setKullaniciId(rs.getInt(1));
                kullanicilar.setKullaniciAdi(rs.getString(2));
                kullanicilar.setAdi(rs.getString(3));
                kullanicilar.setSoyadi(rs.getString(4));
                kullanicilar.setSifre(rs.getString(5));
                kullanicilar.setEmail(rs.getString(6));
                kullanicilar.setTel(rs.getString(7));
                kullanicilar.setCinsiyet(rs.getString(8));
                kullanicilar.setYetki(rs.getString(9));
                kul.add(kullanicilar);
            }
        }catch(Exception e){
            return null;
        }
        return kul;
    }
}
