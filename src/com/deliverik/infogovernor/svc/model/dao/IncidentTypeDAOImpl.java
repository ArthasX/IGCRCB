/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IncidentTypeDAOImpl extends BaseHibernateDAOImpl<IncidentTypeVWInfo> implements IncidentTypeDAO{

	/**
	 * ���췽��
	 */
	public IncidentTypeDAOImpl(){
		super(IncidentTypeVW.class);
	}
	
	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public IncidentTypeVWInfo searchIncidentTypeData(final IncidentTypeSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select 1 as id,");
				query.append(" sum(case when pi.pivarvalue = 'OA�칫' then 1 else 0 end) as oaWork,");
				query.append(" sum(case when pi.pivarvalue = '�û���������' then 1 else 0 end) as userNameOrPassWord,");
				query.append(" sum(case when pi.pivarvalue = '���ʹ���' then 1 else 0 end) as materialsManager,");
				query.append(" sum(case when pi.pivarvalue = '���ﵼҽ' then 1 else 0 end) as triageDaoYi,");
				query.append(" sum(case when pi.pivarvalue = '�������' then 1 else 0 end) as netWorkMalfunction,");
				query.append(" sum(case when pi.pivarvalue = '������ʧ�һ�' then 1 else 0 end) as casesOfLossBack,");
				query.append(" sum(case when pi.pivarvalue = '�����Э��' then 1 else 0 end) as computerHelp,");
				query.append(" sum(case when pi.pivarvalue = '��ʿ����վ' then 1 else 0 end) as nurseWorkstation,");
				query.append(" sum(case when pi.pivarvalue = '��ظ澯' then 1 else 0 end) as prossessingErrorAlarm");
				query.append(" from ig500 pr");
				query.append(" inner join ig599 pi on pr.prid = pi.prid and pi.pivarname = '��������'");
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
