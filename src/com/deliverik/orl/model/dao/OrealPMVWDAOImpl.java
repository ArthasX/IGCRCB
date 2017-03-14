/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.orl.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.orl.model.OrealPMVWInfo;
import com.deliverik.orl.model.condition.OrealPMVWSearchCond;
import com.deliverik.orl.model.entity.OrealPMVW;

/**
 * 概述：欧莱雅监控指标视图DAO实现
 * 功能描述：欧莱雅监控指标视图DAO实现
 * 创建人：Lu Jiayuan
 * 创建记录： 2014/02/26
 * 修改记录：
 */
@SuppressWarnings("deprecation")
public class OrealPMVWDAOImpl extends BaseHibernateDAOImpl<OrealPMVWInfo> implements OrealPMVWDAO {

	/**
	 * 构造函数
	 */
	public OrealPMVWDAOImpl(){
		super(OrealPMVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OrealPMVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public OrealPMVWInfo findByPK(Serializable pk) {
		OrealPMVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 * @throws BLException 
	 */
	public int getSearchCount(final OrealPMVWSearchCond cond) throws BLException{
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
	 * @throws BLException 
	 */
	public List<OrealPMVWInfo> findByCond(final OrealPMVWSearchCond cond, final int start, final int count) throws BLException{
		DetachedCriteria c = getCriteria(cond);
		
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 * @throws BLException 
	 */
	protected DetachedCriteria getCriteria(OrealPMVWSearchCond cond) throws BLException{
		DetachedCriteria c = getDetachedCriteria();
		
		//当是否监控(标识)不为空时
		if(StringUtils.isNotEmpty(cond.getEnabled_eq())){
			c.add(Expression.eq("enabled", new Integer(cond.getEnabled_eq())));
		}
		//当平台名称不为空时
		if(StringUtils.isNotEmpty(cond.getPlatform_name_like())){
			c.add(Expression.like("platform_name", "%"+cond.getPlatform_name_like()+"%"));
		}
		//当平台名称(in)不为空时
		if(cond.getPlatform_name_in() != null){
			c.add(Expression.in("platform_name", cond.getPlatform_name_in()));
		}
		
		return c;
	}
}