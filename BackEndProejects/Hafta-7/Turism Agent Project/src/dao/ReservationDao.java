package dao;

import core.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import core.Db;
import entity.Hotel;
import entity.Reservation;


public class ReservationDao {
    private int id;
    private int room_id;
    private String checkin_date;
    private String checkout_date;
    private double total_price;
    private int guest_count;
    private String guest_name;
    private String guest_idno;
    private String guest_mail;
    private String guest_phone;


    private final Connection con;

    public ReservationDao () {
        this.con = Db.getInstance();
    }



    public Reservation match (ResultSet rs) throws SQLException {
        Reservation obj = new Reservation();
        obj.setId(rs.getInt("id"));
        obj.setId(rs.getInt("room_id"));
        obj.setCheckin_date(rs.getString("checkin_date"));
        obj.setCheckout_date(rs.getString("checkout_date"));
        obj.setTotal_price(rs.getDouble("total_price"));
        obj.setGuest_count(rs.getInt("guest_count"));
        obj.setGuest_name(rs.getString("guest_name"));
        obj.setGuest_idno(rs.getString("guest_idno"));
        obj.setGuest_mail(rs.getString("guest_mail"));
        obj.setGuest_phone(rs.getString("guest_phone"));

        //yarın bir gun user tablosuna alan eklenirse sadece buraya bir satır daha eklemek yeterli sorgu calısır
        return obj;
    }

    //******************************************************************************************************************
    //*****************************************************************************************************************
    //brand yonetimi = yeni marka kaydetmek için buraya geliyoruz
    public boolean save (Reservation reservation) { // bir brand nesnesi alacak ve boolean dönecek (ya kaydedilir ya da edilmez)

        String query = "INSERT INTO public.reservation " +
                "(" +
                "room_id," +
                "checkin_date," +
                "checkout_date," +
                "total_price," +
                "guest_count," +
                "guest_name," +
                "guest_idno," +
                "guest_mail," +
                "guest_phone," +

                ")" +
                " VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, reservation.getRoom_id());
            pr.setString(2, reservation.getCheckin_date());
            pr.setString(3, reservation.getCheckout_date());
            pr.setDouble(4, reservation.getTotal_price());
            pr.setInt(5, reservation.getGuest_count());
            pr.setString(6, reservation.getGuest_name());
            pr.setString(7, reservation.getGuest_idno());
            pr.setString(8, reservation.getGuest_mail());
            pr.setString(9, reservation.getGuest_phone());



            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
//------------------------------------------------------------------------------------------------------------------
//***********************************************************************************************************

    public boolean update (Reservation reservation) {

        String query = "UPDATE public.reservation SET " +




                "room_id = ? ," +
                "checkin_date = ? , " +
                "checkout_date = ? ," +
                "total_price = ? ," +
                "guest_count = ? ," +
                "guest_name = ? ," +
                "guest_idno = ? ," +
                "guest_mail = ? ,"+
                "guest_mail = ? ,"+
                "guest_phone = ? ,"+


                "WHERE id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, reservation.getRoom_id());
            pr.setString(2, reservation.getCheckin_date());
            pr.setString(3, reservation.getCheckout_date());
            pr.setDouble(4, reservation.getTotal_price());
            pr.setInt(5, reservation.getGuest_count());
            pr.setString(6, reservation.getGuest_name());
            pr.setString(7, reservation.getGuest_idno());
            pr.setString(8, reservation.getGuest_mail());
            pr.setString(9, reservation.getGuest_phone());



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
        String query = "DELETE FROM public.hotel WHERE id = ? ";

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
    public Reservation getById (int id) { // id ye göre hotel cagır
        Reservation obj = null;
        String query = "Select * from public.hotel WHERE id = ? ";
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
    public ArrayList<Reservation> findAll () {
        return this.selectByQuery("SELECT * FROM public.reservation ORDER BY id ASC");
    }

    //********************************************************************************************************************
    public ArrayList<Reservation> selectByQuery(String query) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                reservations.add(this.match(rs));
            }
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return reservations;
    }
//********************************************************************************************************************

}
