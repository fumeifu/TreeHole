package com.th.my;
//“我的”
import javax.swing.*;

import com.th.square.Square;

import java.awt.*;


public class My extends JDialog{
	
	public My(Square dialog) {
		super(dialog,"我的",true);//在Square窗口之后出现
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置

		Container container3=getContentPane();//获取窗体容器（将窗体转换为容器）
		
		
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体并停止程序
		
	}
	
}
