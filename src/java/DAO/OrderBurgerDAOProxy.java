/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.OrderBurger;
/**
 *
 * @author allen
 */


public class OrderBurgerDAOProxy {
    
    private OrderBurgerDAO OrderBDao;
    public boolean OrderBurger(int orderNumber,int burger_id,int quantity_ordered){
        boolean ordBurger = OrderBDao.OrderBurger(orderNumber, burger_id, quantity_ordered);
        return ordBurger;
    }
}
