/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoRiskSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoRiskTB;

/**
  * ����: �����Թ���������DAOʵ��
  * ��������: �����Թ���������DAOʵ��
  * ������¼: 2014/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CheckInfoRiskDAOImpl extends
		BaseHibernateDAOImpl<CheckInfoRiskInfo> implements CheckInfoRiskDAO {

	/**
	 * ���캯��
	 */
	public CheckInfoRiskDAOImpl(){
		super(CheckInfoRiskTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoRiskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoRiskInfo findByPK(Serializable pk) {
		CheckInfoRiskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckInfoRiskSearchCond cond){
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
	public List<CheckInfoRiskInfo> findByCond(final CheckInfoRiskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckInfoRiskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getCsid()!=null && !(cond.getCsid().equals("0"))){
			c.add(Restrictions.eq("csid", cond.getCsid()));
		}
		return c;
	}

}