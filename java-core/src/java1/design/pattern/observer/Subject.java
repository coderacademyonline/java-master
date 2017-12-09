package java1.design.pattern.observer;

/**
 * 抽象观察者
 * @author zhaojw
 *
 */
public interface Subject {

	/**
     * 增加观察者
     * @param observer
     */
    public void attach(Observer observer);
    /**
     * 删除观察者
     * @param observer
     */
    public void detach(Observer observer);
    /**
     * 通知观察者更新消息，激活
     */
    public void notify(String message);
}
