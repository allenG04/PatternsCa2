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
import DTO.PlainBurger;
import java.util.ArrayList;

public class BurgerDAOProxy implements BurgerDAOInterface{
    
    private BurgerDAO bDao;
    @Override
    public ArrayList<PlainBurger> viewAllBurgers() {
        ArrayList<PlainBurger> allBurgers = bDao.viewAllBurgers();
        return allBurgers;
    }
    
    @Override
    public boolean createBurger(int burger_id,String basicBun, String origBeef, String ketchup, String plainLettuce, String description, double price) {
        boolean burger = bDao.createBurger(burger_id,basicBun, origBeef, ketchup, plainLettuce, description, price);
        return burger;
    }
    
    
}
