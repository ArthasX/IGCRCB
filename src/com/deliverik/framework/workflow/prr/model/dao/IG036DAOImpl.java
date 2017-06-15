/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>����:��־��ϢDAOʵ��</p>
 * <p>����������1.ȫ������</p>
 * <p>         2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.������������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("deprecation")
public class IG036DAOImpl extends BaseHibernateDAOImpl<IG036Info> implements IG036DAO {
	

	/**
	 * ���캯��
	 */
	public IG036DAOImpl(){
		super(IG036TB.class);
	}

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG036Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rlid"));
		List<IG036Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ���ܣ�������������
	 * @param rlid ����
	 * @return �������
	 */
	public IG036Info findByPK(Serializable rlid) {

		IG036Info rl = super.findByPK(rlid);
		if(rl == null) return null;

		return rl;
	}

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG036Info> findByCond(final IG036SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(WorkFlowConstDefine.RECORDLOG_ORDER_DESC.equals(cond.getRoleorder_type())){
			c.addOrder(Order.desc("rltime"));
		}else if(cond.isRoleorder()){
			c.addOrder(Order.asc("psname"));
			c.addOrder(Order.asc("roleid"));
			c.addOrder(Order.asc("rltime"));
		}else{
			
			c.addOrder(Order.asc("rlid"));
		}
		List<IG036Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG036SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if( cond.getPrid() != null && cond.getPrid()!=0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if( !StringUtils.isEmpty(cond.getRluserid())){
			c.add(Expression.eq("rluserid", cond.getRluserid()));
		}
		if( !StringUtils.isEmpty(cond.getRlusername())){
			c.add(Expression.eq("rlusername", cond.getRlusername()));
		}
		if( cond.getRoleid()!=null && cond.getRoleid().size()>0){
			c.add(Expression.in("roleid", cond.getRoleid()));
		}
		
		if( !StringUtils.isEmpty(cond.getNotEqualrlType())){
			c.add(Expression.ne("rltype", cond.getNotEqualrlType()));
		}
		
		if( !StringUtils.isEmpty(cond.getRlType())){
			c.add(Expression.eq("rltype", cond.getRlType()));
		}
		
		if( !StringUtils.isEmpty(cond.getPsdcode())){
			c.add(Expression.eq("psdcode", cond.getPsdcode()));
		}
		
		if( !StringUtils.isEmpty(cond.getRolemanger())){
			c.add(Expression.eq("rolemanger", cond.getRolemanger()));
		}
		
		if( !StringUtils.isEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		
		if( cond.getPsdnum()!=null && cond.getPsdnum()>0){
			c.add(Expression.eq("psdnum", cond.getPsdnum()));
		}
		
		return c;
	}
}
