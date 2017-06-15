/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.room.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.room.model.CompareTemplateInfo;
import com.deliverik.infogovernor.room.model.condition.CompareTemplateSearchCond;
import com.deliverik.infogovernor.room.model.entity.CompareTemplateTB;

/**
  * ����: compareTemplateDAOʵ��
  * ��������: compareTemplateDAOʵ��
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareTemplateDAOImpl extends
		BaseHibernateDAOImpl<CompareTemplateInfo> implements CompareTemplateDAO {

	/** �������� */
	public static final String UNNORMAL_TYPE_1 = "zone";
	/** ��Ч�ذ����� */
	public static final String UNNORMAL_TYPE_2 = "naf";
	
	/**
	 * ���캯��
	 */
	public CompareTemplateDAOImpl(){
		super(CompareTemplateTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareTemplateInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareTemplateInfo findByPK(Serializable pk) {
		CompareTemplateInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareTemplateSearchCond cond){
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
	public List<CompareTemplateInfo> findByCond(final CompareTemplateSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ctindex"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CompareTemplateSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getCategory())){
			c.add(Expression.eq("ctcategory", cond.getCategory()));
		}
		if(StringUtils.isNotEmpty(cond.getCabtype())){
			c.add(Expression.like("cttype", cond.getCabtype()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getType())){
			c.add(Expression.eq("cttype", cond.getType()));
		}
		if(cond.getLegendArray() != null){
			c.add(Expression.in("cttype", cond.getLegendArray()));
		}
		if(StringUtils.isNotEmpty(cond.getCteiid())){
			c.add(Expression.eq("cteiid", cond.getCteiid()));
		}
		if(StringUtils.isNotEmpty(cond.getNetype())){
			c.add(Expression.ne("cttype", cond.getNetype()));
		}
		if(StringUtils.isNotEmpty(cond.getCtZoneId())){
			c.add(Expression.eq("ctZoneId", cond.getCtZoneId()));
		}
		if("ok".equals(cond.getNotZoneAndNotNafFlag())){
			c.add(Expression.and(Expression.ne("cttype", UNNORMAL_TYPE_1), Expression.ne("cttype", UNNORMAL_TYPE_2)));
		}
		if(StringUtils.isNotEmpty(cond.getCtfloorx())){
			c.add(Expression.eq("ctfloorx", cond.getCtfloorx()));
		}
		if(StringUtils.isNotEmpty(cond.getCtfloory())){
			c.add(Expression.eq("ctfloory", cond.getCtfloory()));
		}
		return c;
	}

}