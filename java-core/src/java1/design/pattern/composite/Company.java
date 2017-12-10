package java1.design.pattern.composite;

/**
 * @Author zhaojw
 * @Date 2017/12/10 21:49
 *
 * 组合模式：将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * 组成（Component）：为组合中的对象声明接口，在适当情况下，实现所有类共有接口的默认行为。声明接口用于访问和管理Component的子部件。
 * 叶节点（leaf）：组合中表示叶节点对象，叶节点没有子节点
 * 子节点（Composite）：定义为有枝节点行为，用来存储子部件，在Component接口中实现与子部件相关的操作，比如增/删
 *
 * 透明模式：在Component中声明所有用来管理子对象的方法，其中包括add，remove等，这样实现Component接口的所有子类都具备了add和remove，
 *          这样做的好处就是叶节点和枝节点对于外界没有区别，他们具备完全一致的行为接口，但问题也很明显，因为leaf类本身不具备add，reomve的方法的功能，他的实现是没有意义的。
 *
 * 安全模式：Component中不声明add和remove方法，那么子类的leaf也就不需要去实现它，而是在Composite声明用来管理子类对象的方法
 *          不过不够透明，所以树叶和树枝类将具有不同的接口，客户端的调用需要做出相应的判断，带来了不变
 *
 * 适用场景：需求中是体现部分和整体层次的结构时，希望用户可以忽略组合对象和单个对象的不同，统一的使用组合结构中的所有对象时，就应该考虑组合模式了。
 *
 * 好处：基本对象可以被组合成更复杂的组合对象，而这个组合对象又可以被组合，这样不断的递归下去。客户代码中，任何用到基本对象的地方都可以使用组合对象。
 *       对于用户来说不用关心到底处理的是一个叶节点还是一个组合组件，也就用不着为定义组合而写一些选择判断语句了。
 *       组合模式可以让用户一致的使用组合结构和单个对象
 *
 * 本类为：Component
 */
public abstract class Company {
    protected  String name;
    public Company(String name){
        this.name=name;
    }

    public abstract void add(Company company);
    public abstract void remove(Company company);
    public abstract void display(int depth);
    public abstract void lineOfDuty();//履行职责
}
