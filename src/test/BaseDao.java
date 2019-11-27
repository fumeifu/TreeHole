package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	//杩炴帴鐨剈rl     localhost鍙互淇敼涓篿p鍦板潃     shopping娉ㄦ剰锛屾槸鏁版嵁搴撳悕锛屼笉鏄繛鎺ュ悕
	private static final String URL="jdbc:mysql://localhost:3306/treehole";
	//鐢ㄦ埛鍚�
	private static final String UNAME = "sx";
	//瀵嗙爜
	private static final String PWD = "19990128";
	//connection杩炴帴瀵硅薄     娉ㄦ剰鍖�   鏄�  java.sql.Connection;
	private static Connection con = null;
	//缁撴灉闆嗗璞�     娉ㄦ剰鍖�   鏄�  java.sql.ResultSet;
	private static ResultSet rs = null;
	//棰勭紪璇戝璞�	娉ㄦ剰鍖�   鏄�  java.sql.PreparedStatement;
	private static PreparedStatement ps = null;
		
	//鍔犺浇椹卞姩
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//鑾峰彇杩炴帴
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
			//2.3  鎵цSQL锛岃幏寰楃粨鏋滈泦
			ps = con.prepareStatement(sql);
			//2.4 缁欏崰浣嶇璧嬪��
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//2.5 鎵ц
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
			//2.3  鎵цSQL锛岃幏寰楃粨鏋滈泦
			ps = con.prepareStatement(sql);
			//2.4 缁欏崰浣嶇璧嬪��
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			//2.5 鎵ц
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
