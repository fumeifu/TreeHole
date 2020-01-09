package com.th.my;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.th.comment.Comment_new;
import com.th.dao.Dao;

public class Secret extends JDialog{
	
	public Secret(My dialog) {	
		super(dialog,"修改密码",true);
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置

		Container container=getContentPane();//获取窗体容器（将窗体转换为容器）
		
		JLabel s1 = new JLabel("原密码");
		s1.setFont(new Font("微软雅黑",0,24));
		s1.setBounds(80, 80, 100, 100);
		container.add(s1);//添加一个组件
		
		JPasswordField password1=new JPasswordField();//创建密码文本框
		password1.setBounds(160, 115, 240, 40);
		password1.setFont(new Font("微软雅黑",0,24));
		password1.setEchoChar('*');//设置密码的回显字符
		container.add(password1);
		
		JLabel s2 = new JLabel("新密码");
		s2.setFont(new Font("微软雅黑",0,24));
		s2.setBounds(80, 180, 100, 100);
		container.add(s2);//添加一个组件
		
		JPasswordField password2=new JPasswordField();//创建密码文本框
		password2.setBounds(160, 215, 240, 40);
		password2.setFont(new Font("微软雅黑",0,24));
		password2.setEchoChar('*');//设置密码的回显字符
		container.add(password2);
		
		JLabel s3 = new JLabel("确认密码");
		s2.setFont(new Font("微软雅黑",0,24));
		s2.setBounds(80, 280, 100, 100);
		container.add(s2);//添加一个组件
		
		JPasswordField password3=new JPasswordField();//创建密码文本框
		password3.setBounds(160, 315, 240, 40);
		password3.setFont(new Font("微软雅黑",0,24));
		password3.setEchoChar('*');//设置密码的回显字符
		container.add(password3);
		
		JButton btn = new JButton("确定");//按钮
		btn.setFont(new Font("微软雅黑",0,28));
		container.add(btn);
		btn.setBounds(150,500,160,60);
		
		btn.addActionListener(new ActionListener() {//为"我的"按钮添加鼠标单击事件			
			@Override
			public void actionPerformed(final ActionEvent e) {
				Dao.MyConn();
				
				new My2(Secret.this);
			}
		});
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//关闭窗体并停止程序
	}
	
}
