/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCond;

/**
  * ����: cicollecttaskDAO�ӿ�
  * ��������: cicollecttaskDAO�ӿ�
  * ������¼: 2013/07/05
  * �޸ļ�¼: 
  */
public interface PlanDAO extends BaseHibernateDAO<PlanInfo> {


	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PlanInfo> findByCond(PlanSearchCond cond, int start, int count);

	
	public Integer getSearchCount(PlanSearchCond cond);
	
	
	

}