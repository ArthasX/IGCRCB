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
        object[0] = "d988b330-2426-43a4-978d-03fc8aa0ad2f";//Object�������洢�����Ĳ���
        object[1] = "false";//Object�������洢�����Ĳ���
        try {
            call = (Call) service.createCall();
            call.setOperationName(new QName("http://PowerProject/", "ChangeTicketPhase"));
            call.setTargetEndpointAddress(endpoint);// Զ�̵���·��
 
            // ���ò�����:
            call.addParameter("ticketId", // ������
                    XMLType.XSD_STRING,// ��������:String
                    ParameterMode.IN);// ����ģʽ��'IN' or 'OUT'
         // ���ò�����:
            call.addParameter("result", // ������
                    XMLType.XSD_BOOLEAN,// ��������:String
                    ParameterMode.IN);// ����ģʽ��'IN' or 'OUT'
            // ���÷���ֵ���ͣ�
            call.setReturnType(XMLType.XSD_STRING);// ����ֵ���ͣ�String          
 
            result = (String) call.invoke(object);// Զ�̵���
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