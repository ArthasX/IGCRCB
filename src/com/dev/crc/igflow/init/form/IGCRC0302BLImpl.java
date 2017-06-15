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

/**
 * <p>
 *   ����������̴�����״̬��ֵ��ʼ��
 * </p>
 */
public class IGCRC0302BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGCRC0302BLImpl.class);
	
	/** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /**
     * @param ��ѯ�๦��API�� the flowSearchBL to set
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
    
	/**
	 * ����״̬��ֵ��ʼ��
	 * 
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		log.debug("======== �������̴�����ڵ��ʼ������ʼ========");
		//��ֵ���Ϸ��ض���
		Map<String, Object> map = new HashMap<String, Object>();
		//���������id��Ϊ�գ�˵�����������������Ǵӱ�����̷����
		if(param.getParprid() != null){
			//��ȡ������
			List<ProcessRecordInfo> process = flowSearchBL.searchProcessInfo(param.getParprid(), null);
			for (ProcessRecordInfo prInfo : process) {
				map.put("��������", prInfo.getPrdesc());
			}
		}
		log.debug("======== �������̴�����ڵ��ʼ���������========");
		return map;
		
	}

}
