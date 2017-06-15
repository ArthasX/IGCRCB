/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowLogTB;

/**
  * 概述: knowLogDAO实现
  * 功能描述: knowLogDAO实现
  * 创建记录: 2011/05/30
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class KnowLogDAOImpl extends
		BaseHibernateDAOImpl<KnowLogInfo> implements KnowLogDAO {

	/**
	 * 构造函数
	 */
	public KnowLogDAOImpl(){
		super(KnowLogTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<KnowLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public KnowLogInfo findByPK(Serializable pk) {
		KnowLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowLogSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowLogInfo> findByCond(final KnowLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("klid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(KnowLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( cond.getKlkid() !=null && !"0".equals(cond.getKlkid())){
			c.add(Expression.eq("klkid", cond.getKlkid()));
		}
		return c;
	}

}