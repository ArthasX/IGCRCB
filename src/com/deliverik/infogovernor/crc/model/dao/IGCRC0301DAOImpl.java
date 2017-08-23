package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;
import com.deliverik.infogovernor.crc.model.entity.IGCRC0301VW;

/**
 * 概述: 集成告警表DAO实现
 * 功能描述: 集成告警表DAO实现
 * 创建记录: 2014/06/21
 * 修改记录: 2014/07/09
 * 				将获取到的String类型主键转换成Int类型
 */
public class IGCRC0301DAOImpl extends
BaseHibernateDAOImpl<IGCRC0301VWInfo> implements IGCRC0301DAO {

	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IGCRC0301VWInfo> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryProblem").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				if(StringUtils.isNotEmpty(cond.getOrder())){
					query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IGCRC0301VW",IGCRC0301VW.class);
				setFetchPoint(q, start, count);
				List<IGCRC0301VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IGCRC0301VWInfo>) execute(action);
	}
	
	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @param query sql
	 * @return 检索用检索条件类
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
		//查询一组流程类型id
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
		// 查询流程时，查询指定用户是否参与该流程
		if( !StringUtils.isEmpty(cond.getPpusername_like())){
			query.append(" AND exists (select 1 from ig337 pp where pr.prid = pp.prid and pp.ppusername like ('%'||:ppusername_like||'%') ) ");
		}
		// 查询流程时，查询指定用户是否参与该流程
		if( !StringUtils.isEmpty(cond.getPpuserid())){
			query.append(" AND exists (select 1 from ig337 pp where pr.prid = pp.prid and pp.ppuserid = :ppuserid ");
			if(!StringUtils.isEmpty(cond.getPpstatus())){
				query.append(" and ppstatus like :ppstatus ");
			}
			// 查询流程是，查询制定用户是否已经确认
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
		//流程内容查询
		if( !StringUtils.isEmpty(cond.getPrdesc())){
			query.append(" AND pr.prdesc like ('%'||:prdesc||'%')");
		}
		//问题来源
		if( !StringUtils.isEmpty(cond.getPrassetname())){
		    query.append(" AND pr.prassetname = :prassetname");
		}

		//流程类型ID
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			query.append(" AND pr.prpdid like (:prpdid||'%')");
		}
		//流程记录类型
		if(StringUtils.isNotEmpty(cond.getPrtype())){
			//测试工作查询用
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
		
		//未关闭流程
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
//			query.append(" and (");
//			query.append(" pr.prtitle like '%' || :content || '%' ");
//			query.append(" or pr.prdesc like '%' || :content || '%' ");
//			query.append(" or exists (select 1 from ig599 ti where pr.prid = ti.prid and ti.pivarvalue like '%' || :content || '%' )");
//			query.append(")");
			query.append(" and exists (select 1 from ig599 pp where pp.prid = pr.prid and pp.pivarname like '问题描述' and pp.pivarvalue like '%"+cond.getContent()+"%') ");
		}
		if(StringUtils.isNotEmpty(cond.getPrstatus_ne())){
			query.append(" and pr.prstatus <> :prstatus_ne ");
		}
		
		
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
						// 树形表单支持根节点模糊查询
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
						addSql.append(" inner join ig599 pm").append(i).append(" on pm").append(i).append(".prid = pr.prid and pm").append(i).append(".pivarname in (").append(cond.getVarnames_in()[i]).append(") and pm").append(i).append(".pivarvalue in (").append(varvalue_in).append(") ");
					}
				}
			}
			if(StringUtils.isNotEmpty(addSql.toString())){
				query.append(" ").append(addSql.toString());
			}
		}
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryProblemCount").getQueryString());
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
}
