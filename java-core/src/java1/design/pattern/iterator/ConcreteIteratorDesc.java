package java1.design.pattern.iterator;

/**
 * @Author zhaojw
 * @Date 2017/12/10 23:27
 */
public class ConcreteIteratorDesc extends  Iterator{

    private ConcreteAggregate aggregate;

    private int current=0;

    public ConcreteIteratorDesc(ConcreteAggregate aggregate){
        this.aggregate=aggregate;
        current=aggregate.count()-1;
    }

    @Override
    public Object firstItem() {
        return aggregate.get(aggregate.count()-1);
    }

    @Override
    public Object nextItem() {
        Object ret=null;
        current--;
        if (current>=0){
            ret=aggregate.get(current);
        }
        return ret;
    }

    @Override
    public boolean isDone() {
        return current<0?true:false;
    }

    @Override
    public Object currentItem() {
        return aggregate.get(current);
    }
}
