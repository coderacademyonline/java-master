package java1.design.pattern.chainofresponsibility;

/**
 * @Author zhaojw
 * @Date 2017/12/12 21:51
 *
 * 职责链模式：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止。
 * 当客户提交一个请求时，请求是沿链传递直至有一个ConcreteHandler对象负责处理他。
 * 优点：接收者和发送者都没有对方的明确消息，且链中的对象自己也并不知道链的结构，结果是职责链可简化对象的相互连接，他们仅需保持一个指向其后继者的引用，而不需要保持他所有的候选接受者的引用。
 *
 * 注意：一个请求极有可能到了链的末端都得不到处理，或者因为没有正确配置而到不到处理。
 *
 */
public abstract class Manager {

    protected String name;
    //管理者的上级
    protected Manager superior;

    public Manager(String name){
        this.name= name;
    }
    //设置管理这的上级
    public void setSuperior(Manager superior) {
        this.superior = superior;
    }
    //申请请求
    public abstract void resquestApplications(Request request);
}
