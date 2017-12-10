package java1.design.pattern.proxy.staticproxy;

/**
 * @Author zhaojw
 * @Date 2017/12/9 20:49
 *
 * 追求者
 *
 */
public class Pursuit implements  IGiveGift{

    private SchoolGirl girl;

    public Pursuit(SchoolGirl girl){
        this.girl=girl;
    }

    @Override
    public void giveDolls() {
        System.out.println(girl.getName()+"送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(girl.getName()+"送你花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(girl.getName()+"送你巧克力");
    }
}
