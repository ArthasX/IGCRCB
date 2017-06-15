/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.condition.ScienceOperationReportSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�Ƽ�����ͳ�Ʒ���DAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ScienceOperationReportDAO extends BaseHibernateDAO<Object>{

	/**
	 * ���ձ�ֵ��ѯ����ֵ��ռ������
	 * @param cond
	 * @return
	 */
	public List<Object[]> getWorkOrderAction(final ScienceOperationReportSearchCond cond);
}
