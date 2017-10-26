package java.design.pattern.observer;

public class Client {

	public static void main(String[] args) {
		//创建微信用户
		WinXinUser user1=new WinXinUser("杨影枫");
		WinXinUser user2=new WinXinUser("月眉儿");
        WinXinUser user3=new WinXinUser("紫轩");
        
        ConcreteSubject concreteSubject=new ConcreteSubject();
        concreteSubject.attach(user1);
        concreteSubject.attach(user2);
        concreteSubject.attach(user3);
        
        concreteSubject.notify("您好，有客人下单了，，，，，");
	}
}
