package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.condition.IG313SearchCond;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * 资产项关系信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG313DAOImpl extends BaseHibernateDAOImpl<IG313Info> implements IG313DAO {

	/**
	 * 构造函数
	 */
	public IG313DAOImpl(){
		super(IG313TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG313Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eirid"));
		List<IG313Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eirid 主键
	 * @return 检索结果
	 */
	public IG313Info findByPK(Serializable eirid) {

		IG313Info entityitemrelation = super.findByPK(eirid);
		if(entityitemrelation == null) return null;

		return entityitemrelation;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG313SearchCond cond){
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
	public List<IG313Info> findByCond(final IG313SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eirrelation"));
		c.addOrder(Order.asc("pareiid"));
		List<IG313Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG313SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//通过资产ID从正反两个方向检索该资产的关联关系
		if(cond.getEiid()!=null){
			c.add(Expression.or(
					Expression.eq("pareiid", cond.getEiid()),
					Expression.eq("cldeiid", cond.getEiid())));
		}	

		//通过资产ID从正两个方向检索该资产的关联关系）
		if(cond.getPareiid()!=null){
			c.add(Expression.eq("pareiid", cond.getPareiid()));
		}	
		//通过资产ID从反两个方向检索该资产的关联关系
		if(cond.getCldeiid()!=null){
			c.add(Expression.eq("cldeiid", cond.getCldeiid()));
		}
		//资产项关系
		if( !StringUtils.isEmpty(cond.getEirrelation())){
			if((CommonDefineUtils.MODULE_RELATION_ENTIY_ID+"#"+CommonDefineUtils.MODULE_RELATION_MODULE_ID).equals(cond.getEirrelation())){
				c.add(Expression.or(Expression.eq("eirrelation", CommonDefineUtils.MODULE_RELATION_ENTIY_ID), Expression.eq("eirrelation", CommonDefineUtils.MODULE_RELATION_MODULE_ID)));
			}else{
				c.add(Expression.eq("eirrelation", cond.getEirrelation()));
			}
		}
		//资产项状态
		if( !StringUtils.isEmpty(cond.getEirstatus())){
			c.add(Expression.eq("eirstatus", cond.getEirstatus()));
		}
		//资产项关系说明
		if( !StringUtils.isEmpty(cond.getEirdesc())){
			c.add(Expression.like("eirdesc", "%"+cond.getEirdesc()+"%"));
		}
		//通过资产属性增加自动生成的关系信息
		if( !StringUtils.isEmpty(cond.getEirinfo())){
			c.add(Expression.like("eirinfo", "%" + cond.getEirinfo() + "%"));
		}
		//正向资产大版本
		if( cond.getParversion()!=null){
			c.add(Expression.eq("parversion", cond.getParversion()));
		}
		//正向资产小版本
		if( cond.getParsmallversion()!=null){
			c.add(Expression.eq("parsmallversion", cond.getParsmallversion()));
		}
		//反向资产大版本
		if( cond.getCldversion()!=null){
			c.add(Expression.eq("cldversion", cond.getCldversion()));
		}
		//反向资产小版本
		if( cond.getCldsmallversion()!=null){
			c.add(Expression.eq("cldsmallversion",cond.getCldsmallversion()));
		}
		//逻辑删除标识
		if( !StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		if(cond.getPareid()!=null){
			c.add(Expression.eq("pareid", cond.getPareid()));
		}
		if(cond.getCldeid()!=null){
			c.add(Expression.eq("cldeid", cond.getCldeid()));
		}
		if(StringUtils.isNotEmpty(cond.getEirrelationcode())){
			c.add(Expression.eq("eirrelationcode", cond.getEirrelationcode()));
		}
		return c;
	}
	
	/**
	 * 资产关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG313Info> searchMaxIG313Info(final IG313SearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG013Info> list = null;
				query.append(session.getNamedQuery("IG313DAO.searchMaxEntityItemRelationVW").getQueryString());
				if(cond.getPareiid()!=null) {
					query.append(" AND a.pareiid  = :pareiid ");
				} 
				if(cond.getParversion()!=null) {
					query.append(" AND a.parversion  = :parversion ");
				} 
				if(cond.getParsmallversion()!=null) {
					query.append(" AND a.parsmallversion  = :parsmallversion ");
				} 
				
				if(cond.getCldeiid()!=null) {
					query.append(" AND a.cldeiid  = :cldeiid ");
				}
				if(cond.getCldversion()!=null) {
					query.append(" AND a.cldversion = :cldversion ");
				}
				if(cond.getCldsmallversion()!=null) {
					query.append(" AND a.cldsmallversion = :cldsmallversion ");
				}
				if(StringUtils.isNotEmpty(cond.getDeleteflag())) {
					query.append(" AND a.deleteflag = :deleteflag ");
				}
				//通过资产属性增加自动生成的关系信息
				if(StringUtils.isNotEmpty(cond.getEirinfo())){
					query.append(" AND a.eirinfo like ('%'||:eirinfo||'%') ");
				}
				//资产项关系说明
				if( !StringUtils.isEmpty(cond.getEirdesc())){
					query.append(" AND a.eirdesc like ('%'||:eirdesc||'%') ");
				}
				//资产项状态
				if( !StringUtils.isEmpty(cond.getEirstatus())){
					query.append(" AND a.eirstatus = :eirstatus ");
				}
				//通过资产ID从正反两个方向检索该资产的关联关系
				if(cond.getEiid()!=null){
					query.append(" AND (a.pareiid  = :eiid AND a.cldeiid  = :eiid) ");
				}
				//关系码
				if(StringUtils.isNotEmpty(cond.getEirrelationcode())){
					query.append(" AND a.Eirrelationcode in ("+cond.getEirrelationcode()+") ");
				}
				//资产项关系
				if( !StringUtils.isEmpty(cond.getEirrelation())){
					if((CommonDefineUtils.MODULE_RELATION_ENTIY_ID+"#"+CommonDefineUtils.MODULE_RELATION_MODULE_ID).equals(cond.getEirrelation())){
						query.append(" AND (a.eirrelation = '").append(CommonDefineUtils.MODULE_RELATION_ENTIY_ID).append("' ");
						query.append(" OR a.eirrelation = '").append(CommonDefineUtils.MODULE_RELATION_MODULE_ID).append("') ");
					}else{
						query.append(" AND a.eirrelation = :eirrelation ");
					}
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(IG313TB.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG313Info>) execute(action);
	}
}
