package java1.design.pattern.factory;

public class AbstractCustomer {

	public static void main(String[] args) {
		//生产宝马320系列配件 
		FactoryBMW320 factoryBMW320=new FactoryBMW320();
		factoryBMW320.createEngine();
		factoryBMW320.createAircontion();
		
		//生产宝马523系列配件    
		FactoryBMW523 factoryBMW523=new FactoryBMW523();
		factoryBMW523.createEngine();
		factoryBMW523.createAircontion();
	}
}
