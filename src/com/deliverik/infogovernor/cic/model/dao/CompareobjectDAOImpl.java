/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectTB;

/**
  * 概述: 对比对象DAO实现
  * 功能描述: 对比对象DAO实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CompareobjectDAOImpl extends
		BaseHibernateDAOImpl<CompareobjectInfo> implements CompareobjectDAO {

	/**
	 * 构造函数
	 */
	public CompareobjectDAOImpl(){
		super(CompareobjectTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<CompareobjectInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public CompareobjectInfo findByPK(Serializable pk) {
		CompareobjectInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareobjectSearchCond cond){
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
	public List<CompareobjectInfo> findByCond(final CompareobjectSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CompareobjectSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 规则表主键
		if (null != cond.getFkCrid_eq()) {
		    c.add(Restrictions.eq("fkCrid", cond.getFkCrid_eq()));
		}
		
		// 规则表版本
		if (null != cond.getCrversion_eq()) {
		    c.add(Restrictions.eq("crversion", cond.getCrversion_eq()));
		}
		return c;
	}
	
	/**
	 * 转移对比对象到 历史表中
	 * @param crid
	 * @return
	 */
	public boolean toHistory(Integer crid){
		getSession().flush();
		String sql="insert into compareobject_h(cohid,coid,fkcrid,coname,cotarget,cosource,sourceip,targetip,crversion,fingerprint) " +
				"select nextval ('compareobject_h_seq') ,coid,fkcrid,coname,cotarget,cosource,sourceip,targetip,crversion,fingerprint from compareobject where fkcrid= "+crid +";" ;
						
		Query q = getSession().createSQLQuery(sql);
		
		return q.executeUpdate()>0;
	}
	
	/**
	 * 根据规则删除对比对象
	 * @param crid
	 * @return
	 */
	public boolean delByCrid(Integer crid){
		String sql="delete from compareobject where fkcrid="+crid;
		Query q = getSession().createSQLQuery(sql);
		
		return q.executeUpdate()>0;
	}

}