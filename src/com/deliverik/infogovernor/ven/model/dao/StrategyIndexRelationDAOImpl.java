/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCond;
import com.deliverik.infogovernor.ven.model.entity.StrategyIndexRelationTB;

/**
  * ����: ���ղ���ָ���ϵ��DAOʵ��
  * ��������: ���ղ���ָ���ϵ��DAOʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class StrategyIndexRelationDAOImpl extends
		BaseHibernateDAOImpl<StrategyIndexRelationInfo> implements StrategyIndexRelationDAO {

	/**
	 * ���캯��
	 */
	public StrategyIndexRelationDAOImpl(){
		super(StrategyIndexRelationTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
    public List<StrategyIndexRelationInfo> findAll() {
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
    public StrategyIndexRelationInfo findByPK(Serializable pk) {
		StrategyIndexRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final StrategyIndexRelationSearchCond cond){
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
	public List<StrategyIndexRelationInfo> findByCond(final StrategyIndexRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(StrategyIndexRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���Ա�����
		if(cond.getRsid()!=null&&cond.getRsid()!=0){
		    c.add(Expression.eq("rsid", Integer.valueOf(cond.getRsid())));
		}
		return c;
	}

}