/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0415SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0415TB;

/**
  * 概述: 表空间容量实时表DAO实现
  * 功能描述: 表空间容量实时表DAO实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/10 将TSCapacityRealTimeDAOImpl表名修改为SOC0415DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0415DAOImpl extends
		BaseHibernateDAOImpl<SOC0415Info> implements SOC0415DAO {

	/**
	 * 构造函数
	 */
	public SOC0415DAOImpl(){
		super(SOC0415TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0415Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0415Info findByPK(Serializable pk) {
		SOC0415Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0415SearchCond cond){
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
	public List<SOC0415Info> findByCond(final SOC0415SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0415SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getHostName_eq())) {
			c.add(Expression.eq("hostName", cond.getHostName_eq()));
		}
		if (!StringUtils.isEmpty(cond.getDbName_eq())) {
			c.add(Expression.eq("dbName", cond.getDbName_eq()));
		}
		return c;
	}

}