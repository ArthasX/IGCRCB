/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
 package com.deliverik.infogovernor.kgm.model.dao;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeVW;


/**
 * 概述: 最新知识信息DAO实现
 * 功能描述：最新知识信息DAO实现
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public class KnowledgeVWDAOImpl extends BaseHibernateDAOImpl<Knowledge> implements KnowledgeVWDAO {
   /**
    * 构造函数
    */
   public KnowledgeVWDAOImpl(){
       super(KnowledgeVW.class);
   }
   /**
    * 全件检索
    * @return 检索结果集
    */
   public List<Knowledge> findAll() {
       return null;
   }
   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
   public Knowledge findByPK(Serializable pk) {
       Knowledge result = super.findByPK(pk);
       if(result == null) return null;
       return result;
   }
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchCount(final KnowledgeSearchCond cond){
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
   public List<Knowledge> findByCond(final KnowledgeSearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("knapprovetime"));
		List<Knowledge> ret = findByCriteria(c, start, count);
	       return ret;
   }
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   protected DetachedCriteria getCriteria(KnowledgeSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
        //归档人姓名
		if( StringUtils.isNotEmpty(cond.getKnapprovername())){
			c.add(Expression.like("knapprovername", "%" + cond.getKnapprovername() + "%"));
		}
		//知识贡献人姓名
		if( StringUtils.isNotEmpty(cond.getKnproffername())){
			c.add(Expression.like("knproffername", "%" + cond.getKnproffername() + "%"));
		}
		//分类
		if( StringUtils.isNotEmpty(cond.getKnclass())){
			c.add(Expression.eq("knclass", cond.getKnclass()));
		}
		//来源
		if( StringUtils.isNotEmpty(cond.getKnorigin())){
			c.add(Expression.eq("knorigin", cond.getKnorigin()));
		}
		//技术领域
		if( StringUtils.isNotEmpty(cond.getKntelarea())){
			c.add(Expression.eq("kntelarea", cond.getKntelarea()));
		}
		//业务领域
		if( StringUtils.isNotEmpty(cond.getKnarea())){
			c.add(Expression.eq("knarea", cond.getKnarea()));
		}
		//状态
		if( StringUtils.isNotEmpty(cond.getKnstatus())){
			c.add(Expression.in("knstatus", cond.getKnstatus().split(",")));
		}
		//用户
		if( StringUtils.isNotEmpty(cond.getKnproffer())){
			c.add(Expression.eq("knproffer", cond.getKnproffer()));
		}
		//归档时间从
		if(StringUtils.isNotEmpty(cond.getKnapprovetime_f())){
			c.add(Expression.ge("knapprovetime", cond.getKnapprovetime_f()+" 00:00"));
		}
		//归档时间到
		if(StringUtils.isNotEmpty(cond.getKnapprovetime_t())){
			c.add(Expression.le("knapprovetime", cond.getKnapprovetime_t()+" 23:59"));
		}
		//贡献时间从
		if(StringUtils.isNotEmpty(cond.getKnproffertime_f())){
			c.add(Expression.ge("knproffertime", cond.getKnproffertime_f()+" 00:00"));
		}
		//贡献时间到
		if(StringUtils.isNotEmpty(cond.getKnproffertime_t())){
			c.add(Expression.le("knproffertime", cond.getKnproffertime_t()+" 23:59"));
		}
		//关键字
		String[] keys = cond.getKnkeys();
		String keylikesql ="";
		
		if(keys != null && keys.length>0){
			Type [] types = new Type[keys.length];
			for (int i = 0; i < keys.length; i++) {
				
				types[i] = Hibernate.STRING;
				if(i==0){
					keylikesql = keylikesql + " knkey like ? ";
				}else{
					keylikesql = keylikesql + "  or knkey like ? ";
				}
				
				keys[i] = "%" + keys[i] + "%";

			}

			c.add(Restrictions.sqlRestriction(" ( " + keylikesql + " ) ", keys, types));
		}
		
		//标题 和知识描述
		String[] kntitles = cond.getKntitles();
		String titlelikesql ="";
		String deslikesql ="";
		
		if(kntitles != null && kntitles.length>0){
			Type [] types = new Type[kntitles.length*2];
			String [] value = new String[kntitles.length*2];
			for (int i = 0; i < kntitles.length*2; i=i+2) {
				if(i==0){
					titlelikesql = titlelikesql + " kntitle like ?  or kndes like ?";
				}else{
					titlelikesql = titlelikesql + "  or kntitle like ?  or kndes like ? ";
				}
				types[i] = Hibernate.STRING;
				types[i+1] = Hibernate.STRING;
				value[i] = "%" + kntitles[i/2] + "%";
				value[i+1] = "%" + kntitles[i/2] + "%";

			}		
			c.add(Restrictions.sqlRestriction(" ( " + titlelikesql + " ) ", value, types));
		}
       return c;
   }
   
}

