package java1.design.pattern.memento;

/**
 * @Author zhaojw
 * @Date 2017/12/10 20:45
 *
 * 发起人
 *
 */
public class GameRole {
    private int vit;
    private int atk;
    private int def;

    /**
     * 保存状态
     * @return
     */
    public RoleStateMemento saveState(){
        return new RoleStateMemento(vit,atk,def);
    }

    /**
     * 恢复状态
     * @param memento
     */
    public void recoveryState(RoleStateMemento memento){
        this.vit=memento.getVit();
        this.atk=memento.getAtk();
        this.def=memento.getDef();
    }

    /**
     * 状态显示
     */
    public void stateDisplay(){
        System.out.println("当前角色的状态：");
        System.out.println("体力："+this.vit);
        System.out.println("攻击力："+this.atk);
        System.out.println("防御力："+this.def);
    }

    /**
     * 角色初始状态
     */
    public void stateInit(){
        this.vit=100;
        this.atk=100;
        this.def=100;
    }

    /**
     * 需要保存状态的时候的状态值
     */
    public void stateFight(){
        this.vit=0;
        this.atk=0;
        this.def=0;
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
