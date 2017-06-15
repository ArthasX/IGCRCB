package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;

/**
 * 资产配置项信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0107DAOImpl extends BaseHibernateDAOImpl<SOC0107Info> implements SOC0107DAO {

	/**
	 * 构造函数
	 */
	public SOC0107DAOImpl(){
		super(SOC0107TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SOC0107Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ciid"));
		List<SOC0107Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param ciid 主键
	 * @return 检索结果
	 */
	public SOC0107Info findByPK(Serializable ciid) {

		SOC0107Info configitem = super.findByPK(ciid);
		if(configitem == null) return null;

		return configitem;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0107SearchCond cond){
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
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(!StringUtils.isEmpty(cond.getEiid())){
			c.addOrder(Order.desc("civersion"));
			c.addOrder(Order.desc("cismallversion"));
			//c.addOrder(Order.desc("ciid"));
		}
		c.addOrder(Order.asc("cid"));
		List<SOC0107Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0107SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
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
			c.add(Expression.eq("civersion", Integer.parseInt(cond.getCiversion())));
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
		String sql =  "SELECT MAX(ci.cismallversion) FROM SOC0107TB ci WHERE eiid = :eiid AND civersion = :civersion";
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
	 * @return List<SOC0107Info>
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0107Info> getConfigItemByEid(final SOC0107SearchCondImpl cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select ciid,cid,eiid,eid,");
				query.append("civalue,ciupdtime,esyscoding,ciexpire,cistatus,cicurver,civersion,civerinfo,fingerprint,cismallversion");
				query.append(" from soc0107 where eiid in(");
				query.append(cond.getEid());
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0107TB.class);
				List<SOC0107Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0107Info>)execute(action);
	}
	public String getHostEiid(final SOC0107SearchCondImpl cond) {
//		String sql =  "select b.eiid from SOC0107TB a left join SOC0107TB b on (a.civalue=b.civalue and b.cid='CI010100010005'"
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
				query.append("select b.eiid from soc0107 a left join soc0107 b on (a.civalue=b.civalue and b.cid='CI010100010005'");
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
				sql.append("SELECT a.eiid from soc0118 a where 1=1");
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

	/**
	 * 根据资产id和config id 查询场景定义流程节点与节点参与人信息
	 * @param cid config id
	 * @param eiid 资产id
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchProcessDefineUserByEiidInfo(final String cid, final Integer eiid) throws BLException {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                
                StringBuffer queryString = new StringBuffer();

                queryString.append(session.getNamedQuery("SOC0107DAO.searchProcessDefineUserByEiidInfo").getQueryString());
                
				SQLQuery q = session.createSQLQuery(queryString.toString());
				q.setParameter("cid", cid);
				q.setInteger("eiid", eiid);
				//查询结果类型转换
				q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				List<Map<String, Object>> list = q.list();
				
				session.clear();
				
				return list;
             }
         };
		return (List<Map<String, Object>>) execute(action);
	}
}
