package com.th.issue;
//������������

import javax.swing.*;

import com.th.dao.Dao;
import com.th.login.Login;
import com.th.square.Square;
import com.th.square.Square_new;

import model.TbTh;
import model.TbUserlist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Issue_new extends JDialog{
	
	JRadioButton jrb1=new JRadioButton("У԰");//����4����ѡ��
	JRadioButton jrb2=new JRadioButton("ѧϰ");
	JRadioButton jrb3=new JRadioButton("�²�");
	JRadioButton jrb4=new JRadioButton("���");
	ButtonGroup bg=new ButtonGroup();//���尴ť��
	final JTextArea textArea = new JTextArea(35,60);//�ı��򣨴����������ݣ�
	JButton fabu=new JButton("����");//������ť
//	String sd_context2=textArea.getText();//��ȡ�ı����е�����
//	String sd_label2;//���ѡ�еĵ�ѡ����ı�����
	
	public Issue_new(Square_new dialog) {
		super(dialog,"��������",true);//��Square����֮�����	
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container2=getContentPane();//��ȡ����������������ת��Ϊ������
		
		bg.add(jrb1);//ע��Ҫ�ѵ�ѡ����밴ť���������в���ʵ�ֵ�ѡ
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		
		jrb1.setBounds(30,580,100,40);//���õ�ѡ���λ�úʹ�С
		jrb1.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container2.add(jrb1);
		jrb2.setBounds(130,580,100,40);//���õ�ѡ���λ�úʹ�С
		jrb2.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container2.add(jrb2);
		jrb3.setBounds(230,580,100,40);//���õ�ѡ���λ�úʹ�С
		jrb3.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container2.add(jrb3);
		jrb4.setBounds(330,580,100,40);//���õ�ѡ���λ�úʹ�С
		jrb4.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container2.add(jrb4);
				
        textArea.setLineWrap(true);//�����ı����Զ�����
        textArea.setBounds(40,40,375,480);
        textArea.setFont(new Font("΢���ź�",0,28));//�������壬0������1����
        container2.add(textArea);
              
        fabu.setBounds(150,650,160,70);//���á���������ť��λ�úʹ�С
		fabu.setFont(new Font("΢���ź�",0,32));//�������壬0������1����
		container2.add(fabu);//����ť��ӵ�������
		
//		if(jrb1.isSelected()) {
//			sd_label2=jrb1.getText();
//		}else if(jrb2.isSelected()) {
//			sd_label2=jrb2.getText();
//		}else if(jrb3.isSelected()) {
//			sd_label2=jrb3.getText();
//		}else if(jrb4.isSelected()) {
//			sd_label2=jrb4.getText();
//		}
		
		
		fabu.addActionListener(new ActionListener() {//Ϊ��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				Dao.MyConn();
//				Dao.addTH(sd_context2,sd_label2);
				Dao.addTH(textArea.getText(),jrb1.isSelected()?jrb1.getText():(jrb2.isSelected()?jrb2.getText():(jrb3.isSelected()?jrb3.getText():jrb4.getText())));
			}
		});
		
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
	}
	

}
