/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Burger;
import java.util.ArrayList;

/**
 *
 * @author allen
 */
public interface BurgerDAOInterface {
    public ArrayList<Burger> viewAllBurgers();
    public boolean createBurger(String breadType, String meatType, String sauce, String salad);
    
    
}
