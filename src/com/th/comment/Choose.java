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
		super(dialog,"ѡ��",true);
		setBounds(220, 300, 460, 250);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container4=getContentPane();//��ȡ����������������ת��Ϊ������
		
		JLabel ch=new JLabel();//����ѡ���ǩ
		ch.setText("����������������ı��");
		ch.setBounds(50, 50, 280, 30);//���ñ�ǩ��λ�úʹ�С
		ch.setFont(new Font("΢���ź�",0,22));//�������壬0������1����
		container4.add(ch);
		
		final JTextField ch2=new JTextField();//�����ı���
		ch2.setBounds(310, 50, 100, 30);
		ch2.setFont(new Font("΢���ź�",0,22));//�����ı�������ʱ������
		container4.add(ch2);
		
		JButton btn=new JButton("ȷ��");//������ť
		btn.setBounds(180,100,100,50);//���ð�ť��λ�úʹ�С
		btn.setFont(new Font("΢���ź�",0,26));//�������壬0������1����
		container4.add(btn);//����ť��ӵ�������


		
		btn.addActionListener(new ActionListener() {//Ϊ��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				Dao.MyConn();
				ch4=Dao.getChoose(Integer.parseInt(ch2.getText()));
				context=ch4.getContext();
				sd_number=ch4.getNumber();
				new Comment(Choose.this);
			}
		});
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
		
	}
	public static TbChooselist getChoose() {
		return ch4;
	}
	public static void setUser(TbChooselist ch4) {
		Choose.ch4 = ch4;
	}
	
}
