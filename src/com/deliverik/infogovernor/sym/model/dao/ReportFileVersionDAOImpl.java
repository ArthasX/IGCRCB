/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;
import com.deliverik.infogovernor.sym.model.entity.ReportFileVersionTB;


/**
 * ����汾DAOʵ��
 */
@SuppressWarnings("deprecation")
public class ReportFileVersionDAOImpl extends BaseHibernateDAOImpl<ReportFileVersion> implements ReportFileVersionDAO {
	/**
	 * ���캯��
	 */
	public ReportFileVersionDAOImpl(){
		super(ReportFileVersionTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<ReportFileVersion> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rfvid"));
		List<ReportFileVersion> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rfvid ����
	 * @return �������
	 */
	public ReportFileVersion findByPK(Serializable rfvid) {

		ReportFileVersion result = super.findByPK(rfvid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ReportFileVersionSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ReportFileVersion> findByCond(final ReportFileVersionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rfvid"));
		List<ReportFileVersion> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ReportFileVersionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��������
		if( cond.getRfdid() != null && cond.getRfdid() > 0){
			c.add(Expression.eq("rfdid", cond.getRfdid()));
		}
		return c;
	}

}
