/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG229Info;
import com.deliverik.framework.workflow.prd.model.condition.IG229SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG229TB;

/**
 * 概述:流程评审详细记录表dao实现类
 * 功能描述：针对流程评审详细记录表实体进行操作
 *           
 * 创建记录：wangxiaoqiang    2010/11/29
 */
@SuppressWarnings("deprecation")
public class IG229DAOImpl extends BaseHibernateDAOImpl<IG229Info> implements IG229DAO {
   /**
    * 构造函数
    */
   public IG229DAOImpl(){
       super(IG229TB.class);
   }
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<IG229Info> findAll() {
       return null;
   }
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public IG229Info findByPK(Serializable id) {
       IG229Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final IG229SearchCond cond){
       DetachedCriteria c = getCriteria(cond);
       return getCount(c);
   }
   /**
    * 条件检索处理
    * @param cond 检索条件
    * @param start 检索记录起始行号
    * @param count 检索记录件数
    * @return 检索结果列表
    */
   public List<IG229Info> findByCond(final IG229SearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteria(cond);
	   List<IG229Info> ret = findByCriteria(c, start, count);
	   return ret;
   }
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
 
protected DetachedCriteria getCriteria(IG229SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       
       if(cond.getPadprid()!=null){
    	   c.add(Expression.eq("padprid", cond.getPadprid()));
       }
       return c;
   }
}

