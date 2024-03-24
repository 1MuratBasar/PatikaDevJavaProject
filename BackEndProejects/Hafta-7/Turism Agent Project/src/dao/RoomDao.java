package dao;

import core.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import core.Db;
import entity.Hotel;
import entity.Room;


public class RoomDao {
    private int room_id;
    private String hotel_name;
    private String pension;
    private String room_type;
    private String season_strt_date;
    private String season_fnsh_date;
    private int stock;
    private int bed;
    private int metresquare;
    private double prc_adult;
    private double prc_child;
    private boolean air_conditioning;
    private boolean minibar;
    private boolean tv;
    private boolean bcase;
    private boolean fridge;

    private final Connection con;

    public RoomDao () {
        this.con = Db.getInstance();
    }



    public Room match (ResultSet rs) throws SQLException {
        Room obj = new Room();
        obj.setRoom_id(rs.getInt("room_id"));
        obj.setHotel_name(rs.getString("hotel_name"));
        obj.setPension(rs.getString("pension"));
        obj.setRoom_type(rs.getString("room_type"));
        obj.setSeason_strt_date(rs.getString("season_strt_date"));
        obj.setSeason_fnsh_date(rs.getString("season_fnsh_date"));
        obj.setStock(rs.getInt("stock"));
        obj.setBed(rs.getInt("bed"));
        obj.setMetresquare(rs.getInt("metresquare"));
        obj.setPrc_adult(rs.getDouble("prc_adult"));
        obj.setPrc_child(rs.getDouble("prc_child"));
        obj.setAir_conditioning(rs.getBoolean("air_conditioning"));
        obj.setMinibar(rs.getBoolean("minibar"));
        obj.setTv(rs.getBoolean("tv"));
        obj.setBcase(rs.getBoolean("bcase"));
        obj.setFridge(rs.getBoolean("fridge"));

        //yarın bir gun user tablosuna alan eklenirse sadece buraya bir satır daha eklemek yeterli sorgu calısır
        return obj;
    }

    //******************************************************************************************************************
    //*****************************************************************************************************************
    //brand yonetimi = yeni marka kaydetmek için buraya geliyoruz
    public boolean save (Room room) { // bir brand nesnesi alacak ve boolean dönecek (ya kaydedilir ya da edilmez)

        String query = "INSERT INTO public.room " +
                "(" +
                "hotel_name," +
                "pension," +
                "room_type," +
                "season_strt_date," +
                "season_fnsh_date," +
                "stock," +
                "bed," +
                "metresquare," +
                "prc_adult," +
                "prc_child," +
                "air_conditioning," +
                "minibar," +
                "tv," +
                "bcase," +
                "fridge," +


                ")" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, room.getHotel_name());
            pr.setString(2, room.getPension());
            pr.setString(3, room.getRoom_type());
            pr.setString(4, room.getSeason_strt_date());
            pr.setString(5, room.getSeason_fnsh_date());
            pr.setInt(6, room.getStock());
            pr.setInt(7, room.getBed());
            pr.setInt(8, room.getMetresquare());
            pr.setDouble(9, room.getPrc_adult());
            pr.setDouble(10, room.getPrc_child());
            pr.setBoolean(11, room.isAir_conditioning());
            pr.setBoolean(12, room.isMinibar());
            pr.setBoolean(13, room.isTv());
            pr.setBoolean(14, room.isBcase());
            pr.setBoolean(14, room.isFridge());


            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
//------------------------------------------------------------------------------------------------------------------
//***********************************************************************************************************

    public boolean update (Room room) {

        String query = "UPDATE public.room SET " +

                "hotel_name = ? ," +
                "pension = ? , " +
                "room_type = ? ," +
                "season_strt_date = ? ," +
                "season_fnsh_date = ? ," +
                "stock = ? ," +
                "bed = ? ," +
                "metresquare = ? ,"+
                "prc_adult = ? ,"+
                "prc_child = ? ,"+
                "air_conditioning = ? ,"+
                "minibar = ? ,"+
                "tv = ? ,"+
                "bcase = ? ,"+
                "fridge = ? ,"+
          "WHERE room_id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, room.getHotel_name());
            pr.setString(2, room.getPension());
            pr.setString(3, room.getRoom_type());
            pr.setString(4, room.getSeason_strt_date());
            pr.setString(5, room.getSeason_fnsh_date());
            pr.setInt(6, room.getStock());
            pr.setInt(7, room.getBed());
            pr.setInt(8, room.getMetresquare());
            pr.setDouble(9, room.getPrc_adult());
            pr.setDouble(10, room.getPrc_child());
            pr.setBoolean(11, room.isAir_conditioning());
            pr.setBoolean(12, room.isMinibar());
            pr.setBoolean(13, room.isTv());
            pr.setBoolean(14, room.isBcase());
            pr.setBoolean(14, room.isFridge());


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
        String query = "DELETE FROM public.room WHERE room_id = ? ";

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
    public Room getById (int id) { // id ye göre hotel cagır
        Room obj = null;
        String query = "Select * from public.room WHERE room_id = ? ";
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
    public ArrayList<Room> findAll () {
        return this.selectByQuery("SELECT * FROM public.room ORDER BY room_id ASC");
    }

    //********************************************************************************************************************
    public ArrayList<Room> selectByQuery(String query) {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                rooms.add(this.match(rs));
            }
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return rooms;
    }
//********************************************************************************************************************

}
