package java1.design.pattern.iterator;

/**
 * @Author zhaojw
 * @Date 2017/12/10 23:30
 */
public class IteratorClient {

    public static void main(String[] args){
        ConcreteAggregate aggregate=new ConcreteAggregate();
        aggregate.set("大鸟");
        aggregate.set("小菜");
        aggregate.set("行李");
        aggregate.set("老外");
        aggregate.set("公交内部员工");
        aggregate.set("小偷");

       // Iterator iterator=new ConcreteIterator(aggregate);

        Iterator iterator=new ConcreteIteratorDesc(aggregate);

        Object item=iterator.firstItem();
        while (!iterator.isDone()){
            System.out.println(String.valueOf(iterator.currentItem())+"请买票！");
            iterator.nextItem();
        }
    }
}
