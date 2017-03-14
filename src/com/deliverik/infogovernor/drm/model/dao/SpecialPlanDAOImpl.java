/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VW;
import com.deliverik.infogovernor.drm.model.condition.SpecialPlanSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ר��Ԥ����ѯDAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class SpecialPlanDAOImpl extends BaseHibernateDAOImpl<SOC0118VWInfo> implements SpecialPlanDAO{

	/**
	 * ���췽��
	 */
	public SpecialPlanDAOImpl(){
		super(SOC0118VW.class);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SpecialPlanSearchCond cond) {
		StringBuffer query = new StringBuffer();
		query.append("select count(1) from soc0118 s where s.esyscoding like '888001%' ");
		getSql(query,cond);
		Session session = getSession();
		session.flush();
		//������ѯ����
		SQLQuery q = session.createSQLQuery(query.toString());
		q.setProperties(cond);
		return getCount(q.list());
	}
	
	/**
	 * ��������
	 * @param cond ��������
	 * @param start ��ʼ����
	 * @param count ��ʾ����
	 * @return �������
	 */
	public List<SOC0118VWInfo> search(SpecialPlanSearchCond cond,int start,int count){
		StringBuffer query = new StringBuffer();
		query.append("select 0 as id,s.* from soc0118 s where s.esyscoding like '888001%' ");
		getSql(query,cond);
		//��ȡ���Ӷ���
		Session session = getSession();
		session.flush();
		//������ѯ����
		SQLQuery q = session.createSQLQuery(query.toString());
		q.addEntity(SOC0118VW.class);
		setFetchPoint(q, start, count);
		q.setProperties(cond);
		return q.list();
	}

	/**
	 * ƴ�Ӳ�ѯ����
	 * @param query ��ѯ���
	 * @param cond ��ѯ��������
	 */
	private void getSql(StringBuffer query, SpecialPlanSearchCond cond) {
		//Ԥ������
		if(StringUtils.isNotEmpty(cond.getEiname_like())){
			query.append(" and s.einame like '%'||:einame_like||'%'");
		}
		//����ҵ��ϵͳ
		if(cond.getUsinessSystemId() != null && cond.getUsinessSystemId() > 0){
			query.append(" and exists (select 1 from soc0119 r where r.pareiid = s.eiid and eirrelationcode = '080-040' and r.cldeiid = :usinessSystemId) ");
		}
		//����ID
		if(cond.getSceneId() != null && cond.getSceneId() > 0){
			query.append(" and exists (select 1 from soc0119 r where r.pareiid = s.eiid and eirrelationcode = '080-060' and r.cldeiid = :sceneId) ");
		}
		//Ӧ����Դ
		if(cond.getDrmResourceId() != null && cond.getDrmResourceId() > 0){
			query.append(" and exists (select 1 from soc0119 r left join soc0107 c on c.eiid = r.cldeiid and c.cid='CI600000001004' left join ig380 pd on pd.pdid = c.civalue left join ig560 dv on dv.pidid like pd.pdid || '___' where r.pareiid = s.eiid and eirrelationcode = '080-060' and dv.dfvalue like '0_");
			query.append(cond.getDrmResourceId());
			query.append("_SOC%' ) ");
		}
	}
}
