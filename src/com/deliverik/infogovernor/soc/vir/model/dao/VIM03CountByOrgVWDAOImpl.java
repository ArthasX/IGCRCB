/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03CountByOrgVW;
/**
 * ���⻯����ҵ���߼�ʵ��
 *
 */
public class VIM03CountByOrgVWDAOImpl extends BaseHibernateDAOImpl<VIM03CountByOrgVWInfo>
		implements VIM03CountByOrgVWDAO {

	public VIM03CountByOrgVWDAOImpl(){
		super(VIM03CountByOrgVW.class);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<VIM03CountByOrgVWInfo> findByCond(final VIM03CountByOrgVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("COUNT_ORG_VIM03VWDAO.findByCond").getQueryString());
				//׷������
				getSql(cond, query);
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("VIM03CountByOrgVW",VIM03CountByOrgVW.class);
				setFetchPoint(q, start, count);
				List<VIM03CountByOrgVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<VIM03CountByOrgVWInfo>)execute(action);
	}
	

	
	/**
	 * ��ѯ����
	 * */	
	protected void getSql(VIM03CountByOrgVWSearchCond cond,StringBuffer query){
		//������
		if(StringUtils.isNotEmpty(cond.getOrgsyscoding_like())){
			query.append("and orgsyscoding like '"+cond.getOrgsyscoding_like()+"%'");
		}
	}
	
	
	/**
	 * ��ѯ��������Դʹ�����
	 * @param cond
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getCount(final VIM03CountByOrgVWSearchCond cond){
		
		StringBuffer sql = new StringBuffer("select orgname,orgsyscoding,count(*)," +
				"sum(vmcpus*(date('now') - to_date(applytime,'yyyy/mm/dd'))) as totalcpu ,"+
				"sum(vmmem*(date('now') - to_date(applytime,'yyyy/mm/dd'))) as totalmem,"+
				"sum(vmdisk*(date('now') - to_date(applytime,'yyyy/mm/dd'))) as totaldisk from vim03 where progress = '100' ");
		if(!StringUtil.isEmpty(cond.getExpiryTime())){
			sql.append(" and expirytime < :expiryTime ");
		}
		sql.append(" group by orgname,orgsyscoding");
		
		SQLQuery q = getSession().createSQLQuery(sql.toString());
		
		if(!StringUtil.isEmpty(cond.getExpiryTime())){
			q.setParameter("expiryTime", cond.getExpiryTime());
		}
		
		q.addEntity(VIM03CountByOrgVW.class);
		
		List<VIM03CountByOrgVWInfo> result =q.list();
		
		return result;
		
	}
}
