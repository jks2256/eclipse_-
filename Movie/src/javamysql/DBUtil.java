package javamysql;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.MySQLDataException;

public class DBUtil {
	
	public static Connection getMySQLConnection() {
		Connection conn = null;
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "";
				String user = "";
				String password = "";
				
				conn = DriverManager.getConnection(url, user, password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(MySQLDataException e) {
				System.out.println("�����ͺ��̽��� �����ϴ�.");
			} catch(SQLException e) {
				System.out.println("����� ���� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.<br/>");
			}
			return conn;
			
		
	}

	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
