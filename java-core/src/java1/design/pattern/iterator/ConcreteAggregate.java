package java1.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaojw
 * @Date 2017/12/10 23:19
 */
public class ConcreteAggregate extends Aggregate {

    private List<Object> items=new ArrayList<>();


    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
    public int count(){
        return items.size();
    }
    public Object get(int index){
        return items.get(index);
    }

    public void set(Object object){
        items.add(object);
    }
}
