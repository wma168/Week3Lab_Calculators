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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("showResult", "---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 //retrieve values from a form (getParameter)
        String firstNum = request.getParameter("firstNum");
        String secondNum = request.getParameter("secondNum");
        
 // Checks if textbox is empty
        if(firstNum == null || firstNum.equals("") 
                || secondNum == null || secondNum.equals("")){
            request.setAttribute("showResult", "invalid");
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                    .forward(request, response);  
            
            return;
        }
        
    int showResult = 0;
    
    try{
 //variables set through parsing for calculations
            int parsedFirstNum = Integer.parseInt(firstNum);
            int parsedSecondNum = Integer.parseInt(secondNum);
            
 //checks which calculations will be performed through switch and then display the answer
 //in the message tag
            switch(request.getParameter("submit")) {
            case "+": 
                showResult = parsedFirstNum+parsedSecondNum;
                break;
            case "-":
                showResult = parsedFirstNum-parsedSecondNum;
                break;
            case "*": 
                showResult = parsedFirstNum*parsedSecondNum;
                break;
            case "/": 
                showResult = parsedFirstNum/parsedSecondNum;
                break;
        }
        } catch (NumberFormatException e) {
            request.setAttribute("showResult","invalid");
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request,response);
            
            return;
        }
        
        request.setAttribute("showResult",showResult);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request,response);
    }

}
