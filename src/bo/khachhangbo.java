package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();
	ArrayList<khachhangbean> ds ;
	public ArrayList<khachhangbean> getkh(){
		ds = khdao.getkh();
		return ds;
	}
	public khachhangbean timTaiKhoan(String tendn) {
		ds = khdao.getkh();
		for(khachhangbean item : ds) {
			if(item.getTendn().equals(tendn))
				return item;
		}
		return null;
	}
	public String getMd5Hash(String pass) {
		return khdao.getMd5Hash(pass);
	}
	public int dangky(String hoten, String diachi, String sodt, String email, String tendn, String pass) {
		try {
			return khdao.dangky(hoten, diachi, sodt, email, tendn, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
				
	}
}
