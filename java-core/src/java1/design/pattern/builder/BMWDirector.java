package java1.design.pattern.builder;

/**
 * 角色Director：
 * Director：构造一个使用Builder接口的对象，指导构建过程。
 * @author zhaojw_420
 *
 */
public class BMWDirector {

	public BMW constructBMW(BMWBuilder builder){
		builder.buildEngine();
		builder.buildConditioner();
		builder.buildTyre();
		builder.buildChassis();
		return builder.buildBMW();
	}
}
