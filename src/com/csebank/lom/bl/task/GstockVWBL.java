/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.condition.GstockVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ���Ԥ����Ϣҵ���߼��ӿ�
 */
public interface GstockVWBL extends BaseBL {

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GstockVWInfo> searchGstockVW(GstockVWSearchCond cond, int start, int count);

}
