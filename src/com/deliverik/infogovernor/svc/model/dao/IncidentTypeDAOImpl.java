/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentTypeSearchCond;
import com.deliverik.infogovernor.svc.model.entity.IncidentTypeVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 故障类型统计DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IncidentTypeDAOImpl extends BaseHibernateDAOImpl<IncidentTypeVWInfo> implements IncidentTypeDAO{

	/**
	 * 构造方法
	 */
	public IncidentTypeDAOImpl(){
		super(IncidentTypeVW.class);
	}
	
	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public IncidentTypeVWInfo searchIncidentTypeData(final IncidentTypeSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select 1 as id,");
				query.append(" sum(case when pi.pivarvalue = 'OA办公' then 1 else 0 end) as oaWork,");
				query.append(" sum(case when pi.pivarvalue = '用户名或密码' then 1 else 0 end) as userNameOrPassWord,");
				query.append(" sum(case when pi.pivarvalue = '物资管理' then 1 else 0 end) as materialsManager,");
				query.append(" sum(case when pi.pivarvalue = '分诊导医' then 1 else 0 end) as triageDaoYi,");
				query.append(" sum(case when pi.pivarvalue = '网络故障' then 1 else 0 end) as netWorkMalfunction,");
				query.append(" sum(case when pi.pivarvalue = '病例丢失找回' then 1 else 0 end) as casesOfLossBack,");
				query.append(" sum(case when pi.pivarvalue = '计算机协助' then 1 else 0 end) as computerHelp,");
				query.append(" sum(case when pi.pivarvalue = '护士工作站' then 1 else 0 end) as nurseWorkstation,");
				query.append(" sum(case when pi.pivarvalue = '监控告警' then 1 else 0 end) as prossessingErrorAlarm");
				query.append(" from ig500 pr");
				query.append(" inner join ig599 pi on pr.prid = pi.prid and pi.pivarname = '故障类型'");
				String year = "____";
				String month = "__";
				if(StringUtils.isNotEmpty(cond.getYear())){
					year = cond.getYear();
				}
				if(StringUtils.isNotEmpty(cond.getMonth())){
					month = cond.getMonth();
				}
				String opentime = year + "/" + month + "/" + "__ __:__";
				query.append(" where pr.prpdid like '");
				query.append(cond.getPdid());
				query.append("%' ");
				query.append(" and pr.propentime like '");
				query.append(opentime);
				query.append("' ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(IncidentTypeVW.class);
				setFetchPoint(q, 0, 0);
				Object object = q.list().get(0);
				session.clear();
				session.close();
				return object;
			}
			
		};
		return (IncidentTypeVWInfo) execute(action);
	}
}
