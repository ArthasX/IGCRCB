/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao.Impl;

 import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtVWSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtVWDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_Monitor_RtVW;


/**
 * +
 * @Description:�洢ʵʱ��Ϣ��ͼDAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_Monitor_RtVWDAOImpl extends BaseHibernateDAOImpl<Collect_Symmetrix_Monitor_RtVWInfo> implements Collect_Symmetrix_Monitor_RtVWDAO {
	/**
	 * ���캯��
	 * 
	 */
	public Collect_Symmetrix_Monitor_RtVWDAOImpl(){
		super(Collect_Symmetrix_Monitor_RtVW.class);
	}
	
	/**
     * ������������
     * @param cond ��������
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
	public List<Collect_Symmetrix_Monitor_RtVWInfo> findByCond(final Collect_Symmetrix_Monitor_RtVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if("IBM".equals(cond.getServerType())){
					query.append( session.getNamedQuery("Collect_Symmetrix_Monitor_RtVWDAO.findByCondAndIBM").getQueryString());
				}else{
					query.append( session.getNamedQuery("Collect_Symmetrix_Monitor_RtVWDAO.findByCond2").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("csmr",Collect_Symmetrix_Monitor_RtVW.class);

				q.setProperties(cond);
				
				List<Collect_Symmetrix_Monitor_RtVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
				
		};
		return (List<Collect_Symmetrix_Monitor_RtVWInfo>) execute(action);
	}
	/**
	 * ��ȡ���ʱ��
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Date getMaxSaveTime(final Collect_Symmetrix_Monitor_RtVWSearchCond cond){
			
		HibernateCallback action = new HibernateCallback() {
					
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append("select max(savetime) from collect_symmetrix_monitor_rt");
				query.append(" where symm_id='"+cond.getSymmid()+"'");
				SQLQuery q = session.createSQLQuery(query.toString());
				
				List<String>list = q.list();
				
				session.clear();
				
				return list.size()>0&&list.get(0)!=null?new Date(list.get(0).substring(0,14)+"59:59"):new Date();
			}				
		};
		return (Date) execute(action);		
	}
}

