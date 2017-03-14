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
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0405TB;

/**
  * 概述: 逻辑卷容量实时表DAO实现
  * 功能描述: 逻辑卷容量实时表DAO实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将LVCapacityRealTimeDAOImpl表名改为SOC0405DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0405DAOImpl extends
		BaseHibernateDAOImpl<SOC0405Info> implements SOC0405DAO {

	/**
	 * 构造函数
	 */
	public SOC0405DAOImpl(){
		super(SOC0405TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0405Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0405Info findByPK(Serializable pk) {
		SOC0405Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0405SearchCond cond){
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
	public List<SOC0405Info> findByCond(final SOC0405SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0405SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getHostName_eq())) {
			c.add(Expression.eq("hostName", cond.getHostName_eq()));
		}
		if (cond.getFsName_neq()!=null) {
			c.add(Expression.ne("fsName", cond.getFsName_neq()));
		}
		if (!StringUtils.isEmpty(cond.getLvState_eq())) {
			c.add(Expression.eq("lvState", cond.getLvState_eq()));
		}
		if (!StringUtils.isEmpty(cond.getLvType_ne())) {
			c.add(Expression.ne("lvType", cond.getLvType_ne()));
		}
		if (!StringUtils.isEmpty(cond.getLvType_eq())) {
			c.add(Expression.eq("lvType", cond.getLvType_eq()));
		}
		if (!StringUtils.isEmpty(cond.getVgName_eq())) {
			c.add(Expression.eq("vgName", cond.getVgName_eq()));
		}
		return c;
	}

}