/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;

/**
  * ����: ErRelationDAOʵ��
  * ��������: ErRelationDAOʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public class ErRelationDAOImpl extends
		BaseHibernateDAOImpl<ErRelationInfo> implements ErRelationDAO {

	/**
	 * ���캯��
	 */
	public ErRelationDAOImpl(){
		super(ErRelationTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ErRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ErRelationInfo findByPK(Serializable pk) {
		ErRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ErRelationSearchCond cond){
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
	public List<ErRelationInfo> findByCond(final ErRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ErRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("errid"));
		//ercode
		if(StringUtils.isNotEmpty(cond.getErcode())){
			c.add(Restrictions.like("ercode", cond.getErcode()+"%"));
		}
		//erid
		if(cond.getErid()!=null&&cond.getErid()>0){
			c.add(Restrictions.eq("erid", cond.getErid()));
		}
		//eiid
		if(StringUtils.isNotEmpty(cond.getEiid())){
			c.add(Restrictions.eq("eiid", cond.getEiid()));
		}
		//deleteflag
		if(StringUtils.isNotEmpty(cond.getDeleteflag())){
			if("NOTONE".equals(cond.getDeleteflag())){
				c.add(Restrictions.not(Restrictions.eq("deleteflag", "1")));
			}else{
				c.add(Restrictions.eq("deleteflag", cond.getDeleteflag()));
			}
		}
		return c;
	}

}