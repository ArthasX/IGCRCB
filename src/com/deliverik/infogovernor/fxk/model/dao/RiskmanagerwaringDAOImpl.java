/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskmanagerwaringSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.RiskmanagerwaringTB;

/**
  * ����: ���չ�����ʾ���ݱ�DAOʵ��
  * ��������: ���չ�����ʾ���ݱ�DAOʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public class RiskmanagerwaringDAOImpl extends
		BaseHibernateDAOImpl<RiskmanagerwaringInfo> implements RiskmanagerwaringDAO {

	/**
	 * ���캯��
	 */
	public RiskmanagerwaringDAOImpl(){
		super(RiskmanagerwaringTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskmanagerwaringInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskmanagerwaringInfo findByPK(Serializable pk) {
		RiskmanagerwaringInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskmanagerwaringSearchCond cond){
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
	public List<RiskmanagerwaringInfo> findByCond(final RiskmanagerwaringSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rwid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskmanagerwaringSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��������(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getRwname())){
			c.add(Restrictions.like("rwname", cond.getRwname()+"%"));
		}
		//�·���Ա����(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getNusername())){
			c.add(Restrictions.eq("nusername", cond.getNusername()));
		}
		//�½�����Ա����(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getUsername_s())){
			c.add(Restrictions.sqlRestriction(" exists (select 1 from  acceptuser a where this_.rwid=a.rwid and  a.apusername like '%" + cond.getUsername_s() + "%') "));
		}
		//�·�ʱ��(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getNtime())){
			c.add(Restrictions.like("ntime", cond.getNtime()+"%"));
		}
		//�·���Ա����ID(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getNorgid())){
			c.add(Restrictions.eq("norgid", cond.getNorgid()));
		}
		
		return c;
	}

}