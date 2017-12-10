package java1.design.pattern.adapter;

/**
 * @Author zhaojw
 * @Date 2017/12/10 18:49
 *
 * 需要适配的类
 *
 */
public class ForeignCenter {

    //不使用构造方法来构造，区分已有的类
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 与已有的类的方法不一样
     */
    public void 进攻(){
        System.out.println("外籍中锋"+name+"进攻");
    }

    public void 防守(){
        System.out.println("外籍中锋"+name+"防守");
    }
}
