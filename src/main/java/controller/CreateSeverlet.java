package controller;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import element.productImp;
import entity.Product;

/**
 * Servlet implementation class CreateSeverlet
 */
@WebServlet("/create")
public class CreateSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("view/product/create.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 String name = request.getParameter("name");
		 float price = Float.parseFloat(request.getParameter("price"));
		 float sale_price =Float.parseFloat(request.getParameter("sale_price"));
		 String description = request.getParameter("description");
		 boolean status = Boolean.parseBoolean(request.getParameter("status"));
		 Product product = new Product(0, name, price, sale_price, description, status);
		
	     productImp imp = new productImp();
	     imp.add(product);
	     response.sendRedirect("/demo");
	
		
		
	}

}
