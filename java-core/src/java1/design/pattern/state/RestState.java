package java1.design.pattern.state;

/**
 * @Author zhaojw
 * @Date 2017/12/10 17:38
 */
public class RestState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println("当前时间"+work.getHour()+"点下班回家了");
    }
}
