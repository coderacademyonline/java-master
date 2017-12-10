package java1.design.pattern.state;

/**
 * @Author zhaojw
 * @Date 2017/12/10 17:36
 */
public class EveningState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinish()){
            //如果完成，则转入下班状态
            work.setState(new RestState());
            work.writeProgram();
        }else {
            if (work.getHour()<21){
                System.out.println("当前时间"+work.getHour()+"点加班哦，疲惫至极");
            }else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
