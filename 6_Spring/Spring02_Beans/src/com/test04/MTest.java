package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		//������ bean 2���� ������
		//��ü�� ����� �� Ȯ��
		
		ApplicationContext factory= new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		Emp lee =factory.getBean("lee",Emp.class); //�������°� emp class���� �������°Ŷ�� �����صθ� ���� ����ȯ ���ص���
		Emp hong=(Emp)factory.getBean("hong");
		
		System.out.println(lee);
		System.out.println(hong);
	}
}