package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM01VW;
import com.deliverik.infogovernor.soc.model.dao.CR01DAOImpl;

public class CRM01DAOImpl  extends
BaseHibernateDAOImpl<CRMVW01Info> implements CRM01DAO{
static Log log = LogFactory.getLog(CR01DAOImpl.class);
protected CodeDetailBL codeDetailBL;	
	/**
	 * 构造方法
	 */
	public CRM01DAOImpl(){
		super(CRM01VW.class);
	}
	@SuppressWarnings("unchecked")
	public List<CRMVW01Info> searchCRM01VWInfoList(final CRM10SearchCond cond,final int start,final int length){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append("select host,ip,servername,servertype,");
				query.append("substr(collecttime,0,5)||'/'||substr(collecttime,5,2)||'/'||substr(collecttime,7,2)||' '||substr(collecttime,9,2)||':'||substr(collecttime,11,2) as collecttime");
				query.append(",command,cdataorder,cdata,inserttime,category,keys,fingerPrint,unit,objectname from ");
				query.append(cond.getTablename());
				query.append(" where 1=1"); 
			
				getSQL(cond,query);
				query.append(" order by collecttime desc");
				log.info(query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(CRM01VW.class);
				setFetchPoint(q, start, length);
				
				return q.list();
			}
		};
		return (List<CRMVW01Info>) execute(action);
	}
	
	public String searchTable(final CRM10SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(" select tablename from ");
				query.append("crm02");
				query.append(" where 1=1 "); 
				query.append(" and collecttime like'%"+cond.getNowCollecttime()+"%'");
				
				log.info(query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());
				if(q.list().size()==0)
					return "";
				else
					return q.list().get(0);
			}
		};
		return(String) execute(action);
	}
	
	protected void getSQL(CRM10SearchCond cond, StringBuffer query){

		if(StringUtils.isNotEmpty(cond.getIp())){
			query.append(" and  ip like '%"+cond.getIp()+"%' ");
		}
		if(StringUtils.isNotEmpty(cond.getGet_StartTime())){
			query.append( "and substr(collecttime,0,9) >='"+replaceStr(cond.getGet_StartTime()) +"'");
		}
		if(StringUtils.isNotEmpty(cond.getGet_EndTime() )){
			query.append(" and substr(collecttime,0,9) <='"+replaceStr(cond.getGet_EndTime()) +"'");
		}
		if(StringUtils.isNotEmpty(cond.getSymType()) && !cond.getSymType().equals("0")){
			query.append(" and servertype="+Integer.parseInt(cond.getSymType()));
		}
		
	}
	
	public int  getSearchCount(final CRM10SearchCond cond) {
		
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(" select count(*) from ");
				query.append(cond.getTablename());
				query.append(" where 1=1 "); 
				getSQL(cond,query);
			
				log.info(query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());
				
				return getCount(q.list());
			}
		};
		return (Integer ) execute(action);
	}
	
	public IGALM07DTO getRefreshRate(IGALM07DTO dto) throws BLException {
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid("950");
        condimpl.setCid("4");
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String rate = cds.get(0).getCvalue();
        if(StringUtils.isEmpty(rate) || "0".equals(rate)) rate = "60";
        dto.setRefreshRate(rate.trim());
		return dto;
	}
	
	public String replaceStr(String cond){
		return cond.substring(0,10).replace("/","").trim();
	}
	
}
