/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.condition.OrganizationServiceSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��DAO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface OrganizationServiceDAO extends BaseHibernateDAO<OrganizationServiceVWInfo>{

	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public List<OrganizationServiceVWInfo> searchOrganizationService(OrganizationServiceSearchCond cond);
}
