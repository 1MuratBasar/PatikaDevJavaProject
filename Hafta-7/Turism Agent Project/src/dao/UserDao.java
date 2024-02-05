package dao;

import core.Db;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {


    private final Connection con;

    public UserDao() {
        this.con = Db.getInstance();
    }


    public User findByLogin(String username, String password) {
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_pass = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1,username);
            pr.setString(2,password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = this.match(rs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM public.user";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                userList.add(this.match(rs));
            }
         }catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    // user role gore arama
    public ArrayList<User> findByRole(String userSearchRole) {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM public.user WHERE user_role =" + "'"+userSearchRole+"'";
        System.out.println("query " + query);
        try{

            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()){
                userList.add(this.match(rs));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;


    }

    public User match (ResultSet rs) throws SQLException {
        User obj = new User();
        obj.setId(rs.getInt("user_id"));
        obj.setUsername(rs.getString("user_name"));
        obj.setPassword(rs.getString("user_pass"));
        obj.setRole(rs.getString("user_role"));
        return obj;
    }


    public boolean save(User newUser) {
        String query = "INSERT INTO public.user (user_name, user_pass, user_role) VALUES (?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, newUser.getUsername());
            pr.setString(2, newUser.getPassword());
            pr.setString(3  , newUser.getRole());
            //
            return pr.executeUpdate() !=-1;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int selectUserId) {
        String query = "DELETE FROM public.user WHERE user_id = ?";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1,selectUserId);
            return pr.executeUpdate() != -1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean update (User user) {

        String query = "UPDATE public.user SET " +
                "user_name = ? , " +
                "user_pass = ? , " +
                "user_role = ? " +
                "WHERE user_id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, user.getId());
            pr.setString(2, user.getUsername());
            pr.setString(3, user.getPassword());
            pr.setString(4, user.getRole());

            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public User getById (int id) {
        User obj = null;
        String query = "Select * from public.user WHERE user_id = ? ";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) obj=this.match(rs);

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return obj;
    }


}
