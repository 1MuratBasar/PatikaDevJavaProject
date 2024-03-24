package view;

import business.*;

import core.ComboItem;
import entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class EmployeeView extends Layout {
    private JPanel container;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_hotel;
    private JPanel pnl_room;
    private JPanel pnl_reservation;
    private User user;
    private DefaultTableModel tmdl_hotel= new DefaultTableModel(); // defaulttable modeli biz tanımladık ve tmdl ismini biz verdik,
    private DefaultTableModel tmdl_season= new DefaultTableModel();
    private DefaultTableModel tmdl_pension= new DefaultTableModel();
    private DefaultTableModel tmdl_reservation= new DefaultTableModel();
    private DefaultTableModel tmdl_room= new DefaultTableModel();

    private JTable tbl_hotel;
    private JTable tbl_season;
    private JTable tbl_pension;
    private JButton btn_exit;
    private JButton btn_add_room;
    private JTextField fld_hote_name;
    private JTextField fld_city;
    private JTextField fld_entry_date;
    private JTextField fld_exit_date;
    private JTextField textField4;
    private JComboBox<Room.Adult> cmb_adult;
    private JComboBox<Room.Child> cmb_child;
    private JButton btn_search;
    private JButton btn_clear;
    private JPanel pnl_room2;
    private JTable tbl_room;
    private JLabel lbl_welcome;
    private JButton btn_add_hotel;
    private JTable tbl_reservation;
    private JTabbedPane tabbedpane;
    private JTabbedPane tabbedPane3;
    private Season season;
    private JScrollPane scrl_bottom;
    private JPopupMenu hotel_menu;  //hotel - kısım1
    private JPopupMenu pension_menu;
    private HotelManager hotelManager;
    private ReservationManager reservationManager;
    private SeasonManager seasonManager;
    private PensionManager pensionManager;
    private RoomManager roomManager;
    private Object[] col_hotel;
    private Object[] col_season;
    private Object[] col_pension;
        private Object[] col_reservation;
        private Object[] col_room;
    public EmployeeView(User user ) {
        this.user = user;
        add(container);
        guiInitialize(1100,700);
        this.hotelManager = new HotelManager();
        this.reservationManager = new ReservationManager();
        this.pensionManager = new PensionManager();
        this.seasonManager = new SeasonManager();
        this.roomManager = new RoomManager();
        this.season = new Season();
        this.lbl_welcome.setText("Hoşgeldiniz " + this.user.getUsername());
        loadHotelTable(null);
        loadHotelComponent();

      //  loadSeasonTable(null);
       // loadSeasonComponent();

        loadPensionTable(null);
        loadSeasonTable(null);
        loadReservationTable (null);
        loadRoomTable(null);
        loadRoomFilter();

        //*******************************************************************************************************************************
               // ***ODA ARAMA*************
        btn_search.addActionListener(e -> {
         //   ComboItem selectGuest = (ComboItem) this.cmb_adult.getSelectedItem();
            ArrayList<Room> roomListBySearch = this.roomManager.searchForTable(fld_hote_name.getText(), fld_city.getText());



        });



        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmb_adult.setSelectedItem(null);
                cmb_child.setSelectedItem(null);
                fld_hote_name.setText(null);
                fld_city.setText(null);
            }

        });
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_add_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomAddView roomAddView = new RoomAddView(null);
            }
        });
    }
    //*******************************************************************************************************************************

    private void loadRoomFilter() {

        this.cmb_adult.setModel(new DefaultComboBoxModel<>(Room.Adult.values()));
        this.cmb_adult.setSelectedItem(null);
        this.cmb_child.setModel(new DefaultComboBoxModel<>(Room.Child.values()));
        this.cmb_child.setSelectedItem(null);
       }

    //*******************************************************************************************************************************

    private void loadRoomTable (ArrayList<Object[]> roomList){

          col_room = new Object[] {"Room_id", "hotel_name ", "pension" ,"room type",
                  "sezon bailangıç tarihi", "sezon bitiş tarihi", "stok", "yatak", "metrekare",
                    "yetişkin ücret" , "çocuk ücret", "klima" , "minibar", "tv" , "kasa", "buzdolabı"  };
            if (roomList == null) {
                roomList = this.roomManager.getForTable(col_room.length, this.roomManager.findAll());  // getfortable brandmanager da uretildi

            }
            //  ArrayList<Object[]> hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());
            createTable(this.tmdl_room, this.tbl_room, col_room, roomList);
    }


    //*******************************************************************************************************************************

    private void loadHotelComponent() {
        tableRowSelect(this.tbl_hotel);
        this.hotel_menu = new JPopupMenu();
        this.hotel_menu.add("Yeni Otel Ekle").addActionListener(e -> {
          //  int selectCarId = this.getTableSelectedRow(this.tbl_hotel, 0);
         //   System.out.println("yeni tıklandı");
            HotelView hotelView = new HotelView(null);
            hotelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                     //loadPensionTable();
                }
            });
        });

        this.tbl_hotel.setComponentPopupMenu(hotel_menu);
        this.tbl_pension.setComponentPopupMenu(hotel_menu);
        this.tbl_season.setComponentPopupMenu(hotel_menu);
//*****************************************************************************************************************
        btn_add_hotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            HotelView hotelView = new HotelView(new Hotel());
            }
        });
//*******************************************************************************************************************************
        this.hotel_menu.add("Pansiyon Ekle").addActionListener(e -> {

            int selectId = this.getTableSelectedRow(this.tbl_hotel, 0);
            //   System.out.println("yeni tıklandı");
            PensionAddView pensionAddView = new PensionAddView(this.hotelManager.getById(selectId));

            // PensionAddView pensionAddView = new PensionAddView(this.hotelManager.getById(selectId));
            pensionAddView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPensionTable(null);
                }
            });
        });
//*******************************************************************************************************************************
        this.hotel_menu.add("Sezon Ekle").addActionListener(e -> {

            int selectId = this.getTableSelectedRow(this.tbl_hotel, 0);

            SeasonAddView seasonAddView = new SeasonAddView(this.hotelManager.getById(selectId));

             seasonAddView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadSeasonTable(null);
                }
            });
        });

    }

//*******************************************************************************************************************************
    private void loadHotelTable(ArrayList<Object[]> hotelList) {

        col_hotel = new Object[] {"Hotel_ID", "hotel_name ", "city" ,"region", "address", "mail", "phone", "star", "carpark",
                "wifi" , "pool", "fitness" , "conclerge", "spa" , "room_service"  };
        if (hotelList == null) {
            hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());  // getfortable brandmanager da uretildi

        }
      //  ArrayList<Object[]> hotelList = this.hotelManager.getForTable(col_hotel.length, this.hotelManager.findAll());
        createTable(this.tmdl_hotel, this.tbl_hotel, col_hotel, hotelList);

    }
/// ***** HOTEL İŞLEMLERİ BİTTİ ********************************************
//*******************************************************************************************************************************

    private void loadPensionTable(ArrayList<Object[]> pensionList) {

        col_pension = new Object[] {"ID","Hotel_id","pension_type"};
        if (pensionList == null) {
            pensionList = this.pensionManager.getForTable(col_pension.length, this.pensionManager.findAll());  // getfortable brandmanager da uretildi

        }
   //       ArrayList<Object[]> hotelList = this.pensionManager.getForTable(col_pension.length, this.pensionManager.findAll());
        createTable(this.tmdl_pension, this.tbl_pension, col_pension, pensionList);

    }
//****************************************************************************************************************

    private void loadReservationTable(ArrayList<Object[]> reservationList) {

        col_reservation = new Object[] {"ID","Room_ID","Checkin Date","Checkout Date","Total_Price","Guest_Count",
                "Guest Name","Guest ID","Guest Mail","Guest Phone"};
        if (reservationList == null) {
            reservationList = this.reservationManager.getForTable(col_reservation.length, this.reservationManager.findAll());  // getfortable brandmanager da uretildi

        }
        //   ArrayList<Object[]> reservList = this.reservationManager.getForTable(col_reservation.length, this.reservationManager.findAll());
            createTable(this.tmdl_reservation, this.tbl_reservation, col_reservation, reservationList);
        //    loadReservationTable(reservList);
    }

//****************************************************************************************************************

   private void loadSeasonTable(ArrayList<Object[]> seasonList) {

        col_season = new Object[] {"ID","Hotel_id","strt_Date","fnsh_date"};
        if (seasonList == null) {
            seasonList = this.seasonManager.getForTable(col_season.length, this.seasonManager.findAll());  // getfortable brandmanager da uretildi

        }
       //   ArrayList<Object[]> seasonsList = this.seasonManager.getForTable(col_season.length, this.seasonManager.findAll());

         createTable(this.tmdl_season, this.tbl_season, col_season, seasonList);
        //    loadSeasonTable(seasonsList);
    }





//****************************************************************************************************************




}
