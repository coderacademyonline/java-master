package java1.design.pattern.adapter;

/**
 * @Author zhaojw
 * @Date 2017/12/10 18:35
 *
 * 适配器模式（Apapter）：将一个类的接口转换成客户希望的另外一个接口，Apapter模式是的原本由于接口不兼容而不能在一起的那些类可以一起工作
 * 适配器主要分为类适配模式和对象适配模式。类适配模式通过多重继承对一个接口和另一个接口进行匹配。java中单继承，不适用。
 *
 * 适用场景：使用一个已经存在的类，但如果他的接口，也就是他的方法和你的要求不服相同时，双方都不太容易修改时。
 * （若前期合理规划，不至于使用适配器模式，适配器模式是作为一个补救的方式）
 *
 *  适配器，抽象类或者接口，通过内部包装一个需要适配的类的对象把源接口转换为目标接口。
 */
public abstract class Player {

    protected String name;

    public Player(String name){
        this.name=name;
    }

    public abstract void attack();//进攻
    public abstract void defense();//防守
}
