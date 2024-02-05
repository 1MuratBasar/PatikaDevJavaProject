package view;

import business.UserManager;
import core.ComboItem;
import core.Helper;
import entity.User;

import javax.swing.*;

public class UserView extends Layout {

    private JPanel container;
    private JLabel lbl_username;
    private JTextField fld_username;
    private JLabel lbl_pass;
    private JPasswordField fld_password;
    private JLabel lbl_role;
    private JComboBox cmb_user_role;
    private JButton btn_update;
    private User user;
    private UserManager userManager;

    public UserView(User user) {
        this.user = user;
        this.userManager = new UserManager();
        // this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitialize(300, 500);


       for (User brand : this.userManager.findAll()) {
           this.cmb_user_role.addItem(new ComboItem(user.getId(), brand.getRole()));
      }
        if (this.user.getId() != 0) {
            this.fld_username.setText(this.user.getUsername());
            this.fld_password.setText(this.user.getPassword());
            this.cmb_user_role.getModel().setSelectedItem(this.user.getRole());

            this.btn_update.addActionListener(e -> {
                if (Helper.isFieldListEmpty(new JTextField[]{this.fld_username, this.fld_password})) {
                    Helper.showMsg("fill");
                } else {
                    boolean result;

                    this.fld_username.setText(this.user.getUsername());
                    this.fld_password.setText(this.user.getPassword());
                    this.cmb_user_role.setSelectedItem(this.user.getRole());

                    if (this.user.getId() != 0) {
                        result = this.userManager.update(this.user);
                    } else {
                        result = this.userManager.save(this.user);
                    }
                    if (result) {
                        Helper.showMsg("done");
                        dispose();
                    } else {
                        Helper.showMsg("error");
                    }

                }
            });


        }


    }
}
