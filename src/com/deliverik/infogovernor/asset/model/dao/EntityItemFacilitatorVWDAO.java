/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;
/**
 * ����:��������Ϣ��ͼDAO�ӿ�
 * ��������: ��������Ϣ��ͼDAO�ӿ�
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼: 
 */
public interface EntityItemFacilitatorVWDAO extends BaseHibernateDAO<EntityItemFacilitatorVWInfo> {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EntityItemFacilitatorVWInfo> findByCond(final EntityItemFacilitatorVWSearchCond cond);
}
