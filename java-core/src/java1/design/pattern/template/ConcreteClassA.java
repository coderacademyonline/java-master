package java1.design.pattern.template;

/**
 * @Author zhaojw
 * @Date 2017/12/10 10:56
 *
 * 具体子类，继承抽象类，实现父类的所定义的一个或多个抽象方法。每一个抽象类都可以有任意多个具体的子类（ConcreteClassA）与之相对应
 * 而每一个具体的子类（ConcreteClassA）都可以给出这些抽象方法的不同实现，从而是顶级逻辑的实现各不相同
 *
 */
public class ConcreteClassA extends TemplateClass {
    @Override
    public void primitveOpereation1() {
        System.out.println("具体类A实现方法1");
    }

    @Override
    public void primitveOpereation2() {
        System.out.println("具体类A实现方法2");
    }
}
