/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.TOPOXMLTB;

/**
  * 概述: TOPOXMLDAO实现
  * 功能描述: TOPOXMLDAO实现
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public class TOPOXMLDAOImpl extends
		BaseHibernateDAOImpl<TOPOXMLInfo> implements TOPOXMLDAO {

	/**
	 * 构造函数
	 */
	public TOPOXMLDAOImpl(){
		super(TOPOXMLTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TOPOXMLInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TOPOXMLInfo findByPK(Serializable pk) {
		TOPOXMLInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TOPOXMLSearchCond cond){
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
	public List<TOPOXMLInfo> findByCond(final TOPOXMLSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(TOPOXMLSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();

		if(StringUtils.isNotEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid() ));
		}
		if(StringUtils.isNotEmpty(cond.getIsellipsis())){
			c.add(Expression.eq("isellipsis", cond.getIsellipsis() ));
		}
		return c;
	}
	/**
	 * 根据用户删除对象
	 * @param userid 用户ID
	 * */
	public boolean deleteTOPOXMLByUserid(final String userid){
		HibernateCallback action=new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				session.flush();
				StringBuffer sb=new StringBuffer();
				sb.append("delete from topoxml where userid='"+userid+"'");
				SQLQuery q=session.createSQLQuery(sb.toString());
				q.executeUpdate();
				return true;
			}
		};
		
		return (Boolean)execute(action);
	}

}