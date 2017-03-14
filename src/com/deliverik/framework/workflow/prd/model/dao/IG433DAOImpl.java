/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG433TB;
import com.deliverik.framework.workflow.prr.model.IG003Info;



 /**
  * 概述:流程评审DAO实现类
  * 功能描述：针对流程评审实体进行操作
  *           
  * 创建记录：宋海洋    2010/11/26
  */
@SuppressWarnings("deprecation")
public class IG433DAOImpl extends BaseHibernateDAOImpl<IG433Info> implements IG433DAO {
   /**
    * 构造函数
    */
   public IG433DAOImpl(){
       super(IG433TB.class);
   }
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<IG433Info> findAll() {
       return null;
   }
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public IG433Info findByPK(Serializable id) {
       IG433Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final IG433SearchCond cond){
       DetachedCriteria c = getCriteria(cond);
       return getCount(c);
   }

   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   
   protected DetachedCriteria getCriteria(IG433SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       
       if(cond.getPaprid()!=null){
    	   c.add(Expression.eq("paprid", cond.getPaprid()));
       }
       
       return c;
   }
   
   
	/**
	 * 功能：条件检索处理（视图）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG433Info> findByCond(final IG433SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				setFetchPoint(q, start, count);
				List<IG003Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG433Info>) execute(action);
	}
	
	/**
	 * 功能：条件检索处理（实体）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG433Info> findByCond_Entity(
			IG433SearchCond cond, int start, int count) {
		DetachedCriteria c = getCriteria(cond);
		List<IG433Info> ret = findByCriteria(c, start, count);
		lazyLoad(ret);
		return ret;
	}
	
	protected void lazyLoad(List<IG433Info> list){
		if(list==null || list.isEmpty()){
			return ;
		}
		for(IG433Info processAssessment:list){
			Hibernate.initialize(processAssessment.getAttachmentList());
		}
		
		
	}
	
}

