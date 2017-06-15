/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;

/**
  * ����: �������ϸ��DAOʵ��
  * ��������: �������ϸ��DAOʵ��
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class RegulatoryReportDetailDAOImpl extends
		BaseHibernateDAOImpl<RegulatoryReportDetailInfo> implements RegulatoryReportDetailDAO {

	/**
	 * ���캯��
	 */
	public RegulatoryReportDetailDAOImpl(){
		super(RegulatoryReportDetailTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RegulatoryReportDetailInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RegulatoryReportDetailInfo findByPK(Serializable pk) {
		RegulatoryReportDetailInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RegulatoryReportDetailSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RegulatoryReportDetailInfo> findByCond(final RegulatoryReportDetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RegulatoryReportDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ʵ��ID
		if(cond.getInstanceID() != null){
			c.add(Expression.eq("instanceID", cond.getInstanceID()));
		}
		//����id
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		return c;
	}

}