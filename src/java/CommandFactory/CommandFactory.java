/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

/**
 *
 * @author allen
 */
public class CommandFactory {
    
    public Command createCommand(String action)
    {
        Command command;
        
        if (action.equalsIgnoreCase("viewBurger"))
        {
            command = new ViewAllBurgers();
        }
        else if (action.equalsIgnoreCase("create"))
        {
            command = new CreateBurgerCommand();
        }
        else if (action.equalsIgnoreCase("buyBurger"))
        {
            command = new BuyBurgerCommand();
        }
        else if (action.equalsIgnoreCase("clearCart"))
        {
            command = new ClearCartCommand();
        }
        else {
             command = new ErrorCommand();
        }
        
        return command;
    }
}
