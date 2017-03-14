/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanSearchCond;
import com.deliverik.infogovernor.drm.model.condition.DrillplanVWSearchCond;

/**
  * ����: �����ƻ�DAO�ӿ�
  * ��������: �����ƻ�DAO�ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface DrillplanDAO extends BaseHibernateDAO<DrillplanInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DrillplanInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DrillplanInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DrillplanSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DrillplanInfo> findByCond(
			final DrillplanSearchCond cond, final int start,
			final int count);
	
	/**
     * ��ѯ�����ƻ���Ŀ��ͼ
     * @param cond
     * @return
     */
    public List<DrillplanVWInfo> getDrillPlanVW(final DrillplanVWSearchCond cond,final int start,final int count);
    /**
     * ��ѯ��������
     * @param cond
     * @return
     */
    public Integer getDrillPlanVWCount(final DrillplanVWSearchCond cond);
    
    /**
     * ����diid��ȡ�ƻ���Ŀ��ͼ
     * @param diid
     * @return
     */
    public DrillplanVWInfo getDrillPlanVWByDiid(final int diid);
	/**
	 * ͳ�������ƻ�����������Ŀ�ļ���
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 */
	public List<Map<String,Object>> searchDrilledPlanByCond(final DrillplanSearchCond cond, final int start, final int count);

}