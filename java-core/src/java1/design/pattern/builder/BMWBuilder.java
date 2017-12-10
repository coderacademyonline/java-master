package java1.design.pattern.builder;
/**
 * 为创建一个产品对象的各个部件指定抽象接口。
 * @author zhaojw_420
 *
 * 建造者模式：将一个复杂对象的构建与他的表示分离，使得同样的构建过程可以创建不同的表示。
 * 适用场景：主要用于创建一些复杂的对象，这些对象内部构建间的建造顺序通常是稳定的，但对象内部的构建通常面临着复杂的变化
 * 好处：使得建造代码与表示代码分离，由于建造者隐藏了该产品是如何组装的，所以需要改变一个产品的内部表示，只需要在定义以一个具体的建造者就可以了。
 *
 *
 */
public interface BMWBuilder {

	void buildEngine();//创建发动机
	
	void buildConditioner();//创建空调
	
	void buildTyre();//创建轮胎
	
	void buildChassis();//创建底盘
	
	BMW buildBMW();//创建宝马车
}
