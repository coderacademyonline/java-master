package java1.design.pattern.appearance;

/**
 * @Author zhaojw
 * @Date 2017/12/10 12:49
 *
 * 客户端类：由于Facade类的存在，客户端根本不知道四个子系统类的存在
 *
 */
public class AppearanceClientTest {

   public static void main(String[] args){
       Facade facade=new Facade();
       facade.methodA();
       facade.methodB();
   }
}
