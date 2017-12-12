package java1.design.pattern.mediator;

/**
 * @Author zhaojw
 * @Date 2017/12/12 22:49
 */
public class ConcreteMediator extends Mediator {

    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    /**
     * 根据对象判断，通知对象
     * @param message
     * @param colleague
     */
    @Override
    public void send(String message, Colleague colleague) {
        if (colleague==colleague1){
            colleague2.notifyMessage(message);
        }else {
            colleague1.notifyMessage(message);
        }
    }
}
