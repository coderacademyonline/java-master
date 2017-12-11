package java1.design.pattern.bridge;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:12
 *
 * 桥接模式：将抽象部分与他的实现部分分离，使他们可以独立的变化。
 *
 * 注意：抽象与实现分离，并不是说让抽象类与派生类分离，以为这没有任何意义，实现指的是抽象类和他的派生类用来实现自己的对象。
 *
 * 适用场景：实现系统可能有很多角色分类，每一种分类都有可能变化，那么就把这种多角度分离出来让他们独立变化，减少他们之间的耦合。
 *
 * 本类：Implementor
 *
 */
public abstract class HandsetSoft {
    public abstract void run();
}
