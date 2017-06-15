/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.dao;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentTypeSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��DAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentTypeDAO extends BaseHibernateDAO<IncidentTypeVWInfo>{

	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public IncidentTypeVWInfo searchIncidentTypeData(IncidentTypeSearchCond cond);
}
