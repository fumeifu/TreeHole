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

public class Choose extends JDialog{
	public Choose(Square_new dialog) {		
		super(dialog,"ѡ��",true);
		setBounds(700, 300, 520, 250);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container4=getContentPane();//��ȡ����������������ת��Ϊ������
		
		JLabel ch=new JLabel();//����ѡ���ǩ
		ch.setText("����������������ı�ǩ");
		ch.setBounds(60, 50, 280, 30);//���ñ�ǩ��λ�úʹ�С
		ch.setFont(new Font("΢���ź�",0,22));//�������壬0������1����
		container4.add(ch);
		
		final JTextField ch2=new JTextField();//�����ı���
		ch2.setBounds(320, 50, 100, 30);
		ch2.setFont(new Font("΢���ź�",0,22));//�����ı�������ʱ������
		container4.add(ch2);
		
		JButton btn=new JButton("ȷ��");//������ť
		btn.setBounds(190,100,100,50);//���ð�ť��λ�úʹ�С
		btn.setFont(new Font("΢���ź�",0,26));//�������壬0������1����
		container4.add(btn);//����ť��ӵ�������
		
		btn.addActionListener(new ActionListener() {//Ϊ��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
		
	}
}
