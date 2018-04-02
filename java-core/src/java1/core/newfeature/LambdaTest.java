package java1.core.newfeature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Java8新特性---lambda表达式
 *
 * lambda表达式定义为一种 简洁、可传递的匿名函数，首先我们需要明确lambda表达式本质上是一个函数，虽然它不属于某个特定的类，
 * 但具备参数列表、函数主体、返回类型，以及能够抛出异常；其次它是匿名的，lambda表达式没有具体的函数名称；
 * lambda表达式可以像参数一样进行传递，从而极大的简化代码的编写。
 *
 * 格式：
 * 格式一： 参数列表 -> 表达式
 * 格式二： 参数列表 -> {表达式集合}
 *
 * @author zhaojw
 * @version 1.0
 * @date 2018/4/1 14:42
 */
public class LambdaTest {

    public static void main(String[] args){
        List<Apple> apples = new ArrayList<Apple>(){
            {
                add(new Apple(1,Color.RED,120,"北京"));
                add(new Apple(2,Color.BLACK,150,"上海"));
                add(new Apple(3,Color.GREEN,80,"山东"));
                add(new Apple(4,Color.RED,90,"浙江"));
                add(new Apple(5,Color.WHITE,130,"河北"));
                add(new Apple(6,Color.BLUE,150,"河南"));
                add(new Apple(7,Color.RED,97,"湖南"));
                add(new Apple(8,Color.RED,100,"贵州"));
                add(new Apple(8,Color.RED,100,""));
            }
        };

       /// LambdaTest.filterAppleTest(apples);

       ///  LambdaTest.predicateTest(apples);

        LambdaTest.functionTest(apples);
    }

    /**
     * 将行为 参数化 ，让函数仅保留模板代码，而把筛选条件抽离出来当做参数传递进来
     *
     * 通过一个过滤接口实现
     *
     * @param apples
     * @param filter
     * @return
     */
    private static List<Apple> filterApplesByAppleFilter(List<Apple> apples,AppleFilter filter){
        List<Apple> filterApples = new ArrayList<>();

        for (final Apple apple:apples) {
            if (filter.accept(apple)){
                filterApples.add(apple);
            }
        }

        return filterApples;
    }


    private static void filterAppleTest(List<Apple> apples){
        List<Apple> filterApples = filterApplesByAppleFilter(apples,
                // 设置筛选条件，传入过滤器
                (Apple apple) -> Color.RED.equals(apple.getColor()) && apple.getWeight() >= 100);

        // 改造
        List<Apple> filterApples1 = filterApplesByAppleFilter(apples,
                apple -> Color.RED.equals(apple.getColor()) && apple.getWeight() >= 100);


        int weight = 100;
        // 使用局部变量，默认局部变量是final修饰
        List<Apple> filterApples2 = filterApplesByAppleFilter(apples,
                apple -> Color.RED.equals(apple.getColor()) && apple.getWeight() >= weight);


        filterApples.forEach(filterApple ->{
            System.out.println(filterApple.toString());
        });
    }

    /**
     * 按照指定的条件对集合元素进行过滤
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    private static <T> List<T> predicateFilter(List<T> list, Predicate<T> predicate){
        List<T> filterList = new ArrayList<T>();

        for(final T t:list){
            if (predicate.test(t)){
                filterList.add(t);
            }
        }

        return filterList;
    }

    /**
     * 接口过滤苹果集合中的产地空字符串：
     * @param apples
     */
    private static void predicateTest(List<Apple> apples){
        List<Apple> filterApples = predicateFilter(apples,
                (Apple apple) -> apple.getOrigin()!=null && !"".equals(apple.getOrigin()));

        filterApples.forEach(filterApple ->{
            System.out.println(filterApple.toString());
        });
    }

    /**
     * Funcation执行转换操作，输入是类型T的数据，返回R类型的数据
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    private static <T,R> List<R> functionFilter(List<T> list, Function<T,R> function){
        List<R> filterList = new ArrayList<>();

        for(final T t:list){
            filterList.add(function.apply(t));
        }

        return filterList;
    }

    /**
     * 返回集合中的苹果产地
     * @param apples
     */
    private static void functionTest(List<Apple> apples){
        List<String> appleOrgins = functionFilter(apples,
                (Apple apple) -> apple.getOrigin());

        appleOrgins.forEach(appleOrgin -> {
            System.out.println(appleOrgin);
        });

    }
}

class Apple{
    /** 编号 */
    private long id;

    /** 颜色 */
    private Color color;

    /** 重量 */
    private float weight;

    /** 产地 */
    private String origin;

    public Apple(long id, Color color, float weight, String origin) {
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.origin = origin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", color=" + color +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }
}