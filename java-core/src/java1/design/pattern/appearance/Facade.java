package java1.design.pattern.appearance;

/**
 * @Author zhaojw
 * @Date 2017/12/10 12:39
 *
 * 外观者模式：为系统中一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口是的这一子系统更加容易使用。
 * 使用场景：1、首先在设计初期阶段，应该有意识的将被不同的两个层分离，例如mvc的三层架构，层与层之间建立外观facade
 * 2、子系统因为不断的重构演化而变得越来越复杂，增加外观类，可以提供一个简单的接口，检查他们之间的依赖，
 * 3、维护一个遗留的大型系统时，可能这个系统共已经非常难以维护和扩展了，但是新的需求系统又依赖与它。可以为新系统开发一个外观类，来提供设计粗糙或高度复杂的
 *    遗留代码的比较清晰的简单的接口，让新系统与Facade对象交互，Facade与遗留代码交互所有复杂的工作
 *
 * 外观类：它需要了解所有的子系统的方法或属性，进行组合，以备外界调用
 */
public class Facade {
    SubSystemOne subSystemOne=null;
    SubSystemTwo subSystemTwo=null;
    SubSystemThree subSystemThree=null;
    SubSystemFour subSystemFour=null;

    public Facade(){
        subSystemOne=new SubSystemOne();
        subSystemTwo=new SubSystemTwo();
        subSystemThree=new SubSystemThree();
        subSystemFour=new SubSystemFour();
    }

    public void methodA(){
        System.out.println("-------------方法组1------------");
        subSystemOne.methodOne();
        subSystemThree.methodThree();
        subSystemFour.methodFour();
    }

    public void methodB(){
        System.out.println("-------------方法组2------------");
        subSystemThree.methodThree();
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
    }
}
