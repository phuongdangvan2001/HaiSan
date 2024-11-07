package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.khachhangbo;

/**
 * Servlet implementation class ktdkController
 */
@WebServlet("/ktdkController")
public class ktdkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ktdkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String username = request.getParameter("tk");
			String pass = request.getParameter("mk");
			String ht = request.getParameter("ht");
			String dc = request.getParameter("dc");
			String sdt = request.getParameter("sdt");
			String email = request.getParameter("email");
			HttpSession session = request.getSession();
			khachhangbo khbo = new khachhangbo();
			RequestDispatcher rd = null;
			if (username == null) {
				rd = request.getRequestDispatcher("ktdnController");
				rd.forward(request, response);
			} else {
				if (khbo.timTaiKhoan(username) == null) {
					khbo.dangky(ht, dc, sdt, email, username, khbo.getMd5Hash(pass));
					session.setAttribute("dk", username);
					session.setAttribute("dn", username);
					rd = request.getRequestDispatcher("ktdnController");
				} else
					rd = request.getRequestDispatcher("ktdnController?kt=1");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
