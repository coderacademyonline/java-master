package java1.design.pattern.adapter;

/**
 * @Author zhaojw
 * @Date 2017/12/10 18:47
 */
public class Center extends Player {

    public Center(String name){
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("中卫"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("中卫"+name+"防守");
    }
}
