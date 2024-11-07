package bean;

import java.sql.Date;

public class lichsumuahangbean {
	private String tensach;
	private Date ngaymua;
	private int soluongmua;
	private long gia;
	private long thanhtien;
	private boolean damua;
	private int makh;
	private long mact;
	private String gopy;
	public lichsumuahangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getMact() {
		return mact;
	}

	public void setMact(long mact) {
		this.mact = mact;
	}

	

	public String getGopy() {
		return gopy;
	}

	public void setGopy(String gopy) {
		this.gopy = gopy;
	}

	public lichsumuahangbean(String tensach, Date ngaymua, int soluongmua, long gia, long thanhtien, boolean damua,
			int makh, long mact, String gopy) {
		super();
		this.tensach = tensach;
		this.ngaymua = ngaymua;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.damua = damua;
		this.makh = makh;
		this.mact = mact;
		this.gopy = gopy;
	}

	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
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
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	
	
}
