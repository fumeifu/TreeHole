package com.th.comment;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
//�������۹���
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.th.dao.Dao;
import com.th.issue.Issue;
import com.th.my.My;
import com.th.square.Square;
import com.th.square.Square_new;
import com.th.square.Square_new2;


public class Comment_new extends JDialog{

	public Comment_new(Comment dialog) {		
		super(dialog,"����",true);
		
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container3=getContentPane();//��ȡ����������������ת��Ϊ������
		
		final JTextArea th = new JTextArea();
        th.setBounds(40,40,375,280);
        th.setFont(new Font("΢���ź�",0,28));//�������壬0������1����
        th.setLineWrap(true);//�����Զ����й���
        th.setEditable(false); //���ɱ༭
        th.append("#");
        th.append(Integer.toString(Choose.sd_number));
        th.append("\n");
        th.append(Choose.context);
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
		
		
		Vector rowData,columnNames;
		JTable jt=null;
		JScrollPane jsp=null;
		columnNames=new Vector();
		//��������
		columnNames.add("������");
		columnNames.add("����");
		rowData = new Vector();
		rowData=Dao.getPL();
		//��ʼ��Jtable
		jt = new JTable(rowData,columnNames);	
		jt.setRowHeight(28);// ���ñ���п�
		jt.setFont(new Font("΢���ź�",0,22));//�������壬0������1����
		//��ʼ�� jsp
//		jsp = new JScrollPane(jt);	
		jsp = new JScrollPane(jt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// ���������������Ĭ�Ϲ�����ʼ�ճ��֣���ʼ���б����
		jsp.setBounds(40,340,380,300);
		//��jsp���뵽container
		container3.add(jsp);
		
		JButton fanhui=new JButton("���ع㳡");
		fanhui.setBounds(320, 755, 125, 40);//���ñ�ǩ��λ�úʹ�С
		fanhui.setFont(new Font("΢���ź�",0,22));//�������壬0������1����
		container3.add(fanhui);
		
		fanhui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new Square_new2(Comment_new.this);
			}
		});
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
		
		
	}

}
