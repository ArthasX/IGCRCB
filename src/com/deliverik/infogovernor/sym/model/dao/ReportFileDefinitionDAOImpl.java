/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.entity.ReportFileDefinitionTB;


/**
 * ������DAOʵ��
 */
@SuppressWarnings("deprecation")
public class ReportFileDefinitionDAOImpl extends BaseHibernateDAOImpl<ReportFileDefinition> implements ReportFileDefinitionDAO {
	/**
	 * ���캯��
	 */
	public ReportFileDefinitionDAOImpl(){
		super(ReportFileDefinitionTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<ReportFileDefinition> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rfdid"));
		List<ReportFileDefinition> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rfdid ����
	 * @return �������
	 */
	public ReportFileDefinition findByPK(Serializable rfdid) {

		ReportFileDefinition result = super.findByPK(rfdid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ReportFileDefinitionSearchCond cond){
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
	public List<ReportFileDefinition> findByCond(final ReportFileDefinitionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rfdid"));
		List<ReportFileDefinition> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ReportFileDefinitionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//������ʾ����(ģ��ƥ��)
		if( StringUtils.isNotEmpty(cond.getRfdtitle_like())){
			c.add(Expression.like("rfdtitle", "%" + cond.getRfdtitle_like() + "%"));
		}
		//������ʾ����
		if( StringUtils.isNotEmpty(cond.getRfdtitle())){
			c.add(Expression.eq("rfdtitle", cond.getRfdtitle()));
		}
		//�������
		if( StringUtils.isNotEmpty(cond.getRfdtype())){
			c.add(Expression.eq("rfdtype", cond.getRfdtype()));
		}
		//����������
		if( StringUtils.isNotEmpty(cond.getRfdfilename())){
			c.add(Expression.eq("rfdfilename", cond.getRfdfilename()));
		}
		//����ID
		if( null!=cond.getRfdid()){
			c.add(Expression.eq("rfdid", cond.getRfdid()));
		}
		return c;
	}

}
