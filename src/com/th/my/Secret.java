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
		super(dialog,"�޸�����",true);
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container=getContentPane();//��ȡ����������������ת��Ϊ������
		
		JLabel s1 = new JLabel("ԭ����");
		s1.setFont(new Font("΢���ź�",0,24));
		s1.setBounds(80, 80, 100, 100);
		container.add(s1);//���һ�����
		
		JPasswordField password1=new JPasswordField();//���������ı���
		password1.setBounds(160, 115, 240, 40);
		password1.setFont(new Font("΢���ź�",0,24));
		password1.setEchoChar('*');//��������Ļ����ַ�
		container.add(password1);
		
		JLabel s2 = new JLabel("������");
		s2.setFont(new Font("΢���ź�",0,24));
		s2.setBounds(80, 180, 100, 100);
		container.add(s2);//���һ�����
		
		JPasswordField password2=new JPasswordField();//���������ı���
		password2.setBounds(160, 215, 240, 40);
		password2.setFont(new Font("΢���ź�",0,24));
		password2.setEchoChar('*');//��������Ļ����ַ�
		container.add(password2);
		
		JLabel s3 = new JLabel("ȷ������");
		s2.setFont(new Font("΢���ź�",0,24));
		s2.setBounds(80, 280, 100, 100);
		container.add(s2);//���һ�����
		
		JPasswordField password3=new JPasswordField();//���������ı���
		password3.setBounds(160, 315, 240, 40);
		password3.setFont(new Font("΢���ź�",0,24));
		password3.setEchoChar('*');//��������Ļ����ַ�
		container.add(password3);
		
		JButton btn = new JButton("ȷ��");//��ť
		btn.setFont(new Font("΢���ź�",0,28));
		container.add(btn);
		btn.setBounds(150,500,160,60);
		
		btn.addActionListener(new ActionListener() {//Ϊ"�ҵ�"��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				Dao.MyConn();
				
				new My2(Secret.this);
			}
		});
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
	}
	
}
