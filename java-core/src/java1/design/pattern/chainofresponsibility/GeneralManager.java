package java1.design.pattern.chainofresponsibility;

/**
 * @Author zhaojw
 * @Date 2017/12/12 22:10
 *
 * 总经理，具有最高权限
 *
 */
public class GeneralManager extends Manager {

    public GeneralManager(String name){
        super(name);
    }

    @Override
    public void resquestApplications(Request request) {
        if ("请假".equals(request.getRequestType())){
            System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNumber()+"请假被批准");
        }else if("加薪".equals(request.getRequestType())&&request.getNumber()<=500){
            System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNumber()+"加薪被批准");
        }else if("加薪".equals(request.getRequestType())&&request.getNumber()>500){
            System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNumber()+"加薪再说吧");
        }


    }
}
