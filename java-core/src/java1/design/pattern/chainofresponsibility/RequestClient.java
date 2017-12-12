package java1.design.pattern.chainofresponsibility;

/**
 * @Author zhaojw
 * @Date 2017/12/12 22:13
 */
public class RequestClient {

    public static void main(String[] args){
        CommonManager jinli=new CommonManager("刘强东");
        Majordomo zongjian=new Majordomo("李彦宏");
        GeneralManager zongjingli=new GeneralManager("马云");
        jinli.setSuperior(zongjian);  //设置上级。可以根据需求来更改设置
        zongjian.setSuperior(zongjingli);

        Request request1=new Request();
        request1.setNumber(1);
        request1.setRequestContent("我请假");
        request1.setRequestType("请假");
        jinli.resquestApplications(request1);//客户端的申请由经理发起，但实际由谁来决策，由具体管理类来处理。客户端不知道。

        Request request2=new Request();
        request2.setRequestType("请假");
        request2.setNumber(4);
        request2.setRequestContent("我请假");
        jinli.resquestApplications(request2);

        Request request3=new Request();
        request3.setRequestType("加薪");
        request3.setNumber(500);
        request3.setRequestContent("我加薪");
        jinli.resquestApplications(request3);

        Request request4=new Request();
        request4.setRequestType("加薪");
        request4.setNumber(1000);
        request4.setRequestContent("我加薪");
        jinli.resquestApplications(request4);

    }

}
