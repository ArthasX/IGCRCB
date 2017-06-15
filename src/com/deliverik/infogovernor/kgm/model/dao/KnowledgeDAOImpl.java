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
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTB;


/**
 * 概述: 知识库信息DAO实现
 * 功能描述：知识库信息DAO实现
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
@SuppressWarnings({"deprecation","rawtypes"})
public class KnowledgeDAOImpl extends BaseHibernateDAOImpl<Knowledge> implements KnowledgeDAO {
   /**
    * 构造函数
    */
   public KnowledgeDAOImpl(){
       super(KnowledgeTB.class);
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
   public Knowledge findByPK(Serializable id) {
       Knowledge result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   
   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
   public int getSearchNotCheckCount(final KnowledgeSearchCond cond){
       DetachedCriteria c = getCriteriaNotCheck(cond);
       return getCount(c);
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
    * 知识序列号取得取得
    * @return 知识序列号取得
    */
   public String getKnserial(){
	   String sql =  "select max(knserial) from KnowledgeTB ";
		NamedParamMap p = getNamedParamMap();
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
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
    * 根据知识id检索当前有效知识处理
    * @param cond 检索条件
    * @return 检索结果列表
    */
   public Knowledge findByKnid(final KnowledgeSearchCond cond){
	   DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("knversion"));
		List<Knowledge> ret = findByCriteria(c, 0, 0);
		if(ret !=null && ret.size()>0){
			return ret.get(0);
		}else{
			return null;
		}
	       
   }
   
   /**
    * 条件检索处理（知识库历史版本查询）
    * @param cond 检索条件
    * @param start 检索记录起始行号
    * @param count 检索记录件数
    * @return 检索结果列表
    */
   public List<Knowledge> findByCond_History(final KnowledgeSearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteriaNotCheck(cond);
		c.addOrder(Order.desc("knversion"));
		List<Knowledge> ret = findByCriteria(c, start, count);
	       return ret;
   }
   
   /**
    * 查询knowledge中是否有没有审批过的记录
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
  
   protected DetachedCriteria getCriteriaNotCheck(KnowledgeSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();

		//id
		if( StringUtils.isNotEmpty(cond.getKnid().toString())){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//状态等于审批或删除：1OR4
		c.add(Expression.or(Expression.eq("knstatus", IGKGMCONSTANTS.KNOWLEDGE_APPROVEED), Expression.eq("knstatus", IGKGMCONSTANTS.KNOWLEDGE_DELETE)));
       return c;
   }
   
   /**
    * 检索条件生成
    * 
    * @param cond 检索条件
    * @return 检索用检索条件类
    */
   protected DetachedCriteria getCriteria(KnowledgeSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       //知识编号
		if( StringUtils.isNotEmpty(cond.getKnserial_like())){
//			c.add(Expression.like("Upper(knserial)", "%" + cond.getKnserial_like().toUpperCase() + "%"));
			c.add(Expression.sql(" Upper(knserial) like "+"'%" + cond.getKnserial_like().toUpperCase() + "%'"));
		}
        //用户
        if(null != cond.getKnid()){
        	if( StringUtils.isNotEmpty(String.valueOf(cond.getKnid()))){
    			c.add(Expression.eq("knid", cond.getKnid()));
    		}
        }
        //知识审批人
        if(cond.getKnapproverole()!=null&&!cond.getKnapproverole().equals(0)){
        	c.add(Expression.eq("knapproverole", cond.getKnapproverole()));
        }
        if(cond.getKnapproveroles()!=null&&cond.getKnapproveroles().length>0){
        	String sql = "";
        	Integer[] kars = cond.getKnapproveroles();
        	int j=0;
        	for(int i=0;i<kars.length;i++){
        		if(kars[i]!=null){
        			
        			if(j==0){
            			sql=" (knapproverole="+kars[i];
            		}else{
            			sql+=" or knapproverole="+kars[i];
            		}
        			j++;
        		}
        	}
        	if(j>0){
    			sql+=")";
    		}
        	c.add(Expression.sql(sql));
        }
        //归档人姓名
		if( StringUtils.isNotEmpty(cond.getKnapprovername())){
//			c.add(Expression.like("knapprovername", "%" + cond.getKnapprovername() + "%"));
			c.add(Expression.sql(" Upper(knapprovername) like "+"'%" + cond.getKnapprovername().toUpperCase() + "%'"));
		}
		//知识贡献人姓名
		if( StringUtils.isNotEmpty(cond.getKnproffername())){
//			c.add(Expression.like("knproffername", "%" + cond.getKnproffername() + "%"));
			c.add(Expression.sql(" Upper(knproffername) like "+"'%" + cond.getKnproffername().toUpperCase() + "%'"));
		}
		//分类
		if( StringUtils.isNotEmpty(cond.getKnclass())){
			c.add(Expression.eq("knclass", cond.getKnclass()));
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
		//来源
		if(StringUtils.isNotEmpty(cond.getKnorigin())){
			c.add(Expression.eq("knorigin", cond.getKnorigin()));
		}
		//技术领域
		if(StringUtils.isNotEmpty(cond.getKntelarea())){
			c.add(Expression.eq("kntelarea", cond.getKntelarea()));
		}
		//关键字
		String[] keys = cond.getKnkeys();
		String keylikesql ="";
		
		if(keys != null && keys.length>0){
			Type [] types = new Type[keys.length];
			for (int i = 0; i < keys.length; i++) {
				
				types[i] = Hibernate.STRING;
				if(i==0){
					keylikesql = keylikesql + " Upper(knkey) like ? ";
				}else{
					keylikesql = keylikesql + "  or Upper(knkey) like ? ";
				}
				
				keys[i] = "%" + keys[i].toUpperCase() + "%";

			}

			c.add(Restrictions.sqlRestriction(" ( " + keylikesql + " ) ", keys, types));
		}
		
		//标题 和知识描述
		String[] kntitles = cond.getKntitles();
		String titlelikesql ="";
		//String deslikesql ="";
		
		if(kntitles != null && kntitles.length>0){
			Type [] types = new Type[kntitles.length*4];
			String [] value = new String[kntitles.length*4];
			for (int i = 0; i < kntitles.length*4; i=i+4) {
				
				
				if(i==0){
					titlelikesql = titlelikesql + " Upper(kntitle) like ?  or Upper(knfaultcause) like ? or Upper(knsolveway) like ? or Upper(kndes) like ?";
					//deslikesql = deslikesql + " kndes like ? ";
				}else{
					titlelikesql = titlelikesql + "  or Upper(kntitle) like ?  or Upper(knfaultcause) like ? or Upper(knsolveway) like ? or Upper(kndes) like ? ";
					//deslikesql = deslikesql + "  or kndes like ? ";
				}
				types[i] = Hibernate.STRING;
				types[i+1] = Hibernate.STRING;
				types[i+2] = Hibernate.STRING;
				types[i+3] = Hibernate.STRING;
				value[i] = "%" + kntitles[i/4].toUpperCase() + "%";
				value[i+1] = "%" + kntitles[i/4].toUpperCase() + "%";
				value[i+2] = "%" + kntitles[i/4].toUpperCase() + "%";
				value[i+3] = "%" + kntitles[i/4].toUpperCase() + "%";

			}
			
			c.add(Restrictions.sqlRestriction(" ( " + titlelikesql + " ) ", value, types));
			
			//c.add(Restrictions.sqlRestriction(" ( " + deslikesql + " ) ", kntitles, types));
		}

		
		
       return c;
   }
   
 
	/**
	 * 功能：获取指定ID最大号
	 * @param knid编号ID
	 * @return 当前ID最大号
	 */
	public Integer getMaxVersion(Integer knid){
		String sql =  "SELECT knversion FROM KnowledgeVW  where knid = :knid";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("knid", knid);
		List list = findByNamedParamMap(sql, p);
		if( list.size() == 0 ) return 0;
		if(list.get(0) == null)return 0;
		return  (Integer) list.get(0);
	}
	
	/**
	 * 功能：获取指定ID最大号
	 * @param knid编号ID
	 * @return 当前ID最大号
	 */
	public Integer getMaxgKnid(){
		String sql =  "SELECT MAX(knid) FROM KnowledgeVW  where knid > :knid";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("knid", Integer.valueOf("0"));
		List list = findByNamedParamMap(sql, p);
		if( list.size() == 0 ) return 0;
		if(list.get(0) == null)return 0;
		return  (Integer) list.get(0);
	}
	
}

