package java1.design.pattern.proxy;

/**
 * 动态代理测试
 * @author Administrator
 *
 */
public class DynameicProxyClient {

	public static void main(String[] args) {
		IDynamicUserDao dynamicUserDao=new DynamicUserDao();
		
		//为目标类创建代理对象
		DynamicProxy dynamicProxy=new DynamicProxy(dynamicUserDao);
		
		IDynamicUserDao userDao=(IDynamicUserDao) dynamicProxy.createProxy();
		
		userDao.save();
	}
}
