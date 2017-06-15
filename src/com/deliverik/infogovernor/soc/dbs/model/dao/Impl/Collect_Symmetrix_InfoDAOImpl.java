/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao.Impl;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_InfoDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;


/**
 * 
 * @Description:存储基本信息DAO实现
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_InfoDAOImpl extends BaseHibernateDAOImpl<Collect_Symmetrix_Info> implements Collect_Symmetrix_InfoDAO {
   /**
    * 构造函数
    */
   public Collect_Symmetrix_InfoDAOImpl(){
       super(Collect_Symmetrix_InfoTB.class);
   }
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<Collect_Symmetrix_Info> findAll() {
	   DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
   }
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public Collect_Symmetrix_Info findByPK(Serializable id) {
       Collect_Symmetrix_Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final Collect_Symmetrix_InfoSearchCond cond){
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
   public List<Collect_Symmetrix_Info> findByCond(final Collect_Symmetrix_InfoSearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteria(cond);
	   c.addOrder(Order.asc("symm_id"));
		List<Collect_Symmetrix_Info> ret = findByCriteria(c, start, count);
		return ret;
   }
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   @SuppressWarnings("deprecation")
protected DetachedCriteria getCriteria(Collect_Symmetrix_InfoSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
     
		if(StringUtils.isNotEmpty(cond.getSymm_id())) {
			c.add(Expression.eq("symm_id", cond.getSymm_id()));
		}
		
		//存储名称
		if(StringUtils.isNotEmpty(cond.getSymm_id_like())){
			c.add(Expression.like("symm_id", "%"+cond.getSymm_id_like()+"%"));
		}
		
		//存储类型
		if(StringUtils.isNotEmpty(cond.getSymm_type())){
			c.add(Expression.eq("symm_type", cond.getSymm_type()));
		}
		
		//存储类型
		if(cond.getSymm_typeStr()!=null&&cond.getSymm_typeStr().length>0){
			c.add(Expression.in("symm_type", cond.getSymm_typeStr()));
		}
       return c;
   }
}

