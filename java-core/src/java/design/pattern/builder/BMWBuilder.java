package java.design.pattern.builder;
/**
 * 为创建一个产品对象的各个部件指定抽象接口。
 * @author zhaojw_420
 *
 */
public interface BMWBuilder {

	void buildEngine();//创建发动机
	
	void buildConditioner();//创建空调
	
	void buildTyre();//创建轮胎
	
	void buildChassis();//创建底盘
	
	BMW buildBMW();//创建宝马车
}
