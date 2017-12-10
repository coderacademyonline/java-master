package java1.design.pattern.template;

/**
 * @Author zhaojw
 * @Date 2017/12/10 11:00
 */
public class TemplateClassClientTest {

    public static void main(String[] args){
        TemplateClass template=null;
        //实现具体子类A
        template=new ConcreteClassA();
        template.templateMethod();
        //实现具体子类B
        template=new ConcreteClassB();
        template.templateMethod();
    }
}
