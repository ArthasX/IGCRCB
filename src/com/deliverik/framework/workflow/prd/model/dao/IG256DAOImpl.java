/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;

/**
  * ����: ���̲�������DAOʵ��
  * ��������: ���̲�������DAOʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG256DAOImpl extends
		BaseHibernateDAOImpl<IG256Info> implements IG256DAO {

	/**
	 * ���캯��
	 */
	public IG256DAOImpl(){
		super(IG256TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG256Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG256Info findByPK(Serializable pk) {
		IG256Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG256SearchCond cond){
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
	public List<IG256Info> findByCond(final IG256SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG256SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() != 0) {
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getPrstatus())) {
			c.add(Expression.eq("prstatus", cond.getPrstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getFlag())){
			c.add(Expression.eq("flag", cond.getFlag()));
		}
		if(cond.getFlag_in() != null && cond.getFlag_in().length != 0){
			c.add(Expression.in("flag", cond.getFlag_in()));
		}
		return c;
	}

}