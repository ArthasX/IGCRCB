/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanitemSearchCond;

/**
  * ����: �����ƻ���ĿDAO�ӿ�
  * ��������: �����ƻ���ĿDAO�ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface DrillplanitemDAO extends BaseHibernateDAO<DrillplanitemInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DrillplanitemInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DrillplanitemInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DrillplanitemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DrillplanitemInfo> findByCond(
			final DrillplanitemSearchCond cond, final int start,
			final int count);
	
	/**��ѯ����������Ϣ*/
	public List<Map<String,Object>> searchDrillDetailByPrid(final String prid,final String flowType);
}