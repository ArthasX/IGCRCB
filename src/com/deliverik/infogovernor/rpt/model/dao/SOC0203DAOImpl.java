/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.rpt.model.dao;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCond;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.entity.SOC0203TB;


/**
 * 
 * @Description:自动报表配置列表DAO实现
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将ReportConfigurationDAOImpl表名改为SOC0203DAOImpl
 */
@SuppressWarnings("deprecation")
public class SOC0203DAOImpl extends BaseHibernateDAOImpl<SOC0203Info> implements SOC0203DAO {
   /**
    * 构造函数
    */
   public SOC0203DAOImpl(){
       super(SOC0203TB.class);
   }
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<SOC0203Info> findAll() {
       List<SOC0203Info> ret = findByCond(new SOC0203SearchCondImpl(), 0, 0);
       return ret;
   }
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public SOC0203Info findByPK(Serializable id) {
       SOC0203Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final SOC0203SearchCond cond){
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
   public List<SOC0203Info> findByCond(final SOC0203SearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<SOC0203Info> ret = findByCriteria(c, start, count);
       return ret;
   }
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   protected DetachedCriteria getCriteria(SOC0203SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getDataid())){
    	   c.add(Expression.eq("dataid", cond.getDataid()));
       }
       return c;
   }
}

