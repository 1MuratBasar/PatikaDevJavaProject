package dao;

import core.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import core.Db;
import entity.Hotel;
import entity.Pension;
import entity.Season;


public class SeasonDao {
    private int id;
    private int hotel_id;
    private String pension_type;
    private HotelDao hotelDao;

    private final Connection con;

    public SeasonDao () {
        this.con = Db.getInstance();
        this.hotelDao = new HotelDao();
    }



    public Season match (ResultSet rs) throws SQLException {
        Season obj = new Season();
        obj.setId(rs.getInt("id"));
        obj.setHotel_id(rs.getInt("hotel_id"));
        obj.setStrt_date(String.valueOf(rs.getDate("strt_date")));
        obj.setFnsh_date(String.valueOf(rs.getDate("fnsh_date")));


        //yarın bir gun user tablosuna alan eklenirse sadece buraya bir satır daha eklemek yeterli sorgu calısır
        return obj;
    }

    //******************************************************************************************************************
    //*****************************************************************************************************************
    //brand yonetimi = yeni marka kaydetmek için buraya geliyoruz
    public boolean save (Season season) { // bir brand nesnesi alacak ve boolean dönecek (ya kaydedilir ya da edilmez)

        String query = "INSERT INTO public.season " +
                "(" +
                "hotel_id," +
                "strt_date," +
                "fnsh_date," +


                ")" +
                " VALUES (?,?,?)";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, season.getHotel_id());
            pr.setString(2, season.getStrt_date());
            pr.setString(3, season.getFnsh_date());



            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
//------------------------------------------------------------------------------------------------------------------
//***********************************************************************************************************

    public boolean update (Season season) {

        String query = "UPDATE public.season SET " +

                "hotel_id = ? ," +
                "strt_date = ? , " +
                "fnsh_date = ? , " +

                "WHERE id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, season.getHotel_id());
            pr.setString(2, season.getStrt_date());
            pr.setString(3, season.getFnsh_date());



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
        String query = "DELETE FROM public.season WHERE id = ? ";

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
    public Season getById (int id) { // id ye göre hotel cagır
        Season obj = null;
        String query = "Select * from public.season WHERE id = ? ";
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
    public ArrayList<Season> findAll () {
        return this.selectByQuery("SELECT * FROM public.season ORDER BY id ASC");
    }

    //********************************************************************************************************************
    public ArrayList<Season> selectByQuery(String query) {
        ArrayList<Season> seasons = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                seasons.add(this.match(rs));
            }
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return seasons;
    }
//********************************************************************************************************************

}
