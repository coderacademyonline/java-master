package java1.design.pattern.memento;

/**
 * @Author zhaojw
 * @Date 2017/12/10 20:48
 *
 * 管理者
 *
 */
public class RoleStateCaretaker {
    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
