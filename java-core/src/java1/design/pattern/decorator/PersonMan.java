package java1.design.pattern.decorator;

/**
 * @Author zhaojw
 * @Date 2017/12/9 18:52
 */
public class PersonMan implements Person {

    private String name;

    public PersonMan(String name){
        this.name=name;
    }

    @Override
    public void show() {
        System.out.println("开始装饰"+name);
    }
}
