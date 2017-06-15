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
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0428VW;

/**
  * 概述: 业务系统视图DAO实现
  * 功能描述: 业务系统视图DAO实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将BusinessCapacityRealTimeVWDAOImpl表名改为SOC0428DAOImpl
  * 					将含有BusinessCapacityRealTimeVW的方法名中的该字段修改为SOC0428如果是表示对象则修改为小写的soc0428
  */
@SuppressWarnings("deprecation")
public class SOC0428DAOImpl extends
		BaseHibernateDAOImpl<SOC0428Info> implements SOC0428DAO {

	/**
	 * 构造函数
	 */
	public SOC0428DAOImpl(){
		super(SOC0428VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0428Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0428Info findByPK(Serializable pk) {
		SOC0428Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0428SearchCond cond){
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
	public List<SOC0428Info> findByCond(final SOC0428SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0428SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getSName())){
			c.add(Expression.eq("sName", cond.getSName()));
		}
		return c;
	}

}