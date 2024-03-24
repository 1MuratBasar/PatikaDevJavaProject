package entity;

import java.time.LocalDate;
import java.util.Date;

public class Season {
    private int id;
    private int hotel_id;
    private String strt_date;
    private String fnsh_date;

public Season() {
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

    public String getStrt_date() {
        return strt_date;
    }

    public void setStrt_date(String strt_date) {
        this.strt_date = strt_date;
    }

    public String getFnsh_date() {
        return fnsh_date;
    }

    public void setFnsh_date(String fnsh_date) {
        this.fnsh_date = fnsh_date;
    }
}