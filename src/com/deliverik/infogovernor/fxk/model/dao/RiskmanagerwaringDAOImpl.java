/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskmanagerwaringSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.RiskmanagerwaringTB;

/**
  * 概述: 风险管理提示数据表DAO实现
  * 功能描述: 风险管理提示数据表DAO实现
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public class RiskmanagerwaringDAOImpl extends
		BaseHibernateDAOImpl<RiskmanagerwaringInfo> implements RiskmanagerwaringDAO {

	/**
	 * 构造函数
	 */
	public RiskmanagerwaringDAOImpl(){
		super(RiskmanagerwaringTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskmanagerwaringInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskmanagerwaringInfo findByPK(Serializable pk) {
		RiskmanagerwaringInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskmanagerwaringSearchCond cond){
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
	public List<RiskmanagerwaringInfo> findByCond(final RiskmanagerwaringSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rwid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskmanagerwaringSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//风险名称(完全匹配)
		if(StringUtils.isNotEmpty(cond.getRwname())){
			c.add(Restrictions.like("rwname", cond.getRwname()+"%"));
		}
		//下发人员名称(完全匹配)
		if(StringUtils.isNotEmpty(cond.getNusername())){
			c.add(Restrictions.eq("nusername", cond.getNusername()));
		}
		//下接受人员名称(完全匹配)
		if(StringUtils.isNotEmpty(cond.getUsername_s())){
			c.add(Restrictions.sqlRestriction(" exists (select 1 from  acceptuser a where this_.rwid=a.rwid and  a.apusername like '%" + cond.getUsername_s() + "%') "));
		}
		//下发时间(完全匹配)
		if(StringUtils.isNotEmpty(cond.getNtime())){
			c.add(Restrictions.like("ntime", cond.getNtime()+"%"));
		}
		//下发人员部门ID(完全匹配)
		if(StringUtils.isNotEmpty(cond.getNorgid())){
			c.add(Restrictions.eq("norgid", cond.getNorgid()));
		}
		
		return c;
	}

}