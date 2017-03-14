package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG126TB;

/**
 * ����ҳ�涨����ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG126DAOImpl extends
		BaseHibernateDAOImpl<IG126Info> implements IG126DAO {

	/**
	 * ���캯��
	 */
	public IG126DAOImpl() {
		super(IG126TB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<IG126Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pjdid"));
		List<IG126Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param pjdid����
	 * @return �������
	 */
	public IG126Info findByPK(Serializable pjdid) {

		IG126Info result = super.findByPK(pjdid);
		if (result == null)
			return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(final IG126SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<IG126Info> findByCond(
			final IG126SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pjdid"));
		List<IG126Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG126SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//���̶���ID
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		//ҳ������
		if(StringUtils.isNotEmpty(cond.getPjdtype())){
			c.add(Expression.eq("pjdtype", cond.getPjdtype()));
		}
		//����ҳ�涨��ID
		if(StringUtils.isNotEmpty(cond.getPjdid_like())){
			c.add(Expression.like("pjdid", cond.getPjdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PJDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PJDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPjdidSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(pjd.pjdid) FROM IG126TB pjd WHERE pjd.pjdid LIKE :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return pdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return pdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(pdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}

}
