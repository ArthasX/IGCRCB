/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.SmsMessageLogInfo;
import com.deliverik.infogovernor.sym.model.condition.SmsMessageLogSearchCond;
import com.deliverik.infogovernor.sym.model.entity.SmsMessageLogTB;

/**
  * 概述: 短信日志信息表DAO实现
  * 功能描述: 短信日志信息表DAO实现
  * 创建记录: 2012/02/20
  * 修改记录: 
  */
public class SmsMessageLogDAOImpl extends
		BaseHibernateDAOImpl<SmsMessageLogInfo> implements SmsMessageLogDAO {

	/**
	 * 构造函数
	 */
	public SmsMessageLogDAOImpl(){
		super(SmsMessageLogTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SmsMessageLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SmsMessageLogInfo findByPK(Serializable pk) {
		SmsMessageLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SmsMessageLogSearchCond cond){
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
	public List<SmsMessageLogInfo> findByCond(final SmsMessageLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SmsMessageLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}