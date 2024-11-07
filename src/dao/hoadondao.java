package dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bean.hoadonbean;
import bean.khachhangbean;

public class hoadondao {
//	public long maxhoadon() {
//		try {
//	
//			CoSodao cs = new CoSodao();
//			cs.KetNoi();
//			String sql = "select max(hoadon) as maxhd from hoadon";
//			PreparedStatement cmd = cs.cn.prepareStatement(sql);
//			ResultSet rs = cmd.executeQuery();
//			long kq=0;
//			if(rs.next()){
//				kq=rs.getLong("maxhd");
//			}
//			rs.close();
//			cs.cn.close();
//			return kq;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//			// TODO: handle exception
//		}
//	}
//	public ArrayList<hoadonbean> gethd(){
//		try {
//			ArrayList<hoadonbean> dshd = new ArrayList<hoadonbean>();
//			CoSodao cs = new CoSodao();
//			cs.KetNoi();
//			String sql = "select * from hoadon";
//			PreparedStatement cmd = cs.cn.prepareStatement(sql);
//			ResultSet rs = cmd.executeQuery();
//			while(rs.next()) {
//				int MaHoaDon = rs.getInt("MaHoaDon");
//				int makh = rs.getInt("makh");
//				Date NgayMua = rs.getDate("NgayMua");
//				boolean damua = rs.getBoolean("damua");
//				dshd.add(new hoadonbean(MaHoaDon, makh, NgayMua, damua));
//			}
//			rs.close();
//			cs.cn.close();
//			return dshd;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	public int Them(int makh) {
//		try {
//			CoSodao cs = new CoSodao();
//			cs.KetNoi();
//			String sql = "insert into hoadon(makh, NgayMua) values(?,?)";
//			PreparedStatement cmd = cs.cn.prepareStatement(sql);
//			cmd.setInt(1, makh);
//			Calendar c = Calendar.getInstance();
//			int ngay = c.get(Calendar.DAY_OF_MONTH);
//			int thang = c.get(Calendar.MONTH)+1;
//			int nam = c.get(Calendar.YEAR);
//			String nn = String.valueOf(nam)+"-"+String.valueOf(thang)+"-"+String.valueOf(ngay);
//			SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
//			Date ngaynhap = (Date) dd.parse(nn);
//			cmd.setDate(2, new java.sql.Date(ngaynhap.getTime()));
////			cmd.setBoolean(3, false);
//			int kq = cmd.executeUpdate();
//			cs.cn.close();
//			return kq;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}
	public long maxhd() {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql="select max(mahoadon) as maxhd from HOADON";
			PreparedStatement cmd= cs.cn.prepareStatement(sql);
			ResultSet rs= cmd.executeQuery();
			long kq=0;
			if(rs.next())
				kq=rs.getLong("maxhd");
			cs.cn.close();
			return kq;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Them(long makh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql="insert into HOADON(makh,ngaymua,damua) values(?,?,?)";
			PreparedStatement cmd= cs.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			Date n= new Date();
			SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
			String ngay= dd.format(n);
			Date ngaymua=dd.parse(ngay);
			cmd.setDate(2, new java.sql.Date(ngaymua.getTime()));
			cmd.setBoolean(3, false);
			int kq=cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int ThemTT(long makh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql="insert into HOADON(makh,ngaymua,damua) values(?,?,?)";
			PreparedStatement cmd= cs.cn.prepareStatement(sql);
			cmd.setLong(1, makh);
			Date n= new Date();
			SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
			String ngay= dd.format(n);
			Date ngaymua=dd.parse(ngay);
			cmd.setDate(2, new java.sql.Date(ngaymua.getTime()));
			cmd.setBoolean(3, true);
			int kq=cmd.executeUpdate();
			cs.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
