package com.devil.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection getConnection() throws Exception {

		String url = "jdbc:mysql://203.250.32.44:3306/devil";
		String driver = "com.mysql.jdbc.Driver";
		String user = "bk";
		String pw = "1q2w3e4r5t";

		// 드라이버 로딩(jar 파일 로드)
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);

		System.out.println("Database에 연결되었습니다.\n");
		return conn;
	}
}