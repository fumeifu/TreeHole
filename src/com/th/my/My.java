//package com.th.my;
////“我的”
//import javax.swing.*;
//
//import com.th.square.Square;
//
//import java.awt.*;
//
//
//public class My extends JDialog{
//	
//	public My(Square dialog) {
//		super(dialog,"我的",true);//在Square窗口之后出现
//		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
//		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置
//
//		Container container3=getContentPane();//获取窗体容器（将窗体转换为容器）
//		
//		
//		
//		setVisible(true);//设置窗体可见	
//		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//关闭窗体并停止程序
//		
//	}
//	
//}


package com.th.my;
//“我的”
import javax.swing.*;

import com.th.dao.Dao;
import com.th.login.Login;
import com.th.square.Square;

import model.TbUserlist;

import java.awt.*;


public class My extends JDialog{
	

	
	public My(Square dialog) {
		super(dialog,"我的",true);//在Square窗口之后出现
		setTitle("我的");
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置
			
		Container container3=getContentPane();//获取窗体容器（将窗体转换为容器）
			
		JLabel l = new JLabel("学号：");
		l.setFont(new Font("微软雅黑",0,24));
		l.setBounds(80, 80, 100, 100);
		container3.add(l);//添加一个组件
//		c.remove(l);//删除组件
		JLabel l0 = new JLabel("密码：");
		l0.setFont(new Font("微软雅黑",0,24));
		l0.setBounds(80, 180, 100, 100);
		container3.add(l0);
		
		JButton btn = new JButton("登出");//登出按钮
		btn.setFont(new Font("微软雅黑",0,36));
		container3.add(btn);
		btn.setBounds(150,600,160,70);
		
		JButton btn0 = new JButton("广场");
		btn0.setFont(new Font("微软雅黑",0,24));
		btn0.setBounds(60,700,150,40);
		container3.add(btn0);
		
		JButton btn1 = new JButton("发布树洞");
		btn1.setFont(new Font("微软雅黑",0,24));
		btn1.setBounds(250,700,150,40);
		container3.add(btn1);
		
		container3.validate();//验证容器中的组件；达到刷新，推荐
//		f.setContentPane(c);//重新载入容器，达到刷新
		
		setResizable(false);//设置窗体是否可以改变大小
//		System.out.println("x="+getX()+" "+"y ="+ getY());
		//获取坐标
		
		JLabel number5=new JLabel();//显示学号，先获取当初登陆的信息
		Dao.MyConn();
//		user=Dao.getUser(int number6, String password6);
		int number6=0;
		String password6=null;
		number5.setText(Integer.toString(Dao.getUser(number6, password6).getNumber4()));
		number5.setFont(new Font("微软雅黑",0,24));
		number5.setBounds(150,110,150,40);
		container3.add(number5);
		
		JLabel password5=new JLabel();//显示密码，先获取当初登陆的信息
		password5.setText(Dao.getUser(number6, password6).getPassword4());
		password5.setFont(new Font("微软雅黑",0,24));
		password5.setBounds(150,210,150,40);
		container3.add(password5);
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体并停止程序
		
	}
	
	
	
	
}

