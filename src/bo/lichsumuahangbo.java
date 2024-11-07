package bo;

import java.util.ArrayList;

import bean.lichsumuahangbean;
import dao.lichsumuahangdao;

public class lichsumuahangbo {
	lichsumuahangdao lsdao = new lichsumuahangdao();
	ArrayList<lichsumuahangbean> ds;
	public ArrayList<lichsumuahangbean> getlsmh(int ma){
		ds = lsdao.getlsmh(ma);
		return ds;
	}
	public ArrayList<lichsumuahangbean> gettt(int ma){
		ds = lsdao.gettt(ma);
		return ds;
	}
}
