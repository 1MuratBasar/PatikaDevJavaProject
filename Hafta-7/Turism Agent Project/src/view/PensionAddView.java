package view;

import business.HotelManager;
import business.PensionManager;
import core.ComboItem;
import core.Helper;
import dao.HotelDao;
import entity.Hotel;
import entity.Pension;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PensionAddView extends Layout {

    private  Pension pension;
    private JPanel container;
    private JButton save_pension;
    private JComboBox<ComboItem> cmb_pension;
    private JLabel lbl_welcome;
   private HotelManager hotelManager;
    private Hotel hotel;
    private PensionManager pensionManager;

    private HotelDao hotelDao;

    public PensionAddView(Hotel hotel) {
        this.hotel = hotel;
        this.pensionManager = new PensionManager();
        this.hotelManager = new HotelManager();
        this.add(container);
        this.guiInitialize(300, 500);


        this.lbl_welcome.setText("Otel " + this.hotel.getId());

        for (Pension pension : this.pensionManager.findAll()){
            this.cmb_pension.addItem(new ComboItem(pension.getHotel_id(), pension.getPension_type()));
        }


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
    }
}
