/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.init.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.sybase.jdbc4.a.b.o;

/**
 * <p>
 * �������̷���״̬��ֵ��ʼ��
 * </p>
 */
public class IGINIT0101BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGINIT0101BLImpl.class);
	
	/**
	 * ����״̬��ֵ��ʼ��
	 * 
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("һ", "һ��ֵ��");
		map.put("��", "����ֵ��");
		return map;
	}

}
