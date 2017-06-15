/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.entity.RecptionGuestInfoTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 * ��Ʊ����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class RecptionGuestInfoDAOImpl extends BaseHibernateDAOImpl<RecptionGuestInfo> implements RecptionGuestInfoDAO {

	/**
	 * ���캯��
	 */
	public RecptionGuestInfoDAOImpl(){
		super(RecptionGuestInfoTB.class);
	}
   
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionGuestInfo> findByCond(final RecptionGuestInfoCond cond, final int start,
			final int count) {		
			DetachedCriteria c = getCriteria(cond);
			c.addOrder(Order.asc("rid"));
			List<RecptionGuestInfo> ret = findByCriteria(c, start, count);
			return ret;
		
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionGuestInfoCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(final RecptionGuestInfoCond cond){
		DetachedCriteria c = getDetachedCriteria();
		

		//������λ
		if( !StringUtils.isEmpty(cond.getRgunit())){
			c.add(Expression.like("rgunit", "%"+cond.getRgunit()+"%"));
		}	
		
		//��������
		if( !StringUtils.isEmpty(cond.getRgname())){
			c.add(Expression.like("rgname", "%"+cond.getRgname()+"%"));
		}	
        		
		return c;
	}

	public String getMaxRacode() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
