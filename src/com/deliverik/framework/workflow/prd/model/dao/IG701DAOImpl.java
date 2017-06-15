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
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG701TB;

/**
  * ����: ���̲鿴��ɫ��Ȩ����DAOʵ��
  * ��������: ���̲鿴��ɫ��Ȩ����DAOʵ��
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG701DAOImpl extends
		BaseHibernateDAOImpl<IG701Info> implements IG701DAO {

	/**
	 * ���캯��
	 */
	public IG701DAOImpl(){
		super(IG701TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG701Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG701Info findByPK(Serializable pk) {
		IG701Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG701SearchCond cond){
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
	public List<IG701Info> findByCond(final IG701SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG701SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		if(cond.getRoleid()!=null&&cond.getRoleid()!=0){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		return c;
	}

}