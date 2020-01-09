package com.th.square;
//广场新
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import com.th.comment.Choose;
import com.th.comment.Comment;
import com.th.comment.Comment_new;
import com.th.dao.Dao;
import com.th.issue.Issue;
import com.th.issue.Issue_new;
import com.th.login.Login;
import com.th.my.My;
import com.th.my.My_new;

import model.TbTh;
import model.TbUserlist;


public class Square_new2 extends JDialog{
	
//	//加载JDBC驱动
//	protected static String dbClassName2 = "com.mysql.cj.jdbc.Driver";
//	protected static String dbUrl2 = "jdbc:mysql://localhost:3306/treehole?serverTimezone=UTC&characterEncoding=utf-8";
//	protected static String dbUser2 = "sx";//用户名
//	protected static String dbPwd2 = "19990128";//密码
//	protected static String second2 = null;
//	public static Connection conn2 = null;//定义一个静态数据库连接，但该连接还没赋值
		
	
//	public static void MyConn() {
//		try {
//			Class.forName(dbClassName2);
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//        try {
//        // 与数据库连接
//        	conn2 = DriverManager.getConnection(dbUrl2, dbUser2, dbPwd2);
//        } catch (Exception e1) {
//        	e1.printStackTrace();
//        }
//        System.out.println("222");
//	}
//	
//	public static ResultSet findForResultSet(String sql) {
//		if (conn2 == null)
//			return null;
//		long time = System.currentTimeMillis();
//		ResultSet rs = null;
//		try {
//			Statement stmt = null;
//			stmt = conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs = stmt.executeQuery(sql);
//			second2 = ((System.currentTimeMillis() - time) / 1000d) + "";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}
	
//	private static List th;
	JButton btn_add=new JButton("发布树洞");//创建"发布树洞"按钮
	JButton btn_my=new JButton("我的");//创建"我的"按钮
	
	public Square_new2(Comment_new dialog) {	
		super(dialog,"广场",true);
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置

		Container container=getContentPane();//获取窗体容器（将窗体转换为容器）
		
		btn_add.setBounds(60,700,150,40);//设置按钮的位置和大小
		btn_add.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container.add(btn_add);//将"发布树洞"按钮添加到容器中
		
		btn_add.addActionListener(new ActionListener() {//为"发布树洞"按钮添加鼠标单击事件			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		
		btn_my.setBounds(250,700,150,40);//设置按钮的位置和大小
		btn_my.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container.add(btn_my);//将"我的"按钮添加到容器中
		
		btn_my.addActionListener(new ActionListener() {//为"我的"按钮添加鼠标单击事件			
			@Override
			public void actionPerformed(final ActionEvent e) {
				new My(Square_new2.this);
			}
		});
		
//		JTextArea ta=new JTextArea(35,60);
//		ta.setLineWrap(true);//设置文本域自动换行
//		ta.setFont(new Font("微软雅黑",0,28));//设置字体，0正常，1粗体
//		JScrollPane sp=new JScrollPane(ta);
//		container.add(sp);
//		sp.setBounds(40,40,375,600);
		
//		Dao.MyConn();
//		TbTh shudong[]=new TbTh[10000];
//		shudong=Dao.getTH();
//		int len=shudong.length;
//		System.out.println(len);
//		for(int i=0;i<len;i++) {
//
//			ta.append(shudong[i].getSd_context()[i]);
//			ta.append("\n");
//			ta.append("#");
//			ta.append(Integer.toString(shudong[i].getSd_number()[i]));
//			ta.append("\t");
//			ta.append("   *");
//			ta.append(shudong[i].getSd_label()[i]);
//			ta.append("\n");
//			ta.append("-----------------------------");
//		}
		
//		Dao.MyConn();
//		//将查询到的一组数据都添加到ta中，ta再添加到滚动面板里
//		ta.append(Dao.getTH().getSd_context());
//		ta.append("\n");
//		ta.append("#");
//		ta.append(Integer.toString(Dao.getTH().getSd_number()));
//		ta.append("\t");
//		ta.append("   *");
//		ta.append(Dao.getTH().getSd_label());
//		ta.append("\n");
//		ta.append("-----------------------------");
		
//		Dao.MyConn();
//	
//		String[] columnNames= {"编号","树洞内容","标签"};
//		String[][] tableValues= {};
		
		//从数据库中取出信息
		//rowData用来存放行数据
		//columnNames存放列名
		Vector rowData,columnNames;
		JTable jt=null;
		JScrollPane jsp=null;	
		//定义数据库需要的全局变量
//		PreparedStatement ps=null;
//		Connection ct=null;
//		ResultSet rs=null;	
		columnNames=new Vector();
		//设置列名
		columnNames.add("编号");
		columnNames.add("树洞内容");
		columnNames.add("标签");
		rowData = new Vector();
		rowData=Dao.getTH();
//1		ResultSet rs = findForResultSet("select * from tb_shudong");
//1		try {
//			Class.forName(dbClassName2);
			// 与数据库连接
//        	conn2 = DriverManager.getConnection(dbUrl2, dbUser2, dbPwd2);
//    		System.out.println(rs2);
//1        	while(rs.next()){
				//rowData可以存放多行
//1       		System.out.println("hello");
//1				Vector hang=new Vector();
//1				hang.add(rs.getInt("sd_number"));
//1				hang.add(rs.getString("sd_context"));
//1				hang.add(rs.getString("sd_label"));
//1				System.out.println(rs.getInt("sd_number"));
				//加入到rowData
//1				rowData.add(hang);
//1			}
//1        }catch (SQLException e) {
//1			e.printStackTrace();
//1		}
//		finally{
////			
//			try {
//				if(rs!=null){
//				rs.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	    }
		//初始化Jtable
		jt = new JTable(rowData,columnNames);	
		jt.setRowHeight(28);// 设置表格行宽
		jt.setFont(new Font("微软雅黑",0,22));//设置字体，0正常，1粗体
//		jt.setEnabled(false);
//		jt.addMouseListener(new MouseListener() {
//		    @Override
//		    public void mouseReleased(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mousePressed(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mouseExited(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mouseEntered(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mouseClicked(MouseEvent e) {
//		        // 点击几次，这里是双击事件
//		        if (e.getClickCount() == 2) {
//		            
//		        }
//		    }
//		});
		//初始化 jsp
//		jsp = new JScrollPane(jt);	
		jsp = new JScrollPane(jt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// 创建滚动条组件，默认滚动条始终出现，初始化列表组件
		jsp.setBounds(40,40,375,600);
		//把jsp放入到container
		container.add(jsp);
		
		
		
		
		//rowData可以存放多行,开始从数据库里取
//		try {
//			//加载驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			//得到连接
//			ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/treehole?serverTimezone=UTC&characterEncoding=utf-8");		
//			ps=ct.prepareStatement("select * from tb_shudong");		
//			rs=ps.executeQuery();	
//			String dbUser2 = "sx";//用户名
//			String dbPwd2 = "19990128";//密码
//			String second2 = null;
//			Connection conn2 = null;//定义一个静态数据库连接，但该连接还没赋值
//			
//			
//			while(rs.next()){
//				//rowData可以存放多行
//				Vector hang=new Vector();
//				hang.add(rs.getInt(1));
//				hang.add(rs.getString(2));
//				hang.add(rs.getString(3));
//				System.out.println(rs.getInt(1));
//				//加入到rowData
//				rowData.add(hang);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			
//				try {
//					if(rs!=null){
//					rs.close();
//					}
//					if(ps!=null){
//						ps.close();
//					}
//					if(ct!=null){
//						ct.close();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//		
//		
//		//初始化Jtable
//		jt = new JTable(rowData,columnNames);	
//		//初始化 jsp
//		jsp = new JScrollPane(jt);	
//		jsp.setBounds(40,40,375,600);
//		//把jsp放入到container
//		container.add(jsp);	
		
//		
//		th=Dao.getTH();
////		Integer.parseInt(th.get(0).toString());
//		System.out.println(Integer.parseInt(th.get(0).getSd_number.toString()));
		
//		for(int i=0;i<th.size();i++) {
//			for(int j=0;j<3;j++) {
//				
//			}
//		}
		
		
//		for(int i=0;i<Dao.getTH().size();i++){	
//			for(int j=0;j<3;j++) {
//				
//				//Dao.getTH().get(i);
//				System.out.println((String) ((List) Dao.getTH().get(i)).get(j));
//				tableValues[i][j]=(String) ((List) Dao.getTH().get(i)).get(j);
//				System.out.println((String) ((List) Dao.getTH().get(i)).get(j));
//				System.out.println(tableValues[i][j]);
//				
//			}        
//		}
		
//		JTable sd_show=new JTable(tableValues,columnNames);//创建表格（表格值，列名）
//		sd_show.setFont(new Font("微软雅黑",0,28));//设置字体，0正常，1粗体
//		JScrollPane scrollPane=new JScrollPane(sd_show);
//		scrollPane.setBounds(40,40,375,600);
//		container.add(scrollPane,BorderLayout.CENTER);

		
		JButton comment=new JButton("评论");
		comment.setBounds(250,650,150,40);//设置按钮的位置和大小
		comment.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container.add(comment);//将"评论"按钮添加到容器中
		
		comment.addActionListener(new ActionListener() {//为"我的"按钮添加鼠标单击事件			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//关闭窗体并停止程序
	}
	
	
	
	
}