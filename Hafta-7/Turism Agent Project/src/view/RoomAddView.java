package view;

import business.UserManager;
import entity.Room;

import javax.swing.*;

public class RoomAddView extends Layout{
    private JPanel container;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JButton btn_save_room;
    private Room room;


    public RoomAddView(Room room) {
        this.room = room;

        this.add(container);
        guiInitialize(700, 400);




}

}