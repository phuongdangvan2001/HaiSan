package bean;

public class giohangbean {
	private String mahaisan;
	private String tenhaisan;
	private long soluong;
	private long gia;
	private long thanhtien;
	private String anh;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String mahaisan, String tenhaisan, long soluong, long gia, String anh) {
		super();
		this.mahaisan = mahaisan;
		this.tenhaisan = tenhaisan;
		this.soluong = soluong;
		this.gia = gia;
		this.thanhtien = soluong*gia;
		this.anh = anh;
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
	public long getThanhtien() {
		return soluong*gia;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}
