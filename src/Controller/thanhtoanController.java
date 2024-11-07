package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.giohangbo;
import dao.chitiethoadondao;
import dao.hoadondao;

/**
 * Servlet implementation class thanhtoanController
 */
@WebServlet("/thanhtoanController")
public class thanhtoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		khachhangbean kh=(khachhangbean)session.getAttribute("kh");
		if(kh==null)
			response.sendRedirect("dangnhapController");
		else {
			giohangbo gh=(giohangbo)session.getAttribute("gio");
			hoadondao hdbo= new hoadondao();
			chitiethoadondao ctbo= new chitiethoadondao();
			//Them vao 1 hoadon
			hdbo.ThemTT(kh.getMakh());
			long mahd=hdbo.maxhd();
			for(giohangbean g: gh.ds)
				ctbo.ThemTT(g.getMahaisan(), g.getSoluong(),mahd);
			session.removeAttribute("gio");
			response.sendRedirect("lichsumuahangController");
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
