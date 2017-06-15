/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.entity.IncidentTendencyTB;



/**
 * 
 * @Description:事件趋势统计表DAO实现
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class IncidentTendencyDAOImpl extends BaseHibernateDAOImpl<IncidentTendency> implements IncidentTendencyDAO {
	
   /**
    * 构造函数
    */
   public IncidentTendencyDAOImpl(){
       super(IncidentTendencyTB.class);
   }
   
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<IncidentTendency> findAll() {
       return null;
   }
   
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public IncidentTendency findByPK(Serializable id) {
       IncidentTendency result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final IncidentTendencySearchCond cond){
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
   public List<IncidentTendency> findByCond(final IncidentTendencySearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<IncidentTendency> ret = findByCriteria(c, start, count);
       return ret;
   }
   
   
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   protected DetachedCriteria getCriteria(IncidentTendencySearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getItyear())){
			c.add(Expression.eq("ityear", cond.getItyear()));
       }
       if(StringUtils.isNotEmpty(cond.getItmonth())){
			c.add(Expression.eq("itmonth", cond.getItmonth()));
       }
       if(StringUtils.isNotEmpty(cond.getItday())){
			c.add(Expression.eq("itday", cond.getItday()));
       }
       if(StringUtils.isNotEmpty(cond.getItdefid())){
			c.add(Expression.eq("itdefid", cond.getItdefid()));
       }
       if(StringUtils.isNotEmpty(cond.getItdefiname())){
			c.add(Expression.eq("itdefiname", cond.getItdefiname()));
       }
       if(StringUtils.isNotEmpty(cond.getItcreateYear())){
			c.add(Expression.eq("itcreateyear", cond.getItcreateYear()));
       }
       if(StringUtils.isNotEmpty(cond.getItcreateMonth())){
			c.add(Expression.eq("itcreatemonth", cond.getItcreateMonth()));
       }
       if(StringUtils.isNotEmpty(cond.getItcreateDay())){
			c.add(Expression.eq("itcreateday", cond.getItcreateDay()));
       }

       return c;
   }
}

