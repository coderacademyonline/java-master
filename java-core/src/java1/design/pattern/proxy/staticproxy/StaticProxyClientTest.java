package java1.design.pattern.proxy.staticproxy;

/**
 * @Author zhaojw
 * @Date 2017/12/9 21:01
 */
public class StaticProxyClientTest {

    public static void main(String[] args){
        SchoolGirl girl=new SchoolGirl("zr");

        GiveProxy proxy=new GiveProxy(girl);
        proxy.giveChocolate();
        proxy.giveDolls();
        proxy.giveFlowers();
    }
}
