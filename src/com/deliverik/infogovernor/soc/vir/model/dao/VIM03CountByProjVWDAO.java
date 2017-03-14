/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCond;
/**
 * ���⻯ͳ�Ʒ���
 *
 */
public interface VIM03CountByProjVWDAO extends BaseHibernateDAO<VIM03CountByProjVWInfo> {
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByProjVWInfo> findByCond(final VIM03CountByProjVWSearchCond cond, final int start, final int count);
}
