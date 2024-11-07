package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CoSodao {
	public Connection cn;
	public void KetNoi() throws Exception{
		//b1: Xac dinh ht QTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("OK buoc 1");
		cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-VODDN60\\SQLEXPRESS:1433;databaseName=HaiSan;user=sa; password=123");
		System.out.println("OK buoc 2");
	}
	public static void main(String[] ts) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

