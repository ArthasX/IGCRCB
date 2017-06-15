package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;
import com.deliverik.framework.user.model.entity.RoleActionTB;

/**
 * ��ɫ�˵���Ȩ��ϢDAO�ӿ�ʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class RoleActionTBDAOImpl extends BaseHibernateDAOImpl<RoleAction> implements RoleActionTBDAO {

	/**
	 * ���캯��
	 */
	public RoleActionTBDAOImpl(){
		super(RoleActionTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RoleAction> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("roleid"));
		List<RoleAction> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public RoleAction findByPK(Serializable raid) {

		RoleAction ra = super.findByPK(raid);
		if(ra == null) return null;

		return ra;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RoleActionSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RoleAction> findByCond(final RoleActionSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("roleid"));
		List<RoleAction> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RoleActionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��ɫID
		if( cond.getRoleid() != null && cond.getRoleid() != 0) {
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		//�˵�ID
		if( !StringUtils.isEmpty(cond.getActname())) {
			c.add(Expression.eq("actname", cond.getActname()));
		}
		return c;
	}
}
