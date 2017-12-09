package java1.design.pattern.factory;

/**
 * 宝马523系列配件
 * @author zhaojw_420
 *
 */
public class FactoryBMW523 implements AbstractFactory {

	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new EngineB();
	}

	public Aircondition createAircontion() {
		// TODO Auto-generated method stub
		return new AirconditionB();
	}

}
