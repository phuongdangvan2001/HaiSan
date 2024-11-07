package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.xacnhanbean;

public class xacnhandao {
	public ArrayList<xacnhanbean> getxacnhan(){
		try {
			ArrayList<xacnhanbean> dslsmh = new ArrayList<xacnhanbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from VXacNhan where damua=0";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long makh = rs.getLong("makh");
				String hoten = rs.getString("hoten"); 
				String tenhaisan = rs.getString("tenhaisan");
				Date NgayMua = rs.getDate("ngaymua");
				int SoLuongMua = rs.getInt("soluongmua");
				long gia = rs.getLong("gia");
				long ThanhTien = rs.getLong("thanhtien");	
				boolean damua = rs.getBoolean("damua");
				long MaChiTietHD = rs.getLong("machitiethd");
				long MaHoaDon = rs.getLong("mahoadon");
				dslsmh.add(new xacnhanbean(makh, hoten, tenhaisan, SoLuongMua, gia, ThanhTien, NgayMua,
						damua, MaChiTietHD, MaHoaDon, null));
			}
			rs.close();
			cs.cn.close();
			return dslsmh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<xacnhanbean> getdanhsach(){
		try {
			ArrayList<xacnhanbean> dslsmh = new ArrayList<xacnhanbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from VXacNhan where damua=1";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long makh = rs.getLong("makh");
				String hoten = rs.getString("hoten"); 
				String tenhaisan = rs.getString("tenhaisan");
				Date NgayMua = rs.getDate("ngaymua");
				int SoLuongMua = rs.getInt("soluongmua");
				long gia = rs.getLong("gia");
				long ThanhTien = rs.getLong("thanhtien");	
				boolean damua = rs.getBoolean("damua");
				long MaChiTietHD = rs.getLong("machitiethd");
				long MaHoaDon = rs.getLong("mahoadon");
				String gopy = rs.getString("gopy");
				dslsmh.add(new xacnhanbean(makh, hoten, tenhaisan, SoLuongMua, gia, ThanhTien, NgayMua,
						damua, MaChiTietHD, MaHoaDon, gopy));
			}
			rs.close();
			cs.cn.close();
			return dslsmh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int Themgopy(String s, long mct) {
		try {
			CoSodao kn= new CoSodao();
			kn.KetNoi();
			String sql="update VXacNhan set gopy = ? where machitiethd = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, s);
			cmd.setLong(2, mct);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}

