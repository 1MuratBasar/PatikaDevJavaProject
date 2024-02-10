package dao;

import core.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import core.Db;
import entity.Hotel;


public class HotelDao {
    private int id;
    private String hotel_name;
    private String city;
    private String region;
    private String address;
    private String mail;
    private String phone;
    private String star;
    private boolean carpark;
    private boolean wifi;
    private boolean pool;
    private boolean fitness;
    private boolean conclerge;
    private boolean spa;
    private boolean roomservice;

    private final Connection con;

    public HotelDao () {
        this.con = Db.getInstance();
    }



    public Hotel match (ResultSet rs) throws SQLException {
        Hotel obj = new Hotel();
        obj.setId(rs.getInt("hotel_id"));
        obj.setHotel_name(rs.getString("hotel_name"));
        obj.setCity(rs.getString("city"));
        obj.setRegion(rs.getString("region"));
        obj.setAddress(rs.getString("address"));
        obj.setMail(rs.getString("mail"));
        obj.setPhone(rs.getString("phone"));
        obj.setStar(rs.getString("star"));
        obj.setCarpark(rs.getBoolean("carpark"));
        obj.setWifi(rs.getBoolean("wifi"));
        obj.setPool(rs.getBoolean("pool"));
        obj.setFitness(rs.getBoolean("fitness"));
        obj.setConclerge(rs.getBoolean("conclerge"));
        obj.setSpa(rs.getBoolean("spa"));
        obj.setRoomservice(rs.getBoolean("room_service"));

        //yarın bir gun user tablosuna alan eklenirse sadece buraya bir satır daha eklemek yeterli sorgu calısır
        return obj;
    }

    //******************************************************************************************************************
    //*****************************************************************************************************************
    //brand yonetimi = yeni marka kaydetmek için buraya geliyoruz
    public boolean save (Hotel hotel) { // bir brand nesnesi alacak ve boolean dönecek (ya kaydedilir ya da edilmez)

        String query = "INSERT INTO public.hotel " +
                "(" +
                "hotel_name," +
                "city," +
                "region," +
                "address," +
                "mail," +
                "phone," +
                "star," +
                "carpark," +
                "wifi," +
                "pool," +
                "fitness," +
                "conclerge," +
                "spa," +
                "room_service," +


                ")" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, hotel.getHotel_name());
            pr.setString(2, hotel.getCity());
            pr.setString(3, hotel.getRegion());
            pr.setString(4, hotel.getAddress());
            pr.setString(5, hotel.getMail());
            pr.setString(6, hotel.getPhone());
            pr.setString(7, hotel.getStar());
            pr.setBoolean(8, hotel.isCarpark());
            pr.setBoolean(9, hotel.isWifi());
            pr.setBoolean(10, hotel.isPool());
            pr.setBoolean(11, hotel.isFitness());
            pr.setBoolean(12, hotel.isConclerge());
            pr.setBoolean(13, hotel.isSpa());
            pr.setBoolean(14, hotel.isRoomservice());


            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
//------------------------------------------------------------------------------------------------------------------
//***********************************************************************************************************

 public boolean update (Hotel hotel) {

 String query = "UPDATE public.car SET " +

         "hotel_name = ? ," +
         "city = ? , " +
         "region = ? ," +
         "address = ? ," +
         "mail = ? ," +
         "phone = ? ," +
         "star = ? ," +
         "carpark = ? ,"+
         "wifi = ? ,"+
         "pool = ? ,"+
         "fitness = ? ,"+
         "conclerge = ? ,"+
         "spa = ? ,"+
         "room_service = ? ,"+

 "WHERE car_id = ?";
 try {
 PreparedStatement pr = con.prepareStatement(query);
 pr.setString(1, hotel.getHotel_name());
 pr.setString(2, hotel.getCity());
 pr.setString(3, hotel.getRegion());
 pr.setString(4, hotel.getAddress());
 pr.setString(5, hotel.getMail());
 pr.setString(6, hotel.getPhone());
     pr.setString(7, hotel.getStar());
     pr.setBoolean(8, hotel.isCarpark());
     pr.setBoolean(9, hotel.isWifi());
     pr.setBoolean(10, hotel.isPool());
     pr.setBoolean(11, hotel.isFitness());
     pr.setBoolean(12, hotel.isConclerge());
     pr.setBoolean(13, hotel.isSpa());
     pr.setBoolean(14, hotel.isRoomservice());



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
        String query = "DELETE FROM public.hotel WHERE hotel_id = ? ";

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
public Hotel getById (int id) { // id ye göre hotel cagır
    Hotel obj = null;
    String query = "Select * from public.hotel WHERE hotel_id = ? ";
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
public ArrayList<Hotel> findAll () {
    return this.selectByQuery("SELECT * FROM public.hotel ORDER BY hotel_id ASC");
}

    //********************************************************************************************************************
public ArrayList<Hotel> selectByQuery(String query) {
    ArrayList<Hotel> hotels = new ArrayList<>();
    try {
        ResultSet rs = this.con.createStatement().executeQuery(query);
        while (rs.next()) {
            hotels.add(this.match(rs));
        }
    } catch (SQLException throwable){
        throwable.printStackTrace();
    }
    return hotels;
}
//********************************************************************************************************************

}
