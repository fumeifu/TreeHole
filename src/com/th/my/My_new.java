package com.th.my;
//“我的”
import javax.swing.*;

import com.th.square.Square;
import com.th.square.Square_new;

import java.awt.*;


public class My_new extends JDialog{
	
	public My_new(Square_new dialog) {
		super(dialog,"我的",true);//在Square窗口之后出现
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
		System.out.println("x="+getX()+" "+"y ="+ getY());
		//获取坐标
		
		
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//关闭窗体并停止程序
		
	}
	
}
