/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.EntityItemFacilitatorVW;
/**
 * ����:��������Ϣ��ͼDAOʵ��
 * ��������: ��������Ϣ��ͼDAOʵ��
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼: 
 */
public class EntityItemFacilitatorVWDAOImpl extends BaseHibernateDAOImpl<EntityItemFacilitatorVWInfo>
		implements EntityItemFacilitatorVWDAO {

	public EntityItemFacilitatorVWDAOImpl(){
		super(EntityItemFacilitatorVW.class);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<EntityItemFacilitatorVWInfo> findByCond(final EntityItemFacilitatorVWSearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("EntityItemFacilitatorVWDAO.entityItemFacilitatorVWDAO").getQueryString());
				//׷������
				getSql(cond, query);
				//׷������
				query.append(" order by ei.einame");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("EntityItemFacilitatorVW",EntityItemFacilitatorVW.class);
				List<EntityItemFacilitatorVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<EntityItemFacilitatorVWInfo>)execute(action);
	}
	/**
	 * ��ѯ����
	 * */	
	protected void getSql(EntityItemFacilitatorVWSearchCond cond,StringBuffer query){
		//��˾����
		if(StringUtils.isNotEmpty(cond.getEiname())){
			query.append(" AND ei.einame like '%"+cond.getEiname()+"%'");
		}
		//������
		if(StringUtils.isNotEmpty(cond.getEiorgsyscoding())){
			query.append(" AND ei.eiorgsyscoding like '"+cond.getEiorgsyscoding()+"%'");
		}
		//ģ����
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			query.append(" AND ei.esyscoding like '"+cond.getEsyscoding()+"%'");
		}
		//�Ǽ���  ��ʼ
		if(StringUtils.isNotEmpty(cond.getEiupdtime_from())){
			query.append(" AND ei.eiinsdate >= '"+cond.getEiupdtime_from()+"'");
		}
		//�Ǽ���  ����
		if(StringUtils.isNotEmpty(cond.getEiupdtime_to())){
			query.append(" AND ei.eiinsdate <= '"+cond.getEiupdtime_to()+"'");
		}
	}
}
