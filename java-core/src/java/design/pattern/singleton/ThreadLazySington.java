package java.design.pattern.singleton;

/**
 * 在getInstance上加同步
 * @author zhaojw_420
 *
 */
public class ThreadLazySington {

	private ThreadLazySington(){};
	
	private static ThreadLazySington sington=null;
	
	public static synchronized ThreadLazySington getInstance(){
		if(sington==null){
			sington=new ThreadLazySington();
		}
		return sington;
	}
}
