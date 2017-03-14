package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2401VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;

/**
 * 
 * 功能：
 */
public class IGCRC2401DAOImpl extends BaseHibernateDAOImpl<IGCRC2401VW>
		implements IGCRC2401DAO {


	/**
	 * 构造函数
	 */
	public IGCRC2401DAOImpl() {
		super(IGCRC2401VW.class);
	}

	/**
	 * 平均解决事件时间
	 * 
	 * 事件解决时间
	 * @param cond
	 *            检索条件
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<IGCRC2401VW> getFindStatistics(final IGCRC2401Cond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				if("1".equals(cond.getSign())){
				//事件
				query.append(session.getNamedQuery(
						"EntityItemIGCRC2401VWDAO.getDept").getQueryString());
				}else{
				//告警
					query.append(session.getNamedQuery(
							"EntityItemIGCRC2401VWDAO.getDeptForWarn").getQueryString());
				}
				// 添加 年 月 查询条件

				// 拼接查询条件
				getSql(query, cond);
				// 获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);
				q.addEntity(IGCRC2401VW.class);
				List<IGCRC2401VWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2401VW>) execute(action);
	}

	/**
	 * 功能：检索条件生成
	 *     
	 * @param query
	 * @param cond
	 *            修改记录：null
	 */
	private void getSql(StringBuffer query, IGCRC2401Cond cond) {
		// 年月
		query.append(" and a.ppproctime is not null and a.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
		// 部门
		if (StringUtils.isNotEmpty(cond.getDept())) {
			query.append(" and  ppuserid in (select userid from iguser where orgid = '"
					+ cond.getDept() + "')");
		} else {
			query.append(" and 1=2");
		}
		//必须按照a.ppuserid排序,因前台算法需要
		query.append(" group by a.prid ,a.ppid,a.ppusername ,a.ppuserid,a.ppinittime,a.ppproctime,a.ppbacktime,b.pivarvalue order by a.ppuserid");
	}
	/**
	 * 平均解决事件时间
	 *  开始时间-----确认时间
	 *    
	 * @param cond
	 *            检索条件
	 *            zhangq@deliverik.com
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<IGCRC2401VW> getFindStatisticsConfirm(final IGCRC2401Cond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if("1".equals(cond.getSign())){
					//事件
					query.append(session.getNamedQuery(
							"EntityItemIGCRC2401VWDAO.getDept").getQueryString());
					}else{
					//告警
						query.append(session.getNamedQuery(
								"EntityItemIGCRC2401VWDAO.getDeptForWarn").getQueryString());
					}
				// 添加 年 月 查询条件

				// 拼接查询条件
				getSqlConfirm(query, cond);
				// 获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);
				q.addEntity(IGCRC2401VW.class);
				List<IGCRC2401VWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2401VW>) execute(action);
	}

	/**
	 * 功能：检索条件生成
	
	 *            修改记录：zhangqiang
	 *            
	 *            分组增加  确认时间
	 *              zhangq@deliverik.com
	 */
	private void getSqlConfirm(StringBuffer query, IGCRC2401Cond cond) {
		// 年月
		query.append(" and a.ppbacktime is not null  and a.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
		// 部门
		if (StringUtils.isNotEmpty(cond.getDept())) {
			query.append(" and  ppuserid in (select userid from iguser where orgid = '"
					+ cond.getDept() + "')");
		} else {
			query.append(" and 1=2");
		}
		//必须按照a.ppuserid排序,因前台算法需要
		query.append(" group by a.prid ,a.ppid,a.ppusername ,a.ppuserid,a.ppinittime,a.ppproctime,a.ppbacktime,b.pivarvalue order by a.ppuserid");
	}
}
