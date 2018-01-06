/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author allen
 */
public interface OrderBurgerDAOInterface {
    
    public boolean OrderBurger(int orderNumber,int burger_id,int quantity_ordered);
}
