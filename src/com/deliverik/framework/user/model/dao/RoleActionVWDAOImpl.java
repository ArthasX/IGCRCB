package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.RoleActionInfo;
import com.deliverik.framework.user.model.condition.RoleActionVWSearchCond;
import com.deliverik.framework.user.model.entity.RoleActionVW;

/**
 * ��ɫ�˵���Ȩ��ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class RoleActionVWDAOImpl extends BaseHibernateDAOImpl<RoleActionInfo> implements RoleActionVWDAO {

	/**
	 * ���캯��
	 */
	public RoleActionVWDAOImpl(){
		super(RoleActionVW.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RoleActionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("roleid"));
		List<RoleActionInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public RoleActionInfo findByPK(Serializable raid) {

		RoleActionInfo ra = super.findByPK(raid);
		if(ra == null) return null;

		return ra;
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RoleActionInfo> findByCond(final RoleActionVWSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("roleid"));
		List<RoleActionInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RoleActionVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��ɫID
		if( cond.getRoleid() != null && cond.getRoleid() != 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		//�˵�ID
		if( !StringUtils.isEmpty(cond.getActname())){
			c.add(Expression.eq("actname", cond.getActname()));
		}
		return c;
	}
}
