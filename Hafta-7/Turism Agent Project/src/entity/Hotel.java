package entity;

public class Hotel {

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
    public Hotel (){

    }



    public Hotel( String name) {
        this.hotel_name = name; // burayı sonradan olusturduk. kayıt esnasında sadece marka adı eklemek için kullanıcam. bknz btn_brand_save listener
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public boolean isCarpark() {
        return carpark;
    }

    public void setCarpark(boolean carpark) {
        this.carpark = carpark;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }

    public boolean isConclerge() {
        return conclerge;
    }

    public void setConclerge(boolean conclerge) {
        this.conclerge = conclerge;
    }

    public boolean isSpa() {
        return spa;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public boolean isRoomservice() {
        return roomservice;
    }

    public void setRoomservice(boolean roomservice) {
        this.roomservice = roomservice;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotel_name='" + hotel_name + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", star='" + star + '\'' +
                ", carpark=" + carpark +
                ", wifi=" + wifi +
                ", pool=" + pool +
                ", fitness=" + fitness +
                ", conclerge=" + conclerge +
                ", spa=" + spa +
                ", roomservice=" + roomservice +
                '}';
    }
}
