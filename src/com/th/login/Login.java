package com.th.login;
//��¼
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.th.dao.Dao;
import com.th.square.Square;

import model.TbUserlist;




//class Succeed extends JDialog{
//	public Succeed(Login frame) {
//		super(frame,"��¼�ɹ�",true);
//		Container container=getContentPane();
//		JLabel j1=new JLabel("��¼�ɹ���");
//		container.add(j1);
//		j1.setFont(new Font("΢���ź�",0,36));
//		setBounds(200, 150, 200, 200);
//		setVisible(true);
//	}
//}

public class Login extends JFrame{
	private static TbUserlist user;
	JLabel stu_number=new JLabel();//����ѧ�ű�ǩ
	JLabel stu_password=new JLabel();//���������ǩ
	final JTextField number=new JTextField();//����ѧ���ı���
	public static int stu_number2;
	JPasswordField password=new JPasswordField();//���������ı���
	JButton btn=new JButton("��¼");//������ť
	
	public Login() {
		setTitle("��ʦ����ϵͳ");//���øô������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		Container c=getContentPane();//��ȡ����������������ת��Ϊ������
		//setBackground(Color.WHITE);//���ñ�����ɫ
		
		stu_number.setText("ѧ��");
		stu_number.setBounds(80, 80, 100, 100);//���ñ�ǩ��λ�úʹ�С
		stu_number.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		c.add(stu_number);
		
		stu_password.setText("����");
		stu_password.setBounds(80, 180, 100, 100);//���ñ�ǩ��λ�úʹ�С
		stu_password.setFont(new Font("΢���ź�",0,24));//�������壬0������1����
		c.add(stu_password);
		
		number.setBounds(160, 115, 240, 40);
		number.setFont(new Font("΢���ź�",0,24));//����ѧ���ı�������ʱ������
		c.add(number);
		
		password.setBounds(160, 215, 240, 40);
		password.setFont(new Font("΢���ź�",0,24));
		password.setEchoChar('*');//��������Ļ����ַ�
		c.add(password);
		
		btn.setBounds(150,600,160,70);//���ð�ť��λ�úʹ�С
		btn.setFont(new Font("΢���ź�",0,36));//�������壬0������1����
		c.add(btn);//����ť��ӵ�������
		
		
		
		btn.addActionListener(new ActionListener() {//Ϊ��ť�����굥���¼�			
			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub
				Dao.MyConn();
				user = Dao.getUser(Integer.parseInt(number.getText()), password.getText());
				stu_number2=Integer.parseInt(number.getText());
//				System.out.println(user.getNumber4());
//				System.out.println(Integer.parseInt(number.getText()));
//				System.out.println(user.getPassword4());
//				System.out.println(password.getText());
				
				//��ȡ��ѧ���ı�������������ݣ�������ǿ��תΪint��
				int number2=Integer.parseInt(number.getText());
				String password2=String.valueOf(password.getPassword());//��ȡ������е�����
				if (0 == number2
		                || password2 == null
		                || (number2+"").length() == 0//���������ĳ��ȵ�����
		                || password2.trim().length() == 0) {//trim()�������ص����ַ��������һ������������������ʼ�ͽ�β����ɾ���ˡ�
		              //JOptionPane����ʵ������Windowsƽ̨�µ�MessageBox�Ĺ��ܣ�ͬ����Java��Ҳ�У�����JOptionPane���еĸ���static������
					//���ɸ��ֱ�׼�ĶԻ���ʵ����ʾ����Ϣ��������⡢���桢�û���������ȹ��ܡ�
					JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��");
		            }
//				else if (user.getNumber4() == 0 || user.getPassword4() == null) {
//					number.setText(null);
//                    password.setText(null);
//                    return;
//				}
//				setVisible(false);
//              new Succeed(Login.this).setVisible(true);
				else if(user.getNumber4()==Integer.parseInt(number.getText())&&user.getPassword4().contentEquals(password.getText())) {
					new Square(Login.this);
				}
			}
		});
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����		
	}
	
	public static void main(String[] args) {

		new Login();
	}
	
	public static TbUserlist getUser() {
		return user;
	}
	public static void setUser(TbUserlist user) {
		Login.user = user;
	}
	
}