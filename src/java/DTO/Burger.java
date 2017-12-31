/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Objects;
/**
 *
 * @author allen
 */
public class Burger {
    
    private int burger_id;
    private String breadType;
    private String meatType;
    private String sauce;
    private String salad;
    private double price;
    
    public Burger(){
        
    }

    public Burger(int burger_id, String breadType, String meatType, String sauce, String salad, double price) {
        this.burger_id = burger_id;
        this.breadType = breadType;
        this.meatType = meatType;
        this.sauce = sauce;
        this.salad = salad;
        this.price = price;
    }

    public int getBurger_id() {
        return burger_id;
    }

    public void setBurger_id(int burger_id) {
        this.burger_id = burger_id;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSalad() {
        return salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.burger_id;
        hash = 67 * hash + Objects.hashCode(this.breadType);
        hash = 67 * hash + Objects.hashCode(this.meatType);
        hash = 67 * hash + Objects.hashCode(this.sauce);
        hash = 67 * hash + Objects.hashCode(this.salad);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Burger other = (Burger) obj;
        if (this.burger_id != other.burger_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.breadType, other.breadType)) {
            return false;
        }
        if (!Objects.equals(this.meatType, other.meatType)) {
            return false;
        }
        if (!Objects.equals(this.sauce, other.sauce)) {
            return false;
        }
        if (!Objects.equals(this.salad, other.salad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Burger{" + "burger_id=" + burger_id + ", breadType=" + breadType + ", meatType=" + meatType + ", sauce=" + sauce + ", salad=" + salad + ", price=" + price + '}';
    }
    
    
    
    
    
    
    
    
}
