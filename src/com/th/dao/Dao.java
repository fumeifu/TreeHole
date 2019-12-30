package com.th.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.TbTh;
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
//        	System.out.println("连接成功");
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public static Vector getTH() {
		Vector rowData2 = new Vector();
		ResultSet rs3 = findForResultSet("select * from tb_shudong");
		try {
//    		System.out.print(rs3);
        	while(rs3.next()){
//				rowData可以存放多行
//       		System.out.println("hello");
			Vector hang=new Vector();
			hang.add(rs3.getInt("sd_number"));
			hang.add(rs3.getString("sd_context"));
			hang.add(rs3.getString("sd_label"));
//			System.out.println(rs3.getInt("sd_number"));
//			加入到rowData
			rowData2.add(hang);
			}
        }catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData2;
	}
	
//	public static TbTh[] getTH() {
//		System.out.println("world");
//		ResultSet rs2 = findForResultSet("select * from tb_shudong");
//		int i=0;
//		int sd_number2[] = new int[10000];
//		String sd_context2[]=new String[10000];
//		String sd_label2[]=new String[10000];
//		TbTh shudong2[]=new TbTh[10000];
//		
//		try {
//			while(rs2.next()) {
//				System.out.println("hellohello");
//				sd_number2[i]=rs2.getInt("sd_number");
//				sd_context2[i]=rs2.getString("sd_context");
//				sd_label2[i]=rs2.getString("sd_label");
//				shudong2[i].setSd_number(sd_number2);
//				shudong2[i].setSd_context(sd_context2);
//				shudong2[i].setSd_label(sd_label2);
//				System.out.println(shudong2[i].getSd_context());
//				System.out.println(shudong2[i].getSd_number());
//				System.out.println(shudong2[i].getSd_label());
//				System.out.println(rs2.getInt("sd_number"));
//				i++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		return shudong2;
//		
//	}
//	
//	public static List getTH() {
//		ResultSet rs2 = findForResultSet("select * from tb_shudong");
//		TbTh shudong2=new TbTh();
//		int sd_number2;
//		String sd_context2;
//		String sd_label2;
//		List list=new ArrayList<>();
//		try {
//			while(rs2.next()) {
//				sd_number2=rs2.getInt("sd_number");
//				sd_context2=rs2.getString("sd_context");
//				sd_label2=rs2.getString("sd_label");
//				shudong2.setSd_number(sd_number2);
//				shudong2.setSd_context(sd_context2);
//				shudong2.setSd_label(sd_label2);
//				list.add(shudong2);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		//return shudong2;
//		
//		return list;
//	}
//	public static List getTH() {
//		List list = findForList("select * from tb_shudong");
//		return list;
//	}
//	
//	public static List findForList(String sql) {
//		List<List> list = new ArrayList<List>();
//		ResultSet rs = findForResultSet(sql);
//		try {
//			ResultSetMetaData metaData = rs.getMetaData();
//			int colCount = metaData.getColumnCount();
//			while (rs.next()) {
//				List<String> row = new ArrayList<String>();
//				for (int i = 1; i <= colCount; i++) {
//					String str = rs.getString(i);
//					if (str != null && !str.isEmpty())
//						str = str.trim();
//					row.add(str);
//				}
//				list.add(row);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	//添加树洞
//	public static boolean addTH(TbTh spTh) {
//		if (spTh == null)
//			return false;
//		return insert("insert tb_shudong values('" + spTh.getSd_context() + "','" + spTh.getSd_label() + "','"
//				+ "')");
//	}
	
	public static boolean addTH(String context,String label) {
//		System.out.println("hello");					
//		System.out.println("world");
//		System.out.println(label);
//		System.out.println(context);
		
		if(context.length()!=0&&label.length()!=0) {
			return insert("insert tb_shudong (sd_context,sd_label) values('"+context+"','"+label+"')");	
		}else {
			return false;
		}

	
	}
	
	public static boolean insert(String sql) {
		boolean result = false;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
//	public static TbUserlist getChoose(int choose3) {
//		TbUserlist user = new TbUserlist();
//		ResultSet rs = findForResultSet("select * from tb_shudong where stu_number="+choose3);
//			
//		try {
//			while(rs.next()) {
//				int number3 = rs.getInt("stu_number"); // 获取列名是"stu_number"的字段值
//				// 获取列名是"stu_password"的字段值
//				String password3 = rs.getString("stu_password");				
////				System.out.print("学号：" + number3); // 将列值输出
////				System.out.println("密码：" + password3);
//				
//				if(password3.contentEquals(password)) {
//					user.setNumber4(number3);
//					user.setPassword4(password3);
//				}
//				
//			}		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
//	}

	
	
}
