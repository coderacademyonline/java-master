package java1.design.pattern.composite;

import java1.design.pattern.appearance.Facade;

/**
 * @Author zhaojw
 * @Date 2017/12/10 22:05
 *
 * 本类叶节点
 *
 */
public class FInanceDepatment extends Company {

    public FInanceDepatment(String name){
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        for(int i=0;i<depth;i++){
            System.out.print("-");
        }
        System.out.println(name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(name+"公司财务收支管理");
    }
}
