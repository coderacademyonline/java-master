package java1.design.pattern.observer.entrust;

import java1.design.pattern.observer.Subject;

/**
 * @Author zhaojw
 * @Date 2017/12/10 15:35
 */
public class WXUser2 {
    private String name;
    private Subject subject;

    public WXUser2(Subject subject,String name){
        this.subject=subject;
        this.name=name;
    }
    public void getMessage2(){

    }
}
