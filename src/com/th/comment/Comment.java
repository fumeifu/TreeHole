package com.th.comment;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//�������۹���
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.th.dao.Dao;
import com.th.issue.Issue;
import com.th.my.My;
import com.th.square.Square;
import com.th.square.Square_new;


public class Comment extends JDialog{

	public Comment(Choose dialog) {		
		super(dialog,"����",true);
		
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container3=getContentPane();//��ȡ����������������ת��Ϊ������
		
		final JTextArea th = new JTextArea(35,60);//�ı��򣨴����������ݣ�
		th.setLineWrap(true);//�����ı����Զ�����
        th.setBounds(40,40,375,280);
        th.setFont(new Font("΢���ź�",0,28));//�������壬0������1����
        container3.add(th);
        
//        th.append(Dao.getTH().getSd_context());
//		th.append("\n");
//		th.append("#");
//		th.append(Integer.toString(Dao.getTH().getSd_number()));
//		th.append("\t");
//		th.append("   *");
//		th.append(Dao.getTH().getSd_label());
//		th.append("\n");
//		th.append("-----------------------------");
		
		JLabel pl=new JLabel("����");
		pl.setBounds(40, 700, 120, 30);//���ñ�ǩ��λ�úʹ�С
		pl.setFont(new Font("΢���ź�",0,22));//�������壬0������1����
		container3.add(pl);
		
		final JTextArea pl2 = new JTextArea(35,60);//�ı��򣨴����������ݣ�
		pl2.setLineWrap(true);//�����ı����Զ�����
		pl2.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
        JScrollPane sp=new JScrollPane(pl2);
		container3.add(sp);
		sp.setBounds(100,670,240,80);
		
		JButton fasong=new JButton("����");
		fasong.setBounds(360, 700, 80, 40);//���ñ�ǩ��λ�úʹ�С
		fasong.setFont(new Font("΢���ź�",0,22));//�������壬0������1����
		container3.add(fasong);
		
		fasong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		
		JTextArea xianshi=new JTextArea(35,60);
		xianshi.setLineWrap(true);//�����ı����Զ�����
		xianshi.setFont(new Font("΢���ź�",0,26));//�������壬0������1����
		JScrollPane sp2=new JScrollPane(xianshi);
		container3.add(sp2);
		sp2.setBounds(40,340,380,300);
        
        
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
		
		
	}

}
