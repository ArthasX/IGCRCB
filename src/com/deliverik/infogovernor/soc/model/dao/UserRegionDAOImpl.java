/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCond;
import com.deliverik.infogovernor.soc.model.entity.UserRegionTB;

/**
  * 概述: UserRegionDAO实现
  * 功能描述: UserRegionDAO实现
  * 创建记录: 2014/01/10
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class UserRegionDAOImpl extends
		BaseHibernateDAOImpl<UserRegionInfo> implements UserRegionDAO {

	/**
	 * 构造函数
	 */
	public UserRegionDAOImpl(){
		super(UserRegionTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<UserRegionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public UserRegionInfo findByPK(Serializable pk) {
		UserRegionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final UserRegionSearchCond cond){
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
	public List<UserRegionInfo> findByCond(final UserRegionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(UserRegionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( StringUtils.isNotEmpty(cond.getFLEXID()) ){
			c.add(Expression.eq("flexID", cond.getFLEXID() ));
		}
		if( StringUtils.isNotEmpty(cond.getUSERID()) ){
			c.add(Expression.eq("UserID", cond.getUSERID() ));
		}
		return c;
	}

}