package java1.design.pattern.singleton;

/**
 * 饿汉模式
 * @author zhaojw_420
 *
 */
public class LazySington {

	private LazySington(){
		
	};
	
	private static LazySington sington=null;
	
	public static LazySington getInstance(){
		if(sington==null){
			sington=new LazySington();
		}
		return sington;
	}
}
