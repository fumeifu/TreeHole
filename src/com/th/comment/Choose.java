package com.th.comment;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.th.dao.Dao;
import com.th.login.Login;
import com.th.square.Square;
import com.th.square.Square_new;

import model.TbChooselist;
import model.TbUserlist;

public class Choose extends JDialog{
	public static String context;
	public static int sd_number;
	private static TbChooselist ch4;
	public Choose(Square_new dialog) {		
		super(dialog,"选择",true);
		setBounds(220, 300, 460, 250);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置

		Container container4=getContentPane();//获取窗体容器（将窗体转换为容器）
		
		JLabel ch=new JLabel();//创建选择标签
		ch.setText("请输入待评论树洞的编号");
		ch.setBounds(50, 50, 280, 30);//设置标签的位置和大小
		ch.setFont(new Font("微软雅黑",0,22));//设置字体，0正常，1粗体
		container4.add(ch);
		
		final JTextField ch2=new JTextField();//创建文本框
		ch2.setBounds(310, 50, 100, 30);
		ch2.setFont(new Font("微软雅黑",0,22));//设置文本框输入时的字体
		container4.add(ch2);
		
		JButton btn=new JButton("确定");//创建按钮
		btn.setBounds(180,100,100,50);//设置按钮的位置和大小
		btn.setFont(new Font("微软雅黑",0,26));//设置字体，0正常，1粗体
		container4.add(btn);//将按钮添加到容器中


		
		btn.addActionListener(new ActionListener() {//为按钮添加鼠标单击事件			
			@Override
			public void actionPerformed(final ActionEvent e) {
				Dao.MyConn();
				ch4=Dao.getChoose(Integer.parseInt(ch2.getText()));
				context=ch4.getContext();
				sd_number=ch4.getNumber();
				new Comment(Choose.this);
			}
		});
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//关闭窗体并停止程序
		
	}
	public static TbChooselist getChoose() {
		return ch4;
	}
	public static void setUser(TbChooselist ch4) {
		Choose.ch4 = ch4;
	}
	
}
