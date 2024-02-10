package dao;

import core.Db;
import entity.Brand;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDao {

    private int id;
    private String name;

    private final Connection con;

    public BrandDao () {
        this.con = Db.getInstance();
    }

    public ArrayList<Brand> findAll(){
        ArrayList<Brand> brandList = new ArrayList<>();
        String sql = "SELECT * FROM public.brand ORDER BY brand_id ASC";
        try {

            ResultSet rs = this.con.createStatement().executeQuery(sql);

            while (rs.next()) {
                brandList.add(this.match(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return brandList;
    }

    public Brand match (ResultSet rs) throws SQLException {
        Brand obj = new Brand();
        obj.setId(rs.getInt("brand_id"));
        obj.setName(rs.getString("brand_name"));

        //yarın bir gun user tablosuna alan eklenirse sadece buraya bir satır daha eklemek yeterli sorgu calısır
        return obj;
    }

    //******************************************************************************************************************
    //*****************************************************************************************************************
    //brand yonetimi = yeni marka kaydetmek için buraya geliyoruz
    public boolean save (Brand brand) { // bir brand nesnesi alacak ve boolean dönecek (ya kaydedilir ya da edilmez)
    String query = "INSERT INTO public.brand (brand_name) VALUES (?)";
    try {
        PreparedStatement pr = this.con.prepareStatement(query);
        pr.setString(1, brand.getName()); //1. soru işaretine brand_name i geitiriyoruz demek
        return pr.executeUpdate() != -1; // pr.executeUpdate başarıl ıdeğilse geriye -1 yollayacak
    } catch (SQLException e){
        e.printStackTrace();
    }
    return true;
    }
//------------------------------------------------------------------------------------------------------------------
    //UPdDATE için

    public boolean update (Brand brand) { // bir brand nesnesi alacak ve boolean dönecek (ya kaydedilir ya da edilmez)
        String query = "UPDATE public.brand SET brand_name = ? WHERE brand_id = ? ";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, brand.getName()); //1. soru işaretine brand_name i geitiriyoruz demek
            pr.setInt(2, brand.getId());
            return pr.executeUpdate() != -1; // pr.executeUpdate başarıl ıdeğilse geriye -1 yollayacak
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    } // branddao da update metotumuzu yazdık. şimdi bunu aynısını (return döndüren) brandmanager e yazıyoru
//---------------------------------------------------------------------------------------------------------------------

    //DELETE için

    public boolean delete (int id) { // integer id vermesi yeterdi. brandid (adminview) ile silme yaparım
    String query = "DELETE FROM public.brand WHERE brand_id = ? ";

    try {
        PreparedStatement pr = this.con.prepareStatement(query);
        pr.setInt(1, id);
        return pr.executeUpdate() != -1; // pr.executeUpdate başarıl ıdeğilse geriye -1 yollayacak
    } catch (SQLException e){
        e.printStackTrace();
    }
    return true;
} // branddao da update metotumuzu yazdık. şimdi bunu aynısını (return döndüren) brandmanager e yazıyorum


//---------------------------------------------------------------------------------------------------------------------

    public Brand getById (int id) { // geriye brand donduren sadece ingteger Id degeri alan bir metot olusturuyoruz
      Brand obj= null;
      String query="SELECT * FROM public.brand WHERE brand_id = ?";
      try {
          PreparedStatement pr = this.con.prepareStatement(query);
          pr.setInt(1,id); // sorgunu 1. parametresine id yi setle
          ResultSet rs = pr.executeQuery(); //sonucu resultset at
          if (rs.next()) { // bu resultset in bir değeri var ise
            obj = this.match(rs); //resultsetimde gelen degeri obj ye atarım
          }
      } catch (SQLException e){
          e.printStackTrace();
      }
        return obj; // bu metotu yazdıktan sonra tekrar brandmanager a gidiyrz ve getbyid metotunu döndüren metotu yazıyoruz
    }




}
