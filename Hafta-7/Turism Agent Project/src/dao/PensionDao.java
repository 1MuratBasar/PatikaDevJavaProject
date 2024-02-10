package dao;

import core.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import core.Db;
import entity.Hotel;
import entity.Pension;


public class PensionDao {
    private int id;
    private int hotel_id;
    private String pension_type;
    private HotelDao hotelDao;

    private final Connection con;

    public PensionDao () {
        this.con = Db.getInstance();
        this.hotelDao = new HotelDao();
    }



    public Pension match (ResultSet rs) throws SQLException {
        Pension obj = new Pension();
        obj.setId(rs.getInt("id"));
        obj.setHotel_id(rs.getInt("hotel_id"));
        obj.setPension_type(rs.getString("pension_type"));


        //yarın bir gun user tablosuna alan eklenirse sadece buraya bir satır daha eklemek yeterli sorgu calısır
        return obj;
    }

    //******************************************************************************************************************
    //*****************************************************************************************************************
    //brand yonetimi = yeni marka kaydetmek için buraya geliyoruz
    public boolean save (Pension pension) { // bir brand nesnesi alacak ve boolean dönecek (ya kaydedilir ya da edilmez)

        String query = "INSERT INTO public.pension_type " +
                "(" +
                "hotel_id," +
                "pension_type," +



                ")" +
                " VALUES (?,?)";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, pension.getHotel_id());
            pr.setString(2, pension.getPension_type());



            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
//------------------------------------------------------------------------------------------------------------------
//***********************************************************************************************************

    public boolean update (Pension pension) {

        String query = "UPDATE public.pension_type SET " +

                "hotel_id = ? ," +
                "pension_type = ? , " +


                "WHERE id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, pension.getHotel_id());
            pr.setString(2, pension.getPension_type());



            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    //***********************************************************************************************************

//---------------------------------------------------------------------------------------------------------------------

    //DELETE için

    public boolean delete (int id) { // integer id vermesi yeterdi. brandid (adminview) ile silme yaparım
        String query = "DELETE FROM public.pension_type WHERE id = ? ";

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


    //********************************************************************************************************************
    public Pension getById (int id) { // id ye göre hotel cagır
        Pension obj = null;
        String query = "Select * from public.pension_type WHERE id = ? ";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) obj=this.match(rs);

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }
    //********************************************************************************************************************
    public ArrayList<Pension> findAll () {
        return this.selectByQuery("SELECT * FROM public.pension_type ORDER BY id ASC");
    }

    //********************************************************************************************************************
    public ArrayList<Pension> selectByQuery(String query) {
        ArrayList<Pension> pensions = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                pensions.add(this.match(rs));
            }
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return pensions;
    }
//********************************************************************************************************************

}
