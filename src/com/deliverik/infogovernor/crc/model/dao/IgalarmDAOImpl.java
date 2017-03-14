/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC0208VW;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/**
  * 概述: 集成告警表DAO实现
  * 功能描述: 集成告警表DAO实现
  * 创建记录: 2014/06/21
  * 修改记录: 2014/07/09
  * 				将获取到的String类型主键转换成Int类型
  */
public class IgalarmDAOImpl extends
		BaseHibernateDAOImpl<IgalarmInfo> implements IgalarmDAO {

	/**
	 * 构造函数
	 */
	public IgalarmDAOImpl(){
		super(IgalarmTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IgalarmInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IgalarmInfo findByPK(Serializable pk) {
		IgalarmInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IgalarmSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> findByCond(final IgalarmSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("pk"));
		c.addOrder(Order.desc("lasttime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IgalarmSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//序号(完全匹配)
		if(StringUtils.isNotEmpty(cond.getSerial())){
			c.add(Restrictions.eq("serial", cond.getSerial()));
		}
		if(StringUtils.isNotEmpty(cond.getStartDate())){
			c.add(Restrictions.gt("lasttime", cond.getStartDate()));
		}
		if(StringUtils.isNotEmpty(cond.getEndDate())){
			c.add(Restrictions.lt("lasttime", cond.getEndDate()));
		}
		if(StringUtils.isNotEmpty(cond.getAppname())){
			c.add(Restrictions.like("appname", String.format("%%%s%%", cond.getAppname())));
		}
		if(StringUtils.isNotEmpty(cond.getSummary())){
			c.add(Restrictions.like("summary", String.format("%%%s%%",  cond.getSummary())));
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			// 查询告警详细时查询全部状态
			if("C".equals(cond.getStatus())){
			
			//为了避免走下面"StringUtils.isEmpty(cond.getStatus())"的逻辑(同时避免和上面的"C"混淆)  by wangxing 2015/11/17 16:44 
			}else if("ALL".equals(cond.getStatus())){
				
			}else{
				c.add(Restrictions.eq("status", cond.getStatus()));
			}
		}
		// 如果状态为空，默认不显示关闭状态的
		if(StringUtils.isEmpty(cond.getStatus())){
			c.add(Restrictions.ne("status", "2"));
		}
		//主键（类型转换）
		if(cond.getAlarmIds() != null && cond.getAlarmIds().length > 0){
			Integer[] a = new Integer[cond.getAlarmIds().length];
			for(int i=0;i<a.length;i++){
			a[i] =  Integer.parseInt(cond.getAlarmIds()[i]);
			c.add(Restrictions.in("pk", a));
			}
		}
		// 触发/恢复时间
		if(StringUtils.isNotEmpty(cond.getLasttime())){
			c.add(Restrictions.eq("lasttime", cond.getLasttime()));
		}
		// 是否显示标识(0显示，1不显示)
		if(StringUtils.isNotEmpty(cond.getIsShow())){
			c.add(Restrictions.eq("isShow", cond.getIsShow()));
		}
		// 事件单编号
		if(StringUtils.isNotEmpty(cond.getPedeventid())){
			c.add(Restrictions.eq("pedeventid", cond.getPedeventid()));
		}
		if(StringUtils.isNotEmpty(cond.getIpaddr())){
			c.add(Restrictions.eq("ipaddr", cond.getIpaddr()));
		}
		if(StringUtils.isNotEmpty(cond.getShieldflag())){
			c.add(Restrictions.eq("shieldflag", cond.getShieldflag()));
		}
		
		/** 2016/10/14修改   功能：添加排序升序或者降序(1.触发事件/恢复事件 2.ip地址 3.主机名称)    gongyunpeng */
		//主机名称(1为降序 2为升序)
		if(StringUtils.isNotEmpty(cond.getAppnamestatus())){
			if("1".equals(cond.getAppnamestatus())){
				c.addOrder(Order.desc("appname"));
			}else{
				c.addOrder(Order.asc("appname"));
			}
		}
		//ip地址(1为降序 2为升序)
		if(StringUtils.isNotEmpty(cond.getIpaddrstatus())){
			if("1".equals(cond.getIpaddrstatus())){
				c.addOrder(Order.desc("ipaddr"));
			}else{
				c.addOrder(Order.asc("ipaddr"));
			}		
		}
		//触发时间(1为降序 2为升序)
		if(StringUtils.isNotEmpty(cond.getLasttimestatus())){
			if( "1".equals(cond.getLasttimestatus())){
				c.addOrder(Order.desc("lasttime"));
			}else{
				c.addOrder(Order.asc("lasttime"));
			}
		}
		//恢复事件(1为降序 2为升序)
		if(StringUtils.isNotEmpty(cond.getRecoverytimestatus())){
			if( "1".equals(cond.getRecoverytimestatus())){
				c.addOrder(Order.desc("recoveryTime"));
			}else{
				c.addOrder(Order.asc("recoveryTime"));
			}
		}
				
		return c;
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IGCRC0208VWInfo> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryAlarmEvent").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				if(StringUtils.isNotEmpty(cond.getOrder())){
					query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IGCRC0208VW",IGCRC0208VW.class);
				setFetchPoint(q, start, count);
				List<IGCRC0208VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IGCRC0208VWInfo>) execute(action);
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
			query.append(" and (");
			query.append(" pr.prtitle like '%' || :content || '%' ");
			query.append(" or pr.prdesc like '%' || :content || '%' ");
			query.append(" or exists (select 1 from ig599 ti where pr.prid = ti.prid and ti.pivarvalue like '%' || :content || '%' )");
			query.append(")");
		}
		if(StringUtils.isNotEmpty(cond.getPrstatus_ne())){
			query.append(" and pr.prstatus <> :prstatus_ne ");
		}
		//是否为告警事件
		if(StringUtils.isNotBlank(cond.getAlarm_Is())){
			if("1".equals(cond.getAlarm_Is())){
				query.append(" and exists (select 1 from ig599 pp where pp.prid = pr.prid and pp.pivarname like '事件来源' and pp.pivarvalue like '监控告警') ");
			}else if("0".equals(cond.getAlarm_Is())){
				query.append(" and exists (select 1 from ig599 pp where pp.prid = pr.prid and pp.pivarname like '事件来源' and pp.pivarvalue  not like '监控告警') ");
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
				query.append(session.getNamedQuery("IG500DAO.queryAlarmEventCount").getQueryString());
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
	 * 条件检索处理(没有默认排序)
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> findByCondNoSort(final IgalarmSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
}