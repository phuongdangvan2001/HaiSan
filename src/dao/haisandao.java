package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.haisanbean;
public class haisandao {
	public ArrayList<haisanbean> geths(){
		try {
			ArrayList<haisanbean> dssach= new ArrayList<haisanbean>();
			   //b1: Ket noi vao csdl
			   CoSodao cs = new CoSodao();
			   cs.KetNoi();
			   //b2: Lay du lieu ve
			   String sql = "select * from HAISAN";
			   PreparedStatement cmd = cs.cn.prepareStatement(sql);
			   ResultSet rs = cmd.executeQuery();
			   //b3: Duyet qua tap du lieu lay ve
			   while(rs.next()) {
				   String mahaisan = rs.getString("mahaisan");
				   String tenhaisan = rs.getString("tenhaisan");
				   long soluong = rs.getLong("soluong");
				   long gia = rs.getLong("gia");
				   String anh = rs.getString("anh");
				   String maloai = rs.getString("maloai");
				   Date ngaynhap = rs.getDate("nhacungcap");
				   String nhacungcap = rs.getString("nhacungcap");
				   dssach.add(new haisanbean(mahaisan, tenhaisan, soluong, gia, maloai, anh, ngaynhap, nhacungcap));
			   }
			   //b4: Dong rs vaf cn
			   rs.close();
			   cs.cn.close();
			   return dssach;
		   }catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	public ArrayList<haisanbean> gethaisanbyma(String ms) {
		ArrayList<haisanbean> ds = new ArrayList<haisanbean>();
		try {
			CoSodao kn = new CoSodao();
			kn.KetNoi();
			String sql = "SELECT * FROM HAISAN WHERE mahaisan = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, ms);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("mahaisan");
				String tensach = rs.getString("tenhaisan");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				Date NgayNhap = rs.getDate("NgayNhap");
				ds.add(new haisanbean(masach, tensach, soluong, gia, maloai, anh, NgayNhap, null));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int Themhaisan(String mahaisan, String tenhaisan, long soluong, long gia, String maloai, String anh,
			Date NgayNhap) throws Exception {

		CoSodao kn = new CoSodao();
		kn.KetNoi();
		String sql = "Insert into HAISAN(mahaisan, tenhaisan, soluong, gia, maloai, anh, ngaynhap, nhacungcap) values(?,?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, mahaisan);
		cmd.setString(2, tenhaisan);
		cmd.setLong(3, soluong);
		cmd.setLong(4, gia);
		cmd.setString(5, maloai);
		cmd.setString(6, anh);
		cmd.setDate(7, new java.sql.Date(NgayNhap.getTime()));
		cmd.setString(8, null);
		return cmd.executeUpdate();

	}

	public int Suahaisan(String masach, String tensach, long soluong, long gia, String maloai, String anh,
			Date NgayNhap) throws Exception {

		CoSodao kn = new CoSodao();
		kn.KetNoi();
		String sql = "Update HAISAN Set tenhaisan = ?, soluong = ?, gia = ?, maloai = ?, anh = ?, ngaynhap = ? Where mahaisan = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tensach);
		cmd.setLong(2, soluong);
		cmd.setLong(3, gia);
		cmd.setString(4, maloai);
		cmd.setString(5, anh);
		cmd.setDate(6, new java.sql.Date(NgayNhap.getTime()));
		cmd.setString(7, masach);
		return cmd.executeUpdate();

	}

	public int Xoahaisan(String masach) throws Exception {

		CoSodao kn = new CoSodao();
		kn.KetNoi();
		String sql = "Delete from HAISAN Where mahaisan = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		return cmd.executeUpdate();

	}
	public ArrayList<haisanbean> getsachPagSearch(int index, String key) {
		ArrayList<haisanbean> ds = new ArrayList<haisanbean>();
		try {
			CoSodao kn = new CoSodao();
			kn.KetNoi();
			String sql = "SELECT * FROM HAISAN WHERE tenhaisan like ? OR  maloai like ? ORDER BY maihaisan OFFSET ? ROW FETCH NEXT 12 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			cmd.setString(2, "%" + key + "%");
			cmd.setInt(3, (index - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String mahaisan = rs.getString("maihaisan");
				String tenhaisan = rs.getString("tenhaisan");
				int soluong = rs.getInt("soluong");
				int gia = rs.getInt("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				Date NgayNhap = rs.getDate("NgayNhap");
				ds.add(new haisanbean(mahaisan, tenhaisan, soluong, gia, maloai, anh, NgayNhap, anh));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public int getTotalSach(String key) {
		try {
			CoSodao kn = new CoSodao();
			kn.KetNoi();
			String sql = "SELECT count(*) FROM HAISAN WHERE tenhaisan like ? OR maloai like ? ";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			cmd.setString(2, "%" + key + "%");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			kn.cn.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return 0;
	}
}
