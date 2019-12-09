package com.th.square;
//广场
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.th.dao.Dao;
import com.th.issue.Issue;
import com.th.login.Login;
import com.th.my.My;


public class Square extends JDialog{
	
	JButton btn_add=new JButton("发布树洞");//创建"发布树洞"按钮
	JButton btn_my=new JButton("我的");//创建"我的"按钮
	
	public Square(Login frame) {
		super(frame,"广场",true);//在Login窗口之后出现	
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置

		Container container=getContentPane();//获取窗体容器（将窗体转换为容器）
		
		btn_add.setBounds(60,700,150,40);//设置按钮的位置和大小
		btn_add.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container.add(btn_add);//将"发布树洞"按钮添加到容器中
		
		btn_add.addActionListener(new ActionListener() {//为"发布树洞"按钮添加鼠标单击事件			
			@Override
			public void actionPerformed(final ActionEvent e) {
				new Issue(Square.this);
			}
		});
		
		btn_my.setBounds(250,700,150,40);//设置按钮的位置和大小
		btn_my.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container.add(btn_my);//将"我的"按钮添加到容器中
		
		btn_my.addActionListener(new ActionListener() {//为"我的"按钮添加鼠标单击事件			
			@Override
			public void actionPerformed(final ActionEvent e) {
				new My(Square.this);
			}
		});
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体并停止程序
	}
}
