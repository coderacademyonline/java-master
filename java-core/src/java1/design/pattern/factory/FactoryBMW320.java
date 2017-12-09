package java1.design.pattern.factory;

/**
 * 宝马320系列配件
 * @author zhaojw_420
 *
 */
public class FactoryBMW320 implements AbstractFactory {

	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new EngineA();
	}

	public Aircondition createAircontion() {
		// TODO Auto-generated method stub
		return new AirconditionA();
	}

}
