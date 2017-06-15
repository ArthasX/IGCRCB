/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindInfoSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RemindInfoTB;

/**
  * 概述: 提醒信息表DAO实现
  * 功能描述: 提醒信息表DAO实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class RemindInfoDAOImpl extends
		BaseHibernateDAOImpl<RemindInfoInfo> implements RemindInfoDAO {

	/**
	 * 构造函数
	 */
	public RemindInfoDAOImpl(){
		super(RemindInfoTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RemindInfoInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RemindInfoInfo findByPK(Serializable pk) {
		RemindInfoInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RemindInfoSearchCond cond){
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
	public List<RemindInfoInfo> findByCond(final RemindInfoSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RemindInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}