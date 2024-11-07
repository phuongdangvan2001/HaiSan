package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class chitiethoadondao {
//	public int Them(String MaSach, long soluongmua, long MaHoaDon) {
//		try {
//			CoSodao cs = new CoSodao();
//			cs.KetNoi();
//			String sql = "insert into ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon, Damua) values(?,?,?,?)";
//			PreparedStatement cmd = cs.cn.prepareStatement(sql);
//			cmd.setString(1, MaSach);
//			cmd.setLong(2, soluongmua);
//			cmd.setLong(3, MaHoaDon);
//			
//			int kq = cmd.executeUpdate();
//			cs.cn.close();
//			return kq;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}
	public int Them(String masach, long soluongmua, long mahd) {
		try {
			CoSodao kn= new CoSodao();
			kn.KetNoi();
			String sql="insert into CHITIETHOADON(mahaisan,soluongmua,mahoadon,damua) values(?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setLong(2, soluongmua);
			cmd.setLong(3, mahd);
			cmd.setBoolean(4, false);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int ThemTT(String masach, long soluongmua, long mahd) {
		try {
			CoSodao kn= new CoSodao();
			kn.KetNoi();
			String sql="insert into CHITIETHOADON(mahaisan,soluongmua,mahoadon,damua) values(?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setLong(2, soluongmua);
			cmd.setLong(3, mahd);
			cmd.setBoolean(4, true);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}

