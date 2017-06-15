/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.soc.mnt.model.dao;

 import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0306TB;


/**
 * 
 * @Description:软件部署信息视图DAO实现
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class SOC0306DAOImpl extends BaseHibernateDAOImpl<SOC0306Info> implements SOC0306DAO {
   /**
    * 构造函数
    */
   public SOC0306DAOImpl(){
       super(SOC0306TB.class);
   }
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<SOC0306Info> findAll() {
	   DetachedCriteria c= getDetachedCriteria();
	   c.addOrder(Order.desc("id"));
	   List<SOC0306Info> ret = findByCriteria(c);
       return ret;
   }
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public SOC0306Info findByPK(Serializable id) {
       SOC0306Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final SOC0306SearchCond cond){
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
   public List<SOC0306Info> findByCond(final SOC0306SearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<SOC0306Info> ret = findByCriteria(c, start, count);
       return ret;
   }
   
   /**
    * 查询缺失的性能导入数据
    * @param yestoday 昨天的日期
    * @return 检索结果列表
    */
   @SuppressWarnings("unchecked")
   public List searchSymmetrixAlarm(final String yestoday){
	   HibernateCallback action = new  HibernateCallback(){

		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			session.flush();
			StringBuffer query = new StringBuffer();
			query.append("SELECT SYMM_ID,SYMM_TYPE FROM (");
			query.append(" SELECT SYMM_ID,SYMM_TYPE FROM COLLECT_SYMMETRIX_INFO  AS A ");
			query.append(" LEFT JOIN (SELECT SYMID,DATA_TIMES FROM COLLECT_SYSTEM_DAY WHERE DATA_TIMES='"+yestoday+"' UNION");
			query.append(" SELECT DATAID,POLL_TIME AS DATA_TIMES FROM CX_COLLECT_PORT_DAY WHERE POLL_TIME='"+yestoday+"' UNION");
			query.append(" SELECT SYMM_ID AS DATAID,SAVETIME AS DATA_TIMES FROM COLLECT_SYMMETRIX_MONITOR_DAY WHERE SAVETIME='"+yestoday+"' UNION");
			query.append(" SELECT DATAID,DATA_TIMES FROM COLLECT_PORT_LEVEL_STATISTICS_DAY WHERE DATA_TIMES='"+yestoday+"') AS B ");
			query.append(" ON A.SYMM_ID = B.SYMID WHERE B.DATA_TIMES IS NULL");
			query.append(" ) E GROUP BY SYMM_ID,SYMM_TYPE");
			SQLQuery q = session.createSQLQuery(query.toString());
			List list = q.list();
			session.clear();
			return list;
		}
		   
	   };
	   
	   return (List) execute(action);
   }
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
protected DetachedCriteria getCriteria(SOC0306SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getSymmid())){
    	   c.add(Expression.eq("symmid", cond.getSymmid()));
       }
       //告警时间从
		if( !StringUtils.isEmpty(cond.getDataitmes_f())){
			c.add(Expression.ge("dataitmes", cond.getDataitmes_f()));
		}
		 //告警时间到
		if( !StringUtils.isEmpty(cond.getDataitmes_t())){
			c.add(Expression.le("dataitmes", cond.getDataitmes_t()));
		}
		//新告警
		if( StringUtils.isEmpty(cond.getReaddate())){
			c.add(Expression.or(Expression.isNull("readdate"), Expression.eq("readdate","")));
		}
       return c;
   }

}

