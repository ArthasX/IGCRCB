/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.igflow.api;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG992BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowExternalExecuteBL;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
 * �����ⲿ�¼�����API
 */
public class FlowExternalBLImpl implements FlowExternalBL{
	
	static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
	
	/** �ⲿ���ô����� */
	IG992BL ig992BL;
	
	/**
	 * �ⲿ���ô�����ע��
	 * @param ig992BL
	 */
	public void setIg992BL(IG992BL ig992BL) {
		this.ig992BL = ig992BL;
	}

	/**
	 * �ⲿ�¼����÷���
	 * 
	 * @param eventID �¼�ID
	 * @param param ������Ϣ
	 * @throws BLException
	 */
	public void eventHandler(String eventID, ExternalParameterInfo param) throws BLException{
	    igflowlog.debug(">>>�����ⲿ���ô���ʼ");
		if(StringUtils.isEmpty(eventID) || StringUtils.isEmpty(eventID.trim())){
			throw new BLException("IGEXTERNAL.E001","�¼�eventIDΪ�գ�");
		}
		if(ig992BL == null) {
			throw new BLException("IGEXTERNAL.E001","��ȡ�ⲿ���ô��������");
		}
		//��ȡ���еǼǵ��ⲿ����ʵ��
		List<IG992Info> lstProcessExternalDefInfo = ig992BL.searchIG992Info();
		if(lstProcessExternalDefInfo == null || lstProcessExternalDefInfo.size() == 0){
			throw new BLException("IGEXTERNAL.E001","û�ж����ⲿ����ʵ����,���������̶��塢�ⲿ���������н��еǼǣ�");
		}
		WorkFlowExternalExecuteBL bl = null;
		boolean searchBl = false;
		//����eventID��ѯ�ⲿ����ʵ����
		for(IG992Info info : lstProcessExternalDefInfo){
			if(info.getPedeventid().equals(eventID)){
				//ȡ���ⲿ����ʵ����
				try {
					bl = (WorkFlowExternalExecuteBL)WebApplicationSupport.getBean(info.getPedaction());
				} catch (Exception e) {
					throw new BLException("IGEXTERNAL.E001","û���ҵ�"+eventID+"��Ӧ��"+info.getPedaction()+"��ʵ����,��ȷ�������ļ���ȷ��");
				}
				searchBl = true;
				//����ʵ�ʴ�����
				bl.eventExecute(eventID, param);
			}
		}
		if(!searchBl){
			throw new BLException("IGEXTERNAL.E001","û���ҵ�"+eventID+",��ȷ���Ƿ�Ǽǹ���");
		}
		igflowlog.debug(">>>�����ⲿ���ô������");
	}
}
 