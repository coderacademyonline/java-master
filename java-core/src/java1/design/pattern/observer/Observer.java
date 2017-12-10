package java1.design.pattern.observer;

/**
 * 抽象观察者：为所有具体观察者定义一个接口，在得到主题的通知时更新自己，
 */
public interface Observer {

	/**
	 * 更新方法
	 * @param message
	 */
	public void update(String message);
}
