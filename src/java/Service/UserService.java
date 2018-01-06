/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import DTO.PlainBurger;
import DTO.OrderBurger;
import DAO.BurgerDAO;
import DAO.OrderBurgerDAO;

import DTO.BaconAddOn;
import DTO.CheeseAddOn;
import DTO.EggAddOn;
import DTO.MayoAddOn;
import DTO.SausageAddOn;
import DTO.SpecialBeef;
import DTO.VegetarianPatty;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author allen
 */
public class UserService {
    
    public boolean create(int burgerId, String bun, String meat, String sauce, String salad, String desc, double burgerPrice)
    {
        boolean chck = false;
        try 
        {
            BurgerDAO dao = new BurgerDAO();
            chck = dao.createBurger(burgerId,bun, desc, desc, sauce, desc, burgerPrice);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return chck;
    }
    
    public ArrayList<PlainBurger> viewAllBurgers()
    {
        ArrayList<PlainBurger> plainBurger = new ArrayList();
        try 
        {
            BurgerDAO dao = new BurgerDAO();
            plainBurger = dao.viewAllBurgers();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return plainBurger;
    }
    
    public PlainBurger findBurgerById(int burgerId)
    {
        PlainBurger b = null;
        BurgerDAO dao = new BurgerDAO();
        try
        {
            b = dao.findBurgerByID(burgerId);
        } 
        catch (Exception e)
        {
           
        }
        return b;
    }
    
    public boolean orderBurger(int orderNumber,int burger_id,int quantity_ordered)
    {
        boolean check = false;
        try 
        {
            OrderBurgerDAO dao = new OrderBurgerDAO();
            check = dao.OrderBurger(orderNumber, burger_id, quantity_ordered);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return check;
    }
}
