package java.design.pattern.builder;

/**
 * 宝马车
 * 表示被构造的复杂对象。BMWBuilder创建该产品的内部表示并定义它的装配过程，
 * 包含定义组成部件的类，包括将这些部件装配成最终产品的接口。
 * @author zhaojw_420
 *
 */
public class BMW {

	private String engine;//发动机
	
	private String conditioner;//空调
	
	private String tyre;//轮胎
	
	private String chassis;//底盘

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getConditioner() {
		return conditioner;
	}

	public void setConditioner(String conditioner) {
		this.conditioner = conditioner;
	}

	public String getTyre() {
		return tyre;
	}

	public void setTyre(String tyre) {
		this.tyre = tyre;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
}
