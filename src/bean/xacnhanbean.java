package bean;

import java.sql.Date;

public class xacnhanbean {
	private long makh;
	private String hoten;
	private String tenhaisan;
	private long soluongmua;
	private long gia;
	private long thanhtien;
	private Date ngaymua;
	private boolean damua;
	private long machitiethd;
	private long mahoadon;
	private String gopy;
	public xacnhanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getGopy() {
		return gopy;
	}

	public void setGopy(String gopy) {
		this.gopy = gopy;
	}

	public xacnhanbean(long makh, String hoten, String tenhaisan, long soluongmua, long gia, long thanhtien,
			Date ngaymua, boolean damua, long machitiethd, long mahoadon, String gopy) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tenhaisan = tenhaisan;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.ngaymua = ngaymua;
		this.damua = damua;
		this.machitiethd = machitiethd;
		this.mahoadon = mahoadon;
		this.gopy = gopy;
	}

	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
	public String getTenhaisan() {
		return tenhaisan;
	}
	public void setTenhaisan(String tenhaisan) {
		this.tenhaisan = tenhaisan;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public long getMachitiethd() {
		return machitiethd;
	}
	public void setMachitiethd(long machitiethd) {
		this.machitiethd = machitiethd;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	
}
