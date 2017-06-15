/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCond;
/**
 * ���⻯ͳ�Ʒ���
 *
 */
public interface VIM03CountByOrgVWDAO extends BaseHibernateDAO<VIM03CountByOrgVWInfo> {
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByOrgVWInfo> findByCond(final VIM03CountByOrgVWSearchCond cond, final int start, final int count);
	
	/**
	 * ��ѯ��������Դʹ�����
	 * @param cond
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getCount(final VIM03CountByOrgVWSearchCond cond);
}
