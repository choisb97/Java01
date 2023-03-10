package j18_fileIOTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	
// ** Oracle Connection
	public static Connection getConnection() {
		try {
			// 1) Oracle JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2) Connection 객체 생성
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
				// => jdbc:oracle:thin:localhost:1521:XE 동일
				//     oracle 11g XE version SID :  XE
				//     oracle 11g re version SID :  orcl
				//	   oracle 10g XE : "jdbc:oracle:thin:@127.0.0.1:1521:XE"
				//     대.소 문자 무관
			
			System.out.println("** DB Connection 성공 **");
			return DriverManager.getConnection(url,"system", "oracle");
		} catch (Exception e) {
			System.out.println("** DB Connection 실패 => " + e.toString());
			return null;
		}
	} // getConnection()

// ** MySql Connection
//	public static Connection getConnection() {
//		try {
//			// 1) MySql JDBC 드라이버 로딩
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// 2) Connection 객체 생성
//			String url ="jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
//			System.out.println("** DB Connection 성공 **");
//			return DriverManager.getConnection(url,"root","mysql");
//		} catch (Exception e) {
//			System.out.println("** DB Connection 실패 => " + e.toString());
//			return null;
//		}
//	} // dbConnection
	
	public static void dbClose(ResultSet rs, PreparedStatement pst, Statement st, Connection cn) {
		try {
			if ( rs != null ) rs.close();
			if ( pst != null ) pst.close();
			if ( st != null ) st.close();
			if ( cn != null ) cn.close();
		} catch (Exception e) {
			System.out.println("** DB Close 실패 => " + e.toString());
		}
	} // dbClose
	
} // class
