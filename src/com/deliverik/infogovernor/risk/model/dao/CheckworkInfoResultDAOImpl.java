/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckworkInfoResultTB;

/**
  * 概述: 检查工作检查任务关联表DAO实现
  * 功能描述: 检查工作检查任务关联表DAO实现
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CheckworkInfoResultDAOImpl extends
		BaseHibernateDAOImpl<CheckworkInfoResultInfo> implements CheckworkInfoResultDAO {

	/**
	 * 构造函数
	 */
	public CheckworkInfoResultDAOImpl(){
		super(CheckworkInfoResultTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckworkInfoResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckworkInfoResultInfo findByPK(Serializable pk) {
		CheckworkInfoResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CheckworkInfoResultSearchCond cond){
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
	public List<CheckworkInfoResultInfo> findByCond(final CheckworkInfoResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CheckworkInfoResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//检查工作id
		if( cond.getRcrid()!=null && !(cond.getRcrid().equals("0"))){
			c.add(Restrictions.eq("rcrid",cond.getRcrid()));
		}
		//检查任务id
		if( cond.getCwrid()!=null && !(cond.getCwrid().equals("0"))){
			c.add(Restrictions.eq("cwrid", cond.getCwrid()));
		}
		//主键id
		if( cond.getCwirid()!=null && !(cond.getCwirid().equals("0"))){
			c.add(Restrictions.eq("cwirid", cond.getCwirid()));
		}
		return c;
	}

}