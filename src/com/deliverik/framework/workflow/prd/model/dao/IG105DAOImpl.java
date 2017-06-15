/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG105TB;

/**
 * 概述: 流程策略设定信息DAO实现
 * 功能描述：流程策略设定信息DAO实现
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
@SuppressWarnings("deprecation")
public class IG105DAOImpl extends
		BaseHibernateDAOImpl<IG105Info> implements IG105DAO {

	/**
	 * 构造函数
	 */
	public IG105DAOImpl() {
		super(IG105TB.class);
	}

	/**
	 * 功能：全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<IG105Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		List<IG105Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * 
	 * @param pk主键
	 * @return 检索结果
	 */
	public IG105Info findByPK(Serializable pk) {

		IG105Info result = super.findByPK(pk);
		if (result == null)
			return null;

		return result;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG105SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG105Info> findByCond(
			final IG105SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<IG105Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG105SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//流程ID
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		//版本号
		if(cond.getPsdversion() != null && cond.getPsdversion() > 0){
			c.add(Expression.eq("psdversion", cond.getPsdversion()));
		}
		//流程状态
		if(StringUtils.isNotEmpty(cond.getPrstatus())){
			c.add(Expression.eq("prstatus", cond.getPrstatus()));
		}
		//流程紧急程度
		if(StringUtils.isNotEmpty(cond.getPrurgency())){
			c.add(Expression.eq("prurgency", cond.getPrurgency()));
		}
		return c;
	}
	
	/**
	 * 功能：获取指定流程定义ID当前策略最大版本号
	 * @param pdid流程定义ID
	 * @return 当前策略最大版本号
	 */
	@SuppressWarnings("rawtypes")
	public Integer getMaxgPsdversion(String pdid){
		String sql =  "SELECT MAX(psd.psdversion) FROM IG105TB psd WHERE psd.pdid = :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return 0;
		if(l.get(0) == null)return 0;
		return (Integer) l.get(0);
	}

}
