package entity;

public class Pension {

    private int id;
    private int hotel_id;
    private String pension_type;

    public Pension (){

    }



    public Pension( String pension_type) {
        this.pension_type = pension_type; // burayı sonradan olusturduk. kayıt esnasında sadece marka adı eklemek için kullanıcam. bknz btn_brand_save listener
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getPension_type() {
        return pension_type;
    }

    public void setPension_type(String pension_type) {
        this.pension_type = pension_type;
    }


    @Override
    public String toString() {
        return "Pension{" +
                "id=" + id +
                ", hotel_id=" + hotel_id +
                ", pension_type='" + pension_type + '\'' +
                '}';
    }




}
