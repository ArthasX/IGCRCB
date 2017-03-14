/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;

/**
  * 概述: 提醒配置表DAO实现
  * 功能描述: 提醒配置表DAO实现
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class RemindConfigureDAOImpl extends
		BaseHibernateDAOImpl<RemindConfigureInfo> implements RemindConfigureDAO {

	/**
	 * 构造函数
	 */
	public RemindConfigureDAOImpl(){
		super(RemindConfigureTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RemindConfigureInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RemindConfigureInfo findByPK(Serializable pk) {
		RemindConfigureInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RemindConfigureSearchCond cond){
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
	public List<RemindConfigureInfo> findByCond(final RemindConfigureSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RemindConfigureSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//年
		if(StringUtils.isNotEmpty(cond.getRcyear())){
			c.add(Expression.eq("rcyear", cond.getRcyear()));
		}
		//类型
		if(StringUtils.isNotEmpty(cond.getRctype())){
			c.add(Expression.eq("rctype", cond.getRctype()));
		}
		return c;
	}

}