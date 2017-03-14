package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.TableSpaceTB;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0437TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0437VW;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;
import com.deliverik.infogovernor.soc.model.entity.NetDeviceTB;

/**
 * 资产信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0118DAOImpl extends BaseHibernateDAOImpl<SOC0118Info> implements SOC0118DAO {

	/**
	 * 构造函数
	 */
	public SOC0118DAOImpl(){
		super(SOC0118TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	@Override
	public List<SOC0118Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eiid"));
		List<SOC0118Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eiid 主键
	 * @return 检索结果
	 */
	@Override
	public SOC0118Info findByPK(Serializable eiid) {

		SOC0118Info entityitem = super.findByPK(eiid);
		if(entityitem == null) return null;

		return entityitem;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0118SearchCond cond){
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
	public List<SOC0118Info> findByCond(final SOC0118SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getEid())&&("CM08010002".equals(cond.getEid())||"CM08010001".equals(cond.getEid()))){
			c.addOrder(Order.asc("eiid"));
		}
		if("888001".equals(cond.getEsyscoding_like())){
			c.addOrder(Order.desc("eiid"));
		}
		c.addOrder(Order.asc("eid"));
		c.addOrder(Order.asc("eilabel"));
		List<SOC0118Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0118SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//存储类型过滤
		if( !StringUtils.isEmpty(cond.getEsyscoding_eq())){
			c.add(Expression.eq("esyscoding", cond.getEsyscoding_eq()));
		}
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", cond.getEid()));
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
		//资产顶级实体ID
		if(cond.getEirootmark() != null && cond.getEirootmark() > 0)
		{
			c.add(Expression.eq("eirootmark", cond.getEirootmark()));
		}
		
		if(cond.getEiids()!=null&&cond.getEiids().size()>0){
			c.add(Expression.in("eiid", cond.getEiids()));
		}
		
		if(cond.getEids()!=null&&cond.getEids().length>0){
			c.add(Expression.in("eid", cond.getEids()));
		}
		if(cond.getEid_arr()!=null&&cond.getEid_arr().length>0){
			c.add(Expression.in("eid", cond.getEid_arr()));
		}
		//存储类型过滤
		if( !StringUtils.isEmpty(cond.getEsyscoding_like())){
			c.add(Expression.like("esyscoding", cond.getEsyscoding_like()+"%"));
		}
		//根据业务系统的管理人员过滤
		if(StringUtils.isNotEmpty(cond.getMagName())){
			c.add(Expression.sql("  eiid in (select a.eiid from soc0118 a "+
			"left join soc0107 b on(b.eiid = a.eiid and b.cid in('CI030100010002','CI030100010003') and a.eiversion = b.civersion and a.eismallversion = b.cismallversion)"+ 
			"where a.esyscoding like '999003001%' and b.civalue like '"+cond.getMagName()+"%')"));
		}
		//根据einame集合 过滤
		if(cond.getEiname_in()!=null && cond.getEiname_in().size()>0){
			c.add(Expression.in("einame", cond.getEiname_in()));
		}
		
		if(StringUtils.isNotEmpty(cond.getEilabel_like())){
			c.add(Expression.like("eilabel", "%"+cond.getEilabel_like()+"%"));
		}
		//IP查询时 是否分配 过滤
		if(StringUtils.isNotEmpty(cond.getEidesc_falg())){
			if("0".equals(cond.getEidesc_falg())){
				c.add(Expression.eq("eidesc", ""));
			}else{
				c.add(Expression.not(Expression.eq("eidesc", "")));
			}
		}
		if(StringUtils.isNotEmpty(cond.getEiupdtime_from())){
			c.add(Expression.ge("eiupdtime", cond.getEiupdtime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getEiupdtime_to())){
			c.add(Expression.le("eiupdtime", cond.getEiupdtime_to()));
		}
		
		if("ISNULL".equals(cond.getEistatus())){
			c.add(Expression.isNull("eistatus"));
		}
		
		if(StringUtils.isNotBlank(cond.getEistatus_ne())){
			if("0".equals(cond.getEistatus_ne())){
				c.add(Expression.or(Expression.ne("eistatus", cond.getEistatus_ne()), Expression.isNull("eistatus")) );
			}else{
				c.add(Expression.ne("eistatus", cond.getEistatus_ne()));
			}
			
		}
		
		// 场景分类过滤 (演练或应急指挥流程选择场景时使用)
		if (StringUtils.isNotEmpty(cond.getScenceCategory())){
			c.add(Restrictions.sqlRestriction(" this_.eiid in (select eiid from soc0107 s7 where s7.cid='CI600000001009' and s7.civersion = this_.eiversion and s7.civalue = '" + cond.getScenceCategory() + "')"));
		}

		return c;
	}
	
	/**
	 * 获取资产编号最大值 资产key+年+编号 （位数：4+2+6）
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号最大值（平台保留）
	 */
	
	@SuppressWarnings("unchecked")
	public String searchMaxEntityItemLable(final SOC0118SearchCond cond) {
		String sql =  "select max(ei.eilabel) from SOC0118TB ei where ei.eilabel like :eilabel";
		NamedParamMap p = getNamedParamMap();
		p.setString("eilabel",cond.getEilabel() + "%");
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
	public List<SOC0118Info> searchDeviceService(final SOC0124SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list =null;
				
				query.append(session.getNamedQuery("DeviceServiceVWDAO.findByCond").getQueryString());
				
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
				
				query.append(" ) ) as vm ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0118TB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				
				return list;
			}
		};
		return (List<SOC0118Info>) execute(action);
	}
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0139VW> searchSwitchService(final String eiid,final String version,final String smallversion){
		
		HibernateCallback action = new HibernateCallback(){  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();		
				query.append("select row_numBER() OVER(order by a.switchname) as switchid,A.switchname,B.switchip,C.switchdomain,D.effectivecfg from ");
				query.append("(select  civalue as switchname,eiid from  SOC0107 ");
				query.append("    where  cid = 'CI010100060006' and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("  )A  left join ");
				query.append("(select  civalue as switchip,eiid from  SOC0107 ");
				query.append("    where  cid = 'CI010100060007' and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append(  ")B  on A.eiid = B.eiid");
				query.append("     left join ");
				query.append(" (select  civalue as switchdomain,eiid from  SOC0107 ");
				query.append("    where  cid = 'CI010100060008' and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("	)C on B.eiid = C.eiid ");
				query.append("    left join ");
				query.append(" (select  civalue as effectivecfg,eiid from  SOC0107 "); 
				query.append("    where  cid = 'CI010200180002' and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("	)D  on C.eiid = D.eiid ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0139VW.class);
				List<SOC0139VW> list = q.list();
				session.clear();
				
				return list;
			}
		};
		return (List<SOC0139VW>) execute(action);
	}
	/**
	 * cx记录检索
	 * 
	 * @param strEilabel
	 *            检索条件
	 * @return 检索结果列表
	 */
	public String searchEntityESyscoding(final String strEilabel) {

		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("unchecked")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query
						.append(" select esyscoding from SOC0118 where eilabel='");
				query.append(strEilabel);
				query.append("'");
				SQLQuery q = session.createSQLQuery(query.toString());
				List<String> list = q.list();
				session.clear();
				return list.size() > 0 && list.get(0) != null ? list.get(0)
						: null;
			}
		};
		return (String) execute(action);
	}
	
	@SuppressWarnings("unchecked")
	public List<CodeDetailEntity> findByCondSQL(final SOC0118SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("CodeDetailTBDAO.findQuery").getQueryString());
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				System.out.println(query.toString());
				q.setProperties(cond);
//				q.addEntity(CodeDetailEntity.class);
				setFetchPoint(q, start, count);
				List<Object[]> list=q.list();
				List<CodeDetailEntity> list1=changeEmployeeEntity(list);
				return list1;
			}
		};
		return (List<CodeDetailEntity>) execute(action);
	}
	
	/**
	 * 转换数据
	 * 
	 */
	protected List<CodeDetailEntity> changeEmployeeEntity(
			List<Object[]> olist) {
		List<CodeDetailEntity> tblist = new ArrayList<CodeDetailEntity>();
		if (olist != null) {
			//将object转为EmployeeSignupStatTB 
			//因为obj[0]为分页函数 所以从obj[1]开始
			for (Object[] obj : olist) {
				CodeDetailEntity tb = new CodeDetailEntity();
				if(obj[0]!=null){
					tb.setCcid(obj[0].toString());
				}
				if(obj[1]!=null){
					tb.setCid(obj[1].toString());
				}
				if(obj[2]!=null){
					tb.setCvalue(obj[2].toString());
				}
				if(obj[3]!=null){
					tb.setPccid(obj[3].toString());
				}
				if(obj[4]!=null){
					tb.setPcid(obj[4].toString());
				}
				if(obj[5]!=null){
					tb.setUpdtime(obj[5].toString());
				}
				if(obj[6]!=null){
					tb.setSyscoding(obj[6].toString());
				}
				if(obj[7]!=null){
					tb.setPsyscoding(obj[7].toString());
				}
				if(obj[8]!=null){
					tb.setCdstatus(obj[8].toString());
				}
				if(obj[9]!=null){
					tb.setBusinesscode(obj[9].toString());
				}
				if(obj[10]!=null){
					tb.setCdinfo(obj[10].toString());
				}
				tblist.add(tb);
			}
		}
		return tblist;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SOC0118SearchCond cond,StringBuffer query) {
		if(!StringUtils.isEmpty(cond.getCcid())){
			query.append(" and ccid='"+cond.getCcid()+"'");
		}
		if(!StringUtils.isEmpty(cond.getPcid())){
			query.append(" and pcid='"+cond.getPcid()+"'");
		}
		if(!StringUtils.isEmpty(cond.getCdstatus())){
			query.append(" and cdstatus='"+cond.getCdstatus()+"'");
		}
		query.append(" order by ccid,cid");
	}

	@SuppressWarnings("unchecked")
	public List<TableSpaceInfo> searchTableRelationInfo(final 
			SOC0118SearchCondImpl cond,final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				List<TableSpaceInfo> list =null;
				query.append(session.getNamedQuery("SOC0118DAO.searchTableRelation").getQueryString());
				if(StringUtils.isNotEmpty(cond.getBusinessName())){
					query.append(" and f.businessName like('%"+cond.getBusinessName()+"%') ");
				}
				if(StringUtils.isNotEmpty(cond.getInstanceName())){
					query.append(" and f.instanceName like('%"+cond.getInstanceName()+"%') ");
				}
				if(StringUtils.isNotEmpty(cond.getTableSpaceName())){
					query.append(" and f.tableSpaceName like('%"+cond.getTableSpaceName().toUpperCase()+"%') ");
				}
				if(StringUtils.isNotEmpty(cond.getTableName())){
					query.append(" and f.tableName like('%"+cond.getTableName().toUpperCase()+"%') ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(TableSpaceTB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				
				return list;
			}
		};
		return (List<TableSpaceInfo>) execute(action);
	}

	@SuppressWarnings("unchecked")
	public Integer updateCutValue(final IGCIM1001Form igcim1001Form) {
		String sql =  "select count(*) from SOC0437TB where eiid = :eiid";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("eiid",Integer.parseInt(igcim1001Form.getEiid()));
		List l = findByNamedParamMap(sql, p);
		final int count = Integer.parseInt(String.valueOf(l.get(0)));
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(count>0){
					query.append("update soc0437 set cvalue='"+igcim1001Form.getCvalue()+"' where eiid="+igcim1001Form.getEiid()+"");
				}else{
					query.append("insert into soc0437(eiid,cvalue) values("+igcim1001Form.getEiid()+",'"+igcim1001Form.getCvalue()+"')");
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(SOC0437TB.class);
				
				int i = q.executeUpdate();
				
				session.clear();
				
				return Integer.valueOf(i);
			}
		};
		return  (Integer) execute(action);
	}
	@SuppressWarnings("unchecked")
	public List<SOC0437Info> searchCutItem(final SOC0437SearchCond cond, final int start, final int count) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("SOC0437DAO.searchCutItem").getQueryString());
				if(StringUtils.isNotEmpty(cond.getDB_eq())){
					query.append(" and a.dbname like '%"+cond.getDB_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getInstance_eq())){
					query.append(" and a.instance like '%"+cond.getInstance_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getTablespace_eq())){
					query.append(" and a.tsname like '%"+cond.getTablespace_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getEid())){
					query.append(" and a.eid = '"+cond.getEid()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(SOC0437VW.class);
				
				setFetchPoint(q, start, count);
				
				List<SOC0437VW> list = q.list();
				session.clear();
				
				return list;
			}
		};
		return (List<SOC0437Info>) execute(action);
	}
	public Integer searchCutItemCount(final SOC0437SearchCond cond) {

		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("unchecked")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("SOC0437DAO.searchCutItem").getQueryString());
				if(StringUtils.isNotEmpty(cond.getDB_eq())){
					query.append(" and a.dbname like '%"+cond.getDB_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getInstance_eq())){
					query.append(" and a.instance like '%"+cond.getInstance_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getTablespace_eq())){
					query.append(" and a.tsname like '%"+cond.getTablespace_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getEid())){
					query.append(" and a.eid = '"+cond.getEid()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(SOC0437VW.class);
				List<SOC0437VW> list = q.list();
				session.clear();
				
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	/**
	 * 清空资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(SOC0118SearchCond cond){
		String sql="update  soc0118 set eidesc = null where eirootmark = :eirootmark and eidesc is not null";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eirootmark", cond.getEirootmark());
		return q.executeUpdate();
	}
	/**
	 * 清空指定eiid的资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118SearchCond cond){
		String sql = "update soc0118 set eidesc = null where eiid in (:eiids)";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameterList("eiids", cond.getEiids());
		return q.executeUpdate();
	}
	
	/**
	 * 执行sql
	 * @param sql
	 * @return
	 */
	public Integer executeSQL(String sql){
		
		SQLQuery q = getSession().createSQLQuery(sql);
		
		return q.executeUpdate();
	}
	
	/**
	 * 批量插入
	 * @param soc0118List
	 * @throws Exception
	 */
	public void saveEntityItems(List<SOC0118TB> soc0118List)throws Exception{
	
		Session session = getSessionFactory().openSession();
		try{
		Transaction tx=session.beginTransaction(); 
		Connection conn=session.connection();
		String sql = "insert into SOC0118 ( " +
				"eid, " +
				"eidesc, " +
				"eiinsdate, " +
				"eilabel, " +
				"einame, " +
				"eiorgsyscoding, " +
				"eirootmark, " +
				"eismallversion, " +
				"eistatus, " +
				"eiupdtime, " +
				"eiuserid, " +
				"eiusername, " +
				"eiversion, " +
				"esyscoding," +
				"fingerPrint) " +
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		for(int j=0;j<soc0118List.size();j++){
			SOC0118TB soc0118 = soc0118List.get(j);
			stmt.setString(1, soc0118.getEid());
			stmt.setString(2, soc0118.getEidesc());
			stmt.setString(3, soc0118.getEiinsdate());
			stmt.setString(4, soc0118.getEilabel());
			stmt.setString(5, soc0118.getEiname());
			stmt.setString(6, soc0118.getEiorgsyscoding());
			if(soc0118.getEirootmark()==null){
				stmt.setNull(7, Types.NULL);
			}else{
				stmt.setInt(7, soc0118.getEirootmark());
			}
			stmt.setInt(8,  soc0118.getEismallversion());
			stmt.setString(9, soc0118.getEistatus());
			stmt.setString(10, soc0118.getEiupdtime());
			stmt.setString(11, soc0118.getEiuserid());
			stmt.setString(12, soc0118.getEiusername());
			stmt.setInt(13,  soc0118.getEiversion());
			stmt.setString(14, soc0118.getEsyscoding());
			stmt.setString(15, soc0118.getFingerPrint());
			
			stmt.executeUpdate();
			
		}
		tx.commit();
		}catch (Exception e) {
			throw e;
		}
		finally{
			session.close();
		}
		
	}
	/**查询网络设备记录检索
	 * @param cond 检索条件
	 * @return 检索结果count
	 */
	public int getNetDeviceCount(final NetDeviceSearchCond cond){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				Integer count =null;
				query.append("select ei.eiid as eiid,ei.eilabel as eilabel,ci.civalue as civalue,ei.eiupdtime as eiupdtime,'' as fingerprint " +
						"from soc0118 ei,soc0107 ci " +
						"where ei.esyscoding='999001028005' and ci.cid='CI010100490002' and ei.eiid=ci.eiid and ei.eiversion=ci.civersion and ei.eismallversion=ci.cismallversion " +
						"and ei.eilabel like '%"+cond.getEilabel_lk_ip()+"%' " +
						"and ei.eilabel like '%"+cond.getEilabel_lk_devname()+"%' ");
				if(StringUtils.isNotEmpty(cond.getCivalue_eq()) ){
					query.append("and ci.civalue = '"+cond.getCivalue_eq()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(NetDeviceTB.class);
				//setFetchPoint(q, start, count);
				count = q.list().size();
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 查询网络设备记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<NetDeviceInfo> searchNetDeviceListByCond(final NetDeviceSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<NetDeviceInfo> list =null;
				query.append("select ei.eiid as eiid,ei.eilabel as eilabel,ci.civalue as civalue,ei.eiupdtime as eiupdtime,'' as fingerprint " +
						"from soc0118 ei,soc0107 ci " +
						"where ei.esyscoding='999001028005' and ci.cid='CI010100490002' and ei.eiid=ci.eiid and ei.eiversion=ci.civersion and ei.eismallversion=ci.cismallversion " +
						"and ei.eilabel like '%"+cond.getEilabel_lk_ip()+"%' " +
						"and ei.eilabel like '%"+cond.getEilabel_lk_devname()+"%' ");
				if(StringUtils.isNotEmpty(cond.getCivalue_eq()) ){
					query.append("and ci.civalue = '"+cond.getCivalue_eq()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				//q.setProperties(cond);
				q.addEntity(NetDeviceTB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<NetDeviceInfo>) execute(action);
	}
	
	/**
	 * 删除eiid和eirootmark在 给定范围内的资产
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids){
		String sql = "delete from soc0118 where eiid in (:eiids) or eirootmark in(:eiids)";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameterList("eiids", eiids);
		return q.executeUpdate();
	}
	
	/**
	 * 获取主机信息
	 * 配置一致性对比 中 根据业务系统 查询主机时 使用
	 * @param cond
	 * @return
	 */
	public List<Map<String,String>> searchHostList(SOC0118SearchCond cond){
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		StringBuffer sql = new StringBuffer();
		Session session = getSession();
		sql.append(session.getNamedQuery("SOC0118.searchHost").getQueryString());
		
		if(StringUtils.isNotEmpty(cond.getEiid())){
			sql.append(" and t.eiid = '"+cond.getEiid()+"'");
		}
		//根据业务系统id 查询与其相关的所有主机
		if(cond.getSystemId()!=null&&cond.getSystemId()>0){
			sql.append(" and t.eiid in (" +
					"select eirootmark from soc0118 where eiid in (" +
					"select cldeiid from soc0119 where pareiid = '"+cond.getSystemId()+"'))");
		}
		
		if(StringUtils.isNotEmpty(cond.getEnvironmentType())){
			sql.append(" and t.hj = (select ccdvalue from soc0151 where ccdid = "+cond.getEnvironmentType()+")");
		}
		if(cond.isClumped()){
			sql.append(" and (t.sjkjq = '是' or t.fwqjq='是' or t.qtjq='是')");
		}
		
		List<Object[]> list = session.createSQLQuery(sql.toString()).list();
		for (Object[] arrObj : list) {
			Map<String, String> entity = new HashMap<String, String>();
			entity.put("eiid",arrObj[0].toString());
			entity.put("einame",arrObj[1].toString());
			entity.put("ip",arrObj[2].toString());
			
			result.add(entity);
		}
		return result;
	}
	
	public void deleteEntityItemByEilabel(String eilabel) {
		String sql = "delete from soc0118 where eilabel =:eilabel";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eilabel", eilabel);
		q.executeUpdate();
	}
	
	public int getEntityItemSearchCountByHost(final SOC0118SearchCondImpl cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				Integer count =null;
				query.append("select count(*) from soc0118 a left join soc0145 b on (a.eiid=b.eiid and a.eiversion=b.eiversion and a.eismallversion=b.eismallversion and b.cid='CI010100010071') where 1=1");
				if(StringUtils.isNotEmpty(cond.getEsyscoding_eq())){
					query.append(" and a.esyscoding like '"+cond.getEsyscoding_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and a.einame like '%"+cond.getEiname()+"%'");
				}
				if(cond.getEirootmark()!=null){
					query.append(" and a.eirootmark="+cond.getEirootmark());
				}
				if(StringUtils.isNotEmpty(cond.getEiupdtime_from())){
					query.append(" and a.eiupdtime>='"+cond.getEiupdtime_from()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getEiupdtime_to())){
					query.append(" and a.eiupdtime<='"+cond.getEiupdtime_to()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getEitype())){
					query.append(" and a.fingerprint='"+cond.getEitype()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				count = q.list().size();
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	@SuppressWarnings("unchecked")
	public List<SOC0118Info> searchEntityItemByHost(final SOC0118SearchCondImpl cond,
			final int fromCount, final int pageDispCount) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list =null;
				query.append("select a.eiid,a.eid,b.civalue as eidesc,a.einame,a.eilabel,a.eiinsdate,a.eiorgsyscoding,a.esyscoding,"
						+"a.eiupdtime,a.eistatus,a.eiversion,a.eiuserid,a.eiusername,a.eismallversion,a.eirootmark,a.fingerprint"
						+" from soc0118 a left join soc0145 b on (a.eiid=b.eiid and a.eiversion=b.eiversion and a.eismallversion=b.eismallversion and b.cid='CI010100010071') where 1=1");
				if(StringUtils.isNotEmpty(cond.getEsyscoding_eq())){
					query.append(" and a.esyscoding like '"+cond.getEsyscoding_eq()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and a.einame like '%"+cond.getEiname()+"%'");
				}
				if(cond.getEirootmark()!=null){
					query.append(" and a.eirootmark="+cond.getEirootmark());
				}
				if(StringUtils.isNotEmpty(cond.getEiupdtime_from())){
					query.append(" and a.eiupdtime>='"+cond.getEiupdtime_from()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getEiupdtime_to())){
					query.append(" and a.eiupdtime<='"+cond.getEiupdtime_to()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getEitype())){
					query.append(" and b.civalue='"+cond.getEitype()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0118TB.class);
				setFetchPoint(q, fromCount, pageDispCount);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0118Info>) execute(action);
	}
	
	/**
	 * 查询风险库分布情况
	 * @return map key:{riskcont:风险点数量,riskesyscoding:风险点层次码(6位),inspectcont:检查项,inspectesyscoding:检查项层次码(6位),名称}
	 */
	public List<Map> getRiskRepository(){
		
		Session session = getSession();
		String sql = session.getNamedQuery("SOC0118DAO.getRiskRepository").getQueryString();
//		String sql = "select t1.riskcont,t1.riskesyscoding ,t2.inspectcont,t2.inspectesyscoding,t2.ename from(  select a.*,b.ename from (select count(a.eid) as riskcont,substr(a.esyscoding,1,9) as riskesyscoding "
//		+"	from soc0118 a "
//		+"		where substr(a.esyscoding,1,6)= '999017'  "
//		+"		group by substr(a.esyscoding,1,9) )a "
//		+"	left join soc0117 b on  a.riskesyscoding = b.esyscoding) t1 "
//		+" left join "
//		+"	( select a.*,b.ename from (select count(a.eid) as inspectcont,substr(a.esyscoding,1,9) as inspectesyscoding "
//		+"	from soc0118 a "
//		+"		where substr(a.esyscoding,1,6)= '999018' "
//		+"		group by substr(a.esyscoding,1,9) )a "
//				+"	left join soc0117 b on  a.inspectesyscoding = b.esyscoding) t2 on t1.ename = t2.ename";
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("riskcont",Hibernate.STRING) ;
		q.addScalar("riskesyscoding",Hibernate.STRING) ;
		q.addScalar("inspectcont",Hibernate.STRING) ;
		q.addScalar("inspectesyscoding",Hibernate.STRING) ;
		q.addScalar("ename",Hibernate.STRING) ;
		
//		q.list();
		return q.list();
	}


	
}
