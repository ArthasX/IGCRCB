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
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCond;
import com.deliverik.infogovernor.sta.model.entity.ContractVW;

/**
 * ��ͬ��ͳ��DAOʵ��
 */
public class ContractVWDAOImpl extends BaseHibernateDAOImpl<Contract> implements ContractVWDAO {
	/**
	 * ���캯��
	 */
	public ContractVWDAOImpl(){
		super(ContractVW.class);
	}

	/**
     * ͳ�Ʋ�ѯ��ǰ����ǰһ�꣬��ͬ��
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<Contract> statisticContractAmount(final ContractSearchCond cond){
        HibernateCallback action = new HibernateCallback() {
            
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                
                StringBuffer query = new StringBuffer();
                
                query.append(session.getNamedQuery("ContractVW.statisticContractAmountHeader").getQueryString());
                
                query.append(" substr(condudetime,1,4) = '"+cond.getCurYear()+"'");
                
                if(StringUtils.isNotEmpty(cond.getFacilitator())){
                    query.append(" and facilitator = '"+cond.getFacilitator()+"'");
                }
                
                query.append(session.getNamedQuery("ContractVW.statisticContractAmountBody").getQueryString());
                query.append(" substr(condudetime,1,4) = '"+(Integer.valueOf(cond.getCurYear())-1)+"'");
                if(StringUtils.isNotEmpty(cond.getFacilitator())){
                    query.append(" and facilitator= '"+cond.getFacilitator() +"'");
                }
                query.append(session.getNamedQuery("ContractVW.statisticContractAmountFooter").getQueryString());
                if(StringUtils.isNotEmpty(cond.getContractType())){
                    query.append(" and e1.ename= '"+ cond.getContractType()+"'");
                }
                SQLQuery q = session.createSQLQuery(query.toString()).addEntity(ContractVW.class);
                
                List<Contract> list = q.list();
                
                session.clear();
                session.close();
                
                return list;
            }
        };
        return (List<Contract>) execute(action);
    }
	
}
