package com.th.square;
//�㳡
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.th.dao.Dao;
import com.th.issue.Issue;
import com.th.login.Login;
import com.th.my.My;


public class Square extends JDialog{
	
	JButton btn_add=new JButton("��������");//����"��������"��ť
	JButton btn_my=new JButton("�ҵ�");//����"�ҵ�"��ť
	
	public Square(Login frame) {
		super(frame,"�㳡",true);//��Login����֮�����	
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container=getContentPane();//��ȡ����������������ת��Ϊ������
		
		btn_add.setBounds(60,700,150,40);//���ð�ť��λ�úʹ�С
		btn_add.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container.add(btn_add);//��"��������"��ť��ӵ�������
		
		btn_add.addActionListener(new ActionListener() {//Ϊ"��������"��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				new Issue(Square.this);
			}
		});
		
		btn_my.setBounds(250,700,150,40);//���ð�ť��λ�úʹ�С
		btn_my.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container.add(btn_my);//��"�ҵ�"��ť��ӵ�������
		
		btn_my.addActionListener(new ActionListener() {//Ϊ"�ҵ�"��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				new My(Square.this);
			}
		});
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
	}
}
