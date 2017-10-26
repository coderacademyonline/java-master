package java.design.pattern.factory;

/**
 * 抽象工厂类接口
 * @author zhaojw_420
 *
 */
public interface AbstractFactory {
    //制造发动机
	Engine createEngine();
	//制造空调
	Aircondition createAircontion();
}
