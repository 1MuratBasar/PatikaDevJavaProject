package view;

import entity.User;

import javax.swing.*;

public class EmployeeView extends Layout {
    private JPanel container;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_hotel;
    private JPanel pnl_room;
    private JPanel pnl_reservation;
    private JTable table1;
    private User user;
    public EmployeeView(User user ) {
        this.user = user;
        add(container);
        guiInitialize(1000,700);
    }

}
