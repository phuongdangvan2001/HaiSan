package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.loaibo;

/**
 * Servlet implementation class adminaddloaiController
 */
@WebServlet("/adminaddloaiController")
public class adminaddloaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminaddloaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("txtmaloai") != null && request.getParameter("txttenloai") != null) {
			String maloai = request.getParameter("txtmaloai");
			String tenloai = request.getParameter("txttenloai");
			loaibo lbo = new loaibo();
			lbo.Themloai(maloai, tenloai);
			response.sendRedirect("loaiController");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("adminaddloai.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
