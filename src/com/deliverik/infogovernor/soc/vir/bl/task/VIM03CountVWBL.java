/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public interface VIM03CountVWBL extends BaseBL {

	/**
	 * ��������ȡ��
	 *
	 * @param cond ��������
	 * @return ��������
	 */
	public Integer getCount(final VIM03CountVWSearchCond cond);
	/**
	 * ��������ȡ��
	 *
	 * @param cond ��������
	 * @return ��������
	 */
	public Integer getCountByCond(final VIM03CountVWSearchCond cond);
}
