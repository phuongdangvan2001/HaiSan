package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.haisanbean;
import dao.haisandao;

public class haisanbo {
	haisandao sdao = new haisandao();
	ArrayList<haisanbean> ds;
	public ArrayList<haisanbean> geths(){
		ds = sdao.geths();
		return ds;
	}
	public ArrayList<haisanbean> TimMa(String maloai){
		ArrayList<haisanbean> tam= new ArrayList<haisanbean>();
		for(haisanbean s: ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		return tam;
	}
	public ArrayList<haisanbean> Tim(String key){
		ArrayList<haisanbean> tam= new ArrayList<haisanbean>();
		for(haisanbean s: ds)
			if(s.getTenhaisan().toLowerCase().trim().contains(
			key.toLowerCase().trim())||
			s.getMaloai().toLowerCase().trim().contains(
					key.toLowerCase().trim())
					)
				tam.add(s);
		return tam;
	}
	public ArrayList<haisanbean> gethaisanbyma(String ms){
		ds = sdao.gethaisanbyma(ms);
		return ds;
	}
	public int Themhaisan(String mahaisan, String tenhaisan, long soluong, long gia, String maloai, String anh,
			Date NgayNhap) {
		try {
			return sdao.Themhaisan(mahaisan, tenhaisan, soluong, gia, maloai, anh, NgayNhap);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int Suahaisan(String masach, String tensach, long soluong, long gia, String maloai, String anh,
			Date NgayNhap) {
		try {
			return sdao.Suahaisan(masach, tensach, soluong, gia, maloai, anh, NgayNhap);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Xoahaisan(String masach) {
		try {
			return sdao.Xoahaisan(masach);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<haisanbean> getsachPag() {
		ds = sdao.getsachPagSearch(1, "");
		return ds;
	}

	public ArrayList<haisanbean> getsachPagSearch(int index, String key) {
		ds = sdao.getsachPagSearch(index, key);
		return ds;
	}

	public int getTotalSach(String key) {
		return sdao.getTotalSach(key);
	}
}
