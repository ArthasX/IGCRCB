/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.condition.CustomConfigurationSearchCond;
import com.deliverik.infogovernor.sym.model.entity.CustomConfigurationTB;

/**
  * 概述: 自定义流程配置表DAO实现
  * 功能描述: 自定义流程配置表DAO实现
  * 创建记录: 2012/11/05
  * 修改记录: 
  */
public class CustomConfigurationDAOImpl extends
		BaseHibernateDAOImpl<CustomConfigurationInfo> implements CustomConfigurationDAO {

	/**
	 * 构造函数
	 */
	public CustomConfigurationDAOImpl(){
		super(CustomConfigurationTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CustomConfigurationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CustomConfigurationInfo findByPK(Serializable pk) {
		CustomConfigurationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CustomConfigurationSearchCond cond){
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
	public List<CustomConfigurationInfo> findByCond(final CustomConfigurationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CustomConfigurationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}