package java1.design.pattern.memento;

/**
 * @Author zhaojw
 * @Date 2017/12/10 20:49
 */
public class MementoClient {

    public static void main(String[] args){
        //保存状态之前
        GameRole gameRole=new GameRole();
        gameRole.stateInit();
        gameRole.stateDisplay();

        //保存进度
        RoleStateCaretaker caretaker=new RoleStateCaretaker();
        caretaker.setMemento(gameRole.saveState());

        //大战boos，状态值改变
        gameRole.stateFight();
        gameRole.stateDisplay();

        //恢复之前的状态
        gameRole.recoveryState(caretaker.getMemento());
        gameRole.stateDisplay();
    }
}
