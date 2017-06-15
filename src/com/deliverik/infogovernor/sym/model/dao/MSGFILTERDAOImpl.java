/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;
import com.deliverik.infogovernor.sym.model.entity.MSGFILTERTB;

/**
  * 概述: MSGFILTERDAO实现
  * 功能描述: MSGFILTERDAO实现
  * 创建记录: 2013/08/21
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class MSGFILTERDAOImpl extends
		BaseHibernateDAOImpl<MSGFILTERInfo> implements MSGFILTERDAO {

	/**
	 * 构造函数
	 */
	public MSGFILTERDAOImpl(){
		super(MSGFILTERTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MSGFILTERInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MSGFILTERInfo findByPK(Serializable pk) {
		MSGFILTERInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MSGFILTERSearchCond cond){
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
	public List<MSGFILTERInfo> findByCond(final MSGFILTERSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(MSGFILTERSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//当告警IP不为空时
		if(cond!=null){
			if (StringUtils.isNotEmpty(cond.getDeviceip())) {
				c.add(Restrictions.like("deviceip", "%" + cond.getDeviceip() + "%"));
				}
			}
		return c;
	}

}