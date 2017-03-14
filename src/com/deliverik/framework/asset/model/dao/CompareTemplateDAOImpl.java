/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.asset.model.CompareTemplateInfo;
import com.deliverik.framework.asset.model.condition.CompareTemplateSearchCond;
import com.deliverik.framework.asset.model.entity.CompareTemplateTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: compareTemplateDAOʵ��
  * ��������: compareTemplateDAOʵ��
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareTemplateDAOImpl extends
		BaseHibernateDAOImpl<CompareTemplateInfo> implements CompareTemplateDAO {

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
			c.add(Expression.in("ctvalue", cond.getLegendArray()));
		}
		return c;
	}

}