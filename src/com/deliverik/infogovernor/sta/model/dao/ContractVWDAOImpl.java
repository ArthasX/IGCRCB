/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
 * 合同额统计DAO实现
 */
public class ContractVWDAOImpl extends BaseHibernateDAOImpl<Contract> implements ContractVWDAO {
	/**
	 * 构造函数
	 */
	public ContractVWDAOImpl(){
		super(ContractVW.class);
	}

	/**
     * 统计查询当前年与前一年，合同额
     *
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
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
