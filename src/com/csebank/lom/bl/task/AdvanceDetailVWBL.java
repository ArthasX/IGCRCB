/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�
 */
public interface AdvanceDetailVWBL extends BaseBL {

	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<AdvanceDetail>
	 */
	public List<AdvanceDetail> searchAdvanceDetailVW(AdvanceDetailSearchCond cond,int start, int count);
	
	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @return �б��¼����
	 */
	public int getSearchCount(AdvanceDetailSearchCond cond);
	
}
