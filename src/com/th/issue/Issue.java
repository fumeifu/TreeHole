package com.th.issue;
//发布树洞功能

import javax.swing.*;

import com.th.login.Login;
import com.th.square.Square;

import java.awt.*;
public class Issue extends JDialog{
	
	JRadioButton jrb1=new JRadioButton("校园");//设置4个单选框
	JRadioButton jrb2=new JRadioButton("学习");
	JRadioButton jrb3=new JRadioButton("吐槽");
	JRadioButton jrb4=new JRadioButton("情感");
	ButtonGroup bg=new ButtonGroup();//定义按钮组
	final JTextArea textArea = new JTextArea(35,60);//文本域（待发布的内容）
	JButton fabu=new JButton("发布");//创建按钮
	
	public Issue(Square dialog) {
		super(dialog,"发布树洞",true);//在Square窗口之后出现	
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置

		Container container2=getContentPane();//获取窗体容器（将窗体转换为容器）
		
		bg.add(jrb1);//注意要把单选框放入按钮组作用域中才能实现单选
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		
		jrb1.setBounds(30,580,100,40);//设置单选框的位置和大小
		jrb1.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container2.add(jrb1);
		jrb2.setBounds(130,580,100,40);//设置单选框的位置和大小
		jrb2.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container2.add(jrb2);
		jrb3.setBounds(230,580,100,40);//设置单选框的位置和大小
		jrb3.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container2.add(jrb3);
		jrb4.setBounds(330,580,100,40);//设置单选框的位置和大小
		jrb4.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		container2.add(jrb4);
				
        textArea.setLineWrap(true);//设置文本域自动换行
        textArea.setBounds(40,40,375,480);
        textArea.setFont(new Font("微软雅黑",0,28));//设置字体，0正常，1粗体
        container2.add(textArea);
        
        fabu.setBounds(150,650,160,70);//设置“发布”按钮的位置和大小
		fabu.setFont(new Font("微软雅黑",0,32));//设置字体，0正常，1粗体
		container2.add(fabu);//将按钮添加到容器中
		

		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体并停止程序
	}
}
