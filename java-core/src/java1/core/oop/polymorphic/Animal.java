package java1.core.oop.polymorphic;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/22 11:08
 */
public class Animal {

    public void eat(){
        System.out.println("Animal eating....");
    }


    public void run(){
        System.out.println("我会跑");
    }

    public void eat(Dog dog){
        System.out.println("dog eating");
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat(new Dog());
        animal.run();
    }
}

class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("cat eating");
    }
}

class Dog extends Animal{
    @Override
    public void eat(Dog dog){
        System.out.println("够改不了吃屎");
    }

    public void run(String str){
        System.out.println("跑到哪里");
    }
}
