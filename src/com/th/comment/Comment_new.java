package com.th.comment;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
//树洞评论功能
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
		super(dialog,"评论",true);
		
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置

		Container container3=getContentPane();//获取窗体容器（将窗体转换为容器）
		
		final JTextArea th = new JTextArea();
        th.setBounds(40,40,375,280);
        th.setFont(new Font("微软雅黑",0,28));//设置字体，0正常，1粗体
        th.setLineWrap(true);//激活自动换行功能
        th.setEditable(false); //不可编辑
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
		
		JLabel pl=new JLabel("评论");
		pl.setBounds(40, 700, 120, 30);//设置标签的位置和大小
		pl.setFont(new Font("微软雅黑",0,22));//设置字体，0正常，1粗体
		container3.add(pl);
		
		final JTextArea pl2 = new JTextArea(35,60);//文本域（待发布的内容）
		pl2.setLineWrap(true);//设置文本域自动换行
		pl2.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
        JScrollPane sp=new JScrollPane(pl2);
		container3.add(sp);
		sp.setBounds(100,670,240,80);
		
		JButton fasong=new JButton("发送");
		fasong.setBounds(360, 700, 80, 40);//设置标签的位置和大小
		fasong.setFont(new Font("微软雅黑",0,22));//设置字体，0正常，1粗体
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
		//设置列名
		columnNames.add("评论人");
		columnNames.add("内容");
		rowData = new Vector();
		rowData=Dao.getPL();
		//初始化Jtable
		jt = new JTable(rowData,columnNames);	
		jt.setRowHeight(28);// 设置表格行宽
		jt.setFont(new Font("微软雅黑",0,22));//设置字体，0正常，1粗体
		//初始化 jsp
//		jsp = new JScrollPane(jt);	
		jsp = new JScrollPane(jt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// 创建滚动条组件，默认滚动条始终出现，初始化列表组件
		jsp.setBounds(40,340,380,300);
		//把jsp放入到container
		container3.add(jsp);
		
		JButton fanhui=new JButton("返回广场");
		fanhui.setBounds(320, 755, 125, 40);//设置标签的位置和大小
		fanhui.setFont(new Font("微软雅黑",0,22));//设置字体，0正常，1粗体
		container3.add(fanhui);
		
		fanhui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new Square_new2(Comment_new.this);
			}
		});
		
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//关闭窗体并停止程序
		
		
	}

}
