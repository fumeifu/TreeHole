package com.th.my;
//���ҵġ�
import javax.swing.*;

import com.th.square.Square;
import com.th.square.Square_new;

import java.awt.*;


public class My_new extends JDialog{
	
	public My_new(Square_new dialog) {
		super(dialog,"�ҵ�",true);//��Square����֮�����
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
		
		JButton btn = new JButton("�ǳ�");//�ǳ���ť
		btn.setFont(new Font("΢���ź�",0,36));
		container3.add(btn);
		btn.setBounds(150,600,160,70);
		
		JButton btn0 = new JButton("�㳡");
		btn0.setFont(new Font("΢���ź�",0,24));
		btn0.setBounds(60,700,150,40);
		container3.add(btn0);
		
		JButton btn1 = new JButton("��������");
		btn1.setFont(new Font("΢���ź�",0,24));
		btn1.setBounds(250,700,150,40);
		container3.add(btn1);
		
		container3.validate();//��֤�����е�������ﵽˢ�£��Ƽ�
//		f.setContentPane(c);//���������������ﵽˢ��
		
		setResizable(false);//���ô����Ƿ���Ըı��С
		System.out.println("x="+getX()+" "+"y ="+ getY());
		//��ȡ����
		
		
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
		
	}
	
}
