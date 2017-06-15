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
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG001TB;

/**
  * ����: OA��ɫ���ñ�DAOʵ��
  * ��������: OA��ɫ���ñ�DAOʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG001DAOImpl extends
		BaseHibernateDAOImpl<IG001Info> implements IG001DAO {

	/**
	 * ���캯��
	 */
	public IG001DAOImpl(){
		super(IG001TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG001Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG001Info findByPK(Serializable pk) {
		IG001Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG001SearchCond cond){
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
	public List<IG001Info> findByCond(final IG001SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG001SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ָ��������صĽ�ɫ����
		if(StringUtils.isNotEmpty(cond.getProtype_eq())){
			c.add(Expression.eq("protype", cond.getProtype_eq()));
		}
		return c;
	}

}