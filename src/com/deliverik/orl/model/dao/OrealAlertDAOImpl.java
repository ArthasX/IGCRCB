/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.orl.model.OrealAlertInfo;
import com.deliverik.orl.model.condition.OrealAlertSearchCond;
import com.deliverik.orl.model.entity.OrealAlertTB;

/**
 * ������ŷ���Ÿ澯��DAOʵ��
 * ����������ŷ���Ÿ澯��DAOʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
@SuppressWarnings("deprecation")
public class OrealAlertDAOImpl extends BaseHibernateDAOImpl<OrealAlertInfo> implements OrealAlertDAO {

	/**
	 * ���캯��
	 */
	public OrealAlertDAOImpl(){
		super(OrealAlertTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OrealAlertInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		
		//Ĭ�ϰ�ʱ�䵹���������
		c.addOrder(Order.desc("ctime"));
		//���Ӱ����ȼ��ɸߵ�������
		c.addOrder(Order.desc("priority"));
		
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public OrealAlertInfo findByPK(Serializable pk) {
		OrealAlertInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws BLException 
	 */
	public int getSearchCount(final OrealAlertSearchCond cond) throws BLException{
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
	 * @throws BLException 
	 */
	public List<OrealAlertInfo> findByCond(final OrealAlertSearchCond cond, final int start, final int count) throws BLException{
		DetachedCriteria c = getCriteria(cond);
		
		//Ĭ�ϰ�ʱ�䵹���������
		c.addOrder(Order.desc("ctime"));
		//���Ӱ����ȼ��ɸߵ�������
		c.addOrder(Order.desc("priority"));
		
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 * @throws BLException 
	 */
	protected DetachedCriteria getCriteria(OrealAlertSearchCond cond) throws BLException{
		DetachedCriteria c = getDetachedCriteria();
		
		//���Ƿ��޸�(��ʶ)��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getFixed_eq())){
			c.add(Expression.eq("fixed", new Integer(cond.getFixed_eq())));
		}
		//��ƽ̨���Ʋ�Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getPlatform_name_like())){
			c.add(Expression.like("platform_name", "%"+cond.getPlatform_name_like()+"%"));
		}
		//��ƽ̨����(in)��Ϊ��ʱ
		if(cond.getPlatform_name_in() != null){
			c.add(Expression.in("platform_name", cond.getPlatform_name_in()));
		}
		
		return c;
	}
}