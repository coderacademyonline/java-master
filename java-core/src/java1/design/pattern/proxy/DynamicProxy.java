package java1.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类，通过利用java.lang.reflect.Proxy类和java.lang.reflect.InvocationHandler接口定义代理类的实现。
 * @author Administrator
 *
 */
public class DynamicProxy implements InvocationHandler {

	/**
	 * 具体实现类
	 */
	private Object target;
	
	public DynamicProxy(Object target) {
		this.target=target;
	}
	
	@Override
	public Object invoke(Object obj, Method method, Object[] objects) throws Throwable {
		System.out.println("动态代理类开始执行。。。。。。");
		Object result=method.invoke(target, objects);
		return result;
	}

	public Object createProxy(){
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		Class<?>[] clazz=target.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, clazz, this);
	}
}
