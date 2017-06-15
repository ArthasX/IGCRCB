/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.csebank.lom.model.entity.GoutstockVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ��Ʒ������Ϣ��ͼDAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class GoutstockVWDAOImpl extends BaseHibernateDAOImpl<GoutstockVWInfo> implements GoutstockVWDAO {

	/**
	 * ���캯��
	 */
	public GoutstockVWDAOImpl(){
		super(GoutstockVW.class);
	}


	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GoutstockVWSearchCond cond){
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
	public List<GoutstockVWInfo> findByCond(final GoutstockVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("gsid"));
		List<GoutstockVWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(GoutstockVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���뵥���
		if(StringUtils.isNotEmpty(cond.getGoreqnum())){
			c.add(Expression.eq("goreqnum", cond.getGoreqnum()));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGocategory())){
			c.add(Expression.like("gocategory", cond.getGocategory()+"%"));
		}
		
		//��������
		if(StringUtils.isNotEmpty(cond.getGotype())){
			c.add(Expression.eq("gotype", cond.getGotype()));
		}
		
		
		//״̬
		if(StringUtils.isNotEmpty(cond.getGostatus())){
			c.add(Expression.eq("gostatus", cond.getGostatus()));
		}
		
		//��������
		if(StringUtils.isNotEmpty(cond.getGoorg())){
			c.add(Expression.eq("goorg", cond.getGoorg()));
		}
		
		return c;
	}

}
