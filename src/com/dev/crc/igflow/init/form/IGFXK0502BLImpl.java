/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

/***
 * �����嵥���������ڵ�ı���ʼ��
 * @time 2014/06/24
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGFXK0502BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGFXK0502BLImpl.class);
	
	/** ��ѯ��API */
	private FlowSearchBL flowSearchBL;
	
	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * �����嵥���������ڵ�ı���ʼ��
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {		
		log.debug("======== �����嵥���̱���ʼ������ʼ   ========");
		
		//��ֵ���Ϸ��ض���
		Map<String, Object> map = new HashMap<String, Object>();
		//�����չ����ֵ��Ϊ�գ���ô�÷����嵥���ɷ����������̷����
		if(param.getParameters() != null){
			//��չ����ֵΪ������������ID,����������������,���յ������ID,���յ����������
			String[] parameter = param.getParameters().split(",");
			//�������4��ֵ��˵�������������
			if(parameter.length != 4){
				log.debug("���������ʽ���ԣ�" + param.getParameters());
			}else{
				//����ʲ�ID��ʼ��
				map.put("����ʲ�ID", parameter[2]);
				//���յ�������ʼ��
				map.put("���յ������", parameter[3]);
				//��ȡ���������������
				List<ProcessRecordInfo> baseProcess = flowSearchBL.searchProcessInfo(parameter[0], "");
				//�������ֶηָ���
				String filter = "_$_";
				//������,Ϊ���̱���ֵ
				StringBuffer hiddenField = new StringBuffer();
				//������ֵ
				hiddenField.append(parameter[0]+filter);
				hiddenField.append(baseProcess.get(0).getPrtype()+filter);
				hiddenField.append(parameter[1]);
				//�������ʼ��
				map.put("������", hiddenField.toString());			
			}
			
		}
		
		log.debug("======== �����嵥���̱���ʼ���������   ========");
		
		return map;
	}
}
