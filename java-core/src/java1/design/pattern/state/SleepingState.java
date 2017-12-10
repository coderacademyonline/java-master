package java1.design.pattern.state;

/**
 * @Author zhaojw
 * @Date 2017/12/10 17:39
 */
public class SleepingState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println("当前时间"+work.getHour()+"点，通宵加班");
    }
}
