package java1.design.pattern.singleton;

/**
 * 饿汉式单例类.在类初始化时，已经自行实例化   
 * @author zhaojw_420
 *
 */
public class HungrySington {

	private HungrySington(){};
	
	private final static HungrySington sington=new HungrySington();
	
	public static HungrySington getInstance(){
		return sington;
	}
}
