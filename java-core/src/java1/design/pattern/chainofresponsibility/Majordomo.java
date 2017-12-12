package java1.design.pattern.chainofresponsibility;

/**
 * @Author zhaojw
 * @Date 2017/12/12 22:08
 *
 * 总监
 */
public class Majordomo extends Manager{

    public Majordomo(String name){
        super(name);
    }

    @Override
    public void resquestApplications(Request request) {
        if ("请假".equals(request.getRequestType())&&request.getNumber()<=5){
            System.out.println(name+":"+request.getRequestContent()+"数量"+request.getNumber()+"请假被批准");
        }else {
            if(superior!=null){
                superior.resquestApplications(request);
            }
        }
    }
}
