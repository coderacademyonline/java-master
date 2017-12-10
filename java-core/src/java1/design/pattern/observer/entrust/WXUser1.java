package java1.design.pattern.observer.entrust;

import java1.design.pattern.observer.Subject;

/**
 * @Author zhaojw
 * @Date 2017/12/10 15:27
 *
 * 由于观察者模式有瑕疵，由于抽象主题依赖抽象观察者，若没有抽象观察者，则观察者模式就不完不成功能。
 * 使用时间委托机制优化。
 * 事件委托：一种引用方法的类型，一旦为委托分配了方法，委托将与该方法具有完全相同的行为，委托方法的使用可以像其他任何方法一样，具有参数和返回值。
 *          委托可以看作是对函数的抽象，是函数的类，委托的实例将代表一个具体的函数。一个委托可以搭载多个方法，所有方法被依次唤起。并且它可以使
 *          搭载的方法并不需要使用同一个类。
 *
 */
public class WXUser1 {

    private String name;
    private Subject subject;

    public WXUser1(Subject subject,String name){
        this.subject=subject;
        this.name=name;
    }
    public void getMessage1(){

    }
}
