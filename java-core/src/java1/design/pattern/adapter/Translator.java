package java1.design.pattern.adapter;

/**
 * @Author zhaojw
 * @Date 2017/12/10 18:51
 */
public class Translator extends Player {

    /**
     * 声明并实例化一个内部 需要适配的类，表明适配器与需要适配的类有关联
     */
    private ForeignCenter foreignCenter=new ForeignCenter();

    public Translator(String name){
        super(name);
        foreignCenter.setName(name);
    }

    @Override
    public void attack() {
        foreignCenter.进攻();
    }

    @Override
    public void defense() {
        foreignCenter.防守();
    }
}
