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
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 资产信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG013DAOImpl extends BaseHibernateDAOImpl<IG013Info> implements IG013DAO {

	/**
	 * 构造函数
	 */
	public IG013DAOImpl(){
		super(IG013TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG013Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eiid"));
		List<IG013Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eiid 主键
	 * @return 检索结果
	 */
	public IG013Info findByPK(Serializable eiid) {

		IG013Info entityitem = super.findByPK(eiid);
		if(entityitem == null) return null;

		return entityitem;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG013SearchCond cond){
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
	public List<IG013Info> findByCond(final IG013SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eid"));
		c.addOrder(Order.asc("eilabel"));
		List<IG013Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG013SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEid())));
		}	
		//资产名称
		if( !StringUtils.isEmpty(cond.getEiname())){
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%"));
		}	
		
		//资产名称(完全匹配)
		if( !StringUtils.isEmpty(cond.getEiname_equal())){
			c.add(Expression.eq("einame", cond.getEiname_equal()));
		}	
		
		//资产编号
		if( !StringUtils.isEmpty(cond.getEilabel())){
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}
		//资产所属机构层次码
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding())){
			c.add(Expression.like("eiorgsyscoding", cond.getEiorgsyscoding()+"%"));
		}
		
		//资产模型in条件
		if( cond.getEilabel_list()!=null && cond.getEilabel_list().size()>0){
			c.add(Expression.in("eilabel", cond.getEilabel_list()));
		}
		//资产ID
		if(StringUtils.isNotEmpty(cond.getEiid())){
			c.add(Expression.eq("eiid", Integer.parseInt(cond.getEiid())));
		}
		//资产版本
		if(cond.getEiversion() != null && cond.getEiversion() > 0){
			c.add(Expression.eq("eiversion", cond.getEiversion()));
		}
		//资产小版本
		if(cond.getEismallversion() != null && cond.getEismallversion() > 0){
			c.add(Expression.eq("eismallversion", cond.getEismallversion()));
		}
		
		return c;
	}
	
	/**
	 * 获取资产编号最大值 资产key+年+编号 （位数：4+2+6）
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号最大值（平台保留）
	 */
	
	@SuppressWarnings("rawtypes")
	public String searchMaxIG013InfoLable(final IG013SearchCond cond) {
		String sql =  "select max(ei.eilabel) from IG013TB ei where ei.eilabel like :eilabel";
		NamedParamMap p = getNamedParamMap();
		p.setString("eilabel", cond.getEilabel() + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG013Info> list =null;
				
				query.append(session.getNamedQuery("IG013DAO.findByCond").getQueryString());
				
				//资产项所属模型
				if( !StringUtils.isEmpty(cond.getEsyscoding())){
					query.append(" AND V.esyscoding like (:esyscoding||'%') ");
				}
				//资产项名
				if( !StringUtils.isEmpty(cond.getEiname())){
					query.append(" AND V.einame like ('%' || :einame || '%') ");
				}
				
				//资产项登记日FROM
				if( !StringUtils.isEmpty(cond.getEiupdtime_from())){
					query.append(" AND V.eiinsdate >= :eiupdtime_from");
				}
				//资产项登记日TO
				if( !StringUtils.isEmpty(cond.getEiupdtime_to())){
					query.append(" AND V.eiinsdate <= :eiupdtime_to");
				}
				
				query.append(" ) ) vm ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(IG013TB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG013Info>) execute(action);
	}
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion){
		
		HibernateCallback action = new HibernateCallback(){  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();		
				query.append("select rownumber()over() as switchid,A.switchname,B.switchip,C.switchdomain,D.effectivecfg from ");
				query.append("(select  civalue as switchname,eiid from  IG800 ");
				query.append("    where  cid = 1059 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("  )A  left join ");
				query.append("(select  civalue as switchip,eiid from  IG800 ");
				query.append("    where  cid = 1121 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append(  ")B  on A.eiid = B.eiid");
				query.append("     left join ");
				query.append(" (select  civalue as switchdomain,eiid from  IG800 ");
				query.append("    where  cid = 1122 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("	)C on B.eiid = C.eiid ");
				query.append("    left join ");
				query.append(" (select  civalue as effectivecfg,eiid from  IG800 "); 
				query.append("    where  cid = 1056 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("	)D  on C.eiid = D.eiid ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SwitchConfigItemVW.class);
				List<SwitchConfigItemVW> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SwitchConfigItemVW>) execute(action);
	}
	
}
