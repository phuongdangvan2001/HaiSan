package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class xacnhanchuyentiendao {
	public void xacnhan(long ma){
    	try {	
			CoSodao kn= new CoSodao();
			kn.KetNoi();
			String sql="update CHITIETHOADON set damua = ? where machitiethd = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setBoolean(1, true);
			cmd.setLong(2, ma);
			ResultSet rs=cmd.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
