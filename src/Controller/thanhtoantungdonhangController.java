package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bean.lichsumuahangbean;
import bo.lichsumuahangbo;

/**
 * Servlet implementation class thanhtoantungdonhangController
 */
@WebServlet("/thanhtoantungdonhangController")
public class thanhtoantungdonhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoantungdonhangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
 		response.setCharacterEncoding("utf-8");
 		HttpSession session = request.getSession();
 		khachhangbean kh=(khachhangbean)session.getAttribute("kh");
 		if (kh == null) {
 			response.sendRedirect("ktdnController");
 		}
 		else {
	 		lichsumuahangbo lsbo = new lichsumuahangbo();
	 		ArrayList<lichsumuahangbean> dslsmh = lsbo.gettt(kh.getMakh());
			request.setAttribute("dstt", dslsmh);
	// 		if(request.getAttribute("dslsmh") != null){
	//			JOptionPane.showMessageDialog(null, "vvvvvv");
	//		}
			RequestDispatcher rd = request.getRequestDispatcher("thanhtoan.jsp");
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
