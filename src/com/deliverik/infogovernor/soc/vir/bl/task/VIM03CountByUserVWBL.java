/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCond;
/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public interface VIM03CountByUserVWBL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByUserVWInfo> findByCond(final VIM03CountByUserVWSearchCond cond,final int start,final int count);
}
