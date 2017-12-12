package java1.design.pattern.mediator;

/**
 * @Author zhaojw
 * @Date 2017/12/12 22:36
 *
 * 中介者模式：用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显示的相互引用，从而使其耦合松散名而且可以独立的改变他们之间的交互
 *
 * 抽象中介者（Mediator）：抽象中介者。定义了同事对象到中介者对象的接口。
 * 具体中介者对象（ConcreteMediator）：具体中介者对象，实现抽象类方法，他需要知道所有具体同事类，并从具体同事接受消息，向具体同事对象发出命令
 * 抽象同事类（Colleague）：抽象同事类
 * 具体同事类（ConcreteColleague）：具体同事类，每个具体同事只知道自己的行为，而不了解其他同事类的情况，但他们却都认识中介者对象。
 *
 * 优点：1、Mediator的出现减少了各个Colleague的耦合，使得可以独立的改变和复用各个Colleague类和Mediator，。
 *      2、由于把对象任何协作进行了抽象，将中介作为一个独立的概念并将其封装在一个对象中，这样关注的对象就从对象各自本身的行为转移到他们之间的交互上来，也就是站在一个更宏观的角度去看待系统。
 *
 * 缺点：由于ConcreteMediator控制了集中化，于是就把交互复杂性变为了中介者的复杂性，这就使得中介者变得比任何一个ConcreteColleague都复杂。
 *
 * 适用场景：一般适用于一组对象以定义良好但是复杂的方式进行通信的场合，以及想定制一个分布在多个类中的行为，而又不想生成太多的子类的场合。
 */
public abstract class Mediator {
    public abstract void send(String message,Colleague colleague);
}
