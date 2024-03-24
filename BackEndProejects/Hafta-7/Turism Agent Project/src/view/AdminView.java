package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_bottom;
    private JPanel pnl_top;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_user;
    private JScrollPane scrl_user;
    private JTable tbl_user;
    private JPanel pnl_user_add;
    private JLabel lbl_username;
    private JTextField fld_username;
    private JLabel lbl_password;
    private JTextField fld_password;
    private JComboBox cmb_user_role;
    private JButton btn_user_add;
    private JLabel lbl_user_role;
    private JComboBox cmb_srch_role;
    private JButton btn_search;
    private JButton btn_clear;
    private JButton btn_list;
    private JButton btn_exit;
    private User user;
    private DefaultTableModel tmdl_user = new DefaultTableModel();
    private Object[] col_user;
    private UserManager userManager;
    private JPopupMenu user_menu;
    //açılan ekranda sekmelerim olacaksa Jtabbed pane kullanıyoruz. örnegin oteller pansiyonlar kiralamalar

    public AdminView(User user ) {
        this.userManager = new UserManager();
        this.user = user;
        add(container);
        guiInitialize(1000,700);
//***************************************************************************************************************************************

        if (this.user == null) {
            dispose();
        }
//***************************************************************************************************************************************
        //General Menus
        this.lbl_welcome.setText("Hoşgeldiniz : " + this.user.getUsername());
        loadUserTable(null);
        loadUserComponent();

      //  loadHotelTable();
      //  loadHotelComponent();

//***************************************************************************************************************************************
        //ÇIKIŞ
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
//***************************************************************************************************************************************

        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUserTable(null);
            }
        });
    }
//***************************************************************************************************************************************
        //USER TABLOSU YUKLE
    public void loadUserTable (ArrayList<Object[]> userList) {

        //gui den jtable olusturduk
        //kendimiz defaulttablemodel olusturdul
        //tek boyutlu arry olusturduk, tablo sütun isimlerin tutmak için --> col_model
        //db ye bağlanıp ilgili tablodaki tüm satırları arrayliste çekmek +
        //defaulttable a setlemek için satırların Object [] e dönüşümü  +
        //defaultable a satırların setlenmesi

        this.col_user = new Object[] {"ID", "Kullanıcı Adı", "Şifre", "Rol"};
        if (userList == null) {
            userList = this.userManager.getForTable(this.col_user.length, this.userManager.findAll());

        }
        createTable(this.tmdl_user, this.tbl_user, this.col_user, userList);
    }
//***************************************************************************************************************************************

    public void loadUserComponent (){
        tableRowSelect(this.tbl_user);
        this.user_menu = new JPopupMenu();
        btn_user_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] fieldList = {fld_username, fld_password};
                if (Helper.isFieldListEmpty(fieldList)) {
                    Helper.showMsg("fill");
                } else {
                    boolean result;
                    User newUser = new User();

                    newUser.setUsername(fld_username.getText());
                    newUser.setPassword(fld_password.getText());
                    newUser.setRole((String) cmb_user_role.getSelectedItem());
                    result = userManager.save(newUser);

                    if(result) {
                        Helper.showMsg("done");
                    } else {
                        Helper.showMsg("error");
                    }
                }
                loadUserTable(null);
                fld_username.setText(null);
                fld_password.setText (null);
                }
        });

        this.user_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectUserId = this.getTableSelectedRow(tbl_user,0);
                if (this.userManager.delete(selectUserId)){
                    Helper.showMsg("done");
                    loadUserTable(null);
                } else {
                    Helper.showMsg("error");
                }

            }
        });


        this.user_menu.add("Güncelle").addActionListener(e -> {
            int selectUserId = this.getTableSelectedRow(tbl_user,0);
            UserView userView = new UserView(this.userManager.getById(selectUserId));
            userView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable(null);
                }
            });
        });


            this.tbl_user.setComponentPopupMenu(user_menu);

//***************************************************************************************************************************************

            // arama yapma (constructor dan alıp user componenetin içinde yapıyoruz)
            btn_search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String userSearchRole = (String) cmb_srch_role.getSelectedItem();
                    ArrayList<User> searchedUserList = userManager.findByRole(userSearchRole);
                    ArrayList<Object[]> searchedUserRowList = userManager.getForTable(col_user.length, searchedUserList);
                    //  createTable(tmdl_user, tbl_user, col_user, searchedUserRowList);
                    loadUserTable(searchedUserRowList);
                }
            });
//***************************************************************************************************************************************


        }

    }



