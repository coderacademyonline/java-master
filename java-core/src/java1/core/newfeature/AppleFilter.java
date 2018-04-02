package java1.core.newfeature;

/**
 * 苹果过滤条件，函数式接口
 *
 * @author zhaojw
 * @version 1.0
 * @date 2018/4/1 21:10
 */
@FunctionalInterface
public interface AppleFilter {

    /**
     * 筛选条件抽象化
     * @param apple
     * @return
     */
    boolean accept(Apple apple);

}
