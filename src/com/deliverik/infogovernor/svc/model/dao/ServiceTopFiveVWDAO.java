/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.model.condition.ServiceTopFiveSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���topͳ��DAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ServiceTopFiveVWDAO extends BaseHibernateDAO<ServiceTopFiveVWInfo>{

	/**
	 * ͳ�����ݲ�ѯ
	 * @param cond
	 * @return
	 */
	public List<ServiceTopFiveVWInfo> searchServiceDate(final ServiceTopFiveSearchCond cond);
}
