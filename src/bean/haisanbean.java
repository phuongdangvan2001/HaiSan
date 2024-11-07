package bean;

import java.util.Date;

public class haisanbean {
	private String mahaisan;
	private String tenhaisan;
	private long soluong;
	private long gia;
	private String maloai;
	private String anh;
	private Date ngaynhap;
	private String nhacungcap;
	public haisanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public haisanbean(String mahaisan, String tenhaisan, long soluong, long gia, String maloai, String anh,
			Date ngaynhap, String nhacungcap) {
		super();
		this.mahaisan = mahaisan;
		this.tenhaisan = tenhaisan;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.anh = anh;
		this.ngaynhap = ngaynhap;
		this.nhacungcap = nhacungcap;
	}
	public String getMahaisan() {
		return mahaisan;
	}
	public void setMahaisan(String mahaisan) {
		this.mahaisan = mahaisan;
	}
	public String getTenhaisan() {
		return tenhaisan;
	}
	public void setTenhaisan(String tenhaisan) {
		this.tenhaisan = tenhaisan;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getNhacungcap() {
		return nhacungcap;
	}
	public void setNhacungcap(String nhacungcap) {
		this.nhacungcap = nhacungcap;
	}
	
}
