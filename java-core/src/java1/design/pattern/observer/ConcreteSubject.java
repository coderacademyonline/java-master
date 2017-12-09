package java1.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者
 * @author zhaojw
 *
 */
public class ConcreteSubject implements Subject {

	//储存订阅公众号的微信用户
    private List<Observer> weixinUserlist = new ArrayList<Observer>();
	
	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		weixinUserlist.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		weixinUserlist.remove(observer);
	}

	@Override
	public void notify(String message) {
		// TODO Auto-generated method stub
		 for (Observer observer : weixinUserlist) {
	            observer.update(message);
	        }
	}

}
