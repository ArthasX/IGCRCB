/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;

/**
  * 概述: ErRelationDAO实现
  * 功能描述: ErRelationDAO实现
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public class ErRelationDAOImpl extends
		BaseHibernateDAOImpl<ErRelationInfo> implements ErRelationDAO {

	/**
	 * 构造函数
	 */
	public ErRelationDAOImpl(){
		super(ErRelationTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ErRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ErRelationInfo findByPK(Serializable pk) {
		ErRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ErRelationSearchCond cond){
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
	public List<ErRelationInfo> findByCond(final ErRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ErRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("errid"));
		//ercode
		if(StringUtils.isNotEmpty(cond.getErcode())){
			c.add(Restrictions.like("ercode", cond.getErcode()+"%"));
		}
		//erid
		if(cond.getErid()!=null&&cond.getErid()>0){
			c.add(Restrictions.eq("erid", cond.getErid()));
		}
		//eiid
		if(StringUtils.isNotEmpty(cond.getEiid())){
			c.add(Restrictions.eq("eiid", cond.getEiid()));
		}
		//deleteflag
		if(StringUtils.isNotEmpty(cond.getDeleteflag())){
			if("NOTONE".equals(cond.getDeleteflag())){
				c.add(Restrictions.not(Restrictions.eq("deleteflag", "1")));
			}else{
				c.add(Restrictions.eq("deleteflag", cond.getDeleteflag()));
			}
		}
		
		if(StringUtils.isNotEmpty(cond.getResourceType())){
			c.add(Restrictions.eq("fingerPrint", cond.getResourceType()));
		}
		
		return c;
	}

}