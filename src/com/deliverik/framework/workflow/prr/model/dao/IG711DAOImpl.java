/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG711TB;

/**
 * <p>����:��Ȩ����DAOʵ��</p>
 * <p>����������1.������������</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("deprecation")
public class IG711DAOImpl extends BaseHibernateDAOImpl<IG711Info> implements IG711DAO {

	/**
	 * ���ܣ����캯��
	 */
	public IG711DAOImpl(){
		super(IG711TB.class);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG711SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//������Ա
		if(StringUtils.isNotEmpty(cond.getPabegintime_f())){
		c.add(Expression.ge("pabegintime", cond.getPabegintime_f()));
		}
		if(StringUtils.isNotEmpty(cond.getPabegintime_t())){
			c.add(Expression.le("pabegintime", cond.getPabegintime_t()));
		}
		
		if(StringUtils.isNotEmpty(cond.getPaflag())){
			c.add(Expression.eq("paflag", cond.getPaflag()));
		}
		if(StringUtils.isNotEmpty(cond.getPaiid())){
			c.add(Expression.eq("paiid", cond.getPaiid()));
		}
		if(StringUtils.isNotEmpty(cond.getPatype())){
			c.add(Expression.eq("patype", cond.getPatype()));
		}
		if(StringUtils.isNotEmpty(cond.getLoginUser())){
			c.add(Expression.eq("pauid", cond.getLoginUser()));
		}
		if(StringUtils.isNotEmpty(cond.getNopaflag())){
			c.add(Expression.ne("paflag", cond.getNopaflag()));
		}
		return c;
	}

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG711Info> findByCond(IG711SearchCond cond, int start,
			int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("paflag"));
		c.addOrder(Order.desc("pabegintime"));
		List<IG711Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * @param pdaid ����
	 * @return �������
	 */
	public IG711Info findIG711InfoByPK(Integer paid) {
		IG711Info ret = findByPK(paid);
		return ret;
	}


}
