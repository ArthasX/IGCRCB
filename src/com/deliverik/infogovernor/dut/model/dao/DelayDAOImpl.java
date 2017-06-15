/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;
import com.deliverik.infogovernor.dut.model.entity.DelayTB;

/**
  * ����: ��ʱ������Ϣ��DAOʵ��
  * ��������: ��ʱ������Ϣ��DAOʵ��
  * ������¼: 2012/04/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class DelayDAOImpl extends
		BaseHibernateDAOImpl<DelayInfo> implements DelayDAO {

	/**
	 * ���캯��
	 */
	public DelayDAOImpl(){
		super(DelayTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DelayInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DelayInfo findByPK(Serializable pk) {
		DelayInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DelaySearchCond cond){
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
	public List<DelayInfo> findByCond(final DelaySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DelaySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( !StringUtils.isEmpty(cond.getOrgname_eq())){
			c.add(Expression.eq("orgname", cond.getOrgname_eq()));
		}
		if( !StringUtils.isEmpty(cond.getTitle_like())){
			c.add(Expression.like("title", "%"+cond.getTitle_like()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getDatetime_from())){
			c.add(Expression.ge("datetime", cond.getDatetime_from()));
		}
		if( !StringUtils.isEmpty(cond.getDatetime_to())){
			c.add(Expression.le("datetime", cond.getDatetime_to()+" 23:59"));
		}
		return c;
	}

}