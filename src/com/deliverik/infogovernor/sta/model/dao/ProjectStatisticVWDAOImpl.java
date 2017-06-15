/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCond;
import com.deliverik.infogovernor.sta.model.entity.ProjectStatisticVW;

/**
 * ��ͬ��ͳ��DAOʵ��
 */
public class ProjectStatisticVWDAOImpl extends BaseHibernateDAOImpl<ProjectStatistic> implements ProjectStatisticVWDAO {
	/**
	 * ���캯��
	 */
	public ProjectStatisticVWDAOImpl(){
		super(ProjectStatisticVW.class);
	}

    /**
     * ��ѯ��Ŀ����
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<ProjectStatistic> searchPrjRec(final ProjectStatisticSearchCond cond , final int start,final int count) {
        HibernateCallback action = new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();

                StringBuffer query = new StringBuffer();

                query.append(session.getNamedQuery("ProjectStatistic.searchPrjRec").getQueryString());

                getSql(query, cond);
                
                SQLQuery q = session.createSQLQuery(query.toString()).addEntity(ProjectStatisticVW.class);
                setFetchPoint(q, start, count);
                List<ProjectStatistic> list = q.list();

                session.clear();
                session.close();

                return list;
            }
        };
        return (List<ProjectStatistic>) execute(action);
    }
	
    private void getSql(StringBuffer query,ProjectStatisticSearchCond cond) {
        if(StringUtils.isNotEmpty(cond.getPrjLevel())){
            query.append(" and prj.prjlevel = '"+cond.getPrjLevel()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getPrTitle())){
            query.append(" and upper(prj.prtitle) like upper('%"+cond.getPrTitle()+"%')");
        }
        if(StringUtils.isNotEmpty(cond.getPrjStage())){
            query.append(" and upper(prj.prjStage) like upper('%"+cond.getPrjStage()+"%')");
        }
        if(StringUtils.isNotEmpty(cond.getPrjOutsourcers())){
            query.append(" and prj.prjOutsourcers ='"+cond.getPrjOutsourcers()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getPrjReport())){
            query.append(" and prj.prjReport = '"+cond.getPrjReport()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getPlanStartTime_from())){
            query.append(" and prj.planStartTime > '"+cond.getPlanStartTime_from()+" 00:00'");
        }
        if(StringUtils.isNotEmpty(cond.getPlanStartTime_to())){
            query.append(" and prj.planStartTime <= '"+cond.getPlanStartTime_to()+" 23:59'");
        }
        if(StringUtils.isNotEmpty(cond.getPlanFinishTime_from())){
            query.append(" and prj.planFinishTime > '"+cond.getPlanFinishTime_from()+" 00:00'");
        }
        if(StringUtils.isNotEmpty(cond.getPlanFinishTime_to())){
            query.append(" and prj.planFinishTime <= '"+cond.getPlanFinishTime_to()+" 23:59'");
        }
    }
}
