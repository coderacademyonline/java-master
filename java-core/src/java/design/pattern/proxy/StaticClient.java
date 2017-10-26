package java.design.pattern.proxy;

public class StaticClient {

	public static void main(String[] args) {
		//目标对象
		StaticUserDao staticUserDao=new StaticUserDao();
		//将目标对象传递给代理，建立代理关系
		StaticProxyUserDao proxyUserDao=new StaticProxyUserDao(staticUserDao);
		
		proxyUserDao.save();
	}
}
