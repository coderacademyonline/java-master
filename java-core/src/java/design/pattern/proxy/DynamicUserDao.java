package java.design.pattern.proxy;

/**
 * 具体实现类
 * @author Administrator
 *
 */
public class DynamicUserDao implements IDynamicUserDao {

	@Override
	public void save() {
		System.out.println("具体实现类执行》》动态代理");

	}

}
