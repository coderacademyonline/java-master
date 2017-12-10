package java1.design.pattern.adapter;

/**
 * @Author zhaojw
 * @Date 2017/12/10 18:54
 */
public class AdapterClient {

    public static void main(String[] args){
        Player player1=new Forwards("霸体");
        player1.attack();
        Player player2=new Center("战体");
        player2.attack();
        Player player=new Translator("神体");
        player.attack();
        player.defense();
    }
}
