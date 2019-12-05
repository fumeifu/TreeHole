package com.th.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.TbUserlist;

//数据库操作类包
//import java.sql.*;
//
//public class Dao{
//	static Connection con; // 声明Connection对象
//	static Statement sql; // 声明Statement对象
//	static ResultSet res; // 声明ResultSet对象
//	public Connection getConnection() { // 连接数据库方法
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql:"
//					+ "//localhost:3306/treehole"+"?serverTimezone=UTC&characterEncoding=utf-8", "sx", "19990128");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return con; // 返回Connection对象
//	}
//	
//	public static void main(String[] args) { // 主方法
//		Dao c = new Dao(); // 创建本类对象
//		con = c.getConnection(); // 与数据库建立连接
//		try {
//			sql = con.createStatement(); // 实例化Statement对象
//			// 执行SQL语句，返回结果集
//			res = sql.executeQuery("select * from tb_user");
//			while (res.next()) { // 如果当前语句不是最后一条则进入循环
//				String number3 = res.getString("stu_number"); // 获取列名是"stu_number"的字段值
//				// 获取列名是"stu_password"的字段值
//				String password3 = res.getString("stu_password");				
//				System.out.print("学号：" + number3); // 将列值输出
//				System.out.println("密码：" + password3);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}









public class Dao {
	
	
	//加载JDBC驱动
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/treehole?serverTimezone=UTC&characterEncoding=utf-8";
	protected static String dbUser = "sx";//用户名
	protected static String dbPwd = "19990128";//密码
	protected static String second = null;
	public static Connection conn = null;//定义一个静态数据库连接，但该连接还没赋值
	
	public static void MyConn() {
		try {
			Class.forName(dbClassName);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        try {
        // 与数据库连接
        	conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        	System.out.println("连接成功");
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
				int number3 = rs.getInt("stu_number"); // 获取列名是"stu_number"的字段值
				// 获取列名是"stu_password"的字段值
				String password3 = rs.getString("stu_password");				
//				System.out.print("学号：" + number3); // 将列值输出
//				System.out.println("密码：" + password3);
				
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
