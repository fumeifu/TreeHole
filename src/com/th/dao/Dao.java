package com.th.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.TbUserlist;

//���ݿ�������
//import java.sql.*;
//
//public class Dao{
//	static Connection con; // ����Connection����
//	static Statement sql; // ����Statement����
//	static ResultSet res; // ����ResultSet����
//	public Connection getConnection() { // �������ݿⷽ��
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql:"
//					+ "//localhost:3306/treehole"+"?serverTimezone=UTC&characterEncoding=utf-8", "sx", "19990128");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return con; // ����Connection����
//	}
//	
//	public static void main(String[] args) { // ������
//		Dao c = new Dao(); // �����������
//		con = c.getConnection(); // �����ݿ⽨������
//		try {
//			sql = con.createStatement(); // ʵ����Statement����
//			// ִ��SQL��䣬���ؽ����
//			res = sql.executeQuery("select * from tb_user");
//			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
//				String number3 = res.getString("stu_number"); // ��ȡ������"stu_number"���ֶ�ֵ
//				// ��ȡ������"stu_password"���ֶ�ֵ
//				String password3 = res.getString("stu_password");				
//				System.out.print("ѧ�ţ�" + number3); // ����ֵ���
//				System.out.println("���룺" + password3);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}









public class Dao {
	
	
	//����JDBC����
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/treehole?serverTimezone=UTC&characterEncoding=utf-8";
	protected static String dbUser = "sx";//�û���
	protected static String dbPwd = "19990128";//����
	protected static String second = null;
	public static Connection conn = null;//����һ����̬���ݿ����ӣ��������ӻ�û��ֵ
	
	public static void MyConn() {
		try {
			Class.forName(dbClassName);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        try {
        // �����ݿ�����
        	conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        	System.out.println("���ӳɹ�");
        } catch (Exception e1) {
        	e1.printStackTrace();
        }
	}
	
	public static ResultSet findForResultSet(String sql) {
		if (conn == null)
			return null;
		long time = System.currentTimeMillis();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			second = ((System.currentTimeMillis() - time) / 1000d) + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static TbUserlist getUser(int number, String password) {
		TbUserlist user = new TbUserlist();
		ResultSet rs = findForResultSet("select * from tb_user where stu_number="+ number);
			
		try {
			while(rs.next()) {
				int number3 = rs.getInt("stu_number"); // ��ȡ������"stu_number"���ֶ�ֵ
				// ��ȡ������"stu_password"���ֶ�ֵ
				String password3 = rs.getString("stu_password");				
//				System.out.print("ѧ�ţ�" + number3); // ����ֵ���
//				System.out.println("���룺" + password3);
				
				if(password3.contentEquals(password)) {
					user.setNumber4(number3);
					user.setPassword4(password3);
				}
				
			}
					
//			System.out.println("hello");
						
//			if (rs.next()) {
////				System.out.println("hello");
//				user.setNumber4(number);
//				user.setPassword4(rs.getString("stu_password"));
//				if (user.getPassword4().equals(password)) {
////					user.setPassword4(rs.getString("stu_password"));
//					System.out.print(user.getNumber4());
//					System.out.println(user.getPassword4());
//				}
//			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

	
	
}
