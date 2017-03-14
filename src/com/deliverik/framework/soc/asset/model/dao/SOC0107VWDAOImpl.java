package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107VW;

/**
 * 资产配置项信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0107VWDAOImpl extends BaseHibernateDAOImpl<SOC0107VWInfo> implements SOC0107VWDAO {

	/**
	 * 构造函数
	 */
	public SOC0107VWDAOImpl(){
		super(SOC0107VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0107VWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0107VWInfo findByPK(Serializable pk) {
		SOC0107VWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0107VWSearchCond cond){
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
	public List<SOC0107VWInfo> findByCond(final SOC0107VWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(!StringUtils.isEmpty(cond.getEiid())){
			c.addOrder(Order.desc("civersion"));
			c.addOrder(Order.desc("cismallversion"));
			//c.addOrder(Order.desc("ciid"));
		}
		c.addOrder(Order.asc("cid"));
		List<SOC0107VWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0107VWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//数据库ID
		if(cond.getId()!=null){
			c.add(Expression.eq("id", cond.getId()));
		}	
		
		//资产ID
		if( !StringUtils.isEmpty(cond.getEiid())){
			c.add(Expression.eq("eiid", Integer.parseInt(cond.getEiid())));
		}	
		
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEid())));
		}	

		//资产属性版本号
		if( !StringUtils.isEmpty(cond.getCiversion())){
			c.add(Expression.eq("civersion", cond.getCiversion()));
		}	
		
		//资产模型属性id
		if( !StringUtils.isEmpty(cond.getCid())){
			c.add(Expression.eq("cid", cond.getCid()));
		}
		
		//资产属性值
		if(!StringUtils.isEmpty(cond.getCivalue())){
			c.add(Expression.eq("civalue", cond.getCivalue()));
		}
		
		//资产属性小版本
		if(!StringUtils.isEmpty(cond.getCismallversion())){
			c.add(Expression.eq("cismallversion", Integer.parseInt(cond.getCismallversion())));
		}
		
		if(cond.getCids()!=null&&cond.getCids().length>0){
			c.add(Expression.in("cid", cond.getCids()));
		}
		
		return c;
	}
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	@SuppressWarnings("unchecked")
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion) {
		String sql =  "SELECT MAX(ci.cismallversion) FROM SOC0107VW ci WHERE eiid = :eiid AND civersion = :civersion";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("eiid", eiid);
		p.setInteger("civersion", civersion);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (Integer) l.get(0);
	}
	/**
	 * 根据资产模型ID获取属性信息
	 * @param eiid 资产ID
	 * @return List<SOC0107VWInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0107VWInfo> getConfigItemByEid(final SOC0107VWSearchCondImpl cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select ciid,cid,eiid,eid,");
				query.append("civalue,ciupdtime,esyscoding,ciexpire,cistatus,cicurver,civersion,civerinfo,fingerprint,cismallversion");
				query.append(" from SOC0107VW where eiid in(");
				query.append(cond.getEid());
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0107VW.class);
				List<SOC0107VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0107VWInfo>)execute(action);
	}
	public String getHostEiid(final SOC0107VWSearchCondImpl cond) {
//		String sql =  "select b.eiid from SOC0107VW a left join SOC0107VW b on (a.civalue=b.civalue and b.cid='CI010100010005'"
//			+" and b.civalue!='') where a.cid='CI010100520001' a.eiid=:eiid and a.civersion=:civersion and a.cismallversion=:cismallversion";
//		NamedParamMap p = getNamedParamMap();
//		p.setInteger("eiid", Integer.parseInt(cond.getEiid()));
//		p.setInteger("civersion", Integer.parseInt(cond.getCiversion()));
//		p.setInteger("cismallversion", Integer.parseInt(cond.getCismallversion()));
//		List l = findByNamedParamMap(sql, p);
//		if( l.size() == 0 ) return null;
//		return (String) l.get(0);
		
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("unchecked")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select b.eiid from SOC0107VW a left join SOC0107VW b on (a.civalue=b.civalue and b.cid='CI010100010005'");
				query.append(" and b.civalue!='') where a.cid='CI010100520001' and a.eiid=");
				query.append(cond.getEiid());
				query.append(" and a.civersion=");
				query.append(cond.getCiversion());
				query.append(" and a.cismallversion=");
				query.append(cond.getCismallversion());
				SQLQuery q = session.createSQLQuery(query.toString());
				List<Integer> list = q.list();
				session.clear();
				return list.size() > 0 && list.get(0) != null ? list.get(0).toString()
						: null;
			}
		};
		return (String) execute(action);
	}
	
	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();StringBuffer sql =  new StringBuffer();
				sql.append("SELECT a.eiid from soc0118vw a where 1=1");
				String ci = null;
				if(value != null) {
					for(String key : value.keySet()) {
						sql.append(" and exists (select 1 from SOC0129 b where a.eiid = b.eiid and b.cname='");
						sql.append(key).append("'");
						ci = value.get(key);
						if(ci == null) {
							//不处理
						} else if("".equals(ci)) {
							sql.append(" and b.civalue=''");
						} else {
							sql.append(" and b.civalue='").append(value.get(key)).append("'");
						}
						sql.append(")");
					}
				}
				sql.append(" group by a.eiid");
				SQLQuery q = session.createSQLQuery(sql.toString());
				List<Integer> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Integer>) execute(action);
	}
}
