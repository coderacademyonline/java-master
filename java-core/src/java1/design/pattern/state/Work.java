package java1.design.pattern.state;

/**
 * @Author zhaojw
 * @Date 2017/12/10 17:17
 */
public class Work {

    private int hour;
    private State state;
    private boolean isFinish=false;
    public Work(){
        state=new ForenoonState();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
    public void writeProgram(){
        state.writeProgram(this);
    }
}
