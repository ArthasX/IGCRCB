/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoRiskSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoRiskTB;

/**
  * 概述: 检查策略关联检查项表DAO实现
  * 功能描述: 检查策略关联检查项表DAO实现
  * 创建记录: 2014/09/03
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CheckInfoRiskDAOImpl extends
		BaseHibernateDAOImpl<CheckInfoRiskInfo> implements CheckInfoRiskDAO {

	/**
	 * 构造函数
	 */
	public CheckInfoRiskDAOImpl(){
		super(CheckInfoRiskTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckInfoRiskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckInfoRiskInfo findByPK(Serializable pk) {
		CheckInfoRiskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CheckInfoRiskSearchCond cond){
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
	public List<CheckInfoRiskInfo> findByCond(final CheckInfoRiskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CheckInfoRiskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getCsid()!=null && !(cond.getCsid().equals("0"))){
			c.add(Restrictions.eq("csid", cond.getCsid()));
		}
		return c;
	}

}