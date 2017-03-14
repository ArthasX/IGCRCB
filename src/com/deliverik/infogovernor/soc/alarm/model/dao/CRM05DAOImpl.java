/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM05TB;

/**
  * 概述: CRM05DAO实现
  * 功能描述: CRM05DAO实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CRM05DAOImpl extends
		BaseHibernateDAOImpl<CRM05Info> implements CRM05DAO {

	/**
	 * 构造函数
	 */
	public CRM05DAOImpl(){
		super(CRM05TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM05Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM05Info findByPK(Serializable pk) {
		CRM05Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CRM05SearchCond cond){
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
	public List<CRM05Info> findByCond(final CRM05SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		
		c.addOrder(Order.desc("uploadtime"));//按照时间由近到远排序
		
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CRM05SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getFilename_like())){
			c.add( Expression.like("filename", "%"+cond.getFilename_like()+"%") );
		}
		if(StringUtils.isNotEmpty(cond.getUploadtime_begin() )){
			c.add( Expression.ge("uploadtime", cond.getUploadtime_begin()+" 00:00:00") );
		}
		if(StringUtils.isNotEmpty(cond.getUploadtime_end() )){
			c.add( Expression.le("uploadtime", cond.getUploadtime_end()+" 23:59:59") );
		}
		return c;
	}

}