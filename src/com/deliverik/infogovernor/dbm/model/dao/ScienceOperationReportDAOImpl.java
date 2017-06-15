/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.condition.ScienceOperationReportSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ƽ�����ͳ�Ʒ���DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class ScienceOperationReportDAOImpl extends BaseHibernateDAOImpl<Object>
		implements ScienceOperationReportDAO {

	/**
	 * ���ձ�ֵ��ѯ����ֵ��ռ������
	 * @param cond
	 * @return
	 */
	public List<Object[]> getWorkOrderAction(final ScienceOperationReportSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			@SuppressWarnings("unused")
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(StringUtils.isNotEmpty(cond.getPidoptions())){
					int index = 0;
					query.append("select ");
					for(String option:cond.getPidoptions().split("#")){
						if(index > 0){
							query.append(",");
						}
						query.append(" sum(count");
						query.append(index);
						query.append(") as total");
						query.append(index);
						index ++;
					}
					query.append(" from (");
					query.append(" select SUBSTR (char(pr.prpdid),1,5) as prpdid,");
					index = 0;
					for(String option:cond.getPidoptions().split("#")){
						if(index > 0){
							query.append(",");
						}
						query.append("case when pi.pivarvalue = '");
						query.append(option);
						query.append("' then 1 else 0 end as count");
						query.append(index);
						index ++;
					}
					query.append(" from ig500 pr ");
					query.append(" left join ig599 pi on pr.prid = pi.prid and pi.pivarname = '");
					query.append(cond.getPivarname());
					query.append("' ");
					query.append(" where pr.prstatus <> '#' ");
					if(StringUtils.isNotEmpty(cond.getPropentime_like())) {
						query.append(" and pr.propentime like  '");
						query.append(cond.getPropentime_like());
						query.append("%' ");
					}
					if(cond.getPrpdid_in() != null && cond.getPrpdid_in().size() > 0){
						query.append(" and (");
						for(int i=0;i<cond.getPrpdid_in().size();i++){
							if(i > 0){
								query.append(" or ");
							}
							query.append(" pr.prpdid like '");
							query.append(cond.getPrpdid_in().get(i));
							query.append("%' ");
						}
						query.append(") ");
					}
					query.append(" )a group by a.prpdid ");
				}
				
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				List list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Object[]>) execute(action);
	}
}
