package java1.design.pattern.proxy.staticproxy;

/**
 * @Author zhaojw
 * @Date 2017/12/9 20:56
 *
 * 代理
 *
 */
public class GiveProxy implements IGiveGift{

    private Pursuit pursuit;

    public GiveProxy(SchoolGirl girl){
        pursuit=new Pursuit(girl);
    }

    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
