/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0152TB;

/**
  * ����: �ʲ���ϵ��DAOʵ��
  * ��������: �ʲ���ϵ��DAOʵ��
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0152DAOImpl extends
		BaseHibernateDAOImpl<SOC0152Info> implements SOC0152DAO {

	/**
	 * ���캯��
	 */
	public SOC0152DAOImpl(){
		super(SOC0152TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0152Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0152Info findByPK(Serializable pk) {
		SOC0152Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0152SearchCond cond){
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
	public List<SOC0152Info> findByCond(final SOC0152SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	
	protected DetachedCriteria getCriteria(SOC0152SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ģ�ʹ�
		if (StringUtils.isNotEmpty(cond.getFromModelEid_eq())) {
			c.add(Expression.eq("fromModelEid", cond.getFromModelEid_eq()));
		}
		//ģ�͵�
		if (StringUtils.isNotEmpty(cond.getToModelEid_eq())) {
			c.add(Expression.eq("toModelEid", cond.getToModelEid_eq()));
		}
		//��ϵ�����
		if (StringUtils.isNotEmpty(cond.getRlnCode_eq())) {
			c.add(Expression.eq("rlnCode", cond.getRlnCode_eq()));
		}
		//��ϵ�����
		if (cond.getRlnCode_in()!=null&&cond.getRlnCode_in().size()>0) {
			c.add(Expression.in("rlnCode", cond.getRlnCode_in()));
		}
		//��ϵ�����
		if (StringUtils.isNotEmpty(cond.getRlnType_eq())) {
			c.add(Expression.eq("rlnType", cond.getRlnType_eq()));
		}
		return c;
	}

}