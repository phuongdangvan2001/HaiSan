package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.xacnhandao;

public class xacnhanbo {
	xacnhandao xndao = new xacnhandao();
	public ArrayList<xacnhanbean> getxacnhan(){
		return xndao.getxacnhan();
	}
	public ArrayList<xacnhanbean> getdanhsach(){
		return xndao.getdanhsach();
	}
}
