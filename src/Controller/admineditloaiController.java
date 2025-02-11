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
 * Servlet implementation class admineditloaiController
 */
@WebServlet("/admineditloaiController")
public class admineditloaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admineditloaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if(request.getParameter("ml") != null && request.getParameter("txttenloai") != null && !request.getParameter("txttenloai").equals("") ) {
			String maloai = request.getParameter("ml");
			String tenloai = request.getParameter("txttenloai");
			loaibo lbo = new loaibo();
			lbo.Sualoai(maloai, tenloai);
			response.sendRedirect("loaiController");
			System.out.println("in" + request.getParameter("ml"));
		}
		else {
			request.setAttribute("maloai", request.getParameter("ml"));
			request.setAttribute("tenloai", request.getParameter("tenloai"));
			RequestDispatcher rd = request.getRequestDispatcher("admineditloai.jsp");
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
