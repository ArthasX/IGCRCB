/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ա������ͳ��DAo�ӿ�
 * </p>
 */
public interface SummaryCountPersonDAO extends BaseHibernateDAO{

	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public List<IG160Info> searchSummary(SummaryCountPersonSearchCond cond);
}
