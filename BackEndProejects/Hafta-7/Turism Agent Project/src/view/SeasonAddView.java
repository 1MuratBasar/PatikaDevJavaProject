package view;

import business.HotelManager;
import business.PensionManager;
import business.SeasonManager;
import core.ComboItem;
import core.Helper;
import dao.HotelDao;
import entity.Hotel;
import entity.Pension;
import entity.Season;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SeasonAddView extends Layout {

    private  Pension pension;
    private JPanel container;
    private JTextField fld_strt_date;
    private JTextField fld_fnsh_date;
    private JButton btn_save_season;
    private JButton save_pension;
    private JComboBox<ComboItem> cmb_pension;
    private JLabel lbl_welcome;
    private HotelManager hotelManager;
    private Hotel hotel;
    private PensionManager pensionManager;
    private SeasonManager seasonManager;
    private HotelDao hotelDao;
    private Season season;

    public SeasonAddView(Hotel hotel) {
      //  this.fld_strt_date = strt_date;
       // this.fld_fnsh_date = fnsh_date;
        this.season = season;
        this.hotel = hotel;
        this.seasonManager = new SeasonManager();
        this.pensionManager = new PensionManager();
        this.hotelManager = new HotelManager();
        this.add(container);
        this.guiInitialize(300, 500);


        this.lbl_welcome.setText("Otel " + this.hotel.getId());


        btn_save_season.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] checkFieldList = {

                        fld_fnsh_date,
                        fld_strt_date
                };
                if (Helper.isFieldListEmpty(checkFieldList) || fld_strt_date.getText().equals("DD/MM/YYYY")
                ||    fld_fnsh_date.getText().equals("DD/MM/YYYY"))
                {
                    Helper.showMsg("fill");


                } else {
                    Season season = new Season();
                   season.setHotel_id(season.getHotel_id());
                   season.setStrt_date(String.valueOf(LocalDate.parse((CharSequence) fld_strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    season.setFnsh_date(String.valueOf(LocalDate.parse((CharSequence) fld_fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
               //     season.setFnsh_date(LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                    if (seasonManager.save(season)){
                        Helper.showMsg("done");
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }




    private void createUIComponents() throws ParseException {
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_strt_date.setText("01/01/2023");
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_fnsh_date.setText("01/01/2024");
    }
}


    /*
            save_pension.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = false;
                ComboItem selectedPensionType = (ComboItem) cmb_pension.getSelectedItem();
                pension.setHotel_id(selectedPensionType.getKey());
                pension.setPension_type((String) cmb_pension.getSelectedItem());
                if (pension.getId() != 0){
                    dispose();
                } else {
                    result = pensionManager.save(pension);
                }
                if  (result){
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
     */

