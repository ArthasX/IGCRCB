/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.dev.hac.util.ComUtil;
/**
 * ����ر�  �ڵ����HAC
 * @author lvxin
 * @mail lvxin@deliverik.com
 * @time 2017-08-18
 *
 */
public class IGSVC0601BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGSVC0601BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	/**
     * ����
     */
	public void afterTreatmentExecute(final WorkFlowStatusEventBeanInfo bean) throws BLException {
		  log.debug("========������̹رսڵ����ݻ����͹ر�����ǰ����========");
		    
		    final List<ProcessRecordInfo> processInfo = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(),null);
		    
		    //���̵���
		    String workNoteNumber = processInfo.get(0).getPrserialnum();
		    
		    //����HTTP�ӿ�����
		    String url = ResourceUtility.getString("WORKNOTESTATUS_URL")+workNoteNumber;
		    
		    final Map<String,Object> jsonmap =  ComUtil.httpRequest(url, "PUT", null);

		    if(jsonmap==null){
		    	log.error("������̸��˽ڵ������ñ��ݻ��ӿ�ʧ�ܣ��ӿ�δ��ͨ");
	        	Thread deployThread = new Thread(){
	     			@Override
	     			public void run() {
	     				//���������־��
	     				WorkFlowLog wfl = new WorkFlowLog();
	     				wfl.setPrid(bean.getLogInfo().getPrid());
	     				wfl.setExecutorid(processInfo.get(0).getPruserid());	
	     				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
	     				wfl.setAuthuserid("");
	     				wfl.setComment("���ݻ�������̹ر�����ӿ��޷���ͨ:conncet failed");
	     				try {
	 						flowSetBL.setProcessLog(wfl, "�뱤�ݻ����̹ر�����ӿ�ͨѶʧ��", Constants.PROCESS_LOG_TYPE_PROCESSING);
	 					} catch (BLException e) {
	 						e.printStackTrace();
	 					}
	     			}
	     		};
	     		deployThread.start();
	         	throw new BLException("IGHAC0101.E001", "�뱤�ݻ����̹ر�����ӿ�ͨѶʧ��");
	        }else{
	        	 if(jsonmap.get("success").toString()=="false"){
	         		Thread deployThread = new Thread(){
	         			@Override
	         			public void run() {
	         				//���������־��
	         				WorkFlowLog wfl = new WorkFlowLog();
	         				wfl.setPrid(bean.getLogInfo().getPrid());
	         				wfl.setExecutorid(processInfo.get(0).getPruserid());	
	         				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
	         				wfl.setAuthuserid("");
	         				wfl.setComment("�����룺"+jsonmap.get("errorCode").toString()+"��������Ϣ��"+jsonmap.get("errorMessage").toString()+"��");
	         				try {
	     						flowSetBL.setProcessLog(wfl, "�뱤�ݻ�ͨѶʧ��", Constants.PROCESS_LOG_TYPE_PROCESSING);
	     					} catch (BLException e) {
	     						e.printStackTrace();
	     					}
	         			}
	         		};
	         		deployThread.start();
	             	throw new BLException("IGHAC0101.E001", jsonmap.get("errorMessage").toString());
	             }
	        }
			log.debug("========������̹رսڵ����ݻ����͹ر�����ǰ�������========");
	}
	
	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(final WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
	
	public static void main(String[] args){
		 String url = ResourceUtility.getString("WORKNOTESTATUS_URL")+"C20171012001";
		 final Map<String,Object> jsonmap =  ComUtil.httpRequest(url, "PUT", null);
		 System.out.println(jsonmap);
	}
}

