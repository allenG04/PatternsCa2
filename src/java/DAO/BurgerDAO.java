/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PlainBurger;
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
    public ArrayList<PlainBurger> viewAllBurgers() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<PlainBurger> burger = new ArrayList();
        try {
            con = this.getConnection();
            //db query to list all the burgers..
            String query = "select * from burger";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            //gets all the info from the database...
            while (rs.next()) {

                int burgerID = rs.getInt("burger_id");

                String breadType = rs.getString("basicBun");

                String meatType = rs.getString("origBeef");
                
                String sauce = rs.getString("ketchup");
                
                String salad = rs.getString("plainLettuce");
                
                String desc = rs.getString("description");

                double price = rs.getDouble("price");

                
                
                PlainBurger b = new PlainBurger(burgerID, breadType, meatType, sauce, salad, desc, price);
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

    public boolean createBurger(int burger_id,String basicBun, String origBeef, String ketchup, String plainLettuce, String description, double price) {
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = this.getConnection();
            //query adds ingredients
            String query = "insert into burger(burger_id,basicBun, origBeef, ketchup, plainLettuce, description, price) values (?,?, ?, ?, ?, ?, ?)";
            
            //adds the entered information to the db...
            ps = con.prepareStatement(query);
            
            ps.setInt(1, burger_id);
            ps.setString(2, basicBun); 
            ps.setString(3, origBeef);
            ps.setString(4, ketchup);
            ps.setString(5, plainLettuce);
            ps.setString(6, description);
            ps.setDouble(7, price);
            
            
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
    
    public PlainBurger findBurgerByID(int burger_id)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PlainBurger b = null;

        try
        {
            //Get connection object using the methods in the super class DAO.java
            con = this.getConnection();
            // looks for the burger_id to match in the database and returns the burger information relating to the id
            String query = "select * from burger where burger_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, burger_id);
            //PreparedStatement is used to execute SQL
            rs = ps.executeQuery();

            while (rs.next())
            {
                int burgerID = rs.getInt("burger_id");
                String bun = rs.getString("basicBun");
                String meat = rs.getString("origBeef");
                String sauce = rs.getString("ketchup");
                String salad = rs.getString("sauce");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                

                b = new PlainBurger(burgerID,bun, meat, sauce,salad, description, price);
            }
        } catch (SQLException e)
        {
            System.err.println("\tA problem occurred during the findBurgerById method:");
            System.err.println("\t" + e.getMessage());
        } finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            } catch (SQLException e)
            {
                System.err.println("A problem occurred when closing down the findBurgerById Method:\n" + e.getMessage());
            }
        }
        return b;
    }

   
    
}
