/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandFactory;

import Service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author allen
 */
public class CreateBurgerCommand implements Command {
    
    public String executeCommand(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;
        
        //calls the user service class...
        UserService userService = new UserService();

        Boolean check;
        
        //parameters entered by the user to register...
        String id = request.getParameter("burger_id");
        String bun = request.getParameter("basicBun");
        String meat = request.getParameter("origBeef");
        String sauce = request.getParameter("ketchup");
        String salad = request.getParameter("plainLettuce");
        String desc = request.getParameter("description");
        String price = request.getParameter("price");
        
        //checks if parameters aren't null and not empty...
        if (id != null && bun != null && meat != null && sauce != null && salad != null && desc != null && price != null
                &&!id.isEmpty() && !bun.isEmpty() && !meat.isEmpty() && !sauce.isEmpty() && !salad.isEmpty() && !desc.isEmpty() && !price.isEmpty()) {
            
            int burgerId = Integer.parseInt(id);
            double burgerPrice = Double.parseDouble(price);
            
            //register method from the user service is stored in the boolean variable called "check"...
            check = userService.create(burgerId,bun, meat, sauce, salad, desc, burgerPrice);
            
            //if true
            if (check == true) {
                
                //then forward to the registration success jsp...
                forwardToJsp = "/CreateBurgerSuccess.jsp";
            } else {
                //if fail, forward to registration fail jsp...
                forwardToJsp = "/CreateBurgerFail.jsp";
            }
        } else {
            //if parameters are null and empty then forward to registration fail jsp...
            forwardToJsp = "/CreateBurgerFail.jsp";
        }

        return forwardToJsp;

    }
}
