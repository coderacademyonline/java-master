package java1.design.pattern.factory;

public class Customer1 {

	public static void main(String[] args) {
		FactoryBMW factory=new FactoryBMW();
		factory.createBMB(320);
		factory.createBMB(523);
	}
}
