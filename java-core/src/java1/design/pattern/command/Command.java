package java1.design.pattern.command;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:42
 *
 * 命令模式：将一个请求封装成一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作
 *
 *  接收者（receiver）：知道如何实施与执行一个请求相关的操作，任何类都可能作为一个接受者
 *  Invoker：要求该命令执行这个请求
 *  command：用来声明执行操作的接口
 *  ConcreteCommand：讲一个接收者绑定一个动作，调用接收者相应的操作，以实现Execute
 *
 * 优点：1、他能较容易的设计一个命令队列
 *      2、在需要的情况下，可以较容易的将命令计入日志
 *      3、允许接受请求的一方决定是否要求否决请求
 *      4、可以容易的实现对请求的撤销和重做
 *      5、由于加进新的具体命令类不影响其他的类，因而新的具体命令类很容易。
 *      6、命令模式把请求的一个操作对象与知道怎么执行一个操作的对象分隔开。
 *
 * 敏捷开发原则：不要为代码添加猜测的，实际不需要的功能，如果不清楚一个系统是否需要命令模式，一般就不要着急去实现它，
 * 事实上，在需要的时候通过重构实现这个模式并不困难，只有在真正需要如撤销/恢复操作等功能时，把原来的代码重构为命令才有意义。
 *
 * 本类：Command
 *
 */
public abstract class Command {

    protected String name;

    protected  Barbecuer barbecuer;

    /**
     * 抽象命令类，只需要确认谁是接收者，来执行相关的操作
     * @param barbecuer
     */
    public Command(Barbecuer barbecuer,String name){
        this.barbecuer=barbecuer;
        this.name=name;
    }
    public abstract void executeCommand();

}
