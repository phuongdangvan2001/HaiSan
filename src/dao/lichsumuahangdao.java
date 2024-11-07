package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsumuahangbean;

public class lichsumuahangdao {
	public ArrayList<lichsumuahangbean> getlsmh(int ma){
		try {
			ArrayList<lichsumuahangbean> dslsmh = new ArrayList<lichsumuahangbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from VLSMH where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, ma);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String tensach = rs.getString("tenhaisan");
				Date NgayMua = rs.getDate("ngaymua");
				int SoLuongMua = rs.getInt("soluongmua");
				long gia = rs.getLong("gia");
				long ThanhTien = rs.getLong("thanhtoan");	
				boolean damua = rs.getBoolean("damua");
				int makh = rs.getInt("makh");
				long mact = rs.getLong("machitiethd");
				String gopy = rs.getString("gopy");
				dslsmh.add(new lichsumuahangbean(tensach, NgayMua, SoLuongMua, gia, ThanhTien, damua, makh, mact, gopy));
			}
			rs.close();
			cs.cn.close();
			return dslsmh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<lichsumuahangbean> gettt(int ma){
		try {
			ArrayList<lichsumuahangbean> dslsmh = new ArrayList<lichsumuahangbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from VLSMH where makh = ? and damua=0";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, ma);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String tensach = rs.getString("tenhaisan");
				Date NgayMua = rs.getDate("ngaymua");
				int SoLuongMua = rs.getInt("soluongmua");
				long gia = rs.getLong("gia");
				long ThanhTien = rs.getLong("thanhtoan");	
				boolean damua = rs.getBoolean("damua");
				int makh = rs.getInt("makh");
				long mact = rs.getLong("machitiethd");
				String gopy = rs.getString("gopy");
				dslsmh.add(new lichsumuahangbean(tensach, NgayMua, SoLuongMua, gia, ThanhTien, damua, makh, mact, gopy));
			}
			rs.close();
			cs.cn.close();
			return dslsmh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
