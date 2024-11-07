package bo;

import java.util.ArrayList;

import bean.tendangnhapbean;
import dao.tendangnhapdao;

public class tendangnhapbo {
	tendangnhapdao tdndao = new tendangnhapdao();
	ArrayList<tendangnhapbean> ds ;
	public tendangnhapbean ktdn(String tendn, String pass){
		return tdndao.ktdn(tendn, pass);
	}
}
