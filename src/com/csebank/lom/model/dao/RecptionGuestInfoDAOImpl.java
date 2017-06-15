/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 发票管理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class RecptionGuestInfoDAOImpl extends BaseHibernateDAOImpl<RecptionGuestInfo> implements RecptionGuestInfoDAO {

	/**
	 * 构造函数
	 */
	public RecptionGuestInfoDAOImpl(){
		super(RecptionGuestInfoTB.class);
	}
   
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RecptionGuestInfo> findByCond(final RecptionGuestInfoCond cond, final int start,
			final int count) {		
			DetachedCriteria c = getCriteria(cond);
			c.addOrder(Order.asc("rid"));
			List<RecptionGuestInfo> ret = findByCriteria(c, start, count);
			return ret;
		
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RecptionGuestInfoCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(final RecptionGuestInfoCond cond){
		DetachedCriteria c = getDetachedCriteria();
		

		//来宾单位
		if( !StringUtils.isEmpty(cond.getRgunit())){
			c.add(Expression.like("rgunit", "%"+cond.getRgunit()+"%"));
		}	
		
		//来宾姓名
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
