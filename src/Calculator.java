/**
 * Calculator.
 * @author Xuesong Zhang (Andrew ID: xuesongz)
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator.
 * @author Xuesong Zhang (Andrew ID: xuesongz)
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calculator() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String function = request.getParameter("function");
		
		out.println("<!doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"utf-8\">");
        out.println("        <title>Calculator</title>");
        out.println("        <style type=\"text/css\">");
        out.println("            table {");
        out.println("                border-width: 2px;");
        out.println("                border-style: dotted;");
        out.println("                border-color: black;");
        out.println("                background-color: #EEE;");
        out.println("            }");
        out.println("            #plus,#minus,#multiply,#divide {");
        out.println("                width: 60px;");
        out.println("                background-color: #EEE;");
        out.println("            }");
        out.println("        </style>");
        out.println("    </head>");
        out.println("    <body>");
        
        if (x != null && y != null) {
            try {         	
            	if (x.trim().isEmpty()) {
                	out.println("<h2><span style=\"color:red\">Number X is missing.</span></h2>");
                } else if (!x.trim().matches("^-{0,1}\\d{0,}\\.{0,1}\\d{0,}$")) {
                	out.println("<h2><span style=\"color:red\">X is not a number.</span></h2>");
                }
                	
                if (y.trim().isEmpty()) {
                	out.println("<h2><span style=\"color:red\">Number Y is missing.</span></h2>");
                } else if (!y.trim().matches("^-{0,1}\\d{0,}\\.{0,1}\\d{0,}$")) {
                	out.println("<h2><span style=\"color:red\">Y is not a number.</span></h2>");
                } else if (Double.parseDouble(y) == 0 && function.equals("/")) {
                	out.println("<h2><span style=\"color:red\">Cannot divide by zero.</span></h2>");
                }
            	
                double numX = Double.parseDouble(x);
                double numY = Double.parseDouble(y);
                
                DecimalFormat df = new DecimalFormat("#,##0.00");
                
                if (function.equals("+")) {
                	out.println("<h2>" + df.format(numX) + " + " + df.format(numY));
	                double result = numX + numY;
	                out.println(" = " + df.format(result));
	                out.println("</h2>");
                }
                if (function.equals("-")) {
                	out.println("<h2>" + df.format(numX) + " - " + df.format(numY));
	                double result = numX - numY;
	                out.println(" = " + df.format(result));
	                out.println("</h2>");
                }
                if (function.equals("*")) {
                	out.println("<h2>" + df.format(numX) + " * " + df.format(numY));
	                double result = numX * numY;
	                out.println(" = " + df.format(result));
	                out.println("</h2>");
                }
                if (function.equals("/") && !(Double.parseDouble(y) == 0)) {
                	out.println("<h2>" + df.format(numX) + " / " + df.format(numY));
	                double result = numX / numY;
	                out.println(" = " + df.format(result));
	                out.println("</h2>");
                }
            } catch (NumberFormatException e) {
            	System.out.println("Input is not number.");
            }
        } else if (x == null && y != null) {
        	x = "";
        	out.println("<h2><span style=\"color:red\">No parameter X to the server.</span></h2>");
        } else if (y == null && x != null) {
        	y = "";
        	out.println("<h2><span style=\"color:red\">No parameter Y to the server.</span></h2>");
        } else {
        	x = "";
            y = "";
            out.println("<h2><span style=\"color:red\">No parameters X,Y to the server.</span></h2>");
        }  
        
        out.println("  <form action=\"Calculator\" method=\"POST\">");
        out.println("        <table>");
        out.println("            <tr>");
        out.println("                <td style=\"font-size: large; text-align: right;\">X:</td>");
        out.println("                <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"x\" id=\"x\" value=\"" + x + "\"></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td style=\"font-size: large; text-align: right;\">Y:</td>");
        out.println("                <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"y\" id=\"y\" value=\"" + y + "\"></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td colspan=\"2\"></td>");
        out.println("                <td>");
        out.println("                    <input id=\"plus\" type=\"submit\" value=\"+\" name=\"function\">");
        out.println("                    <input id=\"minus\" type=\"submit\" value=\"-\" name=\"function\">");
        out.println("                    <input id=\"multiply\" type=\"submit\" value=\"*\" name=\"function\">");
        out.println("                    <input id=\"divide\" type=\"submit\" value=\"/\" name=\"function\">");
        out.println("                </td>");
        out.println("            </tr>");
        out.println("        </table>");
        out.println("  </form>");
        
        out.println("    </body>");
        out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"utf-8\">");
        out.println("        <title>Calculator</title>");
        out.println("        <style type=\"text/css\">");
        out.println("            table {");
        out.println("                border-width: 2px;");
        out.println("                border-style: dotted;");
        out.println("                border-color: black;");
        out.println("                background-color: #EEE;");
        out.println("            }");
        out.println("            #plus,#minus,#multiply,#divide {");
        out.println("                width: 60px;");
        out.println("                background-color: #EEE;");
        out.println("            }");
        out.println("        </style>");
        out.println("    </head>");
        out.println("    <body>");
        
        out.println("  <form action=\"Calculator\" method=\"POST\">");
        out.println("        <table>");
        out.println("            <tr>");
        out.println("                <td style=\"font-size: large; text-align: right;\">X:</td>");
        out.println("                <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"x\" id=\"x\" value=\"" + "" + "\"></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td style=\"font-size: large; text-align: right;\">Y:</td>");
        out.println("                <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"y\" id=\"y\" value=\"" + "" + "\"></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td colspan=\"2\"></td>");
        out.println("                <td>");
        out.println("                    <input id=\"plus\" type=\"submit\" value=\"+\" name=\"function\">");
        out.println("                    <input id=\"minus\" type=\"submit\" value=\"-\" name=\"function\">");
        out.println("                    <input id=\"multiply\" type=\"submit\" value=\"*\" name=\"function\">");
        out.println("                    <input id=\"divide\" type=\"submit\" value=\"/\" name=\"function\">");
        out.println("                </td>");
        out.println("            </tr>");
        out.println("        </table>");
        out.println("  </form>");
        
        out.println("    </body>");
        out.println("</html>");
	}
}
