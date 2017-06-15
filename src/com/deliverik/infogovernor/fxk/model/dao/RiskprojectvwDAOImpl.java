/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskprojectvwSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.RiskprojectvwTB;

/**
  * ����: ͨѶ¼DAOʵ��
  * ��������: ͨѶ¼DAOʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public class RiskprojectvwDAOImpl extends
		BaseHibernateDAOImpl<RiskprojectvwInfo> implements RiskprojectvwDAO {

	/**
	 * ���캯��
	 */
	public RiskprojectvwDAOImpl(){
		super(RiskprojectvwTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
    public List<RiskprojectvwInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
    public RiskprojectvwInfo findByPK(Serializable pk) {
		RiskprojectvwInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskprojectvwSearchCond cond){
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
	public List<RiskprojectvwInfo> findByCond(final RiskprojectvwSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskprojectvwSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		c.add(Restrictions.eq("prpdid", "0100301"));
		
		if(StringUtils.isNotEmpty(cond.getPrusername_l())){
            c.add(Restrictions.like("prusername", "%"+cond.getPrusername_l()+"%"));
        }
		if(StringUtils.isNotEmpty(cond.getRisknum_l())){
            c.add(Restrictions.like("risknum","%"+ cond.getRisknum_l()+"%"));
        }
		if(StringUtils.isNotEmpty(cond.getRiskstart_ge())){
            c.add(Restrictions.ge("riskstart",cond.getRiskstart_ge()));
        }
		if(StringUtils.isNotEmpty(cond.getRiskstart_le())){
            c.add(Restrictions.le("riskstart", cond.getRiskstart_le()));
        }
		if(StringUtils.isNotEmpty(cond.getRiskstatus_q())){
            c.add(Restrictions.eq("riskstatus", cond.getRiskstatus_q()));
        }
		if(StringUtils.isNotEmpty(cond.getRisktype_q())){
            c.add(Restrictions.eq("risktype", cond.getRisktype_q()));
        }
		if(StringUtils.isNotEmpty(cond.getTitle_l())){
            c.add(Restrictions.like("prtitle", "%"+cond.getTitle_l()+"%"));
        }
		
		return c;
	}

}