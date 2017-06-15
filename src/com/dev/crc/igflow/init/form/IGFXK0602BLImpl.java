/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

/***
 * �������Ĺ��������ڵ�ı���ʼ��
 * @time 2014/06/19
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGFXK0602BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGFXK0602BLImpl.class);
	
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
	 * �������Ĺ��������ڵ�ı���ʼ��
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {		
		log.debug("======== �����������̱���ʼ������ʼ   ========");
		
		//��ֵ���Ϸ��ض���
		Map<String, Object> map = new HashMap<String, Object>();
		//���������id��Ϊ�գ�˵�����������������Ǵӱ�����̷����
		if(param.getParprid() != null && param.getParprid() > 0){
			//��ȡ�����̱����������嵥�����ֵ
			String listTitle = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "�����嵥����");
			//�������̱����������嵥�����ֵ ��ֵ�� �������ı������������ı���
			map.put("�������ı���",listTitle);
			
			//��ȡ�����̱����������嵥�����ֵ
			String listDesc = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "�����嵥����");
			//�������̱����������嵥������ֵ ��ֵ�� �������ı�����������������
			map.put("������������",listDesc);
			
			//��ȡ�����̱������嵥���������ֵ
			String listField = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "�嵥��������");
			//�������̱������嵥���������ֵ ��ֵ�� �������ı�����������������
			map.put("������������",listField);
			
			//��ȡ�����̱�������Դ��ֵ
			String source = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "��Դ");
			//�������̱�������Դ��ֵ ��ֵ�� �������ı���������������Դ
			map.put("����������Դ", source);
			
			//������������ҳ�洫���ʼֵ
			StringBuffer hiddenField = new StringBuffer();
			//�����������ķָ���
			String filter = "_$_";
			//��ȡ������
			List<ProcessRecordInfo> baseProcess = flowSearchBL.searchProcessInfo(param.getParprid(), "");
			//ƴ�����̱�������Ĵ�ֵ��Ϣ��������ID
			hiddenField.append(baseProcess.get(0).getPrid()+filter);
			//ƴ�����̱�������Ĵ�ֵ��Ϣ������������
			hiddenField.append(baseProcess.get(0).getPrtype()+filter);
			//ƴ�����̱�������Ĵ�ֵ��Ϣ���������̱���
			hiddenField.append(listTitle);
			//�������̱��� ��ֵ�� �������ı�����������
			map.put("������", hiddenField.toString());
			
		}
		if(StringUtils.isNotEmpty(param.getParameters())){
			map.put("�ʲ�ID", param.getParameters());
		}
		
		log.debug("======== �����������̱���ʼ���������   ========");
		
		return map;
	}
}
