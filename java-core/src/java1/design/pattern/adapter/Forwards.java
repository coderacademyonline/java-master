package java1.design.pattern.adapter;

/**
 * @Author zhaojw
 * @Date 2017/12/10 18:43
 */
public class Forwards extends Player {

    public Forwards(String name){
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("前锋"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("前锋"+name+"防守");
    }
}
