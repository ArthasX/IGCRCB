/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCond;
/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public interface VIM03CountByProjVWBL extends BaseBL {
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByProjVWInfo> findByCond(final VIM03CountByProjVWSearchCond cond,final int start,final int count);
}
