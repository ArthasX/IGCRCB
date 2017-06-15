/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0601VW;

/**
 * ������Ϣ��ͼDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0601DAOImpl extends BaseHibernateDAOImpl<SOC0601Info> implements SOC0601DAO {

	/**
	 * ���캯��
	 * 
	 */
	public SOC0601DAOImpl(){
		super(SOC0601VW.class);
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0601SearchCond cond){
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
	public List<SOC0601Info> findByCond(final SOC0601SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//c.addOrder(Order.asc("eiid"));
		//c.addOrder(Order.asc("eilabel"));
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		//�����豸������������
		c.addOrder(Order.asc("einame"));
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		List<SOC0601Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0601SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (StringUtils.isNotEmpty(cond.getEiid())) {
			c.add(Expression.eq("eiid", Integer.parseInt(cond.getEiid())));
		}
		
		if (StringUtils.isNotEmpty(cond.getRelateroom())){
		    c.add(Expression.eq("relateroom", cond.getRelateroom()));
		}

		return c;
	}
}
