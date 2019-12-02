package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String URL="jdbc:mysql://localhost:3306/treehole?serverTimezone=UTC&characterEncoding=utf-8";
	
	private static final String UNAME = "sx";
	
	private static final String PWD = "19990128";

	private static Connection con = null;
	
	private static ResultSet rs = null;
	
	private static PreparedStatement ps = null;
		
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void open(){
		try {
			con = DriverManager.getConnection(URL, UNAME, PWD);
			if (null==con) {
				System.out.println("failed");
			}else {
				System.out.println("success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int update(String sql, Object... params){
		int count=0;

		try {
			open();
			
			ps = con.prepareStatement(sql);
			
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			count = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			count=-1;
		}finally{
			close();
		}
		return count;		
	}

	public ResultSet query(String sql, Object... params){

		try {
			open();
			ps = con.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;		
	}

	public void close(){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
