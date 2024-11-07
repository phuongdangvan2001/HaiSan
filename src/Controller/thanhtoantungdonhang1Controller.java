package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.thanhtoantungdonhangdao;
import dao.xacnhandao;

/**
 * Servlet implementation class thanhtoantungdonhang1Controller
 */
@WebServlet("/thanhtoantungdonhang1Controller")
public class thanhtoantungdonhang1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoantungdonhang1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			long mct = Long.parseLong(request.getParameter("mct"));
			String gopy = request.getParameter("txtun");
			xacnhandao xn = new xacnhandao();
			xn.Themgopy(gopy, mct);
			thanhtoantungdonhangdao tt = new thanhtoantungdonhangdao();
			tt.xacnhan(mct);
			response.sendRedirect("thanhtoantungdonhangController");
		} catch (Exception e) {
			// TODO: handle exception
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
