package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.tendangnhapbean;

public class tendangnhapdao {
	public ArrayList<tendangnhapbean> gettdn(){
		try {
			ArrayList<tendangnhapbean> dstdn = new ArrayList<tendangnhapbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from DANGNHAP";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String TenDangNhap = rs.getString("tendangnhap");
				String MatKhau = rs.getString("matkhau");
				boolean Quyen = rs.getBoolean("quyen");
				dstdn.add(new tendangnhapbean(TenDangNhap, MatKhau, Quyen));
			}
			rs.close();
			cs.cn.close();
			return dstdn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public tendangnhapbean ktdn(String tendn, String pass) {
		try {
			CoSodao cs= new CoSodao();
			cs.KetNoi();
			String sql="select * from DANGNHAP where tendangnhap=? and matkhau=?";
			PreparedStatement cmd= cs.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs= cmd.executeQuery();
			tendangnhapbean dn=null;
			if(rs.next()) {//Dang nhap thanh cong
			 String TenDangNhap=rs.getString("tendangnhap");
			 String MatKhau=rs.getString("matkhau");
			 boolean Quyen=rs.getBoolean("quyen");
			 dn=new tendangnhapbean(TenDangNhap, MatKhau, Quyen);
			}
			rs.close(); cs.cn.close();
			return dn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
