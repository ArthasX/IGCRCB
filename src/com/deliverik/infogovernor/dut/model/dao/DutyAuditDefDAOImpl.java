/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyAuditDefTB;

/**
 * ֵ�������DAO�ӿ�ʵ��
 */
@SuppressWarnings("deprecation")
public class DutyAuditDefDAOImpl extends BaseHibernateDAOImpl<DutyAuditDef> implements DutyAuditDefDAO {

	/**
	 * ���캯��
	 */
	public DutyAuditDefDAOImpl(){
		super(DutyAuditDefTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyAuditDef> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dadid"));
		List<DutyAuditDef> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public DutyAuditDef findByPK(Serializable dadid) {

		DutyAuditDef result = super.findByPK(dadid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyAuditDefSearchCond cond){
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
	public List<DutyAuditDef> findByCond(final DutyAuditDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dadorderby"));
		List<DutyAuditDef> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DutyAuditDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//������
		if(StringUtils.isNotEmpty(cond.getDadtype())){
			c.add(Expression.eq("dadtype", cond.getDadtype()));
		}
		
		//�������
		if(StringUtils.isNotEmpty(cond.getDadname())){
			c.add(Expression.like("dadname", "%"+cond.getDadname()+"%"));
		}

		//ֵ������
		if(StringUtils.isNotEmpty(cond.getDadcategory())){
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		
		return c;
	}


}
