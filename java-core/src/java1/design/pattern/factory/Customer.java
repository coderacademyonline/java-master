package java1.design.pattern.factory;

public class Customer {

	public static void main(String[] args) {
		BMW320Factory bmw320Factory=new BMW320Factory();
		bmw320Factory.createBMW();
		
		BMW523Factory bmw523Factory=new BMW523Factory();
		bmw523Factory.createBMW();
		
	}
}
