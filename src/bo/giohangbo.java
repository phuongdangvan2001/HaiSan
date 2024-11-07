package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void Them(String mahaisan, String tenhaisan, long soluong, long gia, String anh) {
		for (giohangbean g: ds)
			if (g.getMahaisan().trim().equals(mahaisan.trim())) {
				g.setSoluong(soluong+g.getSoluong());
				return;
			}
		ds.add(new giohangbean(mahaisan, tenhaisan, soluong, gia, anh));
	}
	public void Xoa(String mahaisan) {
		for (giohangbean g: ds)
			if (g.getMahaisan().trim().equals(mahaisan.trim())) {
				ds.remove(g);
				return;
			}
	}
	public void XoaAll() {
		ds.removeAll(ds);
	}
	public void Sua(String mahaisan, long soluong) {
		for (giohangbean g: ds)
			if (g.getMahaisan().trim().equals(mahaisan.trim())) {
				g.setSoluong(soluong);
				return;
			}
	}
	public long TongTien() {
		long s=0;
		for (giohangbean g: ds)
			s+=g.getThanhtien();
		return s;
	}
}
