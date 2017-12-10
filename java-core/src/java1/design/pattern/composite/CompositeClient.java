package java1.design.pattern.composite;

/**
 * @Author zhaojw
 * @Date 2017/12/10 22:07
 */
public class CompositeClient {

    public static void main(String[] args){
        ConcreteCompany root=new ConcreteCompany("北京总公司");
        root.add(new HRDeparment("总公司人力资源"));
        root.add(new FInanceDepatment("总公司财务部"));

        ConcreteCompany comp=new ConcreteCompany("上海华东分公司");
        comp.add(new HRDeparment("华东分公司人力资源部"));
        comp.add(new FInanceDepatment("华东分公司财务部"));
        root.add(comp);

        ConcreteCompany comp1=new ConcreteCompany("南京办事处");
        comp1.add(new HRDeparment("南京办事处人力资源部"));
        comp1.add(new FInanceDepatment("南京办事处财务部"));
        root.add(comp1);

        ConcreteCompany comp2=new ConcreteCompany("杭州办事处");
        comp2.add(new HRDeparment("杭州办事处人力资源部"));
        comp2.add(new FInanceDepatment("杭州办事处财务部"));
        root.add(comp2);

        root.display(1);
        root.lineOfDuty();
    }

}
