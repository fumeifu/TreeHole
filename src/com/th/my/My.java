package com.th.my;
//���ҵġ�
import javax.swing.*;

import com.th.square.Square;

import java.awt.*;


public class My extends JDialog{
	
	public My(Square dialog) {
		super(dialog,"�ҵ�",true);//��Square����֮�����
		setBounds(200, 150, 480, 853);//���ô������ꡢ��С����λ������
		setLayout(null);//ʹ�ô���ȡ�����ֹ��������ã��Ա��Լ�����ÿ������Ĵ�С��λ��

		Container container3=getContentPane();//��ȡ����������������ת��Ϊ������
		
		
		
		setVisible(true);//���ô���ɼ�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��岢ֹͣ����
		
	}
	
}
