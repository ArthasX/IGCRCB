/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0405TB;

/**
  * ����: �߼�������ʵʱ��DAOʵ��
  * ��������: �߼�������ʵʱ��DAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeDAOImpl������ΪSOC0405DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0405DAOImpl extends
		BaseHibernateDAOImpl<SOC0405Info> implements SOC0405DAO {

	/**
	 * ���캯��
	 */
	public SOC0405DAOImpl(){
		super(SOC0405TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0405Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0405Info findByPK(Serializable pk) {
		SOC0405Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0405SearchCond cond){
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
	public List<SOC0405Info> findByCond(final SOC0405SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0405SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getHostName_eq())) {
			c.add(Expression.eq("hostName", cond.getHostName_eq()));
		}
		if (cond.getFsName_neq()!=null) {
			c.add(Expression.ne("fsName", cond.getFsName_neq()));
		}
		if (!StringUtils.isEmpty(cond.getLvState_eq())) {
			c.add(Expression.eq("lvState", cond.getLvState_eq()));
		}
		if (!StringUtils.isEmpty(cond.getLvType_ne())) {
			c.add(Expression.ne("lvType", cond.getLvType_ne()));
		}
		if (!StringUtils.isEmpty(cond.getLvType_eq())) {
			c.add(Expression.eq("lvType", cond.getLvType_eq()));
		}
		if (!StringUtils.isEmpty(cond.getVgName_eq())) {
			c.add(Expression.eq("vgName", cond.getVgName_eq()));
		}
		return c;
	}

}