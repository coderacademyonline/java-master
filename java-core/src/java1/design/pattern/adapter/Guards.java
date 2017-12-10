package java1.design.pattern.adapter;

/**
 * @Author zhaojw
 * @Date 2017/12/10 18:48
 */
public class Guards extends Player {

    public Guards(String name){
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("后卫"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("后卫"+name+"防守");
    }
}
