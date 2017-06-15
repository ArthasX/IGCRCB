/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG787VW;

/**
 * <p>����:���̹�ͨ������ͼDAOʵ��</p>
 * <p>����������1.������������</p>
 * <p>			 2.������������</p>
 * <p>			 3.���������������ȡ��</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("deprecation")
public class IG787DAOImpl extends BaseHibernateDAOImpl<IG787Info> implements IG787DAO {

	/**
	 * ���ܣ����캯��
	 */
	public IG787DAOImpl(){
		super(IG787VW.class);
	}
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG787Info> findByCond(final IG787SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("prid"));
		List<IG787Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG787SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();

		if(cond.getPrid()!=null && cond.getPrid()>0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		
		if(cond.getPidgid()!=null && cond.getPidgid()>0){
			c.add(Expression.eq("pidgid", cond.getPidgid()));
		}
		
		return c;
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG787SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
}
