/*
 * ±±?????????í??????????????°??¨?ù????±????ù???¨????
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG500ONLYTB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG677VW;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;

/**
 * <p>????:?÷??????DAO????</p>
 * <p>?????è????1.?????ì?÷</p>
 * <p>          2.?÷?ü?ì?÷???í</p>
 * <p>          3.?????ì?÷???í</p>
 * <p>          4.???????ó?é????????????getSQL?¨??</p>
 * <p>          5.?????ì?÷?á??????????</p>
 * <p>          6.?ù???÷???à???é???±?°×??ó?÷????</p>
 * <p>          7.???????ó?????ì?÷???í</p>
 * <p>          8.???????ó?????ì?÷??????</p>
 * <p>          9.?÷??(°ü?????????í×?×??????????ì?÷???í</p>
 * <p>          10.?÷??(°ü?????????í×?×??????????ì?÷??????</p>
 * <p>          11.×??¨???÷???????ì?÷??????</p>
 * <p>          12.×??¨???÷???????ì?÷???í</p>
 * <p>          13.×??¨???÷???à???¤×÷?????ì?÷??????</p>
 * <p>          14.×??¨???÷???????ì?÷???í</p>
 * <p>          15.?ì?÷?????ú??</p>
 * <p>          17.???¨???§?à?????í?÷???????ì?÷???í</p>
 * <p>          18.???¨?????????í?÷???????ì?÷???í</p>
 * <p>???¨??????</p>
 */
@SuppressWarnings("deprecation")
public class IG500DAOImpl extends BaseHibernateDAOImpl<IG500Info> implements IG500DAO {
	
	static Log log = LogFactory.getLog(IG500TB.class);

	
	/**
	 * ???ì????
	 */
	public IG500DAOImpl(){
		super(IG500TB.class);
	}

	/**
	 * ???????????ì?÷
	 * @return ?ì?÷?á????
	 */
	@Override
	public List<IG500Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("prclosetime"));
		c.addOrder(Order.asc("propentime"));
		List<IG500Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ???????÷?ü?ì?÷???í
	 * @param prid ?÷?ü
	 * @return ?ì?÷?á??
	 */
	@Override
	public IG500Info findByPK(Serializable prid) {

		IG500Info pr = super.findByPK(prid);
		if(pr == null) return null;

		return pr;
	}

	/**
	 * ???????????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	public List<IG500Info> findByCond(final IG500SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getOrder())){
			if("ASC".equals(cond.getSing())){
				c.addOrder(Order.asc(cond.getOrder()));
			}else{
				c.addOrder(Order.desc(cond.getOrder()));	
			}
		}else{
			c.addOrder(Order.desc("prclosetime"));
			c.addOrder(Order.asc("propentime"));
		}
		
		List<IG500Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 演练流程查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchDrillProcess(IG500SearchCond cond,final int start, final int count){
		Session session = getSession();
		
		StringBuffer querySQL = new StringBuffer(session.getNamedQuery("IG500DAO.searchDrillProcess").getQueryString().replaceAll(":pdid", "'"+cond.getPrpdid()+"'"));
		
		IG500SearchCondImpl newCond = (IG500SearchCondImpl)cond;
		
		newCond.setPrpdid(null);
		
		getSQL(newCond, querySQL);
		
		querySQL.append(" order by propentime desc) where rownumber_ >"+start+" and rownumber_<="+(start+count));
		
		SQLQuery q = session.createSQLQuery(querySQL.toString());
		
		q.setProperties(cond);
		
		q.addEntity("IG500TB",IG500TB.class);
		
//		setFetchPoint(q, start, count);
		
		List<IG500Info> list = q.list();
		session.clear();
		return list;
		
		
	}
	/**
	 * ?????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> queryIG500EntityList(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryProcessRecordEntityList").getQueryString());
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG500TB",IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * ?????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryProcessRecordEntityListByProcessInfo").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				if(StringUtils.isNotEmpty(cond.getOrder())){
					query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG500TB",IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * ???????????ì?÷?á??????????
	 * @param cond ?ì?÷????
	 * @return ?ì?÷?á??????
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryProcessRecordEntityCountByProcessInfo").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ?????????????ó?é????????????getSQL?¨??
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(IG500SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//流程组发起的单一流程pid字段为空
		if(cond.getPid() != null && cond.getPid()==99999){
			c.add(Restrictions.isNull("pid"));
		}
		if(cond.getVarnames() != null && cond.getVarnames().length > 0){
			for(int i=0;i<cond.getVarnames().length;i++){
				String mode = cond.getVarmodes().length > i && StringUtils.isNotEmpty(cond.getVarmodes()[i]) ? cond.getVarmodes()[i] : "";
				if(StringUtils.isNotEmpty(cond.getVarvalues()[i])){
					if("eq".equals(mode)){
						c.add(Restrictions.sqlRestriction(" exists (select 1 from ig599 pit where pit.prid = this_.prid and pit.pivarname = '" + cond.getVarnames()[i] + "' and pit.pivarvalue = '" + cond.getVarvalues()[i] + "') "));
					}else{
						c.add(Restrictions.sqlRestriction(" exists (select 1 from ig599 pit where pit.prid = this_.prid and pit.pivarname = '" + cond.getVarnames()[i] + "' and pit.pivarvalue like '%" + cond.getVarvalues()[i] + "%') "));
					}
				}else{
					if("isNull".equals(mode)){
						c.add(Restrictions.sqlRestriction(" exists (select 1 from ig599 pit where pit.prid = this_.prid and pit.pivarname = '" + cond.getVarnames()[i] + "' and (pit.pivarvalue is null or pit.pivarvalue = '')) "));
					}else if("isNotNull".equals(mode)){
						c.add(Restrictions.sqlRestriction(" exists (select 1 from ig599 pit where pit.prid = this_.prid and pit.pivarname = '" + cond.getVarnames()[i] + "' and pit.pivarvalue is not null) "));
					}
				}
			}
		}
		
		//?÷???????é??
		if( !StringUtils.isEmpty(cond.getPrdesc())){
			c.add(Expression.like("prdesc","%"+cond.getPrdesc()+"%"));
		}
		//
		if( !StringUtils.isEmpty(cond.getPrtitle())){
			c.add(Expression.like("prtitle", "%"+cond.getPrtitle()+"%"));
		}
		
		// ?é???÷???±???é?????¨???§???????????÷??
		if( !StringUtils.isEmpty(cond.getPpusername_like())){
			c.add(Expression.sql(" exists (select 1 from ig337 pp where this_.prid = pp.prid and pp.ppusername like '%" + cond.getPpusername_like()+ "%') "));
		}
		// ?é???÷???±???é?????¨???§???????????÷??
		if( !StringUtils.isEmpty(cond.getPpuserid())){
			c.add(Expression.sql(" exists (select 1 from ig337 pp where this_.prid = pp.prid and pp.ppusersid = '" + cond.getPpuserid() + "' "));
		}
		// ?é???÷???±???é?????¨???§???????????÷??
		if( !StringUtils.isEmpty(cond.getPpusername_like())){
			c.add(Expression.sql(" exists (select 1 from ig337 pp where this_.prid = pp.prid and pp.ppusername like '%" + cond.getPpusername_like()+ "%') "));
		}
		if( !StringUtils.isEmpty(cond.getPrtype())){
			if(cond.getPrtype().equals("P_I")){
				//????????
				c.add(Expression.or(Expression.eq("prtype", "I"),Expression.eq("prtype", "P")));
			}else if("C_D".equals(cond.getPrtype())){
				//±??ü??????
				c.add(Expression.or(Expression.eq("prtype", "C"),Expression.eq("prtype", "D")));
			}else if("WB".equals(cond.getPrtype())){
				if( !StringUtils.isEmpty(cond.getApproveflag()) && "0".equals(cond.getApproveflag()) && !StringUtils.isEmpty(cond.getUserid_q())){
					c.add(Expression.like("prtype", cond.getPrtype()+"%"));
					c.add(Expression.eq("pruserid", cond.getUserid_q()));
				}else{
					c.add(Expression.like("prtype", cond.getPrtype()+"%"));
				}
			}else{
				c.add(Expression.like("prtype", cond.getPrtype()+"%"));
			}
		}
		
		if(cond.getPrTypeArray() !=null ){
			c.add(Expression.in("prtype",cond.getPrTypeArray()));
		}
		if( !StringUtils.isEmpty(cond.getPrstatus())){
			if(cond.getPrstatus().length() > 1){
				c.add(Expression.sql(" exists (select 1 from ig591 temp where temp.prid = this_.prid and temp.psdid = " + cond.getPrstatus() + ") "));
			}else{
				c.add(Expression.eq("prstatus", cond.getPrstatus()));
			}
		}
		if(cond.getPrStatusArray()!=null){
			c.add(Expression.in("prstatus",cond.getPrStatusArray()));
		}
		if( !StringUtils.isEmpty(cond.getPrusername())){
			c.add(Expression.like("prusername", "%"+cond.getPrusername()+"%"));
		}
		if( cond.getPrid()!=null && cond.getPrid()!=0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		//???????±????
		if( !StringUtils.isEmpty(cond.getPrurgency())){
			c.add(Expression.eq("prurgency", cond.getPrurgency()));
		}
		//?????°?ì????
		if( !StringUtils.isEmpty(cond.getPrimpact())){
			c.add(Expression.eq("primpact", cond.getPrimpact()));
		}
		//??????????
		if( !StringUtils.isEmpty(cond.getPrpriority())){
			c.add(Expression.eq("prPriority", cond.getPrpriority()));
		}
		//?????????±??
		if( !StringUtils.isEmpty(cond.getPropentime())){
			if("svc".equals(cond.getSelectMode())){
				c.add(Expression.ge("prplantime", cond.getPropentime()));
				if(cond.getPrclosetime()!= null && cond.getPrclosetime().length() == 10) {
					c.add(Expression.le("prplantime", cond.getPrclosetime() + " 23:59"));
				} else {
					c.add(Expression.le("prplantime", cond.getPrclosetime()));
				}
			}else{
				c.add(Expression.ge("propentime", cond.getPropentime()));
			}
		}
		//?????????±??
		if( !StringUtils.isEmpty(cond.getPrclosetime()) && !"svc".equals(cond.getSelectMode())){
			if(cond.getPrclosetime().length() == 10) {
				c.add(Expression.le("propentime", cond.getPrclosetime() + " 23:59"));
			} else {
				c.add(Expression.le("propentime", cond.getPrclosetime()));
			}
		}
		
		//?????????±??
		if( !StringUtils.isEmpty(cond.getPropentime_like())){
			c.add(Expression.like("propentime", "%" + cond.getPropentime_like() + "%"));
		}
		//?÷????????
		if( !StringUtils.isEmpty(cond.getPruserid())){
			c.add(Expression.eq("pruserid", cond.getPruserid()));
		}
		//?÷??????????id
		if(cond.getPrroleid()!=null&&cond.getPrroleid()!=0){
			c.add(Expression.eq("prroleid", cond.getPrroleid()));
		}
		//?÷???à??id
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			c.add(Expression.like("prpdid", cond.getPrpdid()+"%"));
		}
		//?é????×é?÷???à??id
		if(cond.getPrpdid_like_or() != null && cond.getPrpdid_like_or().length > 0){
			String[] prpdid_like_or = cond.getPrpdid_like_or();
			StringBuffer query = new StringBuffer();
			query.append(" ( ");
			for (int i = 0; i < prpdid_like_or.length; i++) {
				query.append(" prpdid like '").append(prpdid_like_or[i]).append("%' ");
				if(i < prpdid_like_or.length - 1){
					query.append(" or ");
				}
			}
			query.append(" ) ");
			c.add(Expression.sql(query.toString()));
		}
		if(StringUtils.isNotEmpty(cond.getPrid_in())){
			
			List<Integer> prids = new ArrayList<Integer>();
			
			for(String str :cond.getPrid_in().split(",") ){
				prids.add(Integer.valueOf(str));
			}
			c.add(Restrictions.in("prid",prids));
		}
		//未关闭流程
		if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("Y")){
			c.add(Expression.isNull("prclosetime"));
		}
		//????±??÷??
        if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("N")){
            c.add(Expression.isNotNull("prclosetime"));
        }
		//±??ü????×??????????í?????ó??
		if(!StringUtils.isEmpty(cond.getPrtype()) && "C_D".equals(cond.getPrtype())){
			c.add(Expression.or(Expression.eq("prstatus", "E"),Expression.eq("prstatus", "V")));
		}
		//?????±??
		if(!StringUtils.isEmpty(cond.getPrplantime_like())){
			c.add(Expression.like("prplantime", cond.getPrplantime_like()+"%"));
		}
		//???ú?±????(?÷?????í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrplantime())&& !"wkm".equals(cond.getSelectMode())){
			c.add(Expression.ge("prplantime", cond.getPrplantime()));
		}
		//???ú?±????(?÷?????í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrduration())&& !"wkm".equals(cond.getSelectMode())){
			if(cond.getPrduration().length() == 10) {
				c.add(Expression.le("prplantime", cond.getPrduration() + " 23:59"));
			} else {
				c.add(Expression.le("prplantime", cond.getPrduration()));
			}
		}
		//?¤×÷?????±????(?¤×÷???í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrplantime()) && "wkm".equals(cond.getSelectMode())){
			c.add(Expression.ge("propentime", cond.getPrplantime()));
		}
		//?¤×÷?????±????(?¤×÷???í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrduration()) && "wkm".equals(cond.getSelectMode())){
			if(cond.getPrduration().length() == 10) {
				c.add(Expression.le("propentime", cond.getPrduration() + " 23:59"));
			} else {
				c.add(Expression.le("propentime", cond.getPrduration()));
			}
		}
		if (cond.getIsWork()==1) {
			c.add(Expression.like("prtype", "W%"));
		}
		if(cond.getPrassetid() != null && cond.getPrassetid() > 0){
			c.add(Expression.eq("prassetid", cond.getPrassetid()));
		}
		if( !StringUtils.isEmpty(cond.getPrassetcategory())){
			c.add(Expression.eq("prassetcategory", cond.getPrassetcategory()));
		}
		if( !StringUtils.isEmpty(cond.getPrserialnum())){
			c.add(Expression.like("prserialnum", "%"+cond.getPrserialnum()+"%"));
		}
		
		// ?à???÷???????¤????like??????×??¨???÷???÷???à???????¤????????
		if( null != cond.getPrserialnum_likeArr() && cond.getPrserialnum_likeArr().length > 0){
		    String[] pa = cond.getPrserialnum_likeArr();
		    StringBuffer sql = new StringBuffer();
		    sql.append(" (");
		    for(int i = 0; i < pa.length; i++){
		        sql.append(" prserialnum like '%").append(pa[i]).append("%'");
		        if(i != pa.length - 1){
		            sql.append(" or ");
		        }
		    }
		    sql.append(") ");
		    c.add(Expression.sql(sql.toString()));
		    sql = null;
		}

		if( !StringUtils.isEmpty(cond.getPrsubstatus())){
			c.add(Expression.eq("prsubstatus", cond.getPrsubstatus()));
		}else if("svc".equals(cond.getSelectMode())){
			c.add(Expression.isNotNull("prsubstatus"));
		}
		
		// ?÷??×?????????
		if(StringUtils.isNotEmpty(cond.getPrstatus_ne())){
			c.add(Expression.ne("prstatus", cond.getPrstatus_ne()));
		}
		
		if(cond.getPridNotInList() != null && cond.getPridNotInList().size()>0){
			c.add(Expression.not(Expression.in("prid", cond.getPridNotInList())));
		}
		if(cond.getPrserialnumNotInList() != null && cond.getPrserialnumNotInList().size()>0){
			c.add(Expression.not(Expression.in("prserialnum", cond.getPrserialnumNotInList())));
		}
		//?÷???????é??
		if( !StringUtils.isEmpty(cond.getPrdesc())){
			c.add(Expression.like("prdesc","%"+cond.getPrdesc()+"%"));
		}
		
		if((StringUtils.isNotEmpty(cond.getPrtype())||cond.getPrTypeArray()!=null)&&StringUtils.isNotEmpty(cond.getUserid_q())){
			if(StringUtils.isNotEmpty(cond.getPrtype())){
				String sql = " not exists (select prid from IG500 pr where pr.prid = this_.prid and pr.prtype = '"+cond.getPrtype()+"' and (pr.prstatus = 'D' OR pr.prstatus = 'I') and pr.pruserid <> '" + cond.getUserid_q() + "' )";
				c.add(Expression.sql(sql));
			}else{
				String strValue ="";
				for(String value:cond.getPrTypeArray()){
					strValue=strValue+"'"+value+"',";
				}
				strValue = strValue.substring(0,strValue.length()-1);
				String sql = " not exists (select prid from IG500 pr where pr.prid = this_.prid and pr.prtype in ("+strValue+") and (pr.prstatus = 'D' OR pr.prstatus = 'I') and pr.pruserid <> '" + cond.getUserid_q() + "' )";
				c.add(Expression.sql(sql));
			}
		}
		
		if(StringUtils.isNotEmpty(cond.getApproveflag()) && "0".equals(cond.getApproveflag()) && StringUtils.isNotEmpty(cond.getUserid_q())){
			String sql = " not exists (select prid from IG500 pr where pr.prid = this_.prid and pr.prtype = 'WB' and pr.pruserid <> '" + cond.getUserid_q() + "' )";
			c.add(Expression.sql(sql));
		}
		//×??¨???¤×÷?é?????é??????×??????¤×÷
		if(StringUtils.isNotEmpty(cond.getPrtype())&&cond.getPrtype().equals("WD")){
			c.add(Expression.sql(" not exists (select pdid from ig380 ig380 where ig380.pdid=this_.prpdid and (ig380.pdstatus='t' or ig380.pdstatus='i'))"));
		}
		//?????¤×÷?é??
		if(StringUtils.isNotEmpty(cond.getPrtype())&&cond.getPrtype().equals("W")){
			c.add(Expression.sql(" exists (select pdid from ig380 ig380 where ig380.pdid=this_.prpdid and ig380.pdstatus='t')"));
		}
		return c;
	}
	
	/**
	 * ???????????ì?÷?á??????????
	 * @param cond ?ì?÷????
	 * @return ?ì?÷?á??????
	 */
	public int getSearchCount(final IG500SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ???????ù???÷???à???é???±?°×??ó?÷????
	 * @param prserialnum ?÷????
	 * @return ×??ó?÷????
	 */
	@SuppressWarnings("rawtypes")
	public String getMaxPrserialnum(String prserialnum){
		
		String sql =  "select max(pr.prserialnum) from IG500TB pr where pr.prserialnum like :prserialnum";
		NamedParamMap p = getNamedParamMap();
		p.setString("prserialnum", prserialnum+"%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
	/**
	 * ?????????????ó?????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> queryServiceRequestList(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.queryServiceRequestList").getQueryString());
				
				getSQL(cond, query);
				
				if(StringUtils.isNotEmpty(cond.getOrder())){
					if("ASC".equals(cond.getSing())){
						query.append(" ORDER BY "+cond.getOrder()+" asc ");
					}else{
						query.append(" ORDER BY "+cond.getOrder()+" desc ");
					}
				}else{
					
					query.append(" ORDER BY prclosetime desc, propentime");
				}

				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pr",IG500TB.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * ?????????????ó?????ì?÷??????
	 * @param ?ì?÷????
	 * @return ?????ì?÷??????
	 */
	@SuppressWarnings("unchecked")
	public int queryServiceRequestListCount(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.queryServiceRequestList").getQueryString());
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.addEntity("pr",IG500TB.class);
				
				q.setProperties(cond);
				setFetchPoint(q, 0, 0);
				
				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * ???????÷??(°ü?????????í×?×??????????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> queryIG500InfoSubStatusList(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchIG590").getQueryString());
				
				getSubstatusSQL(cond, query);
				
				if(StringUtils.isNotEmpty(cond.getOrder())){
					if("ASC".equals(cond.getSing())){
						query.append(" ORDER BY "+cond.getOrder()+" asc ");
					}else{
						query.append(" ORDER BY "+cond.getOrder()+" desc ");
					}
				}else{
					
					query.append(" ORDER BY prclosetime desc, propentime desc");
				}
				
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pr",IG500TB.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}

	
	/**
	 * ???????÷??(°ü?????????í×?×??????????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500ONLYInfo> queryIG500ONLYInfoSubStatusList(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchIG590").getQueryString());
				
				getSubstatusSQL(cond, query);
				
				if(StringUtils.isNotEmpty(cond.getOrder())){
					if("ASC".equals(cond.getSing())){
						query.append(" ORDER BY "+cond.getOrder()+" asc ");
					}else{
						query.append(" ORDER BY "+cond.getOrder()+" desc ");
					}
				}else{
					
					query.append(" ORDER BY prclosetime desc, propentime");
				}
				
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pr",IG500ONLYTB.class);

				q.setProperties(cond);
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500ONLYInfo> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500ONLYInfo>) execute(action);
	}
	
	/**
	 * ???????÷??(°ü?????????í×?×??????????ì?÷??????
	 * @param ?ì?÷????
	 * @return ?÷??(°ü?????????í×?×??????????ì?÷??????
	 */
	@SuppressWarnings("unchecked")
	public int queryIG500InfoSubStatusListCount(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchIG590").getQueryString());
				
				getSubstatusSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pr",IG500TB.class);

				q.setProperties(cond);
				setFetchPoint(q, 0, 0);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list.size();
			}
		};
		return (Integer) execute(action);
	}


	/**
	 * ???????÷??(°ü?????????í×?×??????????ì?÷??????
	 * @param ?ì?÷????
	 * @return ?÷??(°ü?????????í×?×??????????ì?÷??????
	 */
	@SuppressWarnings("unchecked")
	public int queryIG500ONLYInfoSubStatusListCount(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchIG590").getQueryString());
				
				getSubstatusSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pr",IG500ONLYTB.class);

				q.setProperties(cond);
				setFetchPoint(q, 0, 0);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500ONLYInfo> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * ??????×??¨???÷???????ì?÷??????
	 * @param ?ì?÷????
	 * @return ×??¨???÷???????ì?÷??????
	 */
	public int searchIG500CountForSelfDef(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchCountProcessRecordByUseridAndRoleid").getQueryString());

				getSQLForSelfDef(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);
				
				session.clear();

				return getCount(q.list());

			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * ??????×??¨???÷???????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> searchIG500InfoForSelfDef(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchProcessRecordByUseridAndRoleid").getQueryString());
				
				getSQLForSelfDef(cond, query);
				
				query.append(" ORDER BY pr.prclosetime desc, pr.propentime");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pr",IG500TB.class);

				q.setProperties(cond);
				
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	
	/**
	 * ??????×??¨???÷???à???¤×÷?????ì?÷??????
	 * @param ?ì?÷????
	 * @return ×??¨???÷???????ì?÷??????
	 */
	public int searchIG500InfoCountForRelatedWork(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchCountProcessRecordByRoleid").getQueryString());

				getSQLForSelfDef(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);
				
				session.clear();

				return getCount(q.list());

			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * ??????×??¨???÷???????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> searchIG500InfoForRelatedWork(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchProcessRecordByRoleid").getQueryString());
				
				getSQLForSelfDef(cond, query);
				
				query.append(" ORDER BY pr.prclosetime desc, pr.propentime");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pr",IG500TB.class);

				q.setProperties(cond);
				
				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	
	
	
	
	
	
	
	/**
	 * ???????ì?÷?????ú??
	 * 
	 * @param cond ?ì?÷????
	 * @return ?ì?÷???ì?÷?????à
	 */
	protected void getSQLForSelfDef(IG500SearchCond cond, StringBuffer query){
		
		if( !StringUtils.isEmpty(cond.getPrserialnum())){
//			query.append(" AND pr.prserialnum = :prserialnum");
			query.append(" AND pr.prserialnum like '%").append(cond.getPrserialnum()).append("%'");
		}
		if( !StringUtils.isEmpty(cond.getPrusername())){
//			query.append(" AND pr.prusername = :prusername");
			query.append(" AND pr.prusername like '%").append(cond.getPrusername()).append("%'");
		}
		
		if( !StringUtils.isEmpty(cond.getPrtitle())){
			query.append(" AND pr.prtitle like '%").append(cond.getPrtitle()).append("%'");
		}
		
		if( !StringUtils.isEmpty(cond.getPrtype())){
			if(cond.getPrtype().equals("P_I")){
				query.append(" AND (pr.prtype = 'I' OR pr.prtype = 'P')");
			}else{
				query.append(" AND pr.prtype = :prtype");
			}
		}
		
		if(cond.getPrTypeArray() != null && cond.getPrTypeArray().length > 0){
			if(cond.getPrTypeArray()[0].equals("I")){
				query.append(" AND (pr.prtype = 'I' OR pr.prtype = 'ID')");
			}else if(cond.getPrTypeArray()[0].equals("C")){
				query.append(" AND (pr.prtype = 'C' OR pr.prtype = 'CD')");
			}
		}
		
		if( !StringUtils.isEmpty(cond.getPrstatus())){
			if("D_E".equals(cond.getPrstatus())) {
				query.append(" AND (pr.prstatus = 'D' or pr.prstatus = 'E')");
			} else {
				query.append(" AND pr.prstatus = :prstatus");
			}
		}
		if( cond.getPrid()!=null && cond.getPrid()!=0){
			query.append(" AND pr.prid = :prid");
		}
		//???????±????
		if( !StringUtils.isEmpty(cond.getPrurgency())){
			query.append(" AND pr.prurgency = :prurgency");
		}
		//?????????±??
		if( !StringUtils.isEmpty(cond.getPropentime())){
			query.append(" AND pr.propentime >= :propentime");
		}
		//?????????±??
		if( !StringUtils.isEmpty(cond.getPrclosetime())){
			if(cond.getPrclosetime().length() == 10) {
				query.append(" AND pr.propentime <= (:prclosetime ||' 23:59')");
			} else {
				query.append(" AND pr.propentime <= :prclosetime");
			}
		}
		//?÷????????
		if( !StringUtils.isEmpty(cond.getPruserid())){
			query.append(" AND pr.pruserid = :pruserid");
		}
		//?÷??????????id
		if( cond.getPrroleid() != null && cond.getPrroleid() != 0){
			query.append(" AND pr.prroleid = :prroleid");
		}
		//?÷???à??id
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			query.append(" AND pr.prpdid = :prpdid");
		}
		//????±??÷??
		if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("Y")){
			query.append(" AND pr.prstatus != 'C'");
		}
		
		//???ú?±????(?÷?????í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrplantime())&& !"wkm".equals(cond.getSelectMode())){
			query.append(" AND pr.prplantime >= :prplantime");
		}
		//???ú?±????(?÷?????í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrduration())&& !"wkm".equals(cond.getSelectMode())){
			if(cond.getPrplantime() != null && cond.getPrplantime().length() == 10) {
				query.append(" AND pr.prplantime <= (:prplantime ||' 23:59')");
			} else {
				query.append(" AND pr.prplantime <= :prplantime ||' 23:59'");
			}
		}
		//?¤×÷?????±????(?¤×÷???í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrplantime()) && "wkm".equals(cond.getSelectMode())){
			query.append(" AND pr.propentime >= :propentime");
		}
		//?¤×÷?????±????(?¤×÷???í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrduration()) && "wkm".equals(cond.getSelectMode())){
			if(cond.getPropentime() != null && cond.getPropentime().length() == 10) {
				query.append(" AND pr.propentime <= (:propentime ||' 23:59')");
			} else {
				query.append(" AND pr.propentime <= :propentime");
			}
		}
		if (cond.getIsWork()==1) {
			query.append(" AND pr.prtype like 'W%'");
		}
		if(cond.getPrassetid() != null && cond.getPrassetid() > 0){
			query.append(" AND pr.prassetid = :prassetid");
		}
		if( !StringUtils.isEmpty(cond.getPrassetcategory())){
			query.append(" AND pr.prassetcategory = :prassetcategory");
		}
		
		if( !StringUtils.isEmpty(cond.getPrsubstatus())){
			query.append(" AND pr.prsubstatus = :prsubstatus");
		}
		
	}
	
	
	
	/**
	 * ???????ì?÷?????ú??
	 * 
	 * @param cond ?ì?÷????
	 * @param query sql
	 * @return ?ì?÷???ì?÷?????à
	 */
	protected void getSQL(IG500SearchCond cond, StringBuffer query){
		if( !StringUtils.isEmpty(cond.getPrtitle())){
			query.append(" AND pr.prtitle like ('%'||:prtitle||'%') ");
		}
		if( !StringUtils.isEmpty(cond.getPrserialnum())){
			query.append(" AND pr.prserialnum like ('%'||:prserialnum||'%') ");
		}
		if( !StringUtils.isEmpty(cond.getPrusername())){
			query.append(" AND pr.prusername like ('%'||:prusername||'%') ");
		}
		if(cond.getPrtypes()!=null&&cond.getPrtypes().length>0){
            String appendSQL= " AND pr.prtype IN (";
            for(String str:cond.getPrtypes()){
                appendSQL+="'"+str+"',";
            }
            appendSQL = appendSQL.substring(0,appendSQL.length()-1);
            appendSQL +=" )";
            query.append(appendSQL);
        }
		//?é????×é?÷???à??id
        if(cond.getPrpdid_like_or() != null && cond.getPrpdid_like_or().length > 0){
            String[] prpdid_like_or = cond.getPrpdid_like_or();
            query.append(" AND ( ");
            for (int i = 0; i < prpdid_like_or.length; i++) {
                query.append(" prpdid like '").append(prpdid_like_or[i]).append("%' ");
                if(i < prpdid_like_or.length - 1){
                    query.append(" or ");
                }
            }
            query.append(" ) ");
        }
		// ?é???÷???±???é?????¨???§???????????÷??
		if( !StringUtils.isEmpty(cond.getPpusername_like())){
			query.append(" AND exists (select 1 from ig337 pp where pr.prid = pp.prid and pp.ppusername like ('%'||:ppusername_like||'%') ) ");
		}
		// ?é???÷???±???é?????¨???§???????????÷??
		if( !StringUtils.isEmpty(cond.getPpuserid())){
			query.append(" AND exists (select 1 from ig337 pp where pr.prid = pp.prid and pp.ppuserid = :ppuserid ");
			if(!StringUtils.isEmpty(cond.getPpstatus())){
				query.append(" and ppstatus like :ppstatus ");
			}
			// ?é???÷???????é?????¨???§????????????
			if(StringUtils.isNotBlank(cond.getPpbacktime_isNull())){
				if("0".equals(cond.getPpbacktime_isNull())){
					query.append("and pp.ppbacktime is not null) ");
				}else if("1".equals(cond.getPpbacktime_isNull())){
					query.append("and pp.ppbacktime is null) ");
				}				
			}else{
				query.append("and ppproctime is not null) ");
			}
		}
		if( !StringUtils.isEmpty(cond.getPrstatus())){
			query.append(" AND pr.prstatus = :prstatus");
		}
		if( !StringUtils.isEmpty(cond.getPrurgency())){
			query.append(" AND pr.prurgency = :prurgency");
		}
		if( !StringUtils.isEmpty(cond.getPropentime())){
			query.append(" AND pr.propentime >= :propentime");
		}
		if( !StringUtils.isEmpty(cond.getPrclosetime())){
			if(cond.getPrclosetime().length() == 10) {
				query.append(" AND pr.propentime <= (:prclosetime ||' 23:59')");
			} else {
				query.append(" AND pr.propentime <= :prclosetime");
			}
		}
		//?÷???????é??
		if( !StringUtils.isEmpty(cond.getPrdesc())){
			query.append(" AND pr.prdesc like ('%'||:prdesc||'%')");
		}
		//????????
		if( !StringUtils.isEmpty(cond.getPrassetname())){
		    query.append(" AND pr.prassetname = :prassetname");
		}

		//?÷???à??ID
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			query.append(" AND pr.prpdid like (:prpdid||'%')");
		}
		//?÷???????à??
		if(StringUtils.isNotEmpty(cond.getPrtype())){
			//?????¤×÷?é????
			if("W".equals(cond.getPrtype())) {
				query.append(" AND pr.prtype = 'WD'");
				query.append(" AND pr.prassetcategory = '1'");
			} else {
				query.append(" AND pr.prtype = :prtype");
			}
		}
		if(StringUtils.isNotEmpty(cond.getProrgid_like())){
			query.append(" AND pr.prorgid like (:prorgid_like||'%') ");
		}
		if(cond.getPrroleid()!=null&&cond.getPrroleid()>0){
			query.append(" and pr.prroleid = :prroleid ");
		}
		if(StringUtils.isNotEmpty(cond.getProrgid_in())){
			query.append(" AND prorgid IN ('").append(cond.getProrgid_in()).append("')");
		}
		if(StringUtils.isNotEmpty(cond.getPrid_in())){
			query.append(" AND prid IN (").append(cond.getPrid_in()).append(")");
		}
		if(StringUtils.isNotEmpty(cond.getPdactname())){
			query.append(" and pd.pdactname = :pdactname ");
		}
		if(cond.getPrroleid_in() != null && cond.getPrroleid_in().size() > 0){
			query.append(" and pr.prroleid in (");
			for(int i=0;i<cond.getPrroleid_in().size();i++){
				if(i > 0){
					query.append(",");
				}
				query.append(cond.getPrroleid_in().get(i));
			}
			query.append(") ");
		}
		if(cond.getPrroleid_not_in() != null && cond.getPrroleid_not_in().size() > 0){
			query.append(" and pr.prroleid not in (");
			for(int i=0;i<cond.getPrroleid_not_in().size();i++){
				if(i > 0){
					query.append(",");
				}
				query.append(cond.getPrroleid_not_in().get(i));
			}
			query.append(") ");
		}
		
		//????±??÷??
		if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("Y")){
			query.append(" AND pr.prstatus != 'C'");
		}
		
		if(StringUtils.isNotEmpty(cond.getPropentime_like())){
			query.append(" and pr.propentime like :propentime_like || '%'");
		}
		
		if(StringUtils.isNotEmpty(cond.getPrclosetime_like())){
			query.append(" and pr.prclosetime like :prclosetime_like || '%' ");
		}
		
		if(StringUtils.isNotEmpty(cond.getContent())){
			query.append(" and (");
			query.append(" pr.prtitle like '%' || :content || '%' ");
			query.append(" or pr.prdesc like '%' || :content || '%' ");
			query.append(" or exists (select 1 from ig599 ti where pr.prid = ti.prid and ti.pivarvalue like '%' || :content || '%' )");
			query.append(")");
		}
		if(StringUtils.isNotEmpty(cond.getPrstatus_ne())){
			query.append(" and pr.prstatus <> :prstatus_ne ");
		}
		//??????????????
		if(StringUtils.isNotBlank(cond.getAlarm_Is())){
			if("1".equals(cond.getAlarm_Is())){
				query.append(" and exists (select 1 from ig599 pp where pp.prid = pr.prid and pp.pivarname like '????????' and pp.pivarvalue like '?à??????') ");
			}else if("0".equals(cond.getAlarm_Is())){
				query.append(" and exists (select 1 from ig599 pp where pp.prid = pr.prid and pp.pivarname like '????????' and pp.pivarvalue  not like '?à??????') ");
			}
		}
		
	}
	
	/**
	 * ???????ì?÷?????ú??
	 * 
	 * @param cond ?ì?÷????
	 * @param query sql
	 * @return ?ì?÷???ì?÷?????à
	 */
	protected void getSubstatusSQL(IG500SearchCond cond, StringBuffer query){
		
		//
		if( !StringUtils.isEmpty(cond.getPrtitle())){
			query.append(" AND pr.prtitle like ('%' || :prtitle ||'%')");
		}
		
		if( !StringUtils.isEmpty(cond.getPrtype())){
			if(cond.getPrtype().equals("P_I")){
				query.append(" AND (pr.prtype = 'I' OR pr.prtype = 'P')");
			}else{
				query.append(" AND pr.prtype = :prtype");
			}
		}
		if(StringUtils.isNotEmpty(cond.getPrid_in())){
			query.append(" AND prid IN (").append(cond.getPrid_in()).append(") ");
		}
		if(cond.getPrtypes()!=null&&cond.getPrtypes().length>0){
			String appendSQL= " AND pr.prtype IN (";
			for(String str:cond.getPrtypes()){
				appendSQL+="'"+str+"',";
			}
			appendSQL = appendSQL.substring(0,appendSQL.length()-1);
			appendSQL +=" )";
			query.append(appendSQL);
		}
		
		if(cond.getPrTypeArray() != null && cond.getPrTypeArray().length > 0){
			if(cond.getPrTypeArray()[0].equals("I")){
				query.append(" AND (pr.prtype = 'I' OR pr.prtype = 'ID')");
			}
		}
		
		if( !StringUtils.isEmpty(cond.getPrstatus())){
			if("D_E".equals(cond.getPrstatus())) {
				query.append(" AND (pr.prstatus = 'D' or pr.prstatus = 'E')");
			} else {
				query.append(" AND pr.prstatus = :prstatus");
			}
		}
		if( !StringUtils.isEmpty(cond.getPrusername())){
//			query.append(" AND pr.prusername = :prusername");
			query.append(" AND pr.prusername like '%").append(cond.getPrusername()).append("%'");
		}
		if( cond.getPrid()!=null && cond.getPrid()!=0){
			query.append(" AND pr.prid = :prid");
		}
		//???????±????
		if( !StringUtils.isEmpty(cond.getPrurgency())){
			query.append(" AND pr.prurgency = :prurgency");
		}
		//?????????±??
		if( !StringUtils.isEmpty(cond.getPropentime())){
			query.append(" AND pr.propentime >= :propentime");
		}
		//?????????±??
		if( !StringUtils.isEmpty(cond.getPrclosetime())){
			if(cond.getPrclosetime().length() == 10) {
				query.append(" AND pr.propentime <= (:prclosetime ||' 23:59')");
			} else {
				query.append(" AND pr.propentime <= :prclosetime");
			}
		}
		//?÷????????
		if( !StringUtils.isEmpty(cond.getPruserid())){
			query.append(" AND pr.pruserid = :pruserid");
		}
		//?÷??????????id
		if( cond.getPrroleid() != null && cond.getPrroleid() != 0){
			query.append(" AND pr.prroleid = :prroleid");
		}
		//?÷???à??id
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			query.append(" AND pr.prpdid like :prpdid || '%' ");
		}
		//????±??÷??
		if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("Y")){
			query.append(" AND pr.prclosetime is null");
		}
		
		//??±??÷??
		if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("N")){
			query.append(" AND pr.prclosetime is not null");
		}
		
		//???ú?±????(?÷?????í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrplantime())&& !"wkm".equals(cond.getSelectMode())){
			query.append(" AND pr.prplantime >= :prplantime");
		}
		//???ú?±????(?÷?????í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrduration())&& !"wkm".equals(cond.getSelectMode())){
			if(cond.getPrplantime() != null && cond.getPrplantime().length() == 10) {
				query.append(" AND pr.prplantime <= (:prplantime ||' 23:59')");
			} else {
				query.append(" AND pr.prplantime <= :prplantime");
			}
		}
		//?¤×÷?????±????(?¤×÷???í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrplantime()) && "wkm".equals(cond.getSelectMode())){
			query.append(" AND pr.propentime >= :propentime");
		}
		//?¤×÷?????±????(?¤×÷???í?????ù????????????)
		if( !StringUtils.isEmpty(cond.getPrduration()) && "wkm".equals(cond.getSelectMode())){
			if(cond.getPropentime() != null && cond.getPropentime().length() == 10) {
				query.append(" AND pr.propentime <= (:propentime ||' 23:59')");
			} else {
				query.append(" AND pr.propentime <= :propentime");
			}
		}
		if (cond.getIsWork()==1) {
			query.append(" AND pr.prtype like 'W%'");
		}
		if(cond.getPrassetid() != null && cond.getPrassetid() > 0){
			query.append(" AND pr.prassetid = :prassetid");
		}
		if( !StringUtils.isEmpty(cond.getPrassetcategory())){
			query.append(" AND pr.prassetcategory = :prassetcategory");
		}
		if( !StringUtils.isEmpty(cond.getPrserialnum())){
//			query.append(" AND pr.prserialnum = :prserialnum");
			query.append(" AND pr.prserialnum like '%").append(cond.getPrserialnum()).append("%'");
		}
		if( !StringUtils.isEmpty(cond.getPrsubstatus())){
			query.append(" AND pr.prsubstatus = :prsubstatus");
		}
		
		//?÷???????é??
		if( !StringUtils.isEmpty(cond.getPrdesc())){
			query.append(" AND pr.prdesc like ('%'||:prdesc||'%')");
		}
		// ?÷???????????????±?ò,?±?°???§?????é????×?????????????×????÷??
		if( !StringUtils.isEmpty(cond.getUserid_q())){
			String sql = " AND not exists (select prid from IG500 a where a.prid = pr.prid and (a.prtype = 'S' or a.prtype = 'C' or a.prtype = 'WA') and (a.prstatus = 'D' OR a.prstatus = 'I') and a.pruserid <> '" + cond.getUserid_q() + "')";
			query.append(sql);
		}
	}

	/**
	 * ???¨???§?????í?÷???????ì?÷???í
	 * @param userid ???§ID
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> queryActiveProcessByUserid(final String userid){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.queryActiveProcessByUserid").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setString("userid", userid);

				q.addEntity("pr",IG500TB.class);

				setFetchPoint(q, 0, 0);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * ?????????¨???§?à?????í?÷???????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @param closeFlag ?é????±?±ê????0???????í??1???????í?????????ù??
	 * @param dealFlag  ?é?????í±ê????0??????±???1??????±??????????ù??
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.queryActiveProcessByUserid").getQueryString());
				
				//??????±?
				if(closeFlag == 1) {
					query.append(" AND (pr.prclosetime IS NULL)");//????±?
				} else if(closeFlag == 0){
					query.append(" AND (pr.prclosetime IS NULL)");//????±?
				}
				
				//???????í
				if(dealFlag == 1) {
					query.append(" AND pp.ppproctime IS NULL");//?????í
				} else if(dealFlag == 0){
					query.append(" AND pp.ppproctime IS NOT NULL");//?????í
				}
				
				//?¤????
				if(StringUtils.isNotEmpty(cond.getPrserialnum())) {
//					query.append(" AND pr.prserialnum = :prserialnum");
					query.append(" AND pr.prserialnum like '%").append(cond.getPrserialnum()).append("%'");
				}
				
				//????
				if(StringUtils.isNotEmpty(cond.getPrtitle())) {
					query.append(" AND pr.prtitle like ('%'||:prtitle||'%')");
				}
				
				//???í?????±??
				if(StringUtils.isNotEmpty(cond.getPpproctime_from())){
					query.append(" AND pp.ppproctime >= :ppproctime_from");
				}
				//???í?á???±??
				if(StringUtils.isNotEmpty(cond.getPpproctime_to())){
					if(cond.getPpproctime_to().length() == 10) {
						query.append(" AND pp.ppproctime <= (:ppproctime_to ||' 23:59')");
					} else {
						query.append(" AND pp.ppproctime <= :ppproctime_to");
					}
				}
				
				//?¤???à??
				if(StringUtils.isNotEmpty(cond.getPrpdid())){
					query.append(" AND pr.prpdid = :prpdid");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.addEntity("pr",IG500TB.class);
				
				q.setProperties(cond);

				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}

	/**
	 * ?????????¨???§?à?????í?÷???????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @param closeFlag ?é????±?±ê????0???????í??1???????í?????????ù??
	 * @param dealFlag  ?é?????í±ê????0??????±???1??????±??????????ù??
	 * @return ?ì?÷?á??????
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.queryActiveProcessByUseridCount").getQueryString());
				
				//??????±?
				if(closeFlag == 1) {
					query.append(" AND (pr.prclosetime IS NULL)");//????±?
				} else if(closeFlag == 0){
					query.append(" AND (pr.prclosetime IS NULL)");//????±?
				}
				
				//???????í
				if(dealFlag == 1) {
					query.append(" AND pp.ppproctime IS NULL");//?????í
				} else if(dealFlag == 0){
					query.append(" AND pp.ppproctime IS NOT NULL");//?????í
				}
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	
	public void getSQL(IG677SearchCond cond, StringBuffer query){
		//?¤????
		if(StringUtils.isNotEmpty(cond.getPrserialnum())) {
//			query.append(" AND pr.prserialnum = :prserialnum");
			query.append(" AND pr.prserialnum like '%").append(cond.getPrserialnum()).append("%'");
		}
		
		//????
		if(StringUtils.isNotEmpty(cond.getPrtitle())) {
			query.append(" AND pr.prtitle like ('%'||:prtitle||'%')");
		}
		
		//???í?????±??
		if(StringUtils.isNotEmpty(cond.getPpproctime_from())){
			query.append(" AND pp.ppproctime >= :ppproctime_from");
		}
		//???í?á???±??
		if(StringUtils.isNotEmpty(cond.getPpproctime_to())){
			if(cond.getPpproctime_to().length() == 10) {
				query.append(" AND pp.ppproctime <= (:ppproctime_to ||' 23:59')");
			} else {
				query.append(" AND pp.ppproctime <= :ppproctime_to");
			}
		}
		
		//?¤???à??
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			query.append(" AND pr.prpdid = :prpdid");
		}
	}
	
	/**
	 * ?????????¨?????????í?÷???????ì?÷???í
	 * @param roleid ????ID
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> queryActiveProcessByRoleid(final Integer roleid){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.queryActiveProcessByRoleid").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setInteger("roleid", roleid);
				
				q.addEntity("pr",IG500TB.class);
				
				setFetchPoint(q, 0, 0);
				
				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * ?ì?????¨???§???????????¨?÷???é???¨???¨???°???§??±??ü????????
	 * @param userid ???§ID
	 * @param prid ?÷??ID
	 * @return ?¨??±ê??
	 */
	public boolean checkLookDetailPermission(final String userid, final Integer prid){
		
		HibernateCallback action = new HibernateCallback() {

			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.checkLookDetailPermission").getQueryString());
				
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setString("userid", userid);
				q.setInteger("prid", prid);

				setFetchPoint(q, 0, 0);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?????¨???§???????????¨?÷???é???¨??");
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				boolean ret = false;
				if( list == null || list.size() != 1 ) return ret;
				if((Integer)list.get(0) > 0) ret = true;
				return ret;
			}
		};
		return (Boolean)execute(action);
		
	}
	
	/**
	 * ?ì?????¨???§???????????¨?÷???é???¨???¨???°???§??±??ü????????
	 * @param userid ???§ID
	 * @param prid ?÷??ID
	 * @return ?¨??±ê??
	 */
	@SuppressWarnings("unchecked")
	public List<IG677Info> queryActiveProcessByFPRoleid(final String userid){
		
		HibernateCallback action = new HibernateCallback() {

			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.queryActiveProcessByFPRoleid").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setString("userid", userid);
				q.addEntity("pr",IG677VW.class);
				setFetchPoint(q, 0, 0);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?????¨???§???????????¨?÷???é???¨??");
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG677Info>) execute(action);
		
	}
	
	/**
	 * ???????????÷???????????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> searchDispatchStatisticsVW(final IG677SearchCond cond, 
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG500DAO.searchDispatchStatisticsVW").getQueryString());
				
				//???í??id
				if(StringUtils.isNotEmpty(cond.getPpuserid())) {
					query.append(" and ds.ppuserid = '"+cond.getPpuserid()+"'");
				}
				
				//?é???????????±??
       		    if(StringUtils.isNotEmpty(cond.getPpproctime_from())){
       			    query.append(" and ds.propentime > '"+cond.getPpproctime_from()+"'");
       		    }
       		    //?é???????á???±??
       		    if(StringUtils.isNotEmpty(cond.getPpproctime_to()) ){
       			    query.append(" and ds.propentime < '"+cond.getPpproctime_to()+"'");
       		    }
       		    query.append(" ) pa on pa.prid = pr.prid where pa.prid is not null ");
       		    
       		    if(StringUtils.isNotEmpty(cond.getDsstatus())){       		    	
       		    	//?????ê??????????
       		    	if(("1").equals(cond.getDsstatus())){
       		    		query.append(" and pa.sumzc is not null ");
       		    	}
       		    	//???±?ê??????????
       		    	if(("2").equals(cond.getDsstatus())){
       		    		query.append(" and pa.sumys is not null ");
       		    	}
       		    	//???ê??????????
       		    	if(("3").equals(cond.getDsstatus())){
       		    		query.append(" and pa.sumwwc is not null ");
       		    	}
       		    }
       		    query.append(" order by pr.prserialnum ");
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.addEntity("pr",IG500TB.class);
				
				q.setProperties(cond);

				setFetchPoint(q, start, count);

				long start=0, end=0;
				//
				if(log.isDebugEnabled()){
					start = System.currentTimeMillis();
				}
				
				List<IG500Info> list = q.list();
				
				session.clear();
				
				//
				if(log.isDebugEnabled()){
					end = System.currentTimeMillis();
					log.debug("?ì?÷?±????" + (end - start)/1000 + "??");
					log.debug("?ì?÷?á????????" + list.size() + "??");
					log.debug("?ì?÷SQL??" + q.getQueryString());
				}
				
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	/**
	 * ?ì?÷?????ú??
	 * 
	 * @param cond ?ì?÷????
	 * @return ?ì?÷???ì?÷?????à
	 */
	public int findDispatchStatisticsSearchCount(final IG677SearchCond cond) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append("select count(*) from (");
		               query.append( session.getNamedQuery("IG500DAO.searchDispatchStatisticsVW").getQueryString());
						
						//???í??id
						if(StringUtils.isNotEmpty(cond.getPpuserid())) {
							query.append(" and ds.ppuserid = '"+cond.getPpuserid()+"'");
						}
						
						//?é???????????±??
		       		    if(StringUtils.isNotEmpty(cond.getPpproctime_from())){
		       			    query.append(" and ds.propentime > '"+cond.getPpproctime_from()+"'");
		       		    }
		       		    //?é???????á???±??
		       		    if(StringUtils.isNotEmpty(cond.getPpproctime_to()) ){
		       			    query.append(" and ds.propentime < '"+cond.getPpproctime_to()+"'");
		       		    }
		       		    query.append(" ) pa on pa.prid = pr.prid where pa.prid is not null ");
		       		    
		       		    //?????ê??????????
		       		    if(("1").equals(cond.getDsstatus())){
		       		    	query.append(" and pa.sumzc is not null ");
		       		    }
		       		    //???±?ê??????????
		       		    if(("2").equals(cond.getDsstatus())){
		       			    query.append(" and pa.sumys is not null ");
		       		    }
		       		    //???ê??????????
		       		    if(("3").equals(cond.getDsstatus())){
		       		    	query.append(" and pa.sumwwc is not null ");
		       		    }
		       		    query.append(" ) ");
		               SQLQuery q = session.createSQLQuery(query.toString());		               
		               q.setProperties(cond);
		               session.clear();
		               return getCount(q.list());
		           }
		       };
		       return (Integer) execute(action);
		}
	
	private void getProcessInfoSQL(IG500SearchCond cond,StringBuffer query){
		if(cond.getVarnames()!=null&&cond.getVarvalues()!=null){
			StringBuffer addSql = new StringBuffer();
			for(int i=0;i<cond.getVarnames().length;i++){
				if(StringUtils.isNotEmpty(cond.getVarvalues()[i])){
					if(cond.getVarvalues()[i].indexOf("_time_") >= 0){
						String[] infos = cond.getVarvalues()[i].split("_time_",2);
						String vs1 = infos[0];
						String vs2 = null;
						if(infos.length > 1){
							vs2 = infos[1];
						}
						addSql.append(" inner join ig599 pi").append(i).append(" on pi").append(i).append(".prid = pr.prid and pi").append(i).append(".pivarname = '").append(cond.getVarnames()[i]).append("' ");
						if(StringUtils.isNotEmpty(vs1)){
							addSql.append(" and pi").append(i).append(".pivarvalue >= '").append(vs1).append("' ");
						}
						if(StringUtils.isNotEmpty(vs2)){
							addSql.append(" and pi").append(i).append(".pivarvalue <= '").append(vs2).append("' ");
						}
					}else{
						String varvalue = cond.getVarvalues()[i];
						// ?÷??±í???§???ù?????????é??
						if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_tree_")){
							varvalue = varvalue.split("_tree_")[0];
						}
						addSql.append(" inner join ig599 pi").append(i).append(" on pi").append(i).append(".prid = pr.prid and pi").append(i).append(".pivarname = '").append(cond.getVarnames()[i]).append("' and pi").append(i).append(".pivarvalue like '%").append(varvalue).append("%' ");
					}
				}
			}
			if(cond.getVarnames_in()!=null && cond.getVarvalues_in()!=null){
				for(int i=0;i<cond.getVarnames_in().length;i++){
					if(StringUtils.isNotEmpty(cond.getVarvalues_in()[i])){
						String varvalue_in = cond.getVarvalues_in()[i];
						addSql.append(" inner join ig599 pi").append(i).append(" on pi").append(i).append(".prid = pr.prid and pi").append(i).append(".pivarname in (").append(cond.getVarnames_in()[i]).append(") and pi").append(i).append(".pivarvalue in (").append(varvalue_in).append(") ");
					}
				}
			}
			if(StringUtils.isNotEmpty(addSql.toString())){
				query.append(" ").append(addSql.toString());
			}
		}
	}
	
	//?é?????¨?à??±¨±íkey???????÷??
	public static String SQL2 = "select b.prid from regulatoryreportinstance a " +
			"inner join regulatoryreportdetail b on a.instanceid=b.instanceid " +
			"where where a.key=:key";
	
	/**
	 * ?é?????¨?à??±¨±íkey???????÷??
	 * @param type ±¨±í?à??
	 * @param pdid ±¨±í?¨??ID
	 * @param key ±¨±í????key
	 * @param isClose true???é??????±???false???é??????±???null???é??????????°ü?¨????
	 * @return ?????÷??
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> searchRegulatoryReportDetailByKey(final String type, final String pdid,
			final String key, final Boolean isClose) throws BLException{
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.searchDetailByKey").getQueryString());
				if(StringUtils.isNotEmpty(pdid)) {
					if(isClose == null) {//????,??°ü?¨????
						query.append(" inner join ig500 c on (b.prid=c.prid and c.prpdid=:pdid and c.prstatus != '#')");
					} else if(isClose) {//??±?
						query.append(" inner join ig500 c on (b.prid=c.prid and c.prpdid=:pdid and c.prstatus = 'C')");
					} else {//????±?
						query.append(" inner join ig500 c on (b.prid=c.prid and c.prpdid=:pdid and c.prclosetime is null)");
					}
				} else {
					if(isClose == null) {//????,??°ü?¨????
						query.append(" inner join ig500 c on (b.prid=c.prid and c.prstatus != '#')");
					} else if(isClose) {//??±?
						query.append(" inner join ig500 c on (b.prid=c.prid and c.prstatus = 'C')");
					} else {//????±?
						query.append(" inner join ig500 c on (b.prid=c.prid and c.prclosetime is null)");
					}
				}
				query.append(" where status <> '2' ");
				if(StringUtils.isNotEmpty(type)) {
					query.append(" and a.prtype=:type ");
				}
				if(StringUtils.isNotEmpty(key)) {
					query.append(" and a.key=:key ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				if(StringUtils.isNotEmpty(type)) {
					q.setString("type", type);
				}
				if(StringUtils.isNotEmpty(key)) {
					q.setString("key", key);
				}
				if(StringUtils.isNotEmpty(pdid)) {
					q.setString("pdid", pdid);
				}
				List<Integer> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Integer>) execute(action);
	}


	@SuppressWarnings("unchecked")
	public List<IG500Info> searchMyProcess(final IG500SearchCond cond,final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.searchMyWorkOrder").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				if(StringUtils.isNotEmpty(cond.getUserid_q())){
					query.append(" and exists (select 1 from ig337 pb inner join ig333 psdb on pb.psdid = psdb.psdid WHERE pb.prid = pr.prid and pb.ppuserid = '" + cond.getUserid_q() + "' ");
					if(StringUtils.isNotEmpty(cond.getPcode()) && "Y".equals(cond.getPcode())){
						query.append(" and pr.prstatus = psdb.psdcode ");
					}
					query.append(")");
//					query.append(" and (pp.ppuserid='"+cond.getUserid_q()+"' and (pp.ppproctime is null or pp.ppproctime = '')) ");
				}
				if(StringUtils.isNotEmpty(cond.getOrder())){
					query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG500TB",IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	
	public int searchMyProcessCount(final IG500SearchCond cond) {
		 HibernateCallback action = new HibernateCallback() {
	           public Object doInHibernate(Session session) throws HibernateException, SQLException {
	               session.flush();
	               StringBuffer query = new StringBuffer();
	               query.append("select count(*) from (");
	               query.append( session.getNamedQuery("IG500DAO.searchMyWorkOrder").getQueryString());
	               getProcessInfoSQL(cond,query);
					query.append(" where 1=1 ");
					getSQL(cond, query);
	               if(StringUtils.isNotEmpty(cond.getUserid_q())){
	            	   query.append(" and exists (select 1 from ig337 pb WHERE pb.prid = pr.prid and pb.ppuserid = '" + cond.getUserid_q() + "') ");
	            	  //query.append(" and (pp.ppuserid='"+cond.getUserid_q()+"' and (ppproctime is not null or pr.prstatus = pp.ppstatus)) ");
					}
	               query.append(" ) process ");
	               SQLQuery q = session.createSQLQuery(query.toString());		               
	               q.setProperties(cond);
	               session.clear();
	               return getCount(q.list());
	           }
	       };
	       return (Integer) execute(action);
	}
	
	@SuppressWarnings("unchecked")
	public List<IG500Info> searchMyProcessByOrg(final IG500SearchCond cond,
			final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.searchProcessByOrg").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				if(StringUtils.isNotEmpty(cond.getUserid_q())){
					query.append(" and iu.userid='"+cond.getUserid_q()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getOrder())){
					query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG500TB",IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}

	public int searchMyProcessByOrgCount(final IG500SearchCond cond) {
		 HibernateCallback action = new HibernateCallback() {
	           public Object doInHibernate(Session session) throws HibernateException, SQLException {
	               session.flush();
	               StringBuffer query = new StringBuffer();
	               query.append("select count(*) from (");
	               query.append( session.getNamedQuery("IG500DAO.searchProcessByOrg").getQueryString());
	               getProcessInfoSQL(cond,query);
					query.append(" where 1=1 ");
					getSQL(cond, query);
	               if(StringUtils.isNotEmpty(cond.getUserid_q())){
						query.append(" and iu.userid='"+cond.getUserid_q()+"'");
					}
	               query.append(" ) ");
	               SQLQuery q = session.createSQLQuery(query.toString());		               
	               q.setProperties(cond);
	               session.clear();
	               return getCount(q.list());
	           }
	       };
	       return (Integer) execute(action);
	}
	@SuppressWarnings("unchecked")
	public List<IG500Info> searchMyProcessByRole(final IG500SearchCond cond,
			final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.searchMyWorkOrderByRole").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				if(StringUtils.isNotEmpty(cond.getUserid_q())){
					query.append(" and ur.userid='"+cond.getUserid_q()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getOrder())){
					query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG500TB",IG500TB.class);
				setFetchPoint(q, start, count);
				List<IG500Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	public int searchMyProcessByRoleCount(final IG500SearchCond cond) {
		 HibernateCallback action = new HibernateCallback() {
	           public Object doInHibernate(Session session) throws HibernateException, SQLException {
	               session.flush();
	               StringBuffer query = new StringBuffer();
	               query.append("select count(*) from (");
	               query.append( session.getNamedQuery("IG500DAO.searchMyWorkOrderByRole").getQueryString());
	               getProcessInfoSQL(cond,query);
					query.append(" where 1=1 ");
					getSQL(cond, query);
	               if(StringUtils.isNotEmpty(cond.getUserid_q())){
						query.append(" and ur.userid='"+cond.getUserid_q()+"'");
					}
	               query.append(" ) ");
	               SQLQuery q = session.createSQLQuery(query.toString());		               
	               q.setProperties(cond);
	               session.clear();
	               return getCount(q.list());
	           }
	       };
	       return (Integer) execute(action);
	}
	
	/**
	 * ?????÷???±?°×???????????
	 * @param prid ?÷??ID
	 * @return ?÷???±?°×???????????
	 */
	public String searchCurrentStatusName(final Integer prid) throws BLException{
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("unchecked")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG591DAO.searchCurrentStatusName").getQueryString());
				query.append(" where prid=:prid");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("prid", prid);
				List<Object> lst_name = q.list();
				StringBuffer sbf_name = new StringBuffer("");
				for(Object name : lst_name) {
					sbf_name.append(",").append(name);
				}
				session.clear();
				if(sbf_name.length() > 1) {
					return sbf_name.toString().substring(1);
				} else {
					return sbf_name.toString();
				}
			}
		};
		return (String) execute(action);
	}
	
	/**
	 * ?????÷???±?°×???
	 * @param prid ?÷??ID
	 * @return ?÷???±?°×???
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchCurrentStatus(final Integer prid) throws BLException{
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("Select psdid||'',psdnum from ig591 a where prid=:prid");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("prid", prid);
				List<Object[]> lst_Status = q.list();
				List<String> ret = new ArrayList<String>();
				for(Object[] obj : lst_Status) {
					if(obj[0] != null){
						if(obj[1] == null) {
							ret.add(obj[0].toString());
						} else {
							ret.add(obj[0] + "_" + obj[1]);
						}
					}
				}
				session.clear();
				return ret;
			}
		};
		return (List<String>) execute(action);
	}
	
	/**
	 * dashboard
	 *	???? ???¨?÷???? ?????????? 
	 * @param months ????(yyyy/MM,yyyy?/MM ...)
	 * @param prpdid ?÷???¨?????°????
	 * @return List<Map>
	 * <p>
	 * 	map ?á?? DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT
	 * </p>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getRiskAssess (String months,String prpdid){
		Session session = getSession();
		
		String s = "with temptbale(dateMonth) as( "
				   +" values " +months
				   +" ) "

				   +" SELECT DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT FROM temptbale M LEFT JOIN ("
				   +" select substr(prpdid,1,5) AS PRPDID ,prpdname,substr(propentime,1,7) AS PROPENTIME ,count(1) AS ACOUNT ,count(prclosetime) AS CLOSECOUNT from ig500" 
				   +" where prpdid like :prpdid and prstatus <> '#' "
				   +" group by substr(propentime,1,7),substr(prpdid,1,5),prpdname " 
//				   +"order by  substr(propentime,1,7) desc "
				   +" ) "
				   +" T ON( m.dateMonth = t.PROPENTIME) order by DATEMONTH desc ";
//		String sql = session.getNamedQuery("IG500DAO.getRiskAssess").getQueryString();
		SQLQuery q = session.createSQLQuery(s);
//		q.setParameter("MONTHS", months[0]);
		q.setParameter("prpdid", prpdid+"__");
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("DATEMONTH", Hibernate.STRING);
		q.addScalar("PRPDID", Hibernate.STRING);
		q.addScalar("PRPDNAME", Hibernate.STRING);
		q.addScalar("ACOUNT", Hibernate.STRING);
		q.addScalar("CLOSECOUNT", Hibernate.STRING);
		return q.list();
	}


    /** 
     * @Title: queryIG500WithStatusAndPart 
     * @Description: TODO 查询ig500 和流程状态，当前流程状态的参与者
     * @param prSearchCond
     * @param i
     * @param j
     * @return    
     * List<IG500Info>    
     * @throws 
     */
	 @SuppressWarnings("unchecked")
    public List<Map<String, Object>> queryIG500WithStatusAndPart(final IG500SearchCond cond,final int i,final int j){
        HibernateCallback action = new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG500DAO.queryIG500WithStatusAndPart").getQueryString());
                getProcessInfoSQL(cond,query);
                query.append(" where 1=1 ");
                getSQL(cond, query);
                if(StringUtils.isNotEmpty(cond.getOrder())){
                    query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
                }
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                List<Map<String, Object>> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<Map<String, Object>>) execute(action);
    }

	 /**
		 * 获取我处理过的工作列表
		 * @param cond IG500SearchCond
		 * @param start int
		 * @param count int
		 * @return List<IG500Info>
		 */
		@SuppressWarnings("unchecked")
		public List<IG500Info> searchMyProcessed(final IG500SearchCond cond, final int start, final int count) {
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("IG500DAO.searchMyWorkedOrder").getQueryString());
					if(StringUtils.isNotEmpty(cond.getUserid_q())){
						
						if(StringUtils.isEmpty(cond.getLeaderFlag())){
							query.append(" and EXISTS(	SELECT 1 FROM ig337 pp WHERE pr.prid = pp.prid AND pp.ppuserid = '").append(cond.getUserid_q()).append("' AND (pp.ppproctime IS NOT NULL OR pp.ppproctime <> '') ) ");
						}else{
							query.append(" and EXISTS(	SELECT 1 FROM ig337 pp WHERE pr.prid = pp.prid AND pp.pporgid = '").append(cond.getOrgID()).append("' AND (pp.ppproctime IS NOT NULL OR pp.ppproctime <> '') ) ");
							
						}
					}
					
					getSQL(cond, query);
					if(StringUtils.isNotEmpty(cond.getOrder())){
						query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
					}
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setProperties(cond);
					q.addEntity("IG500TB",IG500TB.class);
					setFetchPoint(q, start, count);
					List<IG500Info> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<IG500Info>) execute(action);
		}
		
		/**
	     * 查询应急处置流程
	     * @param cond
	     * @param start
	     * @param count
	     * @return
	     */
	    public List<IG500Info> getDrmFlow(final IG500SearchCond cond,final int start,final int count){
	    	HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append("select prid,prtype,prsubtype,prstatus,PRSUBSTATUS,PRTITLE,PRDESC," +
							"PROPENTIME,PRCLOSETIME,PRPLANTIME,PRDURATION,PRURGENCY,PRIMPACT,PRASSETID,PRASSETNAME," +
							"PRASSETCATEGORY,PRBUSINESS,PRIMPLPLAN,PRBACKPLAN,PRVFYPLAN,PID,PCODE,PNAME,PRINFO,PRCORID,PRCORTYPE,PRCORTITLE," +
							"PRUSERID,PRUSERNAME,PRROLEID,PRROLENAME,PRPDID,PRPDNAME,PRORGID,PRORGNAME,PRSERIALNUM,PRFACTTIME," +
							"FINGERPRINT,PRPTDCOND,PRSTRATEGYVERSION,PRPRIORITY from ig500 where 1=1");
					//判断编号是否存在
					if(StringUtils.isNotBlank(cond.getPrserialnum())){
						query.append(" and prserialnum like '%" +cond.getPrserialnum()+"%'");
					}
					//判断题目是否存在
					if(StringUtils.isNotBlank(cond.getPrtitle())){
						query.append(" and prtitle like '%" +cond.getPrtitle()+"%'");
					}
					//判断开始时间是否存在
					if(StringUtils.isNotBlank(cond.getPropentime())){
						query.append(" and propentime >= " +cond.getPropentime());
					}
					//判断关闭时间是否存在
					if(StringUtils.isNotBlank(cond.getPrclosetime())){
						query.append(" and prtitle <= " +cond.getPrclosetime());
					}
					//判断发起人是否存在
					if(StringUtils.isNotBlank(cond.getPrusername())){
						query.append(" and prusername like '%" +cond.getPrusername()+"%'");
					}
					//判断内容是否存在
					if(StringUtils.isNotBlank(cond.getPrdesc())){
						query.append(" and prdesc like '%" +cond.getPrdesc()+"%'");
					}
				// 判断处置流程的发起类型
				if (StringUtils.isNotEmpty(cond.getDwpType())) {
					// 如果是演练发起的则 根据关系表过滤出演练发起的处置流程
					if (IGDRMCONSTANTS.DRILL_RELATE_SCENE.equals(cond.getDwpType())) {
						query.append(" and prid  in (select cldprid from EMERGENCYRELATION where relatetype = '" + IGDRMCONSTANTS.DRILL_RELATE_SCENE + "')");
					} else {
						query.append(" and prid not in (select cldprid from EMERGENCYRELATION where relatetype = '" + IGDRMCONSTANTS.DRILL_RELATE_SCENE + "')");
					}
					}
					query.append(" and prtype = 'WDP'");
					query.append(" order by propentime desc");
					SQLQuery q = session.createSQLQuery(query.toString());
					q.addEntity("IG500TB",IG500TB.class);
					setFetchPoint(q, start, count);
					List<IG500Info> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<IG500Info>) execute(action);
	    }
	    
	    
	    /**
	     * 查询应急处置流程数量
	     * @param cond
	     * @param start
	     * @param count
	     * @return
	     */
	    public Integer countDrmFlow(final IG500SearchCond cond){
	    	HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append("select count(prid) from ig500 where 1=1");
					//判断编号是否存在
					if(StringUtils.isNotBlank(cond.getPrserialnum())){
						query.append(" and prserialnum like '%" +cond.getPrserialnum()+"%'");
					}
					//判断题目是否存在
					if(StringUtils.isNotBlank(cond.getPrtitle())){
						query.append(" and prtitle like '%" +cond.getPrtitle()+"%'");
					}
					//判断开始时间是否存在
					if(StringUtils.isNotBlank(cond.getPropentime())){
						query.append(" and propentime >= " +cond.getPropentime());
					}
					//判断关闭时间是否存在
					if(StringUtils.isNotBlank(cond.getPrclosetime())){
						query.append(" and prtitle <= " +cond.getPrclosetime());
					}
					//判断发起人是否存在
					if(StringUtils.isNotBlank(cond.getPrusername())){
						query.append(" and prusername like '%" +cond.getPrusername()+"%'");
					}
					//判断内容是否存在
					if(StringUtils.isNotBlank(cond.getPrdesc())){
						query.append(" and prdesc like '%" +cond.getPrdesc()+"%'");
					}
				// 判断处置流程的发起类型
				if (StringUtils.isNotEmpty(cond.getDwpType())) {
					// 如果是演练发起的则 根据关系表过滤出演练发起的处置流程
					if (IGDRMCONSTANTS.DRILL_RELATE_SCENE.equals(cond.getDwpType())) {
						query.append(" and prid  in (select cldprid from EMERGENCYRELATION where relatetype = '" + IGDRMCONSTANTS.DRILL_RELATE_SCENE + "')");
					} else {
						query.append(" and prid not in (select cldprid from EMERGENCYRELATION where relatetype = '" + IGDRMCONSTANTS.DRILL_RELATE_SCENE + "')");
					}
				}
					query.append(" and prtype = 'WDP'");
					SQLQuery q = session.createSQLQuery(query.toString());
					Integer count = getCount(q.list());
					session.clear();
					return count;
				}
			};
			return (Integer) execute(action);
	    }
	    
	    /**
		 * 查询我未处理过的工单条件检索处理
		 * @param cond 检索条件
		 * @param start 检索记录起始行号
		 * @param count 检索记录件数
		 * @return 检索结果列表
		 */
		@SuppressWarnings("unchecked")
		public List<IG500Info> searchMyUnProcessd(final IG500SearchCond cond,final int start,
				final int count) {
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("IG500DAO.searchMyWorkOrder").getQueryString());
					getProcessInfoSQL(cond,query);
					query.append(" where 1=1 ");
					getSQL(cond, query);
					if(StringUtils.isNotEmpty(cond.getUserid_q())){
						query.append(" and exists (select 1 from ig337 pb inner join ig333 psdb on pb.psdid = psdb.psdid WHERE pb.prid = pr.prid and pb.ppuserid = '" + cond.getUserid_q() + "' and pb.ppproctime is null ");
						if(StringUtils.isNotEmpty(cond.getPcode()) && "Y".equals(cond.getPcode())){
							query.append(" and pr.prstatus = psdb.psdcode ");
						}
						query.append(")");
//						query.append(" and (pp.ppuserid='"+cond.getUserid_q()+"' and (pp.ppproctime is null or pp.ppproctime = '')) ");
					}
					if(StringUtils.isNotEmpty(cond.getOrder())){
						query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
					}
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setProperties(cond);
					q.addEntity("IG500TB",IG500TB.class);
					setFetchPoint(q, start, count);
					List<IG500Info> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<IG500Info>) execute(action);
		}
}

