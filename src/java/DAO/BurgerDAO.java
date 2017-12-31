/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Burger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author allen
 */
public class BurgerDAO extends Dao implements BurgerDAOInterface {
    
    @Override
    public ArrayList<Burger> viewAllBurgers() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Burger> burger = new ArrayList();
        try {
            con = this.getConnection();
            //db query to list all the burgers..
            String query = "select * from burger";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            //gets all the info from the database...
            while (rs.next()) {

                int burgerID = rs.getInt("burger_id");

                String breadType = rs.getString("breadtype");

                String meatType = rs.getString("meattype");
                
                String sauce = rs.getString("sauce");
                
                String salad = rs.getString("salad");

                double price = rs.getDouble("price");

                
                
                Burger b = new Burger(burgerID, breadType, meatType, sauce, salad, price);
                burger.add(b);
            }
        } catch (SQLException e) {
            System.err.println("displayAllBurgers " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("displayAllBurgers " + e.getMessage());
            }
        }
        return burger;
    }

    public boolean createBurger(String breadType, String meatType, String sauce, String salad) {
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = this.getConnection();
            //query adds ingredients
            String query = "insert into burger(breadtype, meattype, sauce, salad, price) values (?, ?, ?, ?, ?)";
            
            //adds the entered information to the db...
            ps = con.prepareStatement(query);
            
            ps.setString(1, breadType); 
            ps.setString(2, meatType);
            ps.setString(3, sauce);
            ps.setString(4, salad);
            
            
            int i = ps.executeUpdate();
            if (i == 0) {
                return false;
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the creation method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the creation method:\n" + e.getMessage());
            }
        }
        return true;
    }
    
}
