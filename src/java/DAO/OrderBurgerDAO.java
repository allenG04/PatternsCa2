/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author allen
 */
public class OrderBurgerDAO extends Dao implements OrderBurgerDAOInterface {
    
    public boolean OrderBurger(int orderNumber,int burger_id,int quantity_ordered){
        
        Connection con = null;
        PreparedStatement ps = null;
        try 
        {
             //Get connection object using the methods in the super class DAO.java
            con = this.getConnection();
            System.out.println("The order number being entered is " + orderNumber);
            // insert the new burger into the database
            String query = "call orderburger (?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderNumber);
            ps.setInt(2, burger_id);
            ps.setInt(3, quantity_ordered);

            int i = ps.executeUpdate();
            // if not updated return false .  order hasn't been created
            if(i == 0)
            {
                return false;
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("\tA problem occurred during the  orderBurger method:");
            System.err.println("\t"+e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                System.err.println("A problem occurred when closing down the  orderBurger method:\n" + e.getMessage());
            }
        }
        return true;
    }
}
