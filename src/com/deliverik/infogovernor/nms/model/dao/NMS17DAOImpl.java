/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.nms.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS17Info;
import com.deliverik.infogovernor.nms.model.condition.NMS17SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS17TB;

/**
  * 概述: 子网区域信息DAO实现
  * 功能描述: 子网区域信息DAO实现
  * 创建记录: 2014/01/07
  * 修改记录: 
  */
public class NMS17DAOImpl extends
		BaseHibernateDAOImpl<NMS17Info> implements NMS17DAO {

	/**
	 * 构造函数
	 */
	public NMS17DAOImpl(){
		super(NMS17TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<NMS17Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS17Info findByPK(Serializable pk) {
		NMS17Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final NMS17SearchCond cond){
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
	public List<NMS17Info> findByCond(final NMS17SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS17SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(null != cond.getGid()){
		    c.add(Restrictions.eq("gid", cond.getGid()));
		}
		if(null != cond.getGversion()){
		    c.add(Restrictions.eq("gversion", cond.getGversion()));
		}
		if(StringUtils.isNotEmpty(cond.getUserid())){
		    c.add(Restrictions.eq("userid", cond.getUserid()));
		}
		return c;
	}

}