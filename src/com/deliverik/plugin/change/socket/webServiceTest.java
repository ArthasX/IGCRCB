package com.deliverik.plugin.change.socket;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
 
public class webServiceTest {
    public String ChangeTicketPhase(String a ,boolean flag) throws MalformedURLException {
        URL  endpoint = new URL("http://123.56.92.205/Csrcbank/WebServicesCustom/Exchange/BizTicketService.asmx");
        String result = "no result!";
        Service service = new Service();
        Call call;
        Object[] object = new Object[2];
        object[0] = "d988b330-2426-43a4-978d-03fc8aa0ad2f";//Object是用来存储方法的参数
        object[1] = "false";//Object是用来存储方法的参数
        try {
            call = (Call) service.createCall();
            call.setOperationName(new QName("http://PowerProject/", "ChangeTicketPhase"));
            call.setTargetEndpointAddress(endpoint);// 远程调用路径
 
            // 设置参数名:
            call.addParameter("ticketId", // 参数名
                    XMLType.XSD_STRING,// 参数类型:String
                    ParameterMode.IN);// 参数模式：'IN' or 'OUT'
         // 设置参数名:
            call.addParameter("result", // 参数名
                    XMLType.XSD_BOOLEAN,// 参数类型:String
                    ParameterMode.IN);// 参数模式：'IN' or 'OUT'
            // 设置返回值类型：
            call.setReturnType(XMLType.XSD_STRING);// 返回值类型：String          
 
            result = (String) call.invoke(object);// 远程调用
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }
 
    public static void main(String[] args) throws MalformedURLException {
        webServiceTest t = new webServiceTest();
        String result = t.ChangeTicketPhase("a",true);
        System.out.println(result);
    }
}