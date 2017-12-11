package java1.design.pattern.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author zhaojw
 * @Date 2017/12/11 22:59
 *
 * 本类：Invoker
 *
 */
public class Waiter {

    private List<Command> commands=new ArrayList<>();

    private static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 增加订单
     * @param command
     */
    public void setCommands(Command command){
       if ("烤鸡翅".equals(command.name)){
           System.out.println("服务员：烤鸡翅没有了，请点别的烧烤！");
       }else{
           commands.add(command);
           System.out.println("日志：新增订单,"+command.name+"，时间："+df.format(new Date()));
       }
    }

    /**
     * 取消订单
     * @param command
     */
    public void removeCommand(Command command){
        commands.remove(command);
        System.out.println("日志：取消订单,"+command.name+"，时间："+df.format(new Date()));
    }

    /**
     * 通知执行命令
     */
    public void notifyCommand(){
        for(Command command:commands){
            command.executeCommand();
        }
    }
}
