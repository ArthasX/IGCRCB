/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.condition.InvestUseInfoSearchCond;

/**
 * ����: Ͷ��ʹ�����������DAO�ӿ�
 * ����������Ͷ��ʹ�����������DAO�ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
public interface InvestUseInfoDAO extends BaseHibernateDAO<InvestUseInfoVW>{
	/**
	 * ��ѯͶ��ʹ�������ϸ
	 */
	public List<InvestUseInfoVW> findAll(final InvestUseInfoSearchCond cond);
	
	/***
	 * Ͷ�ʺ�ͬ��ϸ�����ѯ
	 * @return
	 */
	public List<InvestContractInfoVW> findInvestContractInfo();
}
