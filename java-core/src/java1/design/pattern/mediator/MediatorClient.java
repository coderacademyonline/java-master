package java1.design.pattern.mediator;

/**
 * @Author zhaojw
 * @Date 2017/12/12 22:54
 */
public class MediatorClient {

    public static void main(String[] args){
        ConcreteMediator mediator=new ConcreteMediator();

        ConcreteColleague1 colleague1=new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2=new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("你吃饭了么？");
        colleague2.send("没有呢，你打算请客么？");
    }
}
