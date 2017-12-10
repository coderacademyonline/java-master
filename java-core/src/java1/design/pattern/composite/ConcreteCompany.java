package java1.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaojw
 * @Date 2017/12/10 21:59
 *
 * 本类：Composite 子节点
 *
 */
public class ConcreteCompany extends Company {

    private List<Company> companies=new ArrayList<>();

    public ConcreteCompany(String name){
        super(name);
    }

    @Override
    public void add(Company company) {
        companies.add(company);
    }

    @Override
    public void remove(Company company) {
        companies.remove(company);
    }

    @Override
    public void display(int depth) {
        for(int i=0;i<depth;i++){
            System.out.print("-");
        }
        System.out.println(name);
        for (Company company:companies) {
           company.display(depth+2);
        }
    }

    @Override
    public void lineOfDuty() {
        for (Company compay:companies) {
            compay.lineOfDuty();
        }
    }
}
