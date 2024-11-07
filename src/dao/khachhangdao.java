package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.khachhangbean;


public class khachhangdao {
	public ArrayList<khachhangbean> getkh(){
		try {
			ArrayList<khachhangbean> dskh = new ArrayList<khachhangbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from KHACHHANG";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int makh = rs.getInt("makh");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String sodt = rs.getString("sodt");
				String email = rs.getString("email");
				String tendn = rs.getString("tendn");
				String pass = rs.getString("pass");
				dskh.add(new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass));
			}
			rs.close();
			cs.cn.close();
			return dskh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<khachhangbean> ktdn(String tendn, String pass) {
		try {
			ArrayList<khachhangbean> dskh1 = new ArrayList<khachhangbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from KHACHHANG where tendn=? and pass=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int makh = rs.getInt("makh");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String sodt = rs.getString("sodt");
				String email = rs.getString("email");
				String tendn1 = rs.getString("tendn");
				String pass1 = rs.getString("pass");
				dskh1.add(new khachhangbean(makh, hoten, diachi, sodt, email, tendn1, pass1));
			}
			rs.close();
			cs.cn.close();
			return dskh1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getMd5Hash(String pass) {
	    try {
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      byte[] messageDigest = md.digest(pass.getBytes());
	      BigInteger no = new BigInteger(1, messageDigest);
	      String hashtext = no.toString(16);
	      while (hashtext.length() < 32) {
	        hashtext = "0" + hashtext;
	      }
	      return hashtext;
	    } catch (NoSuchAlgorithmException e) {
	      throw new RuntimeException(e);
	    }
	  }
	public int dangky(String hoten, String diachi, String sodt, String email, String tendn, String pass)
			throws Exception {
		CoSodao kn = new CoSodao();
		kn.KetNoi();
		String sql = "Insert into KHACHHANG(hoten, diachi, sodt, email, tendn, pass) values(?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setString(2, diachi);
		cmd.setString(3, sodt);
		cmd.setString(4, email);
		cmd.setString(5, tendn);
		cmd.setString(6, pass);
		return cmd.executeUpdate();
	}
}
