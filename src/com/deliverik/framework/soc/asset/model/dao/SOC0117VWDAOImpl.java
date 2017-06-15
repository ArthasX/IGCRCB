package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VW;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * 资产信息DAO实现
 * 
 */
public class SOC0117VWDAOImpl extends BaseHibernateDAOImpl<SOC0117VWInfo> implements SOC0117VWDAO {

	/**
	 * 构造函数
	 */
	public SOC0117VWDAOImpl(){
		super(SOC0117VW.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	@Override
	public List<SOC0117VWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eid"));
		List<SOC0117VWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	@Override
	public SOC0117VWInfo findByPK(Serializable pk) {
		SOC0117VWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0117VWSearchCond cond){
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
	public List<SOC0117VWInfo> findByCond(final SOC0117VWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("esyscoding"));
		List<SOC0117VWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}
	/**
	 * 新增类型下级用
	 */
	
	public List<SOC0117VWInfo> findByCond(final SOC0117VWSearchCond cond,final String orderType){
		DetachedCriteria c = getCriteria(cond);
		if("assetdomain".equals(orderType)){//查询角色资产管理内容树的结点全名使用
			c.addOrder(Order.asc("esyscoding"));
		}else{
			c.addOrder(Order.desc("eparcoding"));
		}
		
		List<SOC0117VWInfo> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 获取最大EID用
	 * @param cond
	 * @return
	 */
	public List<SOC0117VWInfo> findMaxEidByCond(final SOC0117VWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("eid"));
		
		List<SOC0117VWInfo> ret = findByCriteria(c);
		return ret;
	}
	
	public List<SOC0117VWInfo> findByCondCoding(final SOC0117VWSearchCond cond)
	{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("esyscoding"));
		List<SOC0117VWInfo> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 查询模型下资产数量（专项预案、应急资源专用）
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("SOC0117VWDAO.getEntityNum").getQueryString();
		
		Query q = session.createSQLQuery(sql);
		
		q.setParameter("esyscoding", rootEsyscoding+"%");
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> result  = q.list();
		
		return result;
		
	}
	/**
	 * 查询模型下资产数量（新版应急资源专用）
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode){
		
		Session session = getSession();
		String sql = " SELECT a.erid ,  a.ername ,  a.ercode ,  a.erparcode,  COUNT(b.eiid) AS account "
				+"FROM  emergencyresource a LEFT JOIN errelation b ON( b.ercode LIKE  '000%' AND b.deleteflag <> '1'  ) "
				+" WHERE  a.ercode LIKE '000%' GROUP BY  a.erid ,  a.ername ,  a.ercode ,  a.erparcode ORDER BY  ercode";
		if(!"allTree".equals(rootErcode)){
			sql = session.getNamedQuery("SOC0117VWDAO.getEntityNumNEW").getQueryString();
		}
		
		Query q = session.createSQLQuery(sql);
		
		if(!"allTree".equals(rootErcode)){
			q.setParameter("ercode", rootErcode+"%");
		}		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> result  = q.list();
		
		return result;
		
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0117VWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//数据库id
		if(cond.getId()!=null)
			c.add(Restrictions.eq("id", cond.getId()));
		if( !StringUtils.isEmpty(cond.getEcategory())){
			if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				//c.add(Restrictions.ne("esyscoding", "999007"));
				c.add(Restrictions.ne("esyscoding", "999008"));	
			}else if(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				c.add(Restrictions.ne("esyscoding", "999008"));	
			}
//			else if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
//					&& CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
//				c.add(Expression.ne("esyscoding", "999007"));	
//			}
		} else {
//			if(!StringUtils.isEmpty(cond.getEname())){
//			}else{
//				c.add(Expression.ne("esyscoding", "999007"));
//			}
			c.add(Restrictions.ne("esyscoding", "999007"));
			c.add(Restrictions.ne("esyscoding", "999008"));
		}
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEidStr())){
			c.add(Restrictions.eq("eid", cond.getEidStr()));
		}	
		//资产模型ID LIKE
		if( !StringUtils.isEmpty(cond.getEidStr_like())){
			c.add(Restrictions.like("eid", cond.getEidStr_like() + "%"));
		}	
		//资产模型编号
		if( !StringUtils.isEmpty(cond.getElabel())){
			c.add(Restrictions.eq("elabel", cond.getElabel()));
		}	
		//资产模型名
		if( !StringUtils.isEmpty(cond.getEname())){
			c.add(Restrictions.like("ename", "%" + cond.getEname() + "%"));
		}	
		
		//资产模型分类
		if( !StringUtils.isEmpty(cond.getEcategory_q())){
			c.add(Restrictions.eq("ecategory", cond.getEcategory()));
		}
		//资产模型分类
		if( !StringUtils.isEmpty(cond.getEcategory()) && 
				!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory()) 
				&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
			c.add(Restrictions.eq("ecategory", cond.getEcategory()));
		}
		//资产模型一级子类
		if( !StringUtils.isEmpty(cond.getEkey1())){
			c.add(Restrictions.eq("ekey1", cond.getEkey1()));
		}
		//资产模型二级子类
		if( !StringUtils.isEmpty(cond.getEkey2())){
			c.add(Restrictions.eq("ekey2", cond.getEkey2()));
		}
		//资产模型三级子类
		if( !StringUtils.isEmpty(cond.getEkey3())){
			c.add(Restrictions.eq("ekey3", cond.getEkey3()));
		}
		
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding()));
		}
		if( !StringUtils.isEmpty(cond.getEsyscoding_q())){
			c.add(Restrictions.like("eparcoding", cond.getEsyscoding_q()));
//			if("999".equals(cond.getEsyscoding_q())){
//				c.add(Expression.ne("esyscoding", "999007"));
//				c.add(Expression.ne("esyscoding", "999008"));
//			}
		}
		if( cond.getSelectList()!=null && cond.getSelectList().size()>0){
			c.add(Restrictions.in("esyscoding", cond.getSelectList()));
		}
		if( cond.getDelList()!=null && cond.getDelList().size()>0){
			c.add(Restrictions.not(Restrictions.in("esyscoding", cond.getDelList())));
		}
		
		//设备登记_类型选择tree
		if( !StringUtils.isEmpty(cond.getEsyscoding_tree()) && StringUtils.isEmpty(cond.getEparcoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding_tree()));
//			if(!StringUtils.isEmpty(cond.getEparcoding())){
//				c.add(Expression.or(Expression.eq("esyscoding", cond.getEsyscoding_tree()),Expression.eq("eparcoding", cond.getEparcoding())));
//			}
		}else{
			//类型登记_上级类型选择tree
			if(!StringUtils.isEmpty(cond.getEparcoding())){
				c.add(Restrictions.eq("eparcoding", cond.getEparcoding()));
			}
		}
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEparcoding()) && StringUtils.isEmpty(cond.getEsyscoding_tree())){
			c.add(Restrictions.eq("eparcoding", cond.getEparcoding()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_q())){
			c.add(Restrictions.eq("eparcoding", cond.getEparcoding_q()));
		}
		
		if( !StringUtils.isEmpty(cond.getEstatus())){
			c.add(Restrictions.eq("estatus", cond.getEstatus()));
		}
	
		//Entity tree 子结点集合
		if( !StringUtils.isEmpty(cond.getSyscoding_q())){
			c.add(Restrictions.like("esyscoding", cond.getSyscoding_q()+"%"));
		}
		//资产模型in条件
		if( cond.getEsyscodingList()!=null && cond.getEsyscodingList().size()>0){
			c.add(Restrictions.in("esyscoding", cond.getEsyscodingList()));
		}

		//资产模型状态修改
		if( !StringUtils.isEmpty(cond.getEparcoding_status())){
			c.add(Restrictions.eq("eparcoding", cond.getEparcoding_status()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_status_start())){
			c.add(Restrictions.eq("esyscoding", cond.getEparcoding_status_start()));
		}
		
		//查询not like Esyscoding_nq的模型
		if( !StringUtils.isEmpty(cond.getEsyscoding_nq())){
			c.add(Restrictions.not(Restrictions.like("esyscoding", cond.getEsyscoding_nq()+"%")));
		}
		
		if( cond.getDelList_q()!=null && cond.getDelList_q().size()>0){
			for(String esys:cond.getDelList_q()){
				c.add(Restrictions.not(Restrictions.like("esyscoding", esys+"%")));
			}
			
		}
		
		return c;
	}
	
	protected DetachedCriteria getCriterias(SOC0117VWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}

	/**
	 * 获取最大EID用,存数字类型
	 * @param cond
	 * @return
	 */
	public Integer findMaxEidByCondNotLikeCM(){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("SOC0117VWDAO.getEidNotLkeCmNum").getQueryString();
		
		Query q = session.createSQLQuery(sql);
		
		
		BigDecimal eid = (BigDecimal)q.uniqueResult();
		
		
		return eid.intValue();
	}
	/**
	 * 获取可导出一级资产列表
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0117VWInfo> searchEntityForExport(final SOC0117VWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                
                StringBuffer queryString = new StringBuffer();

                queryString.append(session.getNamedQuery("SOC0117VWDAO.searchEntityForExport").getQueryString());
                
				SQLQuery q = session.createSQLQuery(queryString.toString());
				
				q.addEntity(SOC0117VW.class);
				
				List<SOC0117VWInfo> list = q.list();
				
				session.clear();
				
				return list;
             }
         };
		return (List<SOC0117VWInfo>) execute(action);
	}
	

}
