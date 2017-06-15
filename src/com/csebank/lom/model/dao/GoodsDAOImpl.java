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

import com.csebank.lom.model.Goods;
import com.csebank.lom.model.condition.GoodsSearchCond;
import com.csebank.lom.model.entity.GoodsTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * �Ӵ�����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class GoodsDAOImpl extends BaseHibernateDAOImpl<Goods> implements GoodsDAO {

	/**
	 * ���캯��
	 */
	public GoodsDAOImpl(){
		super(GoodsTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Goods> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("gid"));
		List<Goods> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Goods findByPK(Serializable gid) {

		Goods result = super.findByPK(gid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GoodsSearchCond cond){
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
	public List<Goods> findByCond(final GoodsSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("gid"));
		List<Goods> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	public List<Goods> findByCond(final String gcategory){
		DetachedCriteria c = getCriteria(gcategory);
		c.addOrder(Order.desc("gid"));
		List<Goods> ret = findByCriteria(c, 0, 0);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(GoodsSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��Ʒ��ϢID
		if(cond.getGid()!=null && cond.getGid()!=0){
			c.add(Expression.eq("gid", cond.getGid()));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGname())){
			c.add(Expression.like("gname", "%"+cond.getGname()+"%"));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGcategory())){
			c.add(Expression.like("gcategory", cond.getGcategory()+"%"));
		}
		
		//��Ʒ���
		if(StringUtils.isNotEmpty(cond.getGcode())){
			c.add(Expression.eq("gcode", cond.getGcode()));
		}
		
		//��Ʒ״̬
		if(StringUtils.isNotEmpty(cond.getGstatus())){
			c.add(Expression.eq("gstatus", cond.getGstatus()));
		}
		
		return c;
	}
	
	protected DetachedCriteria getCriteria(String cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��ƷID
		if(StringUtils.isNotEmpty(cond)){
			c.add(Expression.like("gcode", cond+"%"));
		}
		
		return c;
	}

}
