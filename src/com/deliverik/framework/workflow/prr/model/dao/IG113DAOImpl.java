/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;

/**
 * <p>����:����־��Ϣ����DAOʵ��</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.������������</p>
 *           
 * <p>������¼��</p>
 */
public class IG113DAOImpl extends BaseHibernateDAOImpl<IG113Info> implements IG113DAO {

	/**
	 * ���캯��
	 */
	public IG113DAOImpl(){
		super(IG113TB.class);
	}

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG113Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rlvid"));
		List<IG113Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ���ܣ�������������
	 * @param rlvid ����
	 * @return �������
	 */
	public IG113Info findByPK(Serializable rlvid) {

		IG113Info rl = super.findByPK(rlvid);
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
	public List<IG113Info> findByCond(final IG113SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rlvid"));
		List<IG113Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG113SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		
		//����ID 
		if( cond.getPiid() != null && cond.getPiid() != 0){
			c.add(Restrictions.eq("piid", cond.getPiid()));
		}
		
		//��־ID 
		if( cond.getRlid() != null && cond.getRlid() != 0){
			c.add(Restrictions.eq("rlid", cond.getRlid()));
		}
		
		//���̼�¼ID
		if( cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		//��ֵ�Ƿ�Ϊ��
		if(StringUtils.isNotEmpty(cond.getValueIsNull())){
			if("N".equals(cond.getValueIsNull())){
				c.add(Restrictions.isNotNull("pivarvalue"));
				c.add(Restrictions.ne("pivarvalue", ""));
			}
		}
		return c;
	}

}
