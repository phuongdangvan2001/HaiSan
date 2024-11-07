package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.haisanbean;
import bo.haisanbo;
import bo.loaibo;

/**
 * Servlet implementation class adminedithaisanController
 */
@WebServlet("/adminedithaisanController")
public class adminedithaisanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminedithaisanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		loaibo lbo = new loaibo();
		request.setAttribute("dsloai", lbo.getloai());
		
		haisanbo sbo = new haisanbo();
		ArrayList<haisanbean> sbean = (ArrayList<haisanbean>)sbo.gethaisanbyma(request.getParameter("ms"));
		request.setAttribute("sach", sbean);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminedithaisan.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
