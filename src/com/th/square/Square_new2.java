package com.th.square;
//�㳡��
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import com.th.comment.Choose;
import com.th.comment.Comment;
import com.th.comment.Comment_new;
import com.th.dao.Dao;
import com.th.issue.Issue;
import com.th.issue.Issue_new;
import com.th.login.Login;
import com.th.my.My;
import com.th.my.My_new;

import model.TbTh;
import model.TbUserlist;


public class Square_new2 extends JDialog{
	
//	//����JDBC����
//	protected static String dbClassName2 = "com.mysql.cj.jdbc.Driver";
//	protected static String dbUrl2 = "jdbc:mysql://localhost:3306/treehole?serverTimezone=UTC&characterEncoding=utf-8";
//	protected static String dbUser2 = "sx";//�û���
//	protected static String dbPwd2 = "19990128";//����
//	protected static String second2 = null;
//	public static Connection conn2 = null;//����һ����̬���ݿ����ӣ��������ӻ�û��ֵ
		
	
//	public static void MyConn() {
//		try {
//			Class.forName(dbClassName2);
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//        try {
//        // �����ݿ�����
//        	conn2 = DriverManager.getConnection(dbUrl2, dbUser2, dbPwd2);
//        } catch (Exception e1) {
//        	e1.printStackTrace();
//        }
//        System.out.println("222");
//	}
//	
//	public static ResultSet findForResultSet(String sql) {
//		if (conn2 == null)
//			return null;
//		long time = System.currentTimeMillis();
//		ResultSet rs = null;
//		try {
//			Statement stmt = null;
//			stmt = conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//			rs = stmt.executeQuery(sql);
//			second2 = ((System.currentTimeMillis() - time) / 1000d) + "";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}
	
//	private static List th;
	JButton btn_add=new JButton("��������");//����"��������"��ť
	JButton btn_my=new JButton("�ҵ�");//����"�ҵ�"��ť
	
	public Square_new2(Comment_new dialog) {	
		super(dialog,"�㳡",true);
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container=getContentPane();//��ȡ����������������ת��Ϊ������
		
		btn_add.setBounds(60,700,150,40);//���ð�ť��λ�úʹ�С
		btn_add.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container.add(btn_add);//��"��������"��ť��ӵ�������
		
		btn_add.addActionListener(new ActionListener() {//Ϊ"��������"��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		
		btn_my.setBounds(250,700,150,40);//���ð�ť��λ�úʹ�С
		btn_my.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container.add(btn_my);//��"�ҵ�"��ť��ӵ�������
		
		btn_my.addActionListener(new ActionListener() {//Ϊ"�ҵ�"��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				new My(Square_new2.this);
			}
		});
		
//		JTextArea ta=new JTextArea(35,60);
//		ta.setLineWrap(true);//�����ı����Զ�����
//		ta.setFont(new Font("΢���ź�",0,28));//�������壬0������1����
//		JScrollPane sp=new JScrollPane(ta);
//		container.add(sp);
//		sp.setBounds(40,40,375,600);
		
//		Dao.MyConn();
//		TbTh shudong[]=new TbTh[10000];
//		shudong=Dao.getTH();
//		int len=shudong.length;
//		System.out.println(len);
//		for(int i=0;i<len;i++) {
//
//			ta.append(shudong[i].getSd_context()[i]);
//			ta.append("\n");
//			ta.append("#");
//			ta.append(Integer.toString(shudong[i].getSd_number()[i]));
//			ta.append("\t");
//			ta.append("   *");
//			ta.append(shudong[i].getSd_label()[i]);
//			ta.append("\n");
//			ta.append("-----------------------------");
//		}
		
//		Dao.MyConn();
//		//����ѯ����һ�����ݶ���ӵ�ta�У�ta����ӵ����������
//		ta.append(Dao.getTH().getSd_context());
//		ta.append("\n");
//		ta.append("#");
//		ta.append(Integer.toString(Dao.getTH().getSd_number()));
//		ta.append("\t");
//		ta.append("   *");
//		ta.append(Dao.getTH().getSd_label());
//		ta.append("\n");
//		ta.append("-----------------------------");
		
//		Dao.MyConn();
//	
//		String[] columnNames= {"���","��������","��ǩ"};
//		String[][] tableValues= {};
		
		//�����ݿ���ȡ����Ϣ
		//rowData�������������
		//columnNames�������
		Vector rowData,columnNames;
		JTable jt=null;
		JScrollPane jsp=null;	
		//�������ݿ���Ҫ��ȫ�ֱ���
//		PreparedStatement ps=null;
//		Connection ct=null;
//		ResultSet rs=null;	
		columnNames=new Vector();
		//��������
		columnNames.add("���");
		columnNames.add("��������");
		columnNames.add("��ǩ");
		rowData = new Vector();
		rowData=Dao.getTH();
//1		ResultSet rs = findForResultSet("select * from tb_shudong");
//1		try {
//			Class.forName(dbClassName2);
			// �����ݿ�����
//        	conn2 = DriverManager.getConnection(dbUrl2, dbUser2, dbPwd2);
//    		System.out.println(rs2);
//1        	while(rs.next()){
				//rowData���Դ�Ŷ���
//1       		System.out.println("hello");
//1				Vector hang=new Vector();
//1				hang.add(rs.getInt("sd_number"));
//1				hang.add(rs.getString("sd_context"));
//1				hang.add(rs.getString("sd_label"));
//1				System.out.println(rs.getInt("sd_number"));
				//���뵽rowData
//1				rowData.add(hang);
//1			}
//1        }catch (SQLException e) {
//1			e.printStackTrace();
//1		}
//		finally{
////			
//			try {
//				if(rs!=null){
//				rs.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	    }
		//��ʼ��Jtable
		jt = new JTable(rowData,columnNames);	
		jt.setRowHeight(28);// ���ñ���п�
		jt.setFont(new Font("΢���ź�",0,22));//�������壬0������1����
//		jt.setEnabled(false);
//		jt.addMouseListener(new MouseListener() {
//		    @Override
//		    public void mouseReleased(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mousePressed(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mouseExited(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mouseEntered(MouseEvent e) {
//		 
//		    }
//		 
//		    @Override
//		    public void mouseClicked(MouseEvent e) {
//		        // ������Σ�������˫���¼�
//		        if (e.getClickCount() == 2) {
//		            
//		        }
//		    }
//		});
		//��ʼ�� jsp
//		jsp = new JScrollPane(jt);	
		jsp = new JScrollPane(jt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// ���������������Ĭ�Ϲ�����ʼ�ճ��֣���ʼ���б����
		jsp.setBounds(40,40,375,600);
		//��jsp���뵽container
		container.add(jsp);
		
		
		
		
		//rowData���Դ�Ŷ���,��ʼ�����ݿ���ȡ
//		try {
//			//��������
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			//�õ�����
//			ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/treehole?serverTimezone=UTC&characterEncoding=utf-8");		
//			ps=ct.prepareStatement("select * from tb_shudong");		
//			rs=ps.executeQuery();	
//			String dbUser2 = "sx";//�û���
//			String dbPwd2 = "19990128";//����
//			String second2 = null;
//			Connection conn2 = null;//����һ����̬���ݿ����ӣ��������ӻ�û��ֵ
//			
//			
//			while(rs.next()){
//				//rowData���Դ�Ŷ���
//				Vector hang=new Vector();
//				hang.add(rs.getInt(1));
//				hang.add(rs.getString(2));
//				hang.add(rs.getString(3));
//				System.out.println(rs.getInt(1));
//				//���뵽rowData
//				rowData.add(hang);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			
//				try {
//					if(rs!=null){
//					rs.close();
//					}
//					if(ps!=null){
//						ps.close();
//					}
//					if(ct!=null){
//						ct.close();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//		
//		
//		//��ʼ��Jtable
//		jt = new JTable(rowData,columnNames);	
//		//��ʼ�� jsp
//		jsp = new JScrollPane(jt);	
//		jsp.setBounds(40,40,375,600);
//		//��jsp���뵽container
//		container.add(jsp);	
		
//		
//		th=Dao.getTH();
////		Integer.parseInt(th.get(0).toString());
//		System.out.println(Integer.parseInt(th.get(0).getSd_number.toString()));
		
//		for(int i=0;i<th.size();i++) {
//			for(int j=0;j<3;j++) {
//				
//			}
//		}
		
		
//		for(int i=0;i<Dao.getTH().size();i++){	
//			for(int j=0;j<3;j++) {
//				
//				//Dao.getTH().get(i);
//				System.out.println((String) ((List) Dao.getTH().get(i)).get(j));
//				tableValues[i][j]=(String) ((List) Dao.getTH().get(i)).get(j);
//				System.out.println((String) ((List) Dao.getTH().get(i)).get(j));
//				System.out.println(tableValues[i][j]);
//				
//			}        
//		}
		
//		JTable sd_show=new JTable(tableValues,columnNames);//������񣨱��ֵ��������
//		sd_show.setFont(new Font("΢���ź�",0,28));//�������壬0������1����
//		JScrollPane scrollPane=new JScrollPane(sd_show);
//		scrollPane.setBounds(40,40,375,600);
//		container.add(scrollPane,BorderLayout.CENTER);

		
		JButton comment=new JButton("����");
		comment.setBounds(250,650,150,40);//���ð�ť��λ�úʹ�С
		comment.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		container.add(comment);//��"����"��ť��ӵ�������
		
		comment.addActionListener(new ActionListener() {//Ϊ"�ҵ�"��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
	}
	
	
	
	
}