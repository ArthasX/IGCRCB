/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.igflow.api;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;

/**
 * �����ⲿ�¼�����API
 */
public interface FlowExternalBL{

	/**
	 * �ⲿ�¼����÷���
	 * 
	 * @param eventID �¼�ID
	 * @param param ������Ϣ
	 * @throws BLException
	 */
	public void eventHandler(String eventID, ExternalParameterInfo param) throws BLException;
}
