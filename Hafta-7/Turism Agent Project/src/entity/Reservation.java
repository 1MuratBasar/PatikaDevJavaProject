package entity;

public class Reservation {

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

    public Reservation(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(String checkin_date) {
        this.checkin_date = checkin_date;
    }

    public String getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(String checkout_date) {
        this.checkout_date = checkout_date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getGuest_count() {
        return guest_count;
    }

    public void setGuest_count(int guest_count) {
        this.guest_count = guest_count;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public String getGuest_idno() {
        return guest_idno;
    }

    public void setGuest_idno(String guest_idno) {
        this.guest_idno = guest_idno;
    }

    public String getGuest_mail() {
        return guest_mail;
    }

    public void setGuest_mail(String guest_mail) {
        this.guest_mail = guest_mail;
    }

    public String getGuest_phone() {
        return guest_phone;
    }

    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room_id=" + room_id +
                ", checkin_date='" + checkin_date + '\'' +
                ", checkout_date='" + checkout_date + '\'' +
                ", total_price=" + total_price +
                ", guest_count=" + guest_count +
                ", guest_name='" + guest_name + '\'' +
                ", guest_idno='" + guest_idno + '\'' +
                ", guest_mail='" + guest_mail + '\'' +
                ", guest_phone='" + guest_phone + '\'' +
                '}';
    }
}

