package java1.design.pattern.decorator;

/**
 * @Author zhaojw
 * @Date 2017/12/9 18:45
 *
 * 跟io很相似
 *
 */
public class ClientTest {
    public static void main(String[] args){
        Person person=new PersonMan("zhaojw");

        TShirts tShirts=new TShirts();
        BigTrouser bigTrouser=new BigTrouser();
        Sneakers sneakers=new Sneakers();
        tShirts.setPerson(person);
        bigTrouser.setPerson(tShirts);
        sneakers.setPerson(bigTrouser);

        sneakers.show();
    }
}
