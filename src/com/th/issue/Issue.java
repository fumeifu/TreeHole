package com.th.issue;
//������������

import javax.swing.*;

import com.th.login.Login;
import com.th.square.Square;

import java.awt.*;
public class Issue extends JDialog{
	
	JRadioButton jrb1=new JRadioButton("У԰");//����4����ѡ��
	JRadioButton jrb2=new JRadioButton("ѧϰ");
	JRadioButton jrb3=new JRadioButton("�²�");
	JRadioButton jrb4=new JRadioButton("���");
	ButtonGroup bg=new ButtonGroup();//���尴ť��
	final JTextArea textArea = new JTextArea(35,60);//�ı��򣨴����������ݣ�
	JButton fabu=new JButton("����");//������ť
	
	public Issue(Square dialog) {
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
		

		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
	}
}
