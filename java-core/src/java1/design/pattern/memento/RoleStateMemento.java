package java1.design.pattern.memento;

/**
 * @Author zhaojw
 * @Date 2017/12/10 20:31
 *
 * 备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
 * 备忘录（Memento）：负责存储发起人（Originator，即要保存状态的类）对象的状态，并可防止Originator以外的其他对象访问备忘录Memento。
 *                  备忘录有两个接口，管理者（Caretaker）只能看到备忘录的窄接口，他只能将备忘录传递给其他对象。Originator只能看到一个宽接口，它允许访问返回到先前状态所需的所有数据。
 * 发起人（Originator，即要保存状态的类）：负责创建一个备忘录Memento，用以记录当前时刻他的内部状态，并可使用备忘录恢复内部状态。Originator可根据需要决定Memento存储Originator的那些内部状态。
 * 管理者（Caretaker）：负责保存好备忘录（Memento），不能对备忘录的内容进行操作或这检查。
 *
 * 适用场景：适用于功能比较复杂的，但需要维护或记录属性历史的类，或者需要保存的属性只是众多属性中的一小部分时，Originator可以根据保存的Memento信息还原到前一状态。
 *          在命令模式中，备忘录可以保存撤销操作的命令，
 *  作用：当角色的状态改变的时候，又可能这个状态无效，这时候可以使用暂时存储起来的备忘录将状态还原。
 */
public class RoleStateMemento {
    private int vit;
    private int atk;
    private int def;

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
