package java1.design.pattern.command;

/**
 * @Author zhaojw
 * @Date 2017/12/11 23:16
 */
public class CommandClient {

    public static void main(String[] args) {
        try {
            //命令执行者
            Barbecuer barbecuer=new Barbecuer();

            BakeMuttonCommand command=new BakeMuttonCommand(barbecuer,"烤羊肉串");
            BakeMuttonCommand command2=new BakeMuttonCommand(barbecuer,"烤羊肉串");
            BakeMuttonCommand command3=new BakeMuttonCommand(barbecuer,"烤羊肉串");
            BakeChickenWingCommand chickenWingCommand=new BakeChickenWingCommand(barbecuer,"烤鸡翅");


            Waiter waiter=new Waiter();
            waiter.setCommands(command);
            Thread.sleep(1000L);
            waiter.setCommands(command2);
            Thread.sleep(1000L);
            waiter.setCommands(chickenWingCommand);
            Thread.sleep(1000L);
            waiter.removeCommand(command3);
            Thread.sleep(1000L);
            waiter.notifyCommand();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
