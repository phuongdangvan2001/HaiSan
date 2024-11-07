package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai(){
		   try {
			   ArrayList<loaibean> dsloai= new ArrayList<loaibean>();
			   //b1: Ket noi vao csdl
			   CoSodao cs = new CoSodao();
			   cs.KetNoi();
			   //b2: Lay du lieu ve
			   String sql = "select * from LOAI";
			   PreparedStatement cmd = cs.cn.prepareStatement(sql);
			   ResultSet rs = cmd.executeQuery();
			   //b3: Duyet qua tap du lieu lay ve
			   while(rs.next()) {
				   String maloai = rs.getString("maloai");
				   String tenloai = rs.getString("tenloai");
				   dsloai.add(new loaibean(maloai, tenloai));
			   }
			   //b4: Dong rs vaf cn
			   rs.close();
			   cs.cn.close();
			   return dsloai;
		   }catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	 }
	public int Themloai(String maloai, String tenloai) throws Exception {

		CoSodao kn = new CoSodao();
		kn.KetNoi();
		String sql = "Insert into LOAI(maloai, tenloai) values(?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		return cmd.executeUpdate();

	}

	public int Sualoai(String maloai, String tenloai) throws Exception {

		CoSodao kn = new CoSodao();
		kn.KetNoi();
		String sql = "Update LOAI Set tenloai = ? Where maloai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenloai);
		cmd.setString(2, maloai);
		return cmd.executeUpdate();

	}

	public int Xoaloai(String maloai) throws Exception {

		CoSodao kn = new CoSodao();
		kn.KetNoi();
		String sql = "Delete from LOAI Where maloai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		return cmd.executeUpdate();

	}
}
