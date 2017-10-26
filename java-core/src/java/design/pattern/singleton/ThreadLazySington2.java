package java.design.pattern.singleton;

/**
 * 双重检查锁定
 * @author zhaojw_420
 *
 */
public class ThreadLazySington2 {

	private ThreadLazySington2(){};
	
	private static ThreadLazySington2 sington=null;
	
	public static ThreadLazySington2 getInstance(){
			synchronized(ThreadLazySington2.class){
				if(sington==null){
					sington=new ThreadLazySington2();
				}
		}
			return sington;
	}
}
