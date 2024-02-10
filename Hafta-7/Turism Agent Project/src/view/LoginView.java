package view;

import core.Helper;
import business.UserManager;
import entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_title;
    private JLabel lbl_username;
    private JTextField fld_username;
    private JLabel lbl_password;
    private JTextField fld_password;
    private JButton btn_login;
    private final UserManager userManager;

    public LoginView() {
        this.userManager = new UserManager();
        add(container);
        guiInitialize(300, 300);
       loginButton();
    }


    public void loginButton () {

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] fieldList = {fld_username, fld_password};
                if (Helper.isFieldListEmpty(fieldList)) {
                    Helper.showMsg("fill");
                } else { // else durumda user ı databaseten sorgulatacagımız için user manager lazım onun için de usaerdao lazım bunları olusturuyoruz
                    
                User loginUser = userManager.findByLogin(fld_username.getText(), fld_password.getText());
                  if (loginUser==null) {
                      Helper.showMsg("notFound");
                  }else if (loginUser.getRole().equals("ADMIN")) {
                      AdminView adminView = new AdminView(loginUser);
                      dispose();
                //  }else if (loginUser.getRoling().toString().equals("EMPLOYEE")) {
                 }else if (loginUser.getRole().equals("EMPLOYEE")) {

                      EmployeeView employeeView = new EmployeeView (loginUser);
                      dispose();
                  }
                }
            }
        });

    }

}
