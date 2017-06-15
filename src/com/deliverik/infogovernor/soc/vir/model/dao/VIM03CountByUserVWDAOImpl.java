/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03CountByUserVW;
/**
 * ���⻯ͳ�Ʒ���
 *
 */
public class VIM03CountByUserVWDAOImpl extends BaseHibernateDAOImpl<VIM03CountByUserVWInfo>
		implements VIM03CountByUserVWDAO {

	public VIM03CountByUserVWDAOImpl(){
		super(VIM03CountByUserVW.class);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<VIM03CountByUserVWInfo> findByCond(final VIM03CountByUserVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("COUNT_USER_VIM03VWDAO.findByCond").getQueryString());
				//׷������
				getSql(cond, query);
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("VIM03CountByUserVW",VIM03CountByUserVW.class);
				setFetchPoint(q, start, count);
				List<VIM03CountByUserVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<VIM03CountByUserVWInfo>)execute(action);
	}
	
	/**
	 * ��ѯ����
	 * */	
	protected void getSql(VIM03CountByUserVWSearchCond cond,StringBuffer query){
		//�û���
		if(StringUtils.isNotEmpty(cond.getUserid_like())){
			query.append("and userid like '%"+cond.getUserid_like()+"%'");
		}
		//�û���
		if(StringUtils.isNotEmpty(cond.getUsername_like())){
			query.append("and username like '%"+cond.getUsername_like()+"%'");
		}
		//������
		if(StringUtils.isNotEmpty(cond.getOrgsyscoding_like())){
			query.append("and orgsyscoding like '"+cond.getOrgsyscoding_like()+"%'");
		}
	}
}
