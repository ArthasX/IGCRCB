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
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0202SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0202TB;

/**
  * 概述: 附加报表DAO实现
  * 功能描述: 附加报表DAO实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/09 将ReportAnnexationDAOImpl表名改为SOC0202DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0202DAOImpl extends
		BaseHibernateDAOImpl<SOC0202Info> implements SOC0202DAO {

	/**
	 * 构造函数
	 */
	public SOC0202DAOImpl(){
		super(SOC0202TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0202Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0202Info findByPK(Serializable pk) {
		SOC0202Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0202SearchCond cond){
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
	public List<SOC0202Info> findByCond(final SOC0202SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0202SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getRaUserName_eq())){
			c.add(Expression.eq("raUserName", cond.getRaUserName_eq()));
		}
		return c;
	}

}