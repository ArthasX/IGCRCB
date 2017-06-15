/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.csebank.lom.model.entity.ItemsCodesStTB;
import com.csebank.lom.util.CodeUtils;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ʳ�óɱ�����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class LunchCardDAOImpl extends BaseHibernateDAOImpl<ItemsCodesSt> implements LunchCardDAO {

	/**
	 * ���캯��
	 */
	public LunchCardDAOImpl(){
		super(ItemsCodesStTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<ItemsCodesSt> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("typecode"));
		List<ItemsCodesSt> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public ItemsCodesSt findByPK(Serializable icid) {

		ItemsCodesSt result = super.findByPK(icid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final LunchCardSearchCond cond){
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
	public List<ItemsCodesSt> findByCond(final LunchCardSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("icid"));
		List<ItemsCodesSt> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(LunchCardSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//�Ϳ�����
		if(StringUtils.isNotEmpty(cond.getTypename())){
			c.add(Expression.like("typename", "%"+cond.getTypename()+"%"));
		}
		
		//�Ϳ�״̬
		if(StringUtils.isNotEmpty(cond.getDesc())){
			c.add(Expression.eq("desc", cond.getDesc()));
		}
		
		//�Ϳ����
		if(!"null".equals(String.valueOf(cond.getIcid()))){
			c.add(Expression.eq("icid", cond.getIcid()));
		}
		c.add(Expression.eq("selectid", CodeUtils.CARD_CATEGORY));
		return c;
	}

}
