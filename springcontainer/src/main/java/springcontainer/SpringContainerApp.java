package springcontainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringContainerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testBeanFactory();
	//	testApplicationContext();
		testBeanFactory2();
	}

	private static void testApplicationContext() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		//타입으로 받아오기  불가 !
		//해당 타입으로 생성된 객체가 유일할 경우 사용할 수 있음
//		User user1 = ac.getBean(User.class);
//		System.out.println("get by type:" +user1);
		
		//id또는 name으로 받기 
		User user1 = (User)ac.getBean("user"); //id
		User user2 = (User)ac.getBean("member"); // name
		System.out.println("get by id:" +user1);
		System.out.println("get by name:" +user2);
		System.out.println("user1 ==user2 ?" +(user1 ==user2));
		
		User user3 = (User)ac.getBean("user3");
		System.out.println("user3" +user3);
		System.out.println("user1 ==user3 ?" +(user1 ==user3));
		
		//생성자로 만들어진 bean 얻어오기
		User user4 = (User)ac.getBean("user4");
		System.out.println("user4:"+user4);
		
		User user5 =(User)ac.getBean("user5");
		System.out.println("user5:"+user5);

		//의존성이 주입된 bean
		Friend friend = (Friend)ac.getBean("friend");
		System.out.println("Friend :" +friend);

		User user6 = (User)ac.getBean("user6");
		System.out.println("user6 :" +user6);
		
		
		//집합객체가 주입된 bean
		
		User user7 = (User)ac.getBean("user7");
		System.out.println("user7 :" +user7);

		
	}
	private static void testBeanFactory() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/applicationContext.xml"));

		//type으로 얻어오기 ? 무얼?
		User user = bf.getBean(User.class);
		System.out.println("by type: " + user);
		
		//id로 얻어오기
		user = (User)bf.getBean("user"); // id가 user인 bean 획득
		System.out.println("by id: " + user);

		//name으로 얻어오기
		user = (User)bf.getBean("member"); //name이 user인 bean 획득
		System.out.println("by name: " + user);

	
	}
	
	private static void testBeanFactory2() {
		BeanFactory bf = // bean을 로딩하기 위함
				new XmlBeanFactory(new ClassPathResource("config/applicationContext2.xml"));
		
		User user = (User)bf.getBean("user");
		System.out.println("by Component Scan:" + user);
	}
}



