package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds ;
	public ArrayList<loaibean> getloai(){
		ds = ldao.getloai();
		return ds;
	}
	public int Themloai(String maloai, String tenloai) {
		try {
			return ldao.Themloai(maloai, tenloai);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int Sualoai(String maloai, String tenloai) {
		try {
			return ldao.Sualoai(maloai, tenloai);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Xoaloai(String maloai) {
		try {
			return ldao.Xoaloai(maloai);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
