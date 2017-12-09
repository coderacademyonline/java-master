package java1.design.pattern.builder;

/**
 * 角色ConcreteBuilder
 * 宝马x6系列
 * @author zhaojw_420
 *
 */
public class BMWX6Builder implements BMWBuilder {
	
	BMW bmw=new BMWX6();

	@Override
	public void buildEngine() {
        bmw.setEngine("创建BMWX6的发动机");
	}

	@Override
	public void buildConditioner() {
        bmw.setConditioner("创建BMWX6的空调");
	}

	@Override
	public void buildTyre() {
        bmw.setTyre("创建BMWX6的轮胎");
	}

	@Override
	public void buildChassis() {
		bmw.setChassis("创建BMWX6的底盘");
	}

	@Override
	public BMW buildBMW() {
		// TODO Auto-generated method stub
		return bmw;
	}
}
