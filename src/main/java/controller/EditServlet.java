package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import element.productImp;
import entity.Product;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/update")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		productImp imp = new productImp();
		Product product = imp.find_by_id(id);
		request.setAttribute("pro", product);
		request.getRequestDispatcher("view/product/update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		productImp newProductImp = new productImp();
		 String name = request.getParameter("name");
		 float price = Float.parseFloat(request.getParameter("price"));
		 float sale_price =Float.parseFloat(request.getParameter("sale_price"));
		 String description = request.getParameter("description");
		 boolean status = Boolean.parseBoolean(request.getParameter("status"));
		 System.out.println(status);
		 Product product = new Product(0, name, price, sale_price, description, status);
		newProductImp.edit(id, product);
		response.sendRedirect("/demo");
	}

}
