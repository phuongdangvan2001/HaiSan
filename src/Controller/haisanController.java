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


/**
 * Servlet implementation class haisanController
 */
@WebServlet("/haisanController")
public class haisanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public haisanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		haisanbo sbo = new haisanbo();
		ArrayList<haisanbean> dssach = sbo.geths();
		String maloai=request.getParameter("ml");
		if(maloai!=null)
   			dssach=sbo.TimMa(maloai);
		request.setAttribute("dssachad", dssach);
		RequestDispatcher rd = request.getRequestDispatcher("haisanadmin.jsp");
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
