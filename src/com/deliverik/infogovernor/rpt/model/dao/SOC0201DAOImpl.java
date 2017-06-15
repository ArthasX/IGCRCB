/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.rpt.model.dao;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0201TB;


/**
 * 
 * @Description:自动报表生成表DAO实现
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将REPORT_GDATA_ITEMDAOImpl表名改为SOC0201DAOImpl
 */
@SuppressWarnings("deprecation")
public class SOC0201DAOImpl extends BaseHibernateDAOImpl<SOC0201Info> implements SOC0201DAO {
   /**
    * 构造函数
    */
   public SOC0201DAOImpl(){
       super(SOC0201TB.class);
   }
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<SOC0201Info> findAll() {
       return null;
   }
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public SOC0201Info findByPK(Serializable id) {
       SOC0201Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final SOC0201SearchCond cond){
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
   public List<SOC0201Info> findByCond(final SOC0201SearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       c.addOrder(Order.desc("r_time"));
       List<SOC0201Info> ret = findByCriteria(c, start, count);
       return ret;
   }
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   protected DetachedCriteria getCriteria(SOC0201SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty( cond.getR_path())){
			c.add(Expression.eq("r_path", cond.getR_path()));
		}
       if(cond.getR_rcid()!=null&&cond.getR_rcid()!=0){
			c.add(Expression.eq("r_rcid", cond.getR_rcid()));
       }
       if(StringUtils.isNotEmpty( cond.getR_time())){
			c.add(Expression.eq("r_time", cond.getR_time()));
		}
       if(StringUtils.isNotEmpty( cond.getR_category())){
			c.add(Expression.eq("r_category", cond.getR_category()));
		}
       return c;
   }
}

