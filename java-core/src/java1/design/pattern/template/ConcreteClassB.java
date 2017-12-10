package java1.design.pattern.template;

/**
 * @Author zhaojw
 * @Date 2017/12/10 10:59
 */
public class ConcreteClassB extends TemplateClass {
    @Override
    public void primitveOpereation1() {
        System.out.println("具体子类B实现方法1");
    }

    @Override
    public void primitveOpereation2() {
        System.out.println("具体子类B实现方法2");
    }
}
