package entity;

public class Room {

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
    private Room room;
    private Adult adult;
    private Child child;


    public enum Adult { //ENUM yapılar secenek sunmak için
        BirYetişkin,
        İkiYetişkin,
        ÜçYetişkin,
        DörtYetişkin
    }
    public enum Child { //ENUM yapılar secenek sunmak için
        BirÇocuk,
        İkiÇocuk,
        ÜçÇocuk,
        DörtÇocuk
    }

    public Room(){

    }




    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getSeason_strt_date() {
        return season_strt_date;
    }

    public void setSeason_strt_date(String season_strt_date) {
        this.season_strt_date = season_strt_date;
    }

    public String getSeason_fnsh_date() {
        return season_fnsh_date;
    }

    public void setSeason_fnsh_date(String season_fnsh_date) {
        this.season_fnsh_date = season_fnsh_date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getMetresquare() {
        return metresquare;
    }

    public void setMetresquare(int metresquare) {
        this.metresquare = metresquare;
    }

    public double getPrc_adult() {
        return prc_adult;
    }

    public void setPrc_adult(double prc_adult) {
        this.prc_adult = prc_adult;
    }

    public double getPrc_child() {
        return prc_child;
    }

    public void setPrc_child(double prc_child) {
        this.prc_child = prc_child;
    }

    public boolean isAir_conditioning() {
        return air_conditioning;
    }

    public void setAir_conditioning(boolean air_conditioning) {
        this.air_conditioning = air_conditioning;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isBcase() {
        return bcase;
    }

    public void setBcase(boolean bcase) {
        this.bcase = bcase;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", pension='" + pension + '\'' +
                ", room_type='" + room_type + '\'' +
                ", season_strt_date='" + season_strt_date + '\'' +
                ", season_fnsh_date='" + season_fnsh_date + '\'' +
                ", stock=" + stock +
                ", bed=" + bed +
                ", metresquare=" + metresquare +
                ", prc_adult=" + prc_adult +
                ", prc_child=" + prc_child +
                ", air_conditioning=" + air_conditioning +
                ", minibar=" + minibar +
                ", tv=" + tv +
                ", bcase=" + bcase +
                ", fridge=" + fridge +
                '}';
    }
}

