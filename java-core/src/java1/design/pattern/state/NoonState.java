package java1.design.pattern.state;

/**
 * @Author zhaojw
 * @Date 2017/12/10 17:27
 */
public class NoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour()<13){
            System.out.println("当前时间"+work.getHour()+"点 饿了，午饭，犯困，上午工作，午休");
        }else {
            work.setState(new AfternoonState());//转下午工作状态
            work.writeProgram();
        }
    }
}
