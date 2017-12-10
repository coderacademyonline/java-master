package java1.design.pattern.iterator;

/**
 * @Author zhaojw
 * @Date 2017/12/10 23:11
 *
 * 迭代器模式（Iterator）：提供一中方法顺序访问一个聚合中各个元素，而不暴露该对对象的内部表示。
 *
 * 迭代抽象类（Iterator）：用于定义得到开始对象，得到下一个对象，判断是否到结尾、当前对象等抽象方法，统一接口。
 * 具体迭代器类：继承Iterator，实现开始、下一个、是否结尾、当前对象等方法。
 *
 * 适用场景：访问一个聚集对象，而且不管这些对象是什么都需要遍历的时候，或者对聚集有多种方式遍历时，你就应该考虑迭代器模式。
 *
 */
public abstract class Iterator {

    public abstract Object firstItem();
    public abstract Object nextItem();
    public abstract boolean isDone();
    public abstract Object currentItem();
}
