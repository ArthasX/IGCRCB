/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.dbm.model.dao;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.entity.ChangeTendencyTB;



/**
 * 
 * @Description:变更趋势统计表DAO实现
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class ChangeTendencyDAOImpl extends BaseHibernateDAOImpl<ChangeTendency> implements ChangeTendencyDAO {
	
   /**
    * 构造函数
    */
   public ChangeTendencyDAOImpl(){
       super(ChangeTendencyTB.class);
   }
   
   
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final ChangeTendencySearchCond cond){
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
   public List<ChangeTendency> findByCond(final ChangeTendencySearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<ChangeTendency> ret = findByCriteria(c, start, count);
       return ret;
   }
   
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   protected DetachedCriteria getCriteria(ChangeTendencySearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getCtyear())){
			c.add(Expression.eq("ctyear", cond.getCtyear()));
       }
       if(StringUtils.isNotEmpty(cond.getCtmonth())){
			c.add(Expression.eq("ctmonth", cond.getCtmonth()));
       }
       if(StringUtils.isNotEmpty(cond.getCtday())){
			c.add(Expression.eq("ctday", cond.getCtday()));
       }

       return c;
   }
}

