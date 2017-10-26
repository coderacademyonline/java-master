package java.design.pattern.proxy;

/**
 * 静态代理类，与具体类一同实现统一接口，保存着代理接口，用于操作具体类
 * @author Administrator
 *
 */
public class StaticProxyUserDao implements IStaticUserDao {

	private StaticUserDao staticUserDao;
	
	public StaticProxyUserDao(StaticUserDao staticUserDao) {
		this.staticUserDao=staticUserDao;
	}
	
	@Override
	public void save() {
        System.out.println("代理类执行开始。。。。。");
        staticUserDao.save();
        System.out.println("代理类执行结束。。。。。");
	}

}
