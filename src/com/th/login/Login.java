package com.th.login;
//登录
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.th.dao.Dao;
import com.th.square.Square;

import model.TbUserlist;




//class Succeed extends JDialog{
//	public Succeed(Login frame) {
//		super(frame,"登录成功",true);
//		Container container=getContentPane();
//		JLabel j1=new JLabel("登录成功！");
//		container.add(j1);
//		j1.setFont(new Font("微软雅黑",0,36));
//		setBounds(200, 150, 200, 200);
//		setVisible(true);
//	}
//}

public class Login extends JFrame{
	private static TbUserlist user;
	JLabel stu_number=new JLabel();//创建学号标签
	JLabel stu_password=new JLabel();//创建密码标签
	final JTextField number=new JTextField();//创建学号文本框
	public static int stu_number2;
	JPasswordField password=new JPasswordField();//创建密码文本框
	JButton btn=new JButton("登录");//创建按钮
	
	public Login() {
		setTitle("二师树洞系统");//设置该窗体标题
		setLayout(null);//使该窗体取消布局管理器设置，以便自己设置每个组件的大小和位置
		setBounds(200, 150, 480, 853);//设置窗体坐标、大小，单位：像素
		Container c=getContentPane();//获取窗体容器（将窗体转换为容器）
		//setBackground(Color.WHITE);//设置背景颜色
		
		stu_number.setText("学号");
		stu_number.setBounds(80, 80, 100, 100);//设置标签的位置和大小
		stu_number.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		c.add(stu_number);
		
		stu_password.setText("密码");
		stu_password.setBounds(80, 180, 100, 100);//设置标签的位置和大小
		stu_password.setFont(new Font("微软雅黑",0,24));//设置字体，0正常，1粗体
		c.add(stu_password);
		
		number.setBounds(160, 115, 240, 40);
		number.setFont(new Font("微软雅黑",0,24));//设置学号文本框输入时的字体
		c.add(number);
		
		password.setBounds(160, 215, 240, 40);
		password.setFont(new Font("微软雅黑",0,24));
		password.setEchoChar('*');//设置密码的回显字符
		c.add(password);
		
		btn.setBounds(150,600,160,70);//设置按钮的位置和大小
		btn.setFont(new Font("微软雅黑",0,36));//设置字体，0正常，1粗体
		c.add(btn);//将按钮添加到容器中
		
		
		
		btn.addActionListener(new ActionListener() {//为按钮添加鼠标单击事件			
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
				
				//获取在学号文本框中输入的内容，并将其强制转为int型
				int number2=Integer.parseInt(number.getText());
				String password2=String.valueOf(password.getPassword());//获取密码框中的密码
				if (0 == number2
		                || password2 == null
		                || (number2+"").length() == 0//求整型数的长度的做法
		                || password2.trim().length() == 0) {//trim()方法返回调用字符串对象的一个副本，但是所有起始和结尾都被删掉了。
		              //JOptionPane类来实现类似Windows平台下的MessageBox的功能，同样在Java中也有，利用JOptionPane类中的各个static方法来
					//生成各种标准的对话框，实现显示出信息、提出问题、警告、用户输入参数等功能。
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
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
		setVisible(true);//设置窗体可见	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体并停止程序		
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