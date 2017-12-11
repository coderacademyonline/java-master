package java1.design.pattern.command;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:57
 *
 * 本类：ConctreteCommand
 */
public class BakeMuttonCommand extends Command {

    public BakeMuttonCommand(Barbecuer barbecuer,String name){
        super(barbecuer,name);
    }

    @Override
    public void executeCommand() {
        barbecuer.bakeMutton(name);
    }
}
