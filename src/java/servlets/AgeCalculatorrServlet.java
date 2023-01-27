package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xbali
 */
public class AgeCalculatorrServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //retrieve values from a form (getParameter)
        String age = request.getParameter("age");
        
        request.setAttribute("age", age);
       
 // Checks if textbox is empty
        if(age == null || age.equals("")){
            request.setAttribute("showMessage", "You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);                
            return;
        }

 // Display age
        try{
            int addAge = Integer.parseInt(age);
            request.setAttribute("showMessage", "Your next birthday will be " + ((addAge) + 1) + ".");
 // Catching if there has been anything other than a number for input    
        }catch (NumberFormatException e){
            request.setAttribute("showMessage", "You must enter a number.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);                
            return;  
        }
       getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }
    

}
