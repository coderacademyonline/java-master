package java1.design.pattern.command;

import javafx.scene.SubScene;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:50
 *
 * 本类：receiver  知道如何实施与执行一个请求相关的操作，任何类都可能作为一个接受者
 *
 */
public class Barbecuer {

    public void bakeMutton(String name){
        System.out.println(name);
    }

    public void bakeChickenWing(String name){
        System.out.println(name);
    }
}
