//package com.th.my;
////���ҵġ�
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
//		super(dialog,"�ҵ�",true);//��Square����֮�����
//		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
//		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��
//
//		Container container3=getContentPane();//��ȡ����������������ת��Ϊ������
//		
//		
//		
//		setVisible(true);//���ô���ɼ�	
//		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
//		
//	}
//	
//}


package com.th.my;
//���ҵġ�
import javax.swing.*;

import com.th.dao.Dao;
import com.th.login.Login;
import com.th.square.Square;
import com.th.square.Square_new2;

import model.TbUserlist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class My2 extends JDialog{
	
	public My2(Secret dialog) {
		super(dialog,"�ҵ�",true);//��Square����֮�����
		setTitle("�ҵ�");
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��
			
		Container container3=getContentPane();//��ȡ����������������ת��Ϊ������
			
		JLabel l = new JLabel("ѧ�ţ�");
		l.setFont(new Font("΢���ź�",0,24));
		l.setBounds(80, 80, 100, 100);
		container3.add(l);//���һ�����
//		c.remove(l);//ɾ�����
		JLabel l0 = new JLabel("���룺");
		l0.setFont(new Font("΢���ź�",0,24));
		l0.setBounds(80, 180, 100, 100);
		container3.add(l0);
		
		JButton btn = new JButton("�޸�����");//�ǳ���ť
		btn.setFont(new Font("΢���ź�",0,28));
		container3.add(btn);
		btn.setBounds(150,500,160,60);
		
		JButton btn0 = new JButton("�㳡");
		btn0.setFont(new Font("΢���ź�",0,28));
		btn0.setBounds(60,620,160,60);
		container3.add(btn0);
		
		JButton btn1 = new JButton("��������");
		btn1.setFont(new Font("΢���ź�",0,28));
		btn1.setBounds(250,620,160,60);
		container3.add(btn1);
		
		container3.validate();//��֤�����е�������ﵽˢ�£��Ƽ�
//		f.setContentPane(c);//���������������ﵽˢ��
		
		setResizable(false);//���ô����Ƿ���Ըı��С
//		System.out.println("x="+getX()+" "+"y ="+ getY());
		//��ȡ����
		
		JLabel number5=new JLabel();//��ʾѧ�ţ��Ȼ�ȡ������½����Ϣ
		Dao.MyConn();
//		user=Dao.getUser(int number6, String password6);
		int number6=0;
		String password6=null;
		number5.setText(Integer.toString(Dao.getUser(number6, password6).getNumber4()));
		number5.setFont(new Font("΢���ź�",0,24));
		number5.setBounds(150,110,150,40);
		container3.add(number5);
		
		JLabel password5=new JLabel();//��ʾ���룬�Ȼ�ȡ������½����Ϣ
		password5.setText(Dao.getUser(number6, password6).getPassword4());
		password5.setFont(new Font("΢���ź�",0,24));
		password5.setBounds(150,210,150,40);
		container3.add(password5);
		
		btn.addActionListener(new ActionListener() {//Ϊ"�ҵ�"��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
		
	}
	
}

