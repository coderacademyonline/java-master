package java1.design.pattern.command;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:58
 */
public class BakeChickenWingCommand extends Command {

    public BakeChickenWingCommand(Barbecuer barbecuer,String name){
        super(barbecuer,name);
    }

    @Override
    public void executeCommand() {
        barbecuer.bakeChickenWing(name);
    }
}
