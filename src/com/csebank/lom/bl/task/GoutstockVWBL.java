/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ��Ʒ������Ϣ��ͼҵ���߼��ӿ�
 */
public interface GoutstockVWBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GoutstockVWSearchCond cond);

	

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoutstockVWInfo> searchGoutstockVW(GoutstockVWSearchCond cond, int start, int count);
	

}
