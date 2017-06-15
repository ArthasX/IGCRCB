package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 资产配置项信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG800DAOImpl extends BaseHibernateDAOImpl<IG800Info> implements IG800DAO {

	/**
	 * 构造函数
	 */
	public IG800DAOImpl(){
		super(IG800TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG800Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ciid"));
		List<IG800Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param ciid 主键
	 * @return 检索结果
	 */
	public IG800Info findByPK(Serializable ciid) {

		IG800Info IG800 = super.findByPK(ciid);
		if(IG800 == null) return null;

		return IG800;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG800SearchCond cond){
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
	public List<IG800Info> findByCond(final IG800SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("cid"));
		if(cond.getEiid() !=null){
			c.addOrder(Order.desc("civersion"));
			c.addOrder(Order.desc("cismallversion"));
			//c.addOrder(Order.desc("ciid"));
		}
		List<IG800Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG800SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//资产ID
		if(cond.getEiid()!=null){
			c.add(Expression.eq("eiid", cond.getEiid()));
		}	
		
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEid())));
		}	

		//资产属性版本号
		if(StringUtils.isNotEmpty(cond.getCiversion())){
			c.add(Expression.eq("civersion", Integer.parseInt(cond.getCiversion())));
		}	
		
		//资产模型属性id
		if( cond.getCid()!=null && cond.getCid()!=0){
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
		
		return c;
	}
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	@SuppressWarnings("rawtypes")
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion) {
		String sql =  "SELECT MAX(ci.cismallversion) FROM IG800TB ci WHERE eiid = :eiid AND civersion = :civersion";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("eiid", eiid);
		p.setInteger("civersion", civersion);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (Integer) l.get(0);
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
				sql.append("SELECT a.eiid from ig013 a where 1=1");
				String ci = null;
				if(value != null) {
					for(String key : value.keySet()) {
						sql.append(" and exists (select 1 from ig050 b where a.eiid = b.eiid and b.cname='");
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
