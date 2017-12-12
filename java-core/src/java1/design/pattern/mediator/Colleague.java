package java1.design.pattern.mediator;

/**
 * @Author zhaojw
 * @Date 2017/12/12 22:47
 */
public abstract class Colleague {

    public Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator=mediator;
    }

}
