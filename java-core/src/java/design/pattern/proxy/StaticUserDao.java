package java.design.pattern.proxy;

/**
 * 具体实现类
 * @author Administrator
 *
 */
public class StaticUserDao implements IStaticUserDao {

	@Override
	public void save() {
       System.out.println("具体实现类》》已经保存数据。。。。");
	}

}
