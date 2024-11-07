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
import bean.loaibean;
import bo.haisanbo;
import bo.loaibo;

/**
 * Servlet implementation class hthaisanController
 */
@WebServlet("/hthaisanController")
public class hthaisanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hthaisanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
 		response.setCharacterEncoding("utf-8");
 		String indexPage = request.getParameter("index");
 		if (indexPage == null) {
			indexPage = "1";
		}
 		int index = Integer.parseInt(indexPage);
 		int count = 0;
		int endPage = 0;
		loaibo lbo = new loaibo();
		ArrayList<loaibean>	dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		haisanbo sbo = new haisanbo();
		ArrayList<haisanbean> dssach = sbo.geths();
		String maloai=request.getParameter("ml");
		String key=request.getParameter("txttk");
		if(maloai!=null)
   			dssach=sbo.TimMa(maloai);
   		else
   			if(key!=null)
   				dssach=sbo.Tim(key);
//		count = dssach.size();
//		endPage = count / 12;
//		if (count % 12 != 0) {
//			endPage++;
//		}
//		request.setAttribute("endP", endPage);
//		request.setAttribute("index", index);
//		dssach = sbo.getsachPag();
		request.setAttribute("dssach", dssach);
		RequestDispatcher rd = request.getRequestDispatcher("hthaisan.jsp");
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
