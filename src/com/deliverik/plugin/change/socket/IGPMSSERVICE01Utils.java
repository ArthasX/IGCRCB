package com.deliverik.plugin.change.socket;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;
 

/***
 * 调用pms平台的webService接口
 * @param ticketId
 * @param true / false
 * @return 
 * @date 2015-09-15
 * @author zhao
 *
 */
public class IGPMSSERVICE01Utils extends Stub {
	static Log log = LogFactory.getLog(IGPMSSERVICE01Utils.class);
	//static MessageResources resources;
	
	 public String ChangeTicketPhase(String ticketId ,String result) throws MalformedURLException {
		 
//	        URL  endpoint = new URL(resources.getMessage("PP_WEBSERVICE_URL"));
	        URL  endpoint = new URL(MessageResources.getMessageResources("ApplicationResources").getMessage("PP_WEBSERVICE_URL"));
	        Service service = new Service();
	        String   resp = null;
	        Call call;
	        Object[] object = new Object[2];
	        object[0] = ticketId;//Object是用来存储方法的参数
	        object[1] = result;//Object是用来存储方法的参数
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
	            
	            resp = (String) call.invoke(object);// 远程调用
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            e.printStackTrace();
	        }
	        System.out.println("返回值----------------"+resp);
	        return resp;
	    }
	//测试方法 
	public static void main(String[] args) {
		IGPMSSERVICE01Utils utils = new IGPMSSERVICE01Utils();
		try {
			
			utils.ChangeTicketPhase("d988b330-2426-43a4-978d-03fc8aa0ad2f","true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
