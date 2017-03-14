package com.deliverik.framework.soc.asset.model.dao;

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

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0129VW;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * 资产项配置信息视图DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0129DAOImpl extends BaseHibernateDAOImpl<SOC0129Info> implements SOC0129DAO {

	
	/** EntityItem DAO */
	protected SOC0118DAO entityItemDAO;
	
	public void setEntityItemDAO(SOC0118DAO entityItemDAO) {
		this.entityItemDAO = entityItemDAO;
	}
	
	/**
	 * 构造函数
	 * 
	 */
	public SOC0129DAOImpl(){
		super(SOC0129VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0129SearchCond cond){
		List<SOC0129Info> ret = this.findByCond(cond);
		return ret.size();
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0129Info> findByCond(final SOC0129SearchCond cond, final int start, final int count){
		List<SOC0129Info> ret = this.findByCond(cond);
		return ret;
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0129SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		c.add(Expression.eq("eiid", cond.getEiid()));

		return c;
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<SOC0129Info> findByCond(final SOC0129SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				String esyscoding = cond.getEsyscoding_q();
				int level = CommonDefineUtils.TREE_LEVEL_CODE;
				int ccid = CommonDefineUtils.CCID_LENGTH + level;
				List<String> esyscodingList = new ArrayList<String>();
				String ekey2 = cond.getEkey2();
				//是否可继承标识，使用entity表中预留字段EKEY2, 0代表继承，1代表不继承
				if(StringUtils.isEmpty(ekey2) || EntityItemKeyWords.ENTITY_EKEY2_0.equals(ekey2)){
					esyscodingList.add(esyscoding.substring(0,ccid));
					while(esyscoding.length()>ccid){
						ccid=ccid+CommonDefineUtils.CCID_LENGTH;
						esyscodingList.add(esyscoding.substring(0,ccid));
					}
				}else{
					esyscodingList.add(esyscoding);
				}
				
				SOC0109SearchCondImpl impl = new SOC0109SearchCondImpl();
				impl.setEsyscodingList(esyscodingList);
				if(StringUtils.isNotEmpty(cond.getId())){
					query.append( session.getNamedQuery("ConfigItemVWDAO.ConfigItemQueryByVW").getQueryString());
				}else{
					query.append( session.getNamedQuery("ConfigItemVWDAO.ConfigItemQuery").getQueryString());
				}
				
				if(StringUtils.isNotEmpty(cond.getCname())) {
					query.append( " AND cname like :cname");
				}
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					query.append( " AND clabel = :clabel");
				}
				
				if(StringUtils.isNotEmpty(cond.getId())){
					query.append( session.getNamedQuery("ConfigItemVWDAO.ConfigItemQueryAppendByVW").getQueryString());
				}else{
					query.append( session.getNamedQuery("ConfigItemVWDAO.ConfigItemQueryAppend").getQueryString());
				}
				
				//System.out.println("SOC0129查询SQL为："+query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ci",SOC0129VW.class);

				q.setProperties(impl);
				
				q.setInteger("eiid", Integer.parseInt(cond.getEiid()));
				if(StringUtils.isNotEmpty(cond.getId())){
					q.setInteger("id", Integer.parseInt(cond.getId()));
				}
				if(StringUtils.isNotEmpty(cond.getCname())) {
					q.setString("cname", "%" + cond.getCname() + "%");
				}
				
				//clabel
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					q.setString("clabel", cond.getClabel_q());
				}
				
				List<SOC0129Info> list = q.list();
				
				session.clear();
				
				return list;
			}
				
		};
		return (List<SOC0129Info>) execute(action);
	}
	
	/**
	 * 常熟新的资产查询 
	 */
	@SuppressWarnings("unchecked")
	public  List<SOC0129Info> findSoc0129ByCond(final SOC0129SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				
				String esyscoding = cond.getEsyscoding_q();
				int level = CommonDefineUtils.TREE_LEVEL_CODE;
				int ccid = CommonDefineUtils.CCID_LENGTH + level;
				List<String> esyscodingList = new ArrayList<String>();
				String ekey2 = cond.getEkey2();
				//是否可继承标识，使用entity表中预留字段EKEY2, 0代表继承，1代表不继承
				if(StringUtils.isEmpty(ekey2) || EntityItemKeyWords.ENTITY_EKEY2_0.equals(ekey2)){
					esyscodingList.add(esyscoding.substring(0,ccid));
					while(esyscoding.length()>ccid){
						ccid=ccid+CommonDefineUtils.CCID_LENGTH;
						esyscodingList.add(esyscoding.substring(0,ccid));
					}
				}else{
					esyscodingList.add(esyscoding);
				}
				
				SOC0109SearchCondImpl impl = new SOC0109SearchCondImpl();
				impl.setEsyscodingList(esyscodingList);
				
				query.append( session.getNamedQuery("ConfigItemVWDAO.ConfigItemQuery").getQueryString());
				
				if(StringUtils.isNotEmpty(cond.getCname())) {
					query.append( " AND cname like :cname");
				}
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					query.append( " AND clabel = :clabel");
				}
				
				query.append("     ) B" +
						"   WHERE A.eiid = :eiid " +
						" ) C left outer join SOC0107 D" +
						" ON  (    C.cid = D.cid" +
						" AND  C.eiid = D.eiid" +
						"  AND  '"+cond.getCheckersion()+"' = D.civersion" +
						"    AND  C.eismallversion = D.cismallversion" +
						"   )" +
						"    ) ci order by ci.ccategory, ci.eiid, ci.corder, ci.cid  ");
				
				//System.out.println("SOC0129查询SQL为："+query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ci",SOC0129VW.class);

				q.setProperties(impl);
				
				q.setInteger("eiid", Integer.parseInt(cond.getEiid()));
				
				if(StringUtils.isNotEmpty(cond.getCname())) {
					q.setString("cname", "%" + cond.getCname() + "%");
				}
				
				//clabel
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					q.setString("clabel", cond.getClabel_q());
				}
				
				List<SOC0129Info> list = q.list();
				
				session.clear();
				
				return list;
			}
				
		};
		return (List<SOC0129Info>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0129Info> findByCondSoc0109(final SOC0129SearchCond cond, final int start, final int count){
		List<SOC0129Info> ret = this.findSoc0129ByCond(cond);
		return ret;
	}
	
	
}
