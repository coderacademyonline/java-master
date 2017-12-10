package java1.design.pattern.iterator;

/**
 * @Author zhaojw
 * @Date 2017/12/10 23:18
 */
public class ConcreteIterator extends Iterator {

    private ConcreteAggregate aggregate;
    private int current=0;

    public ConcreteIterator(ConcreteAggregate aggregate){
        this.aggregate=aggregate;
    }

    @Override
    public Object firstItem() {
        return aggregate.get(0);
    }

    @Override
    public Object nextItem() {
        Object ret=null;
        current++;
        if (current<aggregate.count()){
            ret=aggregate.get(current);
        }
        return ret;
    }

    @Override
    public boolean isDone() {
        return current>=aggregate.count()?true:false;
    }

    @Override
    public Object currentItem() {
        return aggregate.get(current);
    }
}
