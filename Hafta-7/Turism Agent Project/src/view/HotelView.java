package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.HotelManager;
import core.ComboItem;
import core.Helper;
import dao.HotelDao;
import entity.Hotel;
import entity.User;

public class HotelView extends Layout{
    private JPanel container;
    private JLabel lbl_hotel_saving;
    private JTextField fld_hotel_name;
    private JTextField fld_hotel_city;
    private JTextField fld_hotel_region;
    private JComboBox<ComboItem> cmb_hotel_star;
    private JTextField fld_hotel_mail;
    private JTextArea fld_address;
    private JTextField fld_hotel_phone;
    private JRadioButton rd_pool;
    private JRadioButton rd_wifi;
    private JRadioButton rd_fitness;
    private JRadioButton rd_spa;
    private JRadioButton rd_roomservice;
    private JRadioButton rd_otopark;
    private JButton btn_save_hotel;
    private JButton btn_exit_hotel;
    private JRadioButton rd_conclerge;
    private HotelManager hotelManager;
    private HotelDao hotelDao;
    private  Hotel hotel;




    public HotelView(Hotel hotel) {

        this.hotel = hotel;
        this.add(container);
        this.hotelManager = new HotelManager();
        this.guiInitialize(800,600);





        btn_exit_hotel.addActionListener(e -> {
            dispose();
         //   EmployeeView employeeView = new EmployeeView(null);


        });
        btn_save_hotel.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_hotel_name, this.fld_hotel_city, this.fld_hotel_region,
            this.fld_hotel_mail, this.fld_hotel_phone})) {
                Helper.showMsg("fill");
            } else {

                boolean result;
                Hotel hotel1  = new Hotel();
                hotel1.setHotel_name(fld_hotel_name.getText());
                hotel1.setCity(fld_hotel_city.getText());
                hotel1.setRegion(fld_hotel_region.getText());
                hotel1.setAddress(fld_address.getText());
                hotel1.setMail(fld_hotel_mail.getText());
                hotel1.setPhone(fld_hotel_phone.getText());
                hotel1.setStar((String) cmb_hotel_star.getSelectedItem());
                hotel1.setCarpark(rd_otopark.isSelected());
                hotel1.setWifi(rd_wifi.isSelected());
                hotel1.setPool(rd_pool.isSelected());
                hotel1.setFitness(rd_fitness.isSelected());
                hotel1.setConclerge(rd_conclerge.isSelected());
                hotel1.setSpa(rd_spa.isSelected());
                hotel1.setRoomservice(rd_roomservice.isSelected());
                result = hotelManager.save(hotel1);

                if(result) {
                    Helper.showMsg("done");
                } else {
                    Helper.showMsg("error");
                }

            }



        });

    }


}
