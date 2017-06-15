package com.deliverik.framework.asset.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.asset.model.entity.IG601VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * ������Ϣ��ͼDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG601DAOImpl extends BaseHibernateDAOImpl<IG601Info> implements IG601DAO {

	/**
	 * ���캯��
	 * 
	 */
	public IG601DAOImpl(){
		super(IG601VW.class);
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG601SearchCond cond){
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
	public List<IG601Info> findByCond(final IG601SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//c.addOrder(Order.asc("eiid"));
		//c.addOrder(Order.asc("eilabel"));
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		//�����豸������������
		c.addOrder(Order.asc("einame"));
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		List<IG601Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG601SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getEiid()!=null) {
			c.add(Expression.eq("eiid", cond.getEiid()));
		}
		
		if (StringUtils.isNotEmpty(cond.getRelateroom())){
		    c.add(Expression.eq("relateroom", cond.getRelateroom()));
		}

		return c;
	}
}
