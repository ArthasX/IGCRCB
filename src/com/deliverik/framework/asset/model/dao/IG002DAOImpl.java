package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG002VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * 资产项配置信息视图DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG002DAOImpl extends BaseHibernateDAOImpl<IG002Info> implements IG002DAO {

	
	/** EntityItem DAO */
	protected IG013DAO ig013DAO;
	
	public void setIg013DAO(IG013DAO ig013DAO) {
		this.ig013DAO = ig013DAO;
	}
	
	/**
	 * 构造函数
	 * 
	 */
	public IG002DAOImpl(){
		super(IG002VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG002SearchCond cond){
//		DetachedCriteria c = getCriteria(cond);
		List<IG002Info> ret = this.findByCond(cond);
		return ret.size();
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG002Info> findByCond(final IG002SearchCond cond, final int start, final int count){
//		DetachedCriteria c = getCriteria(cond);
//		c.addOrder(Order.asc("eiid"));
//		c.addOrder(Order.asc("clabel"));
//		List<ConfigItemVWInfo> ret = findByCriteria(c, start, count);
		List<IG002Info> ret = this.findByCond(cond);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG002SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		c.add(Expression.eq("eiid", cond.getEiid()));

		return c;
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<IG002Info> findByCond(final IG002SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
//				EntityItemBL entityItemBL = (EntityItemBL) WebApplicationSupport.getBean("entityItemBL");
//				
//				EntityItem entityItem = entityItemBL.searchEntityItemByKey(Integer.parseInt(cond.getEiid()));
				
//				EntityItem entityItem = entityItemDAO.findByPK(Integer.parseInt(cond.getEiid()));
//				if( entityItem == null) {
//					throw new BLException(BLErrorType.ENTITY_ITEM_NOT_EXISTS_ERROR,
//							"IGCO10000.E004","资产基本");
//				}
//				
				
				String esyscoding = cond.getEsyscoding_q();
				int level = CommonDefineUtils.TREE_LEVEL_CODE;
				int ccid = CommonDefineUtils.CCID_LENGTH + level;
				List<String> esyscodingList = new ArrayList<String>();
				esyscodingList.add(esyscoding.substring(0,ccid));
				while(esyscoding.length()>ccid){
					ccid=ccid+CommonDefineUtils.CCID_LENGTH;
					esyscodingList.add(esyscoding.substring(0,ccid));
				}
				IG225SearchCondImpl impl = new IG225SearchCondImpl();
				impl.setEsyscodingList(esyscodingList);
				
				query.append( session.getNamedQuery("IG002DAO.ConfigItemQuery").getQueryString());
				
				if(StringUtils.isNotEmpty(cond.getCname())) {
					query.append( " AND cname like :cname");
				}
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					query.append( " AND clabel = :clabel");
				}
				
				if(StringUtils.isNotEmpty(cond.getCiversion())){//按版本查询
					query.append( session.getNamedQuery("IG002DAO.ConfigItemQueryAppend2").getQueryString());
				}else{
					query.append( session.getNamedQuery("IG002DAO.ConfigItemQueryAppend").getQueryString());
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ci",IG002VW.class);

				q.setProperties(impl);
				
				if(StringUtils.isNotEmpty(cond.getCiversion())){
					q.setInteger("civersion",Integer.parseInt(cond.getCiversion()));
				}
				
				q.setInteger("eiid", cond.getEiid());
				
				if(StringUtils.isNotEmpty(cond.getCname())) {
					q.setString("cname", "%" + cond.getCname() + "%");
				}
				
				//clabel
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					q.setString("clabel", cond.getClabel_q());
				}
				
				List<IG002Info> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<IG002Info>) execute(action);
	}
	
	@SuppressWarnings("unchecked")
	public  List<IG002Info> initFindByCond(final IG002SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
//				EntityItemBL entityItemBL = (EntityItemBL) WebApplicationSupport.getBean("entityItemBL");
//				
//				EntityItem entityItem = entityItemBL.searchEntityItemByKey(Integer.parseInt(cond.getEiid()));
				
//				EntityItem entityItem = entityItemDAO.findByPK(Integer.parseInt(cond.getEiid()));
//				if( entityItem == null) {
//					throw new BLException(BLErrorType.ENTITY_ITEM_NOT_EXISTS_ERROR,
//							"IGCO10000.E004","资产基本");
//				}
//				
				
				String esyscoding = cond.getEsyscoding_q();
				int level = CommonDefineUtils.TREE_LEVEL_CODE;
				int ccid = CommonDefineUtils.CCID_LENGTH + level;
				List<String> esyscodingList = new ArrayList<String>();
				esyscodingList.add(esyscoding.substring(0,ccid));
				while(esyscoding.length()>ccid){
					ccid=ccid+CommonDefineUtils.CCID_LENGTH;
					esyscodingList.add(esyscoding.substring(0,ccid));
				}
				IG225SearchCondImpl impl = new IG225SearchCondImpl();
				impl.setEsyscodingList(esyscodingList);
				
				query.append( session.getNamedQuery("IG002DAO.InitConfigItemQuery").getQueryString());
				
//				if(StringUtils.isNotEmpty(cond.getCname())) {
//					query.append( " AND cname like :cname");
//				}
//				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
//					query.append( " AND clabel = :clabel");
//				}
				
				query.append( session.getNamedQuery("IG002DAO.InitConfigItemQueryAppend").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ci",IG002VW.class);
				impl.setEid(cond.getEid_q());
				q.setProperties(impl);
				
//				q.setInteger("eid", Integer.parseInt(cond.getEid()));
				
//				if(StringUtils.isNotEmpty(cond.getCname())) {
//					q.setString("cname", "%" + cond.getCname() + "%");
//				}
//				
//				//clabel
//				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
//					q.setString("clabel", cond.getClabel_q());
//				}
				
				List<IG002Info> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<IG002Info>) execute(action);
	}
}
