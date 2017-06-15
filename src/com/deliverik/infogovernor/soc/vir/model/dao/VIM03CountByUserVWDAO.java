/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCond;
/**
 * ���⻯ͳ�Ʒ���
 *
 */
public interface VIM03CountByUserVWDAO extends BaseHibernateDAO<VIM03CountByUserVWInfo> {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByUserVWInfo> findByCond(final VIM03CountByUserVWSearchCond cond, final int start, final int count);
}
