package java1.design.pattern.state;

/**
 * @Author zhaojw
 * @Date 2017/12/10 17:28
 */
public class AfternoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour()<17){
            System.out.println("当前时间"+work.getHour()+"点，下午状态还不错，继续努力");
        }else{
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
