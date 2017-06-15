/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;
import com.deliverik.infogovernor.svc.model.condition.AnnualTrendVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��DAO�ӿ�
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public interface AnnualTrendVWDAO extends BaseHibernateDAO<AnnualTrendVWInfo>{

	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public List<AnnualTrendVWInfo> searchAnnualTrendVW(final AnnualTrendVWSearchCond cond);
}
