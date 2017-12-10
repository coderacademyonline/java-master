package java1.design.pattern.composite;

/**
 * @Author zhaojw
 * @Date 2017/12/10 22:03
 *
 * 本类叶节点
 *
 */
public class HRDeparment extends Company {

    public HRDeparment(String name){
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
        System.out.println(name+"员工招聘培训管理");
    }
}
