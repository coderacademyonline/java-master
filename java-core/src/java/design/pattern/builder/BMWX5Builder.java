package java.design.pattern.builder;

/**
 * 角色ConcreteBuilder：
 * 宝马车x5系列
 * 实现Builder的接口以构造和装配该产品的各个部件，
 * 定义并明确它所创建的表示，并提供一个检索产品的接口。
 * @author zhaojw_420
 *
 */
public class BMWX5Builder implements BMWBuilder {

	BMW bmw=new BMWX5();

	@Override
	public void buildEngine() {
        bmw.setEngine("创建BMWX5的发动机");
	}

	@Override
	public void buildConditioner() {
        bmw.setConditioner("创建BMWX5的空调");
	}

	@Override
	public void buildTyre() {
        bmw.setTyre("创建BMWX5的轮胎");
	}

	@Override
	public void buildChassis() {
		bmw.setChassis("创建BMWX5的底盘");
	}

	@Override
	public BMW buildBMW() {
		// TODO Auto-generated method stub
		return bmw;
	}

}
