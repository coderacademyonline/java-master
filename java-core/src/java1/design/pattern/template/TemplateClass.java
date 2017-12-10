package java1.design.pattern.template;

/**
 * @Author zhaojw
 * @Date 2017/12/10 10:50
 *
 * 模版方法模式：
 * 抽象类，即抽象模版，定义并实现了一个模版方法，这个模版方法一般是一个具体方法，他给出了一个顶级逻辑的骨架
 * 而逻辑的组成步骤在相应的抽象操作中，推迟到子类中去实现
 * 顶级逻辑中也有可能调用一些具体方法
 *
 * 模版方式特点：
 * 1、模版方式通过把不变行为搬移到超类中去除子类中的重复代码来体现其优势
 * 2、模版方式方法提供了一个很好的代码复用平台
 * 使用场景：
 * 当不变的行为和可变的行为在方法的子类中实现中混合在一起的时候，不变的行为就会在子类中重复出现，
 * 我们就可以通过模版方法模式把这些行为搬移到单一的地方，这样就摆脱重复的不变行为的纠缠。
 *
 */
public abstract class TemplateClass {

    public abstract void primitveOpereation1();//一些抽象行为，在子类中具体实现
    public abstract void primitveOpereation2();

    public void templateMethod(){
        primitveOpereation1();
        primitveOpereation2();
        System.out.println("顶级逻辑骨架");
    }
}
