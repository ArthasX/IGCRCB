/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCond;
/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public interface VIM03CountByOrgVWBL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByOrgVWInfo> findByCond(final VIM03CountByOrgVWSearchCond cond,final int start,final int count);

	/**
	 * ��ѯ��������Դʹ�����
	 * @param cond
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getCount(final VIM03CountByOrgVWSearchCond cond);


}
