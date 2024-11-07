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
import javax.swing.JOptionPane;

import bean.khachhangbean;
import bean.loaibean;
import bo.khachhangbo;
import bo.loaibo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class ktdnController
 */
@WebServlet("/ktdnController")
public class ktdnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ktdnController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		khachhangbo khbo = new khachhangbo();
		HttpSession session = request.getSession();
		String un= request.getParameter("txtun");
		String pass= request.getParameter("txtpass");
		int count = 0;
		if (session.getAttribute("countLogin") != null)
			count = (int) session.getAttribute("countLogin");
		if (un!=null && pass!=null) {
			ArrayList<khachhangbean> dskh = khbo.getkh();
			int i = 0;
			//tao doi tuong session
			for (khachhangbean s: dskh) {
//				System.out.println(s.getTenDangNhap());
//				System.out.println(s.getMatKhau());
				if (un.equals(s.getTendn()) && (khbo.getMd5Hash(pass).equals(s.getPass()) && count <3)) {
					session.setAttribute("dn", un);
					i++;
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
					   //Neu chua tao session
					  if(session.getAttribute("kh")==null) {
						session.setAttribute("kh", s);//Tao bien session dn
					  }

					RequestDispatcher rd = request.getRequestDispatcher("hthaisanController");
					rd.forward(request, response);
				}
				if(un.equals(s.getTendn()) && (khbo.getMd5Hash(pass).equals(s.getPass()) && count >=3)) {
					Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					String answer = request.getParameter("answer");
					if (captcha.isCorrect(answer)){
						session.setAttribute("dn", un);
						i++;
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
						   //Neu chua tao session
						  if(session.getAttribute("kh")==null) {
							session.setAttribute("kh", s);//Tao bien session dn
						  }
						session.setAttribute("countLogin", 0);
						RequestDispatcher rd = request.getRequestDispatcher("hthaisanController");
						rd.forward(request, response);
					}
				}
			}
			if (i == 0) {
				session.setAttribute("countLogin", count + 1);
				int s = JOptionPane.showConfirmDialog(null, "Đăng nhập lại!", "Đăng nhập thất bại! Tài khoản hoặc mật khẩu sai!", JOptionPane.OK_CANCEL_OPTION);
				if (s == JOptionPane.OK_OPTION) {
					RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("hthaisanController");
					rd.forward(request, response);
				}
			}
			
			//Neu chua tao session
//			if (session.getAttribute("dn") == null)
//				session.setAttribute("dn", "");
//			session.setAttribute("dn", un);
		}else {
			session.setAttribute("countLogin", count + 1);
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
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
